import java.util.ArrayList;

public class FuncSymbol {
    private String funcName;
    private int paramNum;
    private ArrayList<Symbol> paramList;

    public void setParamList(ArrayList<Symbol> paramList) {
        this.paramList = paramList;
    }

    public FuncSymbol(String funcName){
        this.funcName=funcName;
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
