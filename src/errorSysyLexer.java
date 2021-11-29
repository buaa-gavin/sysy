import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.LexerNoViableAltException;

public class errorSysyLexer extends sysyLexer{

    public errorSysyLexer(CharStream input) {
        super(input);
    }

    public void recover(LexerNoViableAltException e){
        throw new RuntimeException(e);
    }
}
