import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class Visitor extends sysyBaseVisitor<Void>{
    private int register_num = 1;
    private int nodeValue;
    private int braceCount;
    private int basePointer;//数组[0]的基地址，后面按照一维数组模拟加上去
    private boolean isReg;
    private boolean useReg;//整个表达式有没有用到register
    private boolean singleBool;//是否是单个表达式
    private boolean defGlobal;//是否正在定义全局变量
    private boolean haveParam;//有需要分配空间的
    private boolean isVoid;//函数类型
    private boolean shouldLoad;//维数不同不用load
    private String sign;
    private String type = "";
    private String name = "";
    private FuncSymbol curFunc;//当前函数
    private Stack<ArrayList<Symbol>> symStack = new Stack<>(); //符号栈，arraylist存Symbol类的符号
    private Stack<String> typeStack = new Stack<>();
    private Stack<Integer> beginStack=new Stack<>();
    private Stack<Integer> endStack=new Stack<>();
    private ArrayList<Integer> regNumList=new ArrayList<>(); //不同作用域有不同寄存器，相互独立，与symstack平行使用
    private ArrayList<Symbol> globalSym=new ArrayList<>();//全局符号存储
    private ArrayList<Integer> tmpDimList=new ArrayList<>();
    private ArrayList<Integer> cntList=new ArrayList<>();//用于在局部数组初始化时计算各维的值
    private ArrayList<Symbol> paramSymList=new ArrayList<>();
    private ArrayList<FuncSymbol> funcList=new ArrayList<>();

    @Override
    public Void visitCompunit(sysyParser.CompunitContext ctx) {
        // 调用默认的 visit 方法即可
        defGlobal=true;
        if(ctx.compunit()!=null){
            visit(ctx.compunit());
        }
        if(ctx.decl()!=null){
            visit(ctx.decl());
        }
        else {
            visit(ctx.funcdef());
        }
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
            if(ctx.LBRACKET(0)!=null){
                //数组
                Symbol constArraySymbol=new Symbol(constGlobalName,"const global array",-1);
                int dimension=ctx.LBRACKET().size();
                constArraySymbol.setDimension(dimension);
                ArrayList<Integer> dimList=constArraySymbol.getDimList();
                int i;
                for(i=0;i<ctx.constexp().size();i++){
                    visit(ctx.constexp(i));
                    int value=nodeValue;
                    dimList.add(value);
                }
                System.out.print(String.format("@%s = constant ", constGlobalName));
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                globalSym.add(constArraySymbol);
                //看初始化情况
                if(ctx.constinitval().constinitval(0)==null){
                    //全0
                    System.out.print(" zeroinitializer");
                }
                else {
                    tmpDimList=dimList;
                    braceCount=dimension;
                    //框起来
                    System.out.print(" [");
                    visit(ctx.constinitval());
                    System.out.print("]");
                }
                System.out.println();
            }
            else {
                //全局常量，非数组
                visit(ctx.constinitval());
                globalSym.add(new Symbol(constGlobalName,"const",-1));
                int value=nodeValue;
                globalSym.get(globalSym.size()-1).setValue(value);
            }
        }
        else {
            //局部常量部分
            this.name="";
            visit(ctx.ident());
            String constName=name;
            if(ctx.LBRACKET(0)!=null){
                //局部常量数组
                int arrayReg=regNumList.get(regNumList.size()-1);
                System.out.print(String.format("%%t%d = alloca ",arrayReg));
                Symbol constArraySymbol=new Symbol(constName,"const array",arrayReg);
                int dimension=ctx.LBRACKET().size();
                constArraySymbol.setDimension(dimension);
                ArrayList<Integer> dimList=constArraySymbol.getDimList();
                int i;
                int elements=1;
                for(i=0;i<ctx.constexp().size();i++){
                    visit(ctx.constexp(i));
                    int value=nodeValue;
                    elements*=value;
                    dimList.add(value);
                }
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                ArrayList<Symbol> curTable=symStack.peek();

                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                System.out.println();
                //常量，肯定得先置0
                //先取0地址
                int setReg=regNumList.get(regNumList.size()-1);
                System.out.print(String.format("%%t%d = getelementptr ",setReg));
                //两个<ty>
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                System.out.print(",");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                System.out.print(String.format("* %%t%d",arrayReg));
                for(i=0;i<dimension+1;i++){
                    System.out.print(", i32 0");
                }
                System.out.println();
                System.out.println(String.format("call void @memset(i32* %%t%d, i32 0, i32 %d) ",setReg,elements*4));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                //初始化
                cntList.removeAll(cntList);
                for(i=0;i<dimension;i++){
                    cntList.add(0);
                }
                tmpDimList=dimList;
                braceCount=dimension;
                basePointer=setReg;
                constArraySymbol.setBasePointer(setReg);
                curTable.add(constArraySymbol);
                visit(ctx.constinitval());
            }
            else {
                //局部常量
                checkRepeat(name, "const");
                visit(ctx.constinitval());
                if (useReg) {
                    System.exit(-1);
                }
                register_num = -1;
                ArrayList<Symbol> curTable = symStack.peek();
                curTable.add(new Symbol(name, "const", register_num));
                int value = nodeValue;
                curTable.get(curTable.size() - 1).setValue(value);
            }
        }
        return null;
    }

    @Override
    public Void visitConstinitval(sysyParser.ConstinitvalContext ctx) {
        if(ctx.LBRACE()==null){
            visit(ctx.constexp());
        }
        else if(defGlobal){
            //全局常量数组初始化
            int i,j,k;
            if(ctx.LBRACE()!=null){
                braceCount-=1;
            }
            if(ctx.constinitval(0)!=null&&ctx.constinitval(0).constexp()==null){
                //还在外层，持续打印外层信息
                int thisDim=tmpDimList.get(tmpDimList.size()-braceCount-1);
                for(k=0;k<ctx.constinitval().size();k++){
                    for(j=0;j<braceCount;j++){
                        System.out.print(String.format("[%d x ",tmpDimList.get(j+tmpDimList.size()-braceCount)));
                    }
                    System.out.print("i32");
                    for(j=0;j<braceCount;j++){
                        System.out.print("]");
                    }
                    System.out.print(" [");
                    visit(ctx.constinitval(k));
                    System.out.print("]");
                    if(k!=thisDim-1){
                        System.out.print(", ");
                    }
                }
                if(ctx.constinitval().size()<thisDim){
                    //补0，用zeroinitializer
                    for(k=ctx.constinitval().size();k<thisDim;k++){
                        for(j=0;j<braceCount;j++){
                            System.out.print(String.format("[%d x ",tmpDimList.get(j+tmpDimList.size()-braceCount)));
                        }
                        System.out.print("i32");
                        for(j=0;j<braceCount;j++){
                            System.out.print("]");
                        }
                        System.out.print(" zeroinitializer");
                        if(k!=thisDim-1){
                            System.out.print(", ");
                        }
                    }
                }

            }
            else {
                //最内层了,直接打印
                int thisDim=tmpDimList.get(tmpDimList.size()-1);
                for(j=0;j<ctx.constinitval().size();j++){
                    visit(ctx.constinitval(j));
                    int value=nodeValue;
                    System.out.print(String.format("i32 %d",value));
                    if(j!=thisDim-1){
                        System.out.print(",");
                    }
                }

                //补0
                for(j=ctx.constinitval().size();j<thisDim;j++){
                    System.out.print("i32 0");
                    if(j!=thisDim-1){
                        System.out.print(",");
                    }
                }
            }
            if(ctx.RBRACE()!=null){
                braceCount+=1;
            }
        }
        else {
            //局部常量数组初始化
            int i,j;
            if(ctx.LBRACE()!=null){
                braceCount-=1;
            }
            if(ctx.constinitval(0)!=null&&ctx.constinitval(0).constexp()==null){
                //外层
                for(i=0;i<ctx.constinitval().size();i++){
                    visit(ctx.constinitval(i));
                    int index=cntList.size()-braceCount-1;
                    int thisDim=cntList.get(index)+1;
                    //此维+1
                    cntList.set(index, thisDim);
                }
                //归零，比如[0][6]变成[1][0]
                int index=cntList.size()-braceCount-1;
                cntList.set(index, 0);
            }
            else {
                int elements=0,dimAll=1;
                for(i=0;i<tmpDimList.size();i++){
                    dimAll*=tmpDimList.get(i);
                }
                //计算完之前的偏移量
                for(i=0;i<cntList.size()-1;i++){
                    //该层的长度乘该层的实际偏移
                    dimAll/=tmpDimList.get(i);
                    elements+=cntList.get(i)*dimAll;
                }
                for(i=0;i<ctx.constinitval().size();i++){
                    //定位到元素
                    int elemReg=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = getelementptr i32, i32* %%t%d, i32 %d", elemReg,basePointer,elements+i));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                    //赋值
                    visit(ctx.constinitval(i));
                    int value=nodeValue;
                    if(useReg){
                        int valueReg=regNumList.get(regNumList.size()-1)-1;
                        System.out.println(String.format("store i32 %%t%d, i32* %%t%d", valueReg,elemReg));
                    }
                    else {
                        System.out.println(String.format("store i32 %d, i32* %%t%d", value,elemReg));
                    }
                }
            }
            if(ctx.RBRACE()!=null){
                braceCount+=1;
            }
        }
        return null;
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
            if(ctx.LBRACKET(0)!=null){
                //数组
                Symbol globalArraySymbol=new Symbol(globalVarName,"var global array",-1);
                int dimension=ctx.LBRACKET().size();
                globalArraySymbol.setDimension(dimension);
                ArrayList<Integer> dimList=globalArraySymbol.getDimList();
                int i;
                for(i=0;i<ctx.constexp().size();i++){
                    visit(ctx.constexp(i));
                    int value=nodeValue;
                    dimList.add(value);
                }
                System.out.print(String.format("@%s = global ", globalVarName));
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                globalSym.add(globalArraySymbol);
                //看初始化情况
                if(ctx.EQUAL()==null||ctx.initval().initval(0)==null){
                    //全0
                    System.out.print(" zeroinitializer");
                }
                else {
                    tmpDimList=dimList;
                    braceCount=dimension;
                    //框起来
                    System.out.print(" [");
                    visit(ctx.initval());
                    System.out.print("]");
                }
                System.out.println();
            }
            else{
                //定义非数组
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
            }
        }
        else {
            //局部变量
            //alloca部分 声明
            this.name="";
            visit(ctx.ident());
            String varName=name;
            if(ctx.LBRACKET(0)!=null){
                //局部变量数组
                int arrayReg=regNumList.get(regNumList.size()-1);
                System.out.print(String.format("%%t%d = alloca ",arrayReg));
                Symbol varArraySymbol=new Symbol(varName,"var array",arrayReg);
                int dimension=ctx.LBRACKET().size();
                varArraySymbol.setDimension(dimension);
                ArrayList<Integer> dimList=varArraySymbol.getDimList();
                int i;
                int elements=1;
                for(i=0;i<ctx.constexp().size();i++){
                    visit(ctx.constexp(i));
                    int value=nodeValue;
                    elements*=value;
                    dimList.add(value);
                }
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                ArrayList<Symbol> curTable=symStack.peek();
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                System.out.println();
                //不管有没有初始值，先取0地址作为basePointer
                int setReg=regNumList.get(regNumList.size()-1);
                System.out.print(String.format("%%t%d = getelementptr ",setReg));
                //两个<ty>
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                System.out.print(",");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<ctx.constexp().size();i++){
                    System.out.print("]");
                }
                System.out.print(String.format("* %%t%d",arrayReg));
                for(i=0;i<dimension+1;i++){
                    System.out.print(", i32 0");
                }
                basePointer=setReg;
                varArraySymbol.setBasePointer(setReg);
                System.out.println();
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                if(ctx.EQUAL()!=null){
                    //有初始值
                    System.out.println(String.format("call void @memset(i32* %%t%d, i32 0, i32 %d) ",setReg,elements*4));
                    cntList.removeAll(cntList);
                    for(i=0;i<dimension;i++){
                        cntList.add(0);
                    }
                    tmpDimList=dimList;
                    braceCount=dimension;
                    visit(ctx.initval());
                }
                curTable.add(varArraySymbol);
            }
            else {
                //局部变量
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
            }
        }

        return null;
    }

    @Override
    public Void visitInitval(sysyParser.InitvalContext ctx) {
        if(ctx.LBRACE()==null){
            visit(ctx.exp());
        }
        else if(defGlobal){
            //全局变量数组
            int i,j,k;
            if(ctx.LBRACE()!=null){
                braceCount-=1;
            }
            if(ctx.initval(0)!=null&&ctx.initval(0).exp()==null){
                //还在外层，持续打印外层信息
                int thisDim=tmpDimList.get(tmpDimList.size()-braceCount-1);
                for(k=0;k<ctx.initval().size();k++){
                    for(j=0;j<braceCount;j++){
                        System.out.print(String.format("[%d x ",tmpDimList.get(j+tmpDimList.size()-braceCount)));
                    }
                    System.out.print("i32");
                    for(j=0;j<braceCount;j++){
                        System.out.print("]");
                    }
                    System.out.print(" [");
                    visit(ctx.initval(k));
                    System.out.print("]");
                    if(k!=thisDim-1){
                        System.out.print(", ");
                    }
                }
                if(ctx.initval().size()<thisDim){
                    //补0，用zeroinitializer
                    for(k=ctx.initval().size();k<thisDim;k++){
                        for(j=0;j<braceCount;j++){
                            System.out.print(String.format("[%d x ",tmpDimList.get(j+tmpDimList.size()-braceCount)));
                        }
                        System.out.print("i32");
                        for(j=0;j<braceCount;j++){
                            System.out.print("]");
                        }
                        System.out.print(" zeroinitializer");
                        if(k!=thisDim-1){
                            System.out.print(", ");
                        }
                    }
                }

            }
            else {
                //最内层了,直接打印
                int thisDim=tmpDimList.get(tmpDimList.size()-1);
                for(j=0;j<ctx.initval().size();j++){
                    visit(ctx.initval(j));
                    int value=nodeValue;
                    System.out.print(String.format("i32 %d",value));
                    if(j!=thisDim-1){
                        System.out.print(",");
                    }
                }

                //补0
                for(j=ctx.initval().size();j<thisDim;j++){
                    System.out.print("i32 0");
                    if(j!=thisDim-1){
                        System.out.print(",");
                    }
                }
            }
            if(ctx.RBRACE()!=null){
                braceCount+=1;
            }
        }
        else {
            //局部变量数组初始化
            int i,j;
            if(ctx.LBRACE()!=null){
                braceCount-=1;
            }
            if(ctx.initval(0)!=null&&ctx.initval(0).exp()==null){
                //外层
                for(i=0;i<ctx.initval().size();i++){
                    visit(ctx.initval(i));
                    int index=cntList.size()-braceCount-1;
                    int thisDim=cntList.get(index)+1;
                    //此维+1
                    cntList.set(index, thisDim);
                }
                //归零，比如[0][6]变成[1][0]
                int index=cntList.size()-braceCount-1;
                cntList.set(index, 0);
            }
            else {
                int elements=0,dimAll=1;
                for(i=0;i<tmpDimList.size();i++){
                    dimAll*=tmpDimList.get(i);
                }
                //计算完之前的偏移量
                for(i=0;i<cntList.size()-1;i++){
                    //该层的长度乘该层的实际偏移
                    dimAll/=tmpDimList.get(i);
                    elements+=cntList.get(i)*dimAll;
                }
                for(i=0;i<ctx.initval().size();i++){
                    //定位到元素
                    int elemReg=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = getelementptr i32, i32* %%t%d, i32 %d", elemReg,basePointer,elements+i));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                    //赋值
                    visit(ctx.initval(i));
                    int value=nodeValue;
                    if(useReg){
                        int valueReg=regNumList.get(regNumList.size()-1)-1;
                        System.out.println(String.format("store i32 %%t%d, i32* %%t%d", valueReg,elemReg));
                    }
                    else {
                        System.out.println(String.format("store i32 %d, i32* %%t%d", value,elemReg));
                    }
                }
            }
            if(ctx.RBRACE()!=null){
                braceCount+=1;
            }
        }
        return null;
    }

    @Override
    public Void visitFuncdef(sysyParser.FuncdefContext ctx) {
        this.name="";
        defGlobal=false;
        regNumList.add(1);
        String funcType="";
        if(ctx.functype().INT()!=null){
            isVoid=false;
            funcType="i32";
        }
        else {
            isVoid=true;
            funcType="void";
        }
        visit(ctx.ident());
        String funcName=name;
        FuncSymbol func=new FuncSymbol(funcName,funcType);
        funcList.add(func);
        curFunc=func;
        System.out.print(String.format("define %s @%s(",funcType,funcName));
        if(ctx.funcfparams()!=null){
            haveParam=true;
            visit(ctx.funcfparams());
        }
        System.out.print(")");
        System.out.println("{");
        visit(ctx.block());
        //占位
        if(!isVoid){
            System.out.println("ret i32 0");
        }
        else {
            System.out.println("ret void");
        }
        System.out.println("}");
        defGlobal=true;
        return null;
    }

    @Override
    public Void visitFunctype(sysyParser.FunctypeContext ctx) {
        this.type="int";
        return super.visitFunctype(ctx);
    }

    @Override
    public Void visitFuncfparams(sysyParser.FuncfparamsContext ctx) {
        paramSymList.removeAll(paramSymList);
        curFunc.setParamNum(ctx.funcfparam().size());
        for(int i=0;i<ctx.funcfparam().size();i++){
            visit(ctx.funcfparam(i));
            if(i!=ctx.funcfparam().size()-1){
                System.out.print(",");
            }
        }
        return null;
    }

    @Override
    public Void visitFuncfparam(sysyParser.FuncfparamContext ctx) {
        if(ctx.LBRACKET(0)!=null){
            //数组形参
            if(ctx.LBRACKET().size()==1){
                //一维
                visit(ctx.ident());
                String funcParamName=name;
                int paramReg=regNumList.get(regNumList.size()-1);
                System.out.print(String.format("i32* %%t%d",paramReg));
                Symbol arraySymbol=new Symbol(funcParamName,"var param array",paramReg);
                arraySymbol.setDimension(1);
                ArrayList<Integer> dimList=arraySymbol.getDimList();
                dimList.add(1);
                paramSymList.add(arraySymbol);
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
            else {
                int i;
                visit(ctx.ident());
                String funcParamName=name;
                int paramReg=regNumList.get(regNumList.size()-1);
                Symbol arraySymbol=new Symbol(funcParamName,"var param array",paramReg);
                arraySymbol.setDimension(ctx.LBRACKET().size());
                ArrayList<Integer> dimList=arraySymbol.getDimList();
                dimList.add(1);
                for(i=0;i<ctx.exp().size();i++){
                    visit(ctx.exp(i));
                    int value=nodeValue;
                    dimList.add(value);
                    System.out.print(String.format("[%d x ",value));
                }
                System.out.print("i32");
                for(i=0;i<ctx.exp().size();i++){
                    System.out.print("]");
                }
                System.out.print(String.format("* %%t%d",paramReg));
                paramSymList.add(arraySymbol);
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
        }
        else {
            visit(ctx.ident());
            String funcParamName=name;
            int paramReg=regNumList.get(regNumList.size()-1);
            System.out.print(String.format("i32 %%t%d",paramReg));
            paramSymList.add(new Symbol(funcParamName,"var",paramReg));
            regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
        }
        return null;
    }

    @Override
    public Void visitBlock(sysyParser.BlockContext ctx) {
        ArrayList<Symbol> blockSym= new ArrayList<>();
        this.symStack.push(blockSym);
//        this.regNumList.add(1);
        int i=0;
        if(haveParam){
            ArrayList<Symbol> params=curFunc.getParamList();
            for(i=0;i<paramSymList.size();i++){
                params.add(paramSymList.get(i));
            }
            for(i=0;i<paramSymList.size();i++){
                Symbol paramSym=paramSymList.get(i);
                blockSym.add(paramSym);
                if(paramSym.getType().equals("var")){
                    //变量
                    int paramReg=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = alloca i32",paramReg));
                    System.out.println(String.format("store i32 %%t%d, i32* %%t%d",paramSym.getRegNum(),paramReg));
                    paramSym.setRegNum(paramReg);
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);

                }
                else if(paramSym.getDimension()==1){
                    //一维数组
                    int paramReg=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = alloca i32*",paramReg));
                    System.out.println(String.format("store i32* %%t%d, i32* * %%t%d",paramSym.getRegNum(),paramReg));
                    paramSym.setRegNum(paramReg);
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else {
                    //二维数组
                    int paramReg=regNumList.get(regNumList.size()-1);
                    System.out.print(String.format("%%t%d = alloca ",paramReg));
                    ArrayList<Integer> dimList=paramSym.getDimList();
                    //从1开始，第一维未知
                    for(i=1;i<dimList.size();i++){
                        System.out.print(String.format("[%d x ",dimList.get(i)));
                    }
                    System.out.print("i32");
                    for(i=1;i<dimList.size();i++){
                        System.out.print("]");
                    }
                    System.out.println("*");
                    //store部分
                    System.out.print("store ");
                    for(i=1;i<dimList.size();i++){
                        System.out.print(String.format("[%d x ",dimList.get(i)));
                    }
                    System.out.print("i32");
                    for(i=1;i<dimList.size();i++){
                        System.out.print("]");
                    }
                    System.out.print(String.format("* %%t%d,",paramSym.getRegNum()));
                    for(i=1;i<dimList.size();i++){
                        System.out.print(String.format("[%d x ",dimList.get(i)));
                    }
                    System.out.print("i32");
                    for(i=1;i<dimList.size();i++){
                        System.out.print("]");
                    }
                    System.out.println(String.format("* * %%t%d",paramReg));
                    paramSym.setRegNum(paramReg);
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
            }
        }
        haveParam=false;
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
            if(ctx.lval().LBRACKET(0)!=null){
                varReg=regNumList.get(regNumList.size()-1)-1;
            }
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
            if(ctx.exp()!=null){
                visit(ctx.exp());
                System.out.print("ret ");
                System.out.print("i32 ");
                if(isVoid){
                    System.exit(-1);
                }
                else if(useReg){
                    int retReg=regNumList.get(regNumList.size()-1)-1;
                    System.out.println(String.format("%%t%d",retReg));
                }
                else {
                    System.out.println(nodeValue);
                }
            }
            else {
                System.out.print("ret ");
                System.out.println("void");
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
        if(ctx.LBRACKET(0)!=null||getArray(ctx.ident().IDENT().getText())!=null
        ||getGlobalArray(ctx.ident().IDENT().getText())!=null){
            //数组特判
            int i,j,base;
            String identName=ctx.ident().IDENT().getText();
            int varReg=getReg(identName);
            Symbol thisSymbol;
            Symbol ifParam=searchParamArray(identName);
            //load数组
            if(ifParam!=null){
                //特判参数数组
                thisSymbol=ifParam;
                int loadReg=regNumList.get(regNumList.size()-1);
                ArrayList<Integer> dimList=thisSymbol.getDimList();
                System.out.print(String.format("%%t%d = load ",loadReg));
                for(i=1;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=1;i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.print("* ,");
                for(i=1;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=1;i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.println(String.format("* * %%t%d",thisSymbol.getRegNum()));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                int setReg = regNumList.get(regNumList.size()-1);
                System.out.print(String.format("%%t%d = getelementptr ",setReg));
                for(i=1;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=1;i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.print(",");
                for(i=1;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=1;i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.println(String.format("* %%t%d, i32 0",loadReg));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                base=setReg;
            }
            else {
                Symbol arraySymbol=getGlobalArray(identName);
                boolean isGlobal=true;
                if(arraySymbol==null){
                    arraySymbol=getArray(identName);
                    isGlobal=false;
                }
                thisSymbol=arraySymbol;
                //假定都没有存basePointer
                int setReg = regNumList.get(regNumList.size()-1);
                ArrayList<Integer> dimList=arraySymbol.getDimList();
                System.out.print(String.format("%%t%d = getelementptr ",setReg));
                //两个<ty>
                for(i=0;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.print(",");
                for(i=0;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=0;i<dimList.size();i++){
                    System.out.print("]");
                }
                if(isGlobal){
                    System.out.print(String.format("* @%s",arraySymbol.getSymName()));
                }
                else {
                    System.out.print(String.format("* %%t%d",arraySymbol.getRegNum()));
                }
                for(i=0;i<ctx.LBRACKET().size()+1;i++){
                    System.out.print(", i32 0");
                }
                System.out.println();
                arraySymbol.setBasePointer(setReg);
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                //获取basePointer
                base=arraySymbol.getBasePointer();
            }
            //获取基地址后，计算偏移量
            int dimAll=1;
            ArrayList<Integer> dimList=thisSymbol.getDimList();
            for(i=0;i<thisSymbol.getDimension();i++){
                dimAll*=dimList.get(i);
            }
            if(ctx.LBRACKET().size()!=thisSymbol.getDimension()){
                //不是元素不load
                shouldLoad=false;
            }
            //计数基准寄存器，值为0
            int cntBase=regNumList.get(regNumList.size()-1);
            System.out.println(String.format("%%t%d = add i32 0, 0",cntBase));
            regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            for(i=0;i<ctx.exp().size();i++){
                dimAll/=dimList.get(i);
                visit(ctx.exp(i));
                if(useReg){
                    int tmpReg=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = mul i32 %%t%d, %d",tmpReg,tmpReg-1,dimAll));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                    tmpReg=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = add i32 %%t%d, %%t%d",tmpReg,cntBase,tmpReg-1));
                    cntBase=tmpReg;
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                else {
                    int value=nodeValue*dimAll;
                    int tmpReg=regNumList.get(regNumList.size()-1);
                    System.out.println(String.format("%%t%d = add i32 %%t%d, %d",tmpReg,cntBase,value));
                    cntBase=tmpReg;
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
            }
            //bias
            int biasReg=regNumList.get(regNumList.size()-1);
            if(ifParam!=null){
                //特判参数数组偏移
                System.out.print(String.format("%%t%d = getelementptr ",biasReg));
                for(i=1;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=1;i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.print(",");
                for(i=1;i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=1;i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.print(String.format("* %%t%d",base));
                for(i=1;i<dimList.size();i++){
                    System.out.print(",i32 0");
                }
                System.out.println(String.format(",i32 %%t%d",cntBase));
            }
            else {
                System.out.print(String.format("%%t%d = getelementptr ",biasReg));
                for(i=ctx.LBRACKET().size();i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=ctx.LBRACKET().size();i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.print(",");
                for(i=ctx.LBRACKET().size();i<dimList.size();i++){
                    System.out.print(String.format("[%d x ",dimList.get(i)));
                }
                System.out.print("i32");
                for(i=ctx.LBRACKET().size();i<dimList.size();i++){
                    System.out.print("]");
                }
                System.out.print(String.format("* %%t%d",base));
                for(i=ctx.LBRACKET().size();i<dimList.size();i++){
                    System.out.print(",i32 0");
                }
                System.out.println(String.format(",i32 %%t%d",cntBase));
            }
            regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
        }
        else {
            visit(ctx.ident());
        }
        return null;
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
                if(ctx.funcrparams().children.size()!=1){
                    System.exit(-1);
                }
                visit(ctx.funcrparams().exp(0));
                isReg=true;
                useReg=true;
                register_num=regNumList.get(regNumList.size()-1);
                System.out.println(String.format("%%t%d = call i32 @getarray(i32 * %%t%d)",register_num,register_num-1));
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
            else if(funcName.equals("putint")){
                if(ctx.funcrparams() ==null || ctx.funcrparams().children.size()>1){
                    System.exit(-1);
                }
                isReg=false;
//                useReg=false;
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
                if(ctx.funcrparams().exp().size()!=2||ctx.funcrparams()==null){
                    System.exit(-1);
                }
                int lenValue=0,lenReg=0,arrayReg;
                visit(ctx.funcrparams().exp(0));
                boolean lenUse=useReg;
                if(lenUse){
                    lenReg=regNumList.get(regNumList.size()-1)-1;
                }
                else {
                    lenValue=nodeValue;
                }
                visit(ctx.funcrparams().exp(1));
                arrayReg=regNumList.get(regNumList.size()-1)-1;
                //调用
                if(lenUse){
                    System.out.println(String.format("call void @putarray(i32 %%t%d,i32* %%t%d)",lenReg,arrayReg));
                }
                else {
                    System.out.println(String.format("call void @putarray(i32 %d,i32* %%t%d)",lenValue,arrayReg));
                }
            }
            else {
                int i,j;
                FuncSymbol thisFunc=searchFunc(funcName);
                if(thisFunc==null){
                    System.exit(-1);
                }
                ArrayList<Integer> regList=new ArrayList<>();
                ArrayList<Integer> valueList=new ArrayList<>();
                if(ctx.funcrparams()!=null){
                    for(i=0;i<ctx.funcrparams().exp().size();i++){
                        visit(ctx.funcrparams().exp(i));
                        if(useReg){
                            regList.add(regNumList.get(regNumList.size()-1)-1);
                            valueList.add(0);
                        }
                        else {
                            regList.add(-1);
                            valueList.add(nodeValue);
                        }
                    }
                }
                if(thisFunc.getFuncType().equals("void")){
                    System.out.print(String.format("call void @%s(",funcName));
                }
                else {
                    int retReg=regNumList.get(regNumList.size()-1);
                    useReg=true;
                    System.out.print(String.format("%%t%d = call i32 @%s(",retReg,funcName));
                    regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
                }
                ArrayList<Symbol> paramList=thisFunc.getParamList();
                for(i=0;i<regList.size();i++){
                    Symbol paramSymbol=paramList.get(i);
                    if(paramSymbol.getType().equals("var")){
                        if(regList.get(i)!=-1){
                            System.out.print(String.format("i32 %%t%d",regList.get(i)));
                        }
                        else {
                            System.out.print(String.format("i32 %d",valueList.get(i)));
                        }
                    }
                    else if(paramSymbol.getDimension()==1){
                        System.out.print(String.format("i32* %%t%d",regList.get(i)));
                    }
                    else {
                        for(j=1;j<paramSymbol.getDimList().size();j++){
                            System.out.print(String.format("[%d x ",paramSymbol.getDimList().get(j)));
                        }
                        System.out.print("i32");
                        for(j=1;j<paramSymbol.getDimList().size();j++){
                            System.out.print("]");
                        }
                        System.out.print(String.format("* %%t%d",regList.get(i)));
                    }
                    if(i!=regList.size()-1){
                        System.out.print(",");
                    }
                }
                System.out.println(")");
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

                String identName=ctx.lval().ident().IDENT().getText();
                int varReg=getReg(identName);
                register_num = regNumList.get(regNumList.size()-1);
                if(ctx.lval().LBRACKET(0)!=null||getArray(ctx.lval().ident().IDENT().getText())!=null
                ||getGlobalArray(ctx.lval().ident().IDENT().getText())!=null){
                    //数组
                    shouldLoad=true;
                    visit(ctx.lval());
                    if(shouldLoad){
                        isReg=true;
                        useReg=true;
                        register_num = regNumList.get(regNumList.size()-1);
                        System.out.println(String.format("%%t%d = load i32, i32* %%t%d", register_num, register_num-1));
                    }
                    else {
                        //不load，就不用寄存器+1
                        regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)-1);
                    }
                    shouldLoad=true;
                }
                else if(varReg==-1){
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
                if(useReg){
                    System.out.println(String.format("%%t%d = icmp ne i32 %%t%d, 0",register_num,register_num-1));
                }
                else {
                    int value=nodeValue;
                    System.out.println(String.format("%%t%d = icmp ne i32 %d, 0",register_num,value));
                }
                regNumList.set(regNumList.size()-1, regNumList.get(regNumList.size()-1)+1);
            }
        }
        else {
            singleBool=true;
            int leftReg,rightReg;
            visit(ctx.landexp());
            //这里不用在判断单符合，因为landexp时已经在上面会判断的
            leftReg=regNumList.get(regNumList.size()-1)-1;
            singleBool=true;
            visit(ctx.eqexp());
            if(singleBool){
                register_num=regNumList.get(regNumList.size()-1);
                if(useReg){
                    System.out.println(String.format("%%t%d = icmp ne i32 %%t%d, 0",register_num,register_num-1));
                }
                else {
                    int value=nodeValue;
                    System.out.println(String.format("%%t%d = icmp ne i32 %d, 0",register_num,value));
                }
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

    public Symbol getArray(String str){
        int i,j;
        for (i=symStack.size()-1;i>=0;i--){
            ArrayList<Symbol> tmp=symStack.get(i);
            for(j=tmp.size()-1;j>=0;j--){
                if(str.equals(tmp.get(j).getSymName())&&(tmp.get(j).getType().equals("var array")||
                tmp.get(j).getType().equals("const array")||tmp.get(j).getType().equals("var param array"))){
                    return tmp.get(j);
                }
            }
        }
        return null;
    }

    public Symbol getGlobalArray(String str){
        int i;
        for(i=globalSym.size()-1;i>=0;i--){
            if(str.equals(globalSym.get(i).getSymName())&&(globalSym.get(i).getType().equals("const global array")||
                    globalSym.get(i).getType().equals("var global array"))){
                return globalSym.get(i);
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

    public Symbol searchParamArray(String str){
        int i,j;
        for (i=symStack.size()-1;i>=0;i--){
            ArrayList<Symbol> tmp=symStack.get(i);
            for(j=tmp.size()-1;j>=0;j--){
                if(str.equals(tmp.get(j).getSymName())&&tmp.get(j).getType().equals("var param array")){
                    return tmp.get(j);
                }
            }
        }
        return null;
    }

    public FuncSymbol searchFunc(String str){
        int i;
        for(i=0;i<funcList.size();i++){
            if(str.equals(funcList.get(i).getFuncName())){
                return funcList.get(i);
            }
        }
        return null;
    }

}
