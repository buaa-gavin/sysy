// Generated from sysy.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link sysyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface sysyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link sysyParser#compunit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompunit(sysyParser.CompunitContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(sysyParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#constdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstdecl(sysyParser.ConstdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBtype(sysyParser.BtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#constdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstdef(sysyParser.ConstdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#constinitval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstinitval(sysyParser.ConstinitvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#constexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstexp(sysyParser.ConstexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(sysyParser.VardeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#vardef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardef(sysyParser.VardefContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#initval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitval(sysyParser.InitvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(sysyParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#functype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctype(sysyParser.FunctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(sysyParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#blockitem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockitem(sysyParser.BlockitemContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(sysyParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#lval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLval(sysyParser.LvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(sysyParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#addexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexp(sysyParser.AddexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#mulexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulexp(sysyParser.MulexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#unaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexp(sysyParser.UnaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#primaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryexp(sysyParser.PrimaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#funcrparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncrparams(sysyParser.FuncrparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#unaryop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryop(sysyParser.UnaryopContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(sysyParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(sysyParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#decimal_const}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_const(sysyParser.Decimal_constContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#octal_const}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOctal_const(sysyParser.Octal_constContext ctx);
	/**
	 * Visit a parse tree produced by {@link sysyParser#hexadecimal_const}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimal_const(sysyParser.Hexadecimal_constContext ctx);
}