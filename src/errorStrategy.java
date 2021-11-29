import org.antlr.v4.runtime.*;

public class errorStrategy extends DefaultErrorStrategy {
    @Override public Token recoverInline(Parser recognizer) throws RecognitionException {
        throw new RuntimeException(new InputMismatchException(recognizer));
    }

    @Override public void sync(Parser recognizer){}

    @Override public void recover(Parser recognizer,RecognitionException e){
        throw new RuntimeException(e);
    }
}