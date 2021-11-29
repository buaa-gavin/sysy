import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        String input = "int main() {\n" +
                "    const int Nqn7m1 = 010;\n" +
                "    int yiersan = 456;\n" +
                "    int mAgIc_NuMbEr;\n" +
                "    mAgIc_NuMbEr = 8456;\n" +
                "    int a1a11a11 = (mAgIc_NuMbEr - yiersan) / 1000 - Nqn7m1, _CHAOS_TOKEN;\n" +
                "    _CHAOS_TOKEN = 2;\n" +
                "    a1a11a11 = a1a11a11 + _CHAOS_TOKEN;\n" +
                "    return a1a11a11 - _CHAOS_TOKEN + 000;\n" +
                "}";


//        try {
//            System.setOut(new PrintStream(args[1]));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        String filename=args[0];
        CharStream inputStream = null; // 获取输入流
        try {
            inputStream = CharStreams.fromFileName(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(inputStream);

        //preprocess, without notation
        int i=0;
        StringBuilder stringBuilder=new StringBuilder(inputStream.toString());
        StringBuilder outInput=new StringBuilder();
        for(i=0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i)=='/'){
                if(stringBuilder.charAt(i+1)=='/'){
                    while (stringBuilder.charAt(i)!='\n'){
                        i+=1;
                    }
                }
                else if(stringBuilder.charAt(i+1)=='*'){
                    i+=2;
                    while (stringBuilder.charAt(i)!='*'&&stringBuilder.charAt(i+1)!='/'){
                        i+=1;
                    }
                    i+=2;
                }
            }
            outInput.append(stringBuilder.charAt(i));
        }
        //preprocess over
        inputStream=CharStreams.fromString(outInput.toString());
        sysyLexer lexer = new sysyLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer); // 词法分析获取 token 流
        sysyParser parser = new sysyParser(tokenStream);
        ParseTree tree = parser.compunit(); // 获取语法树的根节点
        PreVisit preVisit=new PreVisit();
        preVisit.visit(tree);
        Visitor visitor = new Visitor();
        visitor.visit(tree);
    }
}