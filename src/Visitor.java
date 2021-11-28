import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class Visitor extends sysyBaseVisitor<Void>{
    private int register_num = 1;
    private int nodeValue;
    private boolean isReg;
    private boolean useReg;//整个表达式有没有用到register
    private String sign;
    private String type = "";
    private String name = "";
    private Stack<ArrayList<Symbol>> symStack = new Stack<>(); //符号栈，arraylist存Symbol类的符号
    private ArrayList<Integer> regNumList=new ArrayList<>(); //不同作用域有不同寄存器，相互独立，与symstack平行使用

    @Override
    public Void visitCompunit(sysyParser.CompunitContext ctx) {
        // 调用默认的 visit 方法即可
        return super.visitCompunit(ctx);
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
        //alloca部分 声明
        this.name="";
        visit(ctx.ident());
        String varName=name;
        checkRepeat(varName,"var");
        register_num = regNumList.get(regNumList.size()-1);
        System.out.println(String.format("%%%d = alloca i32", register_num));
        ArrayList<Symbol> curTable=symStack.peek();
        curTable.add(new Symbol(varName, "var", register_num));
        int varReg = register_num;
        regNumList.set(regNumList.size()-1, register_num+1);
        //有初始值
        if(ctx.children.size() != 1){
//            useReg=false;
            visit(ctx.initval());
            int value = nodeValue;
            if(useReg){
                int valueReg=regNumList.get(regNumList.size()-1)-1;
                System.out.println(String.format("store i32 %%%d, i32* %%%d",valueReg,varReg));
            }
            else {
                System.out.println(String.format("store i32 %d, i32* %%%d",value,varReg));
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
            if(register_num==-1){
                System.exit(-1);
            }
//            useReg=false;
            visit(ctx.exp());
            int value = nodeValue;
            if(useReg){
                int interReg=regNumList.get(regNumList.size()-1)-1;
                System.out.println(String.format("store i32 %%%d, i32* %%%d",interReg,varReg));
            }
            else {
                System.out.println(String.format("store i32 %d, i32* %%%d",value,varReg));
            }
        }
        else if(ctx.RETURN()!=null){
//            useReg=false;
            visit(ctx.exp());
            System.out.print("ret i32 ");
            if(useReg){
                int retReg=regNumList.get(regNumList.size()-1)-1;
                System.out.println(String.format("%%%d",retReg));
            }
            else {
                System.out.println(nodeValue);
            }
        }
        else if(ctx.IF()!=null){
            visit(ctx.cond());
            visit(ctx.stmt(0));
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
            int left,right,ans,leftNum,rightNum;
            boolean leftReg,rightReg;
            visit(ctx.addexp());
            left=nodeValue;
            leftReg=isReg;
            //取最近的寄存器值
            leftNum=regNumList.get(regNumList.size()-1)-1;
            visit(ctx.mulexp());
            right=nodeValue;
            rightReg=isReg;
            rightNum=regNumList.get(regNumList.size()-1)-1;
            isReg=true;
            if(ctx.ADD()!=null){
                if(leftReg&&rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = add i32 %%%d, %%%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = add i32 %%%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = add i32 %d, %%%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
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
                    System.out.println(String.format("%%%d = sub i32 %%%d, %%%d", register_num, leftNum, rightNum));
                    regNumList.set(regNumList.size() - 1, register_num + 1);
                } else if (leftReg) {
                    register_num = regNumList.get(regNumList.size() - 1);
                    System.out.println(String.format("%%%d = sub i32 %%%d, %d", register_num, leftNum, right));
                    regNumList.set(regNumList.size() - 1, register_num + 1);
                } else if (rightReg) {
                    register_num = regNumList.get(regNumList.size() - 1);
                    System.out.println(String.format("%%%d = sub i32 %d, %%%d", register_num, left, rightNum));
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
            int left,right,ans,leftNum,rightNum;
            boolean leftReg,rightReg;
            visit(ctx.mulexp());
            left=nodeValue;
            leftReg=isReg;
            leftNum=regNumList.get(regNumList.size()-1)-1;
            visit(ctx.unaryexp());
            right=nodeValue;
            rightReg=isReg;
            rightNum=regNumList.get(regNumList.size()-1)-1;
            isReg=true;
            if(ctx.MUL()!=null){
                if(leftReg&&rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = mul i32 %%%d, %%%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = mul i32 %%%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = mul i32 %d, %%%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
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
                    System.out.println(String.format("%%%d = sdiv i32 %%%d, %%%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = sdiv i32 %%%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = sdiv i32 %d, %%%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
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
                    System.out.println(String.format("%%%d = srem i32 %%%d, %%%d",register_num,leftNum,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(leftReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = srem i32 %%%d, %d",register_num,leftNum,right));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else if(rightReg){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = srem i32 %d, %%%d",register_num,left,rightNum));
                    regNumList.set(regNumList.size()-1, register_num+1);
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
                System.out.println(String.format("%%%d = call i32 @getint()",register_num));
                regNumList.set(regNumList.size()-1, register_num+1);
            }
            else if(funcName.equals("getch")){
                if(ctx.funcrparams()!=null){
                    System.exit(-1);
                }
                isReg=true;
                useReg=true;
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%%d = call i32 @getch()",register_num));
                regNumList.set(regNumList.size()-1, register_num+1);
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
                    System.out.println(String.format("call void @putint(i32 %%%d)",register_num));
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
                    System.out.println(String.format("call void @putch(i32 %%%d)",register_num));
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
            int sig = 1;
            if(sign.equals("-")){
                sig = -1;
            }
            visit(ctx.unaryexp());
            boolean nodeBool=isReg;
            if(sig==-1){
                if(nodeBool){
                    register_num=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%%d = sub i32 0, %%%d",register_num,register_num-1));
                    regNumList.set(regNumList.size()-1, register_num+1);
                }
                else {
                    nodeValue *= sig;
                }
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
            if(!checkConst(ctx.lval().ident().IDENT().getText())){
                //是变量，要load
                isReg=true;
                useReg=true;
                register_num = regNumList.get(regNumList.size()-1);
                int varReg=getReg(ctx.lval().ident().IDENT().getText());
                System.out.println(String.format("%%%d = load i32, i32* %%%d", register_num, varReg));
                regNumList.set(regNumList.size()-1, register_num+1);
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
        else {
            sign="+";
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

    public void changeValue(String str, int value){
        int i,j;
        for (i=symStack.size()-1;i>=0;i--){
            ArrayList<Symbol> tmp=symStack.get(i);
            for(j=tmp.size()-1;j>=0;j--){
                if(str.equals(tmp.get(j).getSymName())){
                    tmp.get(j).setValue(value);
                    return;
                }
            }
        }
    }

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


}
