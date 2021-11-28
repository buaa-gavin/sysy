

public class Symbol {
    private String symName;
    private String type;
    private int value;
    private int regNum;

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
    }
}
