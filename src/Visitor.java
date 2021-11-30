import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class Visitor extends sysyBaseVisitor<Void>{
    private int register_num = 1;
    private int nodeValue;
    private boolean isReg;
    private boolean useReg;//整个表达式有没有用到register
    private boolean singleBool;//是否是单个表达式
    private boolean defGlobal;//是否正在定义全局变量
    private String sign;
    private String type = "";
    private String name = "";
    private Stack<ArrayList<Symbol>> symStack = new Stack<>(); //符号栈，arraylist存Symbol类的符号
    private Stack<String> typeStack = new Stack<>();
    private Stack<Integer> beginStack=new Stack<>();
    private Stack<Integer> endStack=new Stack<>();
    private ArrayList<Integer> regNumList=new ArrayList<>(); //不同作用域有不同寄存器，相互独立，与symstack平行使用
    private ArrayList<Symbol> globalSym=new ArrayList<>();

    @Override
    public Void visitCompunit(sysyParser.CompunitContext ctx) {
        // 调用默认的 visit 方法即可
        defGlobal=true;
        for(int i=0;i<ctx.decl().size();i++){
            visit(ctx.decl(i));
        }
        defGlobal=false;
        visit(ctx.funcdef());
        return null;
    }

    @Override
    public Void visitDecl(sysyParser.DeclContext ctx) {
        if(ctx.constdecl()!=null){
            visit(ctx.constdecl());
        }
        else {
            visit(ctx.vardecl());
        }
        return null;
    }

    @Override
    public Void visitConstdecl(sysyParser.ConstdeclContext ctx) {
        return super.visitConstdecl(ctx);
    }

    @Override
    public Void visitBtype(sysyParser.BtypeContext ctx) {
        this.type = "int";
        return null;
    }

    @Override
    public Void visitConstdef(sysyParser.ConstdefContext ctx) {
        //正在定义全局常量
        if(defGlobal){
            this.name="";
            visit(ctx.ident());
            String constGlobalName=name;
            visit(ctx.constinitval());
            globalSym.add(new Symbol(constGlobalName,"const",-1));
            int value=nodeValue;
            globalSym.get(globalSym.size()-1).setValue(value);
            return null;
        }
        //局部变量部分
        this.name="";
        visit(ctx.ident());
        checkRepeat(name,"const");
//        useReg=false;
        visit(ctx.constinitval());
        if(useReg){
            System.exit(-1);
        }
        register_num = -1;
        ArrayList<Symbol> curTable=symStack.peek();
        curTable.add(new Symbol(name, "const", register_num));
        int value=nodeValue;
        curTable.get(curTable.size()-1).setValue(value);
        return null;
    }

    @Override
    public Void visitConstinitval(sysyParser.ConstinitvalContext ctx) {
        return super.visitConstinitval(ctx);
    }

    @Override
    public Void visitConstexp(sysyParser.ConstexpContext ctx) {
        return super.visitConstexp(ctx);
    }

    @Override
    public Void visitVardecl(sysyParser.VardeclContext ctx) {
        return super.visitVardecl(ctx);
    }

    @Override
    public Void visitVardef(sysyParser.VardefContext ctx) {
        //正在定义全局变量
        if(defGlobal){
            this.name="";
            visit(ctx.ident());
            String globalVarName=name;
            checkGlobalRepeat(globalVarName,"var");
            int globalVarValue;
            if(ctx.initval()==null){
                globalVarValue=0;
            }
            else {
                visit(ctx.initval());
                globalVarValue=nodeValue;
            }
            System.out.println(String.format("@%s = global i32 %d", globalVarName,globalVarValue));
            Symbol globalVar=new Symbol(globalVarName,"var",-1);
            globalVar.setValue(globalVarValue);
            globalSym.add(globalVar);
            return null;
        }
        //alloca部分 声明
        this.name="";
        visit(ctx.ident());
        String varName=name;
        checkRepeat(varName,"var");
        register_num = regNumList.get(regNumList.size()-1);
        System.out.println(String.format("%%t%d = alloca i32", register_num));
        ArrayList<Symbol> curTable=symStack.peek();
        curTable.add(new Symbol(varName, "var", register_num));
        int varReg = register_num;
        regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
        //有初始值
        if(ctx.children.size() != 1){
//            useReg=false;
            visit(ctx.initval());
            int value = nodeValue;
            if(useReg){
                int valueReg=regNumList.get(regNumList.size()-1)-1;
                System.out.println(String.format("store i32 %%t%d, i32* %%t%d",valueReg,varReg));
            }
            else {
                System.out.println(String.format("store i32 %d, i32* %%t%d",value,varReg));
            }
        }
        return null;
    }

    @Override
    public Void visitInitval(sysyParser.InitvalContext ctx) {
        return super.visitInitval(ctx);
    }

    @Override
    public Void visitFuncdef(sysyParser.FuncdefContext ctx) {
        this.name="";
        regNumList.add(1);
        visit(ctx.ident());
        System.out.print("define dso_local i32 @main()");
        System.out.println("{");
        visit(ctx.block());
        System.out.println("}");
        return null;
    }

    @Override
    public Void visitFunctype(sysyParser.FunctypeContext ctx) {
        this.type="int";
        return super.visitFunctype(ctx);
    }

    @Override
    public Void visitBlock(sysyParser.BlockContext ctx) {
        ArrayList<Symbol> blockSym= new ArrayList<>();
        this.symStack.push(blockSym);
//        this.regNumList.add(1);
        int i=0;
        for(i=0;i<ctx.blockitem().size();i++){
            visit(ctx.blockitem().get(i));
        }
        this.symStack.pop();
//        this.regNumList.remove(regNumList.size()-1);
        return null;
    }

    @Override
    public Void visitBlockitem(sysyParser.BlockitemContext ctx) {
        if(ctx.decl()!=null){
            visit(ctx.decl());
        }
        else {
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public Void visitStmt(sysyParser.StmtContext ctx) {
        if(ctx.lval()!=null){
            visit(ctx.lval());
            String curName=name;
            register_num = getReg(curName);
            int varReg=register_num;
            String leftGlobal="";
            if(varReg==-1){
                leftGlobal=getGlobalReg(curName);
                if(leftGlobal==null){
                    System.exit(-1);
                }
            }
//            useReg=false;
            visit(ctx.exp());
            int value = nodeValue;
            if(useReg){
                int interReg=regNumList.get(regNumList.size()-1)-1;
                if(!leftGlobal.equals("")){
                    System.out.println(String.format("store i32 %%t%d, i32* @%s",interReg,leftGlobal));
                }
                else {
                    System.out.println(String.format("store i32 %%t%d, i32* %%t%d",interReg,varReg));
                }
            }
            else {
                if(!leftGlobal.equals("")){
                    System.out.println(String.format("store i32 %d, i32* @%s",value,leftGlobal));
                }
                else {
                    System.out.println(String.format("store i32 %d, i32* %%t%d",value,varReg));
                }
            }
        }
        else if(ctx.RETURN()!=null){
//            useReg=false;
            visit(ctx.exp());
            System.out.print("ret i32 ");
            if(useReg){
                int retReg=regNumList.get(regNumList.size()-1)-1;
                System.out.println(String.format("%%t%d",retReg));
            }
            else {
                System.out.println(nodeValue);
            }
        }
        else if(ctx.IF()!=null){
            visit(ctx.cond());
            if(ctx.stmt(1)!=null){
                //有else
                int icmpReg=regNumList.get(regNumList.size()-1)-1;
                int ifReg=icmpReg+1,elseReg=icmpReg+2,retReg=icmpReg+3;
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+3);
                System.out.println(String.format("br i1 %%t%d,label %%t%d, label %%t%d",icmpReg,ifReg,elseReg));
                System.out.println(String.format("t%d:",ifReg));
                visit(ctx.stmt(0));
                System.out.println(String.format("br label %%t%d",retReg));
                System.out.println(String.format("t%d:",elseReg));
                visit(ctx.stmt(1));
                System.out.println(String.format("br label %%t%d",retReg));
                System.out.println(String.format("t%d:",retReg));
            }
            else {
                //无else
                int icmpReg=regNumList.get(regNumList.size()-1)-1;
                int ifReg=icmpReg+1,retReg=icmpReg+2;
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+2);
                System.out.println(String.format("br i1 %%t%d,label %%t%d,label %%t%d",icmpReg,ifReg,retReg));
                System.out.println(String.format("t%d:",ifReg));
                visit(ctx.stmt(0));
                System.out.println(String.format("br label %%t%d",retReg));
                System.out.println(String.format("t%d:",retReg));
            }
        }
        else if(ctx.block()!=null){
            visit(ctx.block());
        }
        else if(ctx.WHILE()!=null){
            int whileReg=regNumList.get(regNumList.size()-1);
            regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            beginStack.push(whileReg);
            System.out.println(String.format("br label %%t%d",whileReg));
            System.out.println(String.format("t%d:",whileReg));
            visit(ctx.cond());
            int icmpReg=regNumList.get(regNumList.size()-1)-1;
            int stmtReg=icmpReg+1,endReg=icmpReg+2;
            endStack.push(endReg);
            regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+2);
            System.out.println(String.format("br i1 %%t%d,label %%t%d,label %%t%d",icmpReg,stmtReg,endReg));
            System.out.println(String.format("t%d:",stmtReg));
            visit(ctx.stmt(0));
            System.out.println(String.format("br label %%t%d",whileReg));
            System.out.println(String.format("t%d:",endReg));
            beginStack.pop();
            endStack.pop();
        }
        else if(ctx.BREAK()!=null){
            System.out.println(String.format("br label %%t%d",endStack.peek()));
        }
        else if(ctx.CONTINUE()!=null){
            System.out.println(String.format("br label %%t%d",beginStack.peek()));
        }
        else if(ctx.exp()!=null){
            visit(ctx.exp());
        }
        return null;
    }

    @Override
    public Void visitLval(sysyParser.LvalContext ctx) {
        this.name="";
        return super.visitLval(ctx);
    }

    @Override
    public Void visitExp(sysyParser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    @Override
    public Void visitAddexp(sysyParser.AddexpContext ctx) {
        useReg=false;
        if(ctx.children.size()==1){
            visit(ctx.mulexp());
        }
        else {
            int left,right,ans,leftNum=0,rightNum=0;
            boolean leftReg,rightReg;
            visit(ctx.addexp());
            left=nodeValue;
            leftReg=isReg;
            //取最近的寄存器值
            if(regNumList.size()>0){
                leftNum=regNumList.get(regNumList.size()-1)-1;
            }
            visit(ctx.mulexp());
            right=nodeValue;
            rightReg=isReg;
            if(regNumList.size()>0){
                rightNum=regNumList.get(regNumList.size()-1)-1;
            }
            isReg=true;
            if(ctx.ADD()!=null){
                if(leftReg&&rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = add i32 %%t%d, %%t%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = add i32 %%t%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = add i32 %d, %%t%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else {
                    ans=left+right;
                    nodeValue=ans;
                    isReg=false;
                }
            }
            else {
                if (leftReg && rightReg) {
                    register_num = regNumList.get(regNumList.size() - 1);
                    System.out.println(String.format("%%t%d = sub i32 %%t%d, %%t%d", register_num, leftNum, rightNum));
                    regNumList.set(regNumList.size() - 1, register_num + 1);
                } else if (leftReg) {
                    register_num = regNumList.get(regNumList.size() - 1);
                    System.out.println(String.format("%%t%d = sub i32 %%t%d, %d", register_num, leftNum, right));
                    regNumList.set(regNumList.size() - 1, register_num + 1);
                } else if (rightReg) {
                    register_num = regNumList.get(regNumList.size() - 1);
                    System.out.println(String.format("%%t%d = sub i32 %d, %%t%d", register_num, left, rightNum));
                    regNumList.set(regNumList.size() - 1, register_num + 1);
                } else {
                    ans = left - right;
                    nodeValue = ans;
                    isReg=false;
                }
            }
        }
        return null;
    }

    @Override
    public Void visitMulexp(sysyParser.MulexpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.unaryexp());
        }
        else {
            int left,right,ans,leftNum=0,rightNum=0;
            boolean leftReg,rightReg;
            visit(ctx.mulexp());
            left=nodeValue;
            leftReg=isReg;
            if(regNumList.size()>0){
                leftNum=regNumList.get(regNumList.size()-1)-1;
            }
            visit(ctx.unaryexp());
            right=nodeValue;
            rightReg=isReg;
            if(regNumList.size()>0){
                rightNum=regNumList.get(regNumList.size()-1)-1;
            }
            isReg=true;
            if(ctx.MUL()!=null){
                if(leftReg&&rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = mul i32 %%t%d, %%t%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = mul i32 %%t%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = mul i32 %d, %%t%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else {
                    ans=left*right;
                    nodeValue=ans;
                    isReg=false;
                }
            }
            else if(ctx.DIV()!=null){
                if(leftReg&&rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = sdiv i32 %%t%d, %%t%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = sdiv i32 %%t%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = sdiv i32 %d, %%t%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else {
                    ans=left/right;
                    nodeValue=ans;
                    isReg=false;
                }
            }
            else {
                if(leftReg&&rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = srem i32 %%t%d, %%t%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = srem i32 %%t%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = srem i32 %d, %%t%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else {
                    ans=left%right;
                    nodeValue=ans;
                    isReg=false;
                }
            }
        }
        return null;
    }

    @Override
    public Void visitCond(sysyParser.CondContext ctx) {
        return super.visitCond(ctx);
    }

    @Override
    public Void visitUnaryexp(sysyParser.UnaryexpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.primaryexp());
        }
        else if(ctx.LPAREN()!=null){
            visit(ctx.ident());
            String funcName=name;
            if(funcName.equals("getint")){
                if(ctx.funcrparams()!=null){
                    System.exit(-1);
                }
                isReg=true;
                useReg=true;
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = call i32 @getint()",register_num));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
            else if(funcName.equals("getch")){
                if(ctx.funcrparams()!=null){
                    System.exit(-1);
                }
                isReg=true;
                useReg=true;
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = call i32 @getch()",register_num));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
            else if(funcName.equals("getarray")){
                System.out.println("declare i32 @getarray(i32*)");
            }
            else if(funcName.equals("putint")){
                if(ctx.funcrparams() ==null || ctx.funcrparams().children.size()>1){
                    System.exit(-1);
                }
                isReg=false;
                useReg=false;
                visit(ctx.funcrparams());
                if(useReg){
                    register_num=regNumList.get(regNumList.size()-1)-1;
                    System.out.println(String.format("call void @putint(i32 %%t%d)",register_num));
                }
                else {
                    System.out.println(String.format("call void @putint(i32 %d)",nodeValue));
                }
            }
            else if(funcName.equals("putch")){
                if(ctx.funcrparams()==null || ctx.funcrparams().children.size()>1){
                    System.exit(-1);
                }
                isReg=false;
//                useReg=false;
                visit(ctx.funcrparams());
                if(useReg){
                    register_num=regNumList.get(regNumList.size()-1)-1;
                    System.out.println(String.format("call void @putch(i32 %%t%d)",register_num));
                }
                else {
                    System.out.println(String.format("call void @putch(i32 %d)",nodeValue));
                }
            }
            else if(funcName.equals("putarray")){
                System.out.println("declare void @putarray(i32,i32*)");
            }
        }
        else {
            visit(ctx.unaryop());
            String sig = sign;
            visit(ctx.unaryexp());
            boolean nodeBool=isReg;
            if(sig.equals("-")){
                if(nodeBool){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = sub i32 0, %%t%d",register_num,register_num-1));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else {
                    nodeValue *= -1;
                }
            }
            else if(sig.equals("!")){
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = icmp eq i32 %%t%d, 0",register_num,register_num-1));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = zext i1 %%t%d to i32",register_num,register_num-1));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
        }
        return null;
    }

    @Override
    public Void visitPrimaryexp(sysyParser.PrimaryexpContext ctx) {
        isReg=false;
        if(ctx.LPAREN()!=null){
            visit(ctx.exp());
        }
        else if(ctx.lval()!=null){
            if(defGlobal){
                if(!checkGlobalConst(ctx.lval().ident().IDENT().getText())){
                    //全局变量是常量表达式
                    System.exit(-1);
                }
                return null;
            }
            //既不是全局常量也不是局部常量，说明是变量
            if(!checkConst(ctx.lval().ident().IDENT().getText())&&!checkGlobalConst(ctx.lval().ident().IDENT().getText())){
                //是变量，要load
                isReg=true;
                useReg=true;
                register_num = regNumList.get(regNumList.size()-1);
                String identName=ctx.lval().ident().IDENT().getText();
                int varReg=getReg(identName);
                if(varReg==-1){
                    String gloReg=getGlobalReg(identName);
                    System.out.println(String.format("%%t%d = load i32, i32* @%s", register_num, gloReg));
                }
                else {
                    System.out.println(String.format("%%t%d = load i32, i32* %%t%d", register_num, varReg));
                }
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
        }
        else {
            visit(ctx.number());
        }
        return null;
    }

    @Override
    public Void visitFuncrparams(sysyParser.FuncrparamsContext ctx) {
        return super.visitFuncrparams(ctx);
    }

    @Override
    public Void visitUnaryop(sysyParser.UnaryopContext ctx) {
        if(ctx.SUB()!=null){
            sign="-";
        }
        else if(ctx.NOT()!=null){
            sign="!";
        }
        else {
            sign="+";
        }
        return null;
    }

    @Override
    public Void visitRelexp(sysyParser.RelexpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.addexp());
        }
        else {
            singleBool=false;
            int left,right,ans,leftNum,rightNum;
            boolean leftReg,rightReg;
            visit(ctx.relexp());
            left=nodeValue;
            leftNum=regNumList.get(regNumList.size()-1)-1;
            leftReg=useReg;
            visit(ctx.addexp());
            right=nodeValue;
            rightNum=regNumList.get(regNumList.size()-1)-1;
            rightReg=useReg;
            int icmpReg=regNumList.get(regNumList.size()-1);
            regNumList.set(regNumList.size()-1, icmpReg+1);
            if(ctx.LESS()!=null){
                if(leftReg&&rightReg){
                    System.out.println(String.format("%%t%d = icmp slt i32 %%t%d, %%t%d",icmpReg, leftNum, rightNum));
                }
                else if(leftReg){
                    System.out.println(String.format("%%t%d = icmp slt i32 %%t%d, %d",icmpReg, leftNum, right));
                }
                else if(rightReg){
                    System.out.println(String.format("%%t%d = icmp slt i32 %d, %%t%d",icmpReg, left, rightNum));
                }
                else {
                    System.out.println(String.format("%%t%d = icmp slt i32 %d, %d",icmpReg, left, right));
                }
            }
            else if(ctx.GREATER()!=null){
                if(leftReg&&rightReg){
                    System.out.println(String.format("%%t%d = icmp sgt i32 %%t%d, %%t%d",icmpReg, leftNum, rightNum));
                }
                else if(leftReg){
                    System.out.println(String.format("%%t%d = icmp sgt i32 %%t%d, %d",icmpReg, leftNum, right));
                }
                else if(rightReg){
                    System.out.println(String.format("%%t%d = icmp sgt i32 %d, %%t%d",icmpReg, left, rightNum));
                }
                else {
                    System.out.println(String.format("%%t%d = icmp sgt i32 %d, %d",icmpReg, left, right));
                }
            }
            else if(ctx.LESS_OR_EQUAL()!=null){
                if(leftReg&&rightReg){
                    System.out.println(String.format("%%t%d = icmp sle i32 %%t%d, %%t%d",icmpReg, leftNum, rightNum));
                }
                else if(leftReg){
                    System.out.println(String.format("%%t%d = icmp sle i32 %%t%d, %d",icmpReg, leftNum, right));
                }
                else if(rightReg){
                    System.out.println(String.format("%%t%d = icmp sle i32 %d, %%t%d",icmpReg, left, rightNum));
                }
                else {
                    System.out.println(String.format("%%t%d = icmp sle i32 %d, %d",icmpReg, left, right));
                }
            }
            else if(ctx.GREATER_OR_EQUAL()!=null){
                if(leftReg&&rightReg){
                    System.out.println(String.format("%%t%d = icmp sge i32 %%t%d, %%t%d",icmpReg, leftNum, rightNum));
                }
                else if(leftReg){
                    System.out.println(String.format("%%t%d = icmp sge i32 %%t%d, %d",icmpReg, leftNum, right));
                }
                else if(rightReg){
                    System.out.println(String.format("%%t%d = icmp sge i32 %d, %%t%d",icmpReg, left, rightNum));
                }
                else {
                    System.out.println(String.format("%%t%d = icmp sge i32 %d, %d",icmpReg, left, right));
                }
            }
        }
        return null;
    }

    @Override
    public Void visitEqexp(sysyParser.EqexpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.relexp());
        }
        else {
            singleBool=false;
            int left,right,ans,leftNum,rightNum;
            boolean leftReg,rightReg;
            visit(ctx.eqexp());
            left=nodeValue;
            leftNum=regNumList.get(regNumList.size()-1)-1;
            leftReg=useReg;
            visit(ctx.relexp());
            right=nodeValue;
            rightNum=regNumList.get(regNumList.size()-1)-1;
            rightReg=useReg;
            int icmpReg=regNumList.get(regNumList.size()-1);
            regNumList.set(regNumList.size()-1, icmpReg+1);
            if(ctx.LOGICAL_EQUAL()!=null){
                if(leftReg&&rightReg){
                    System.out.println(String.format("%%t%d = icmp eq i32 %%t%d, %%t%d",icmpReg, leftNum, rightNum));
                }
                else if(leftReg){
                    System.out.println(String.format("%%t%d = icmp eq i32 %%t%d, %d",icmpReg, leftNum, right));
                }
                else if(rightReg){
                    System.out.println(String.format("%%t%d = icmp eq i32 %d, %%t%d",icmpReg, left, rightNum));
                }
                else {
                    System.out.println(String.format("%%t%d = icmp eq i32 %d, %d",icmpReg, left, right));
                }
            }
            else if(ctx.LOGICAL_NOT_EQUAL()!=null){
                if(leftReg&&rightReg){
                    System.out.println(String.format("%%t%d = icmp ne i32 %%t%d, %%t%d",icmpReg, leftNum, rightNum));
                }
                else if(leftReg){
                    System.out.println(String.format("%%t%d = icmp ne i32 %%t%d, %d",icmpReg, leftNum, right));
                }
                else if(rightReg){
                    System.out.println(String.format("%%t%d = icmp ne i32 %d, %%t%d",icmpReg, left, rightNum));
                }
                else {
                    System.out.println(String.format("%%t%d = icmp ne i32 %d, %d",icmpReg, left, right));
                }
            }
        }
        return null;
    }

    @Override
    public Void visitLandexp(sysyParser.LandexpContext ctx) {
        if(ctx.children.size()==1){
            singleBool=true;
            visit(ctx.eqexp());
            if(singleBool){
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = icmp ne i32 %%t%d, 0",register_num,register_num-1));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
        }
        else {
            singleBool=true;
            int leftReg,rightReg;
            visit(ctx.landexp());
            if(singleBool){
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = icmp ne i32 %%t%d, 0",register_num,register_num-1));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
            leftReg=regNumList.get(regNumList.size()-1)-1;
            singleBool=true;
            visit(ctx.eqexp());
            if(singleBool){
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = icmp ne i32 %%t%d, 0",register_num,register_num-1));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
            rightReg=regNumList.get(regNumList.size()-1)-1;
            register_num=regNumList.get(regNumList.size()-1);
            System.out.println(String.format("%%t%d = and i1 %%t%d,%%t%d",register_num,leftReg,rightReg));
            regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
        }
        return null;
    }

    @Override
    public Void visitLorexp(sysyParser.LorexpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.landexp());
        }
        else {
            int leftReg,rightReg;
            visit(ctx.lorexp());
            leftReg=regNumList.get(regNumList.size()-1)-1;
            visit(ctx.landexp());
            rightReg=regNumList.get(regNumList.size()-1)-1;
            register_num=regNumList.get(regNumList.size()-1);
            System.out.println(String.format("%%t%d = or i1 %%t%d,%%t%d",register_num,leftReg,rightReg));
            regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
        }
        return null;
    }

    @Override
    public Void visitIdent(sysyParser.IdentContext ctx) {
        String str=ctx.IDENT().getText();
        this.name=str;
        checkIfValue(str);
        return null;
    }

    @Override
    public Void visitNumber(sysyParser.NumberContext ctx) {
        nodeValue=0;
        if(ctx.decimal_const()!=null){
            visit(ctx.decimal_const());
        }
        else if(ctx.octal_const()!=null){
            visit(ctx.octal_const());
        }
        else {
            visit(ctx.hexadecimal_const());
        }
        return null;
    }

    @Override
    public Void visitDecimal_const(sysyParser.Decimal_constContext ctx) {
        nodeValue=Integer.parseInt(ctx.DECIMAL_CONST().getText());
        return null;
    }

    @Override
    public Void visitOctal_const(sysyParser.Octal_constContext ctx) {
        int pow=1,i,res=0;
        StringBuilder stringBuilder= new StringBuilder(ctx.OCTAL_CONST().getText());
        for(i=stringBuilder.length()-1;i>0;i--){
            res+=(stringBuilder.charAt(i)-'0') * pow;
            pow *= 8;
        }
        nodeValue=res;
        return null;
    }

    @Override
    public Void visitHexadecimal_const(sysyParser.Hexadecimal_constContext ctx) {
        int res=0,pow=1,i;
        StringBuilder stringBuilder= new StringBuilder(ctx.HEXADECIMAL_CONST().getText().toUpperCase(Locale.ROOT));
        for(i=stringBuilder.length()-1;i>1;i--){
            if(Character.isDigit(stringBuilder.charAt(i))){
                res+=(stringBuilder.charAt(i)-'0') * pow;
            }
            else {
                res+=(stringBuilder.charAt(i)-'A'+10) * pow;
            }
            pow *= 16;
        }
        nodeValue=res;
        return null;
    }

    //查有无重复
    public void checkRepeat(String checkName,String checkType){
        int i;
        ArrayList<Symbol> checkList=symStack.peek();
        for(i=0;i<checkList.size();i++){
            Symbol tmp=checkList.get(i);
            if(checkName.equals(tmp.getSymName()) && checkType.equals(tmp.getType())){
                System.exit(-1);
            }
        }
    }

    //获取str对应的值
    public void checkIfValue(String str){
        int i,j;
        for (i=symStack.size()-1;i>=0;i--){
            ArrayList<Symbol> tmp=symStack.get(i);
            for(j=tmp.size()-1;j>=0;j--){
                if(str.equals(tmp.get(j).getSymName())){
                    nodeValue=tmp.get(j).getValue();
                    return;
                }
            }
        }
    }

    public int getReg(String str){
        int i,j;
        for (i=symStack.size()-1;i>=0;i--){
            ArrayList<Symbol> tmp=symStack.get(i);
            for(j=tmp.size()-1;j>=0;j--){
                if(str.equals(tmp.get(j).getSymName())){
                    return tmp.get(j).getRegNum();
                }
            }
        }
        return -1;
    }

    public String getGlobalReg(String str){
        int i;
        for(i=globalSym.size()-1;i>=0;i--){
            if(str.equals(globalSym.get(i).getSymName())&&globalSym.get(i).getType().equals("var")){
                return globalSym.get(i).getSymName();
            }
        }
        return null;
    }


    //ident时候用，看一个字符串是不是常量
    public boolean checkConst(String str){
        int i,j;
        for (i=symStack.size()-1;i>=0;i--){
            ArrayList<Symbol> tmp=symStack.get(i);
            for(j=tmp.size()-1;j>=0;j--){
                if(str.equals(tmp.get(j).getSymName()) && tmp.get(j).getType().equals("const")){
                    //顺便赋值了
                    nodeValue=tmp.get(j).getValue();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkGlobalConst(String str){
        int i;
        for(i=globalSym.size()-1;i>=0;i--){
            if(str.equals(globalSym.get(i).getSymName()) && globalSym.get(i).getType().equals("const")){
                //顺便赋值了
                nodeValue=globalSym.get(i).getValue();
                return true;
            }
        }
        return false;
    }

    public void checkGlobalRepeat(String checkName,String checkType){
        int i;
        for(i=globalSym.size()-1;i>=0;i--){
            if(checkName.equals(globalSym.get(i).getSymName()) && checkType.equals(globalSym.get(i).getType())){
                System.exit(-1);
            }
        }
    }


}
