import java.util.ArrayList;

public class FuncSymbol {
    private String funcName;
    private String funcType;
    private int paramNum;
    private ArrayList<Symbol> paramList;

    public String getFuncType() {
        return funcType;
    }

    public FuncSymbol(String funcName, String funcType){
        this.funcName=funcName;
        this.funcType=funcType;
        this.paramList=new ArrayList<>();
    }

    public void setParamNum(int paramNum) {
        this.paramNum = paramNum;
    }

    public String getFuncName() {
        return funcName;
    }

    public ArrayList<Symbol> getParamList() {
        return paramList;
    }

    public int getParamNum() {
        return paramNum;
    }
}
