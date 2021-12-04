import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class PreVisit extends sysyBaseVisitor<Void>{
    private String name;
    boolean flag1=false,flag2=false,flag3=false,flag4=false,flag5=false,flag6=false,flagArray=false;

    @Override
    public Void visitConstdef(sysyParser.ConstdefContext ctx){
        if(ctx.LBRACKET()!=null && !flagArray){
            System.out.println("declare void @memset(i32*, i32, i32)");
            flagArray=true;
        }
        return null;
    }

    @Override
    public Void visitVardef(sysyParser.VardefContext ctx){
        if(ctx.LBRACKET()!=null && !flagArray){
            System.out.println("declare void @memset(i32*, i32, i32)");
            flagArray=true;
            return null;
        }
        else {
            return super.visitVardef(ctx);
        }
    }

    @Override
    public Void visitUnaryexp(sysyParser.UnaryexpContext ctx){
        if(ctx.LPAREN()!=null){
            visit(ctx.ident());
            if(name.equals("getint")&&!flag1){
                System.out.println("declare i32 @getint()");
                flag1=true;
            }
            else if(name.equals("getch")&&!flag2){
                System.out.println("declare i32 @getch()");
                flag2=true;
            }
            else if(name.equals("getarray")&&!flag3){
                System.out.println("declare i32 @getarray(i32*)");
                flag3=true;
            }
            else if(name.equals("putint")&&!flag4){
                System.out.println("declare void @putint(i32)");
                flag4=true;
            }
            else if(name.equals("putch")&&!flag5){
                System.out.println("declare void @putch(i32)");
                flag5=true;
            }
            else if(name.equals("putarray")&&!flag6){
                System.out.println("declare void @putarray(i32,i32*)");
                flag6=true;
            }
            return null;
        }
        else {
            return super.visitUnaryexp(ctx);
        }
    }

    @Override
    public Void visitIdent(sysyParser.IdentContext ctx){
        name= ctx.IDENT().getText();
        return null;
    }
}
