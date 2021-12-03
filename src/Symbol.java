import java.util.ArrayList;

public class Symbol {
    private String symName;
    private String type;
    private int value;
    private int regNum;
    private int dimension;
    private int basePointer;

    public int getBasePointer() {
        return basePointer;
    }

    public void setBasePointer(int basePointer) {
        this.basePointer = basePointer;
    }

    private ArrayList<Integer> dimList;//存放各维度的尺寸

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public ArrayList<Integer> getDimList() {
        return dimList;
    }

    public int getDimension() {
        return dimension;
    }

    public int getRegNum() {
        return regNum;
    }

    public String getType() {
        return type;
    }

    public String getSymName() {
        return symName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Symbol(String symName, String type, int regNum){
        this.symName=symName;
        this.type=type;
        this.regNum=regNum;
        this.dimList=new ArrayList<>();
        this.basePointer=-1;
    }
}
