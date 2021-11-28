// Generated from sysy.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sysyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONST=1, DOT=2, SEMI=3, INT=4, EQUAL=5, LPAREN=6, RPAREN=7, LBRACE=8, 
		RBRACE=9, RETURN=10, ADD=11, SUB=12, MUL=13, DIV=14, MOD=15, DECIMAL_CONST=16, 
		OCTAL_CONST=17, HEXADECIMAL_CONST=18, IDENT=19, WHITE_SPACE=20;
	public static final int
		RULE_compunit = 0, RULE_decl = 1, RULE_constdecl = 2, RULE_btype = 3, 
		RULE_constdef = 4, RULE_constinitval = 5, RULE_constexp = 6, RULE_vardecl = 7, 
		RULE_vardef = 8, RULE_initval = 9, RULE_funcdef = 10, RULE_functype = 11, 
		RULE_block = 12, RULE_blockitem = 13, RULE_stmt = 14, RULE_lval = 15, 
		RULE_exp = 16, RULE_addexp = 17, RULE_mulexp = 18, RULE_unaryexp = 19, 
		RULE_primaryexp = 20, RULE_funcrparams = 21, RULE_unaryop = 22, RULE_ident = 23, 
		RULE_number = 24, RULE_decimal_const = 25, RULE_octal_const = 26, RULE_hexadecimal_const = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"compunit", "decl", "constdecl", "btype", "constdef", "constinitval", 
			"constexp", "vardecl", "vardef", "initval", "funcdef", "functype", "block", 
			"blockitem", "stmt", "lval", "exp", "addexp", "mulexp", "unaryexp", "primaryexp", 
			"funcrparams", "unaryop", "ident", "number", "decimal_const", "octal_const", 
			"hexadecimal_const"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "','", "';'", "'int'", "'='", "'('", "')'", "'{'", "'}'", 
			"'return'", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONST", "DOT", "SEMI", "INT", "EQUAL", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "RETURN", "ADD", "SUB", "MUL", "DIV", "MOD", "DECIMAL_CONST", 
			"OCTAL_CONST", "HEXADECIMAL_CONST", "IDENT", "WHITE_SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "sysy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public sysyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompunitContext extends ParserRuleContext {
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public CompunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compunit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitCompunit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompunitContext compunit() throws RecognitionException {
		CompunitContext _localctx = new CompunitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compunit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			funcdef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public ConstdeclContext constdecl() {
			return getRuleContext(ConstdeclContext.class,0);
		}
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				constdecl();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				vardecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstdeclContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(sysyParser.CONST, 0); }
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public List<ConstdefContext> constdef() {
			return getRuleContexts(ConstdefContext.class);
		}
		public ConstdefContext constdef(int i) {
			return getRuleContext(ConstdefContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(sysyParser.SEMI, 0); }
		public List<TerminalNode> DOT() { return getTokens(sysyParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(sysyParser.DOT, i);
		}
		public ConstdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constdecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitConstdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstdeclContext constdecl() throws RecognitionException {
		ConstdeclContext _localctx = new ConstdeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(CONST);
			setState(63);
			btype();
			setState(64);
			constdef();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(65);
				match(DOT);
				setState(66);
				constdef();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BtypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(sysyParser.INT, 0); }
		public BtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitBtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_btype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstdefContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(sysyParser.EQUAL, 0); }
		public ConstinitvalContext constinitval() {
			return getRuleContext(ConstinitvalContext.class,0);
		}
		public ConstdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitConstdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstdefContext constdef() throws RecognitionException {
		ConstdefContext _localctx = new ConstdefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			ident();
			setState(77);
			match(EQUAL);
			setState(78);
			constinitval();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstinitvalContext extends ParserRuleContext {
		public ConstexpContext constexp() {
			return getRuleContext(ConstexpContext.class,0);
		}
		public ConstinitvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constinitval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitConstinitval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstinitvalContext constinitval() throws RecognitionException {
		ConstinitvalContext _localctx = new ConstinitvalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constinitval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			constexp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstexpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ConstexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitConstexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstexpContext constexp() throws RecognitionException {
		ConstexpContext _localctx = new ConstexpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			addexp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclContext extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public List<VardefContext> vardef() {
			return getRuleContexts(VardefContext.class);
		}
		public VardefContext vardef(int i) {
			return getRuleContext(VardefContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(sysyParser.SEMI, 0); }
		public List<TerminalNode> DOT() { return getTokens(sysyParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(sysyParser.DOT, i);
		}
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitVardecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			btype();
			setState(85);
			vardef();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(86);
				match(DOT);
				setState(87);
				vardef();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardefContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(sysyParser.EQUAL, 0); }
		public InitvalContext initval() {
			return getRuleContext(InitvalContext.class,0);
		}
		public VardefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitVardef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardefContext vardef() throws RecognitionException {
		VardefContext _localctx = new VardefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_vardef);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				ident();
				setState(97);
				match(EQUAL);
				setState(98);
				initval();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitvalContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InitvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitInitval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitvalContext initval() throws RecognitionException {
		InitvalContext _localctx = new InitvalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_initval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdefContext extends ParserRuleContext {
		public FunctypeContext functype() {
			return getRuleContext(FunctypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(sysyParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(sysyParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			functype();
			setState(105);
			ident();
			setState(106);
			match(LPAREN);
			setState(107);
			match(RPAREN);
			setState(108);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(sysyParser.INT, 0); }
		public FunctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitFunctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctypeContext functype() throws RecognitionException {
		FunctypeContext _localctx = new FunctypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(sysyParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(sysyParser.RBRACE, 0); }
		public List<BlockitemContext> blockitem() {
			return getRuleContexts(BlockitemContext.class);
		}
		public BlockitemContext blockitem(int i) {
			return getRuleContext(BlockitemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(LBRACE);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << SEMI) | (1L << INT) | (1L << LPAREN) | (1L << RETURN) | (1L << ADD) | (1L << SUB) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
				{
				{
				setState(113);
				blockitem();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockitemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockitem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitBlockitem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockitemContext blockitem() throws RecognitionException {
		BlockitemContext _localctx = new BlockitemContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blockitem);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				decl();
				}
				break;
			case SEMI:
			case LPAREN:
			case RETURN:
			case ADD:
			case SUB:
			case DECIMAL_CONST:
			case OCTAL_CONST:
			case HEXADECIMAL_CONST:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(sysyParser.EQUAL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(sysyParser.SEMI, 0); }
		public TerminalNode RETURN() { return getToken(sysyParser.RETURN, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmt);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				lval();
				setState(126);
				match(EQUAL);
				setState(127);
				exp();
				setState(128);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << ADD) | (1L << SUB) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
					{
					setState(130);
					exp();
					}
				}

				setState(133);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(RETURN);
				setState(135);
				exp();
				setState(136);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public LvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitLval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalContext lval() throws RecognitionException {
		LvalContext _localctx = new LvalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			addexp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddexpContext extends ParserRuleContext {
		public MulexpContext mulexp() {
			return getRuleContext(MulexpContext.class,0);
		}
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public TerminalNode ADD() { return getToken(sysyParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(sysyParser.SUB, 0); }
		public AddexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitAddexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexpContext addexp() throws RecognitionException {
		return addexp(0);
	}

	private AddexpContext addexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddexpContext _localctx = new AddexpContext(_ctx, _parentState);
		AddexpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_addexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(145);
			mulexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addexp);
					setState(147);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(148);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(149);
					mulexp(0);
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulexpContext extends ParserRuleContext {
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public MulexpContext mulexp() {
			return getRuleContext(MulexpContext.class,0);
		}
		public TerminalNode MUL() { return getToken(sysyParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(sysyParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(sysyParser.MOD, 0); }
		public MulexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitMulexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulexpContext mulexp() throws RecognitionException {
		return mulexp(0);
	}

	private MulexpContext mulexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulexpContext _localctx = new MulexpContext(_ctx, _parentState);
		MulexpContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_mulexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(156);
			unaryexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulexp);
					setState(158);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(159);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(160);
					unaryexp();
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryexpContext extends ParserRuleContext {
		public PrimaryexpContext primaryexp() {
			return getRuleContext(PrimaryexpContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(sysyParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(sysyParser.RPAREN, 0); }
		public FuncrparamsContext funcrparams() {
			return getRuleContext(FuncrparamsContext.class,0);
		}
		public UnaryopContext unaryop() {
			return getRuleContext(UnaryopContext.class,0);
		}
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public UnaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitUnaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexpContext unaryexp() throws RecognitionException {
		UnaryexpContext _localctx = new UnaryexpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryexp);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				primaryexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				ident();
				setState(168);
				match(LPAREN);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << ADD) | (1L << SUB) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
					{
					setState(169);
					funcrparams();
					}
				}

				setState(172);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				unaryop();
				setState(175);
				unaryexp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryexpContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(sysyParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(sysyParser.RPAREN, 0); }
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PrimaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitPrimaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexpContext primaryexp() throws RecognitionException {
		PrimaryexpContext _localctx = new PrimaryexpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryexp);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(LPAREN);
				setState(180);
				exp();
				setState(181);
				match(RPAREN);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				lval();
				}
				break;
			case DECIMAL_CONST:
			case OCTAL_CONST:
			case HEXADECIMAL_CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncrparamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(sysyParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(sysyParser.DOT, i);
		}
		public FuncrparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcrparams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitFuncrparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncrparamsContext funcrparams() throws RecognitionException {
		FuncrparamsContext _localctx = new FuncrparamsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_funcrparams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			exp();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(188);
				match(DOT);
				setState(189);
				exp();
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryopContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(sysyParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(sysyParser.SUB, 0); }
		public UnaryopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitUnaryop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryopContext unaryop() throws RecognitionException {
		UnaryopContext _localctx = new UnaryopContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(sysyParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public Decimal_constContext decimal_const() {
			return getRuleContext(Decimal_constContext.class,0);
		}
		public Octal_constContext octal_const() {
			return getRuleContext(Octal_constContext.class,0);
		}
		public Hexadecimal_constContext hexadecimal_const() {
			return getRuleContext(Hexadecimal_constContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_number);
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				decimal_const();
				}
				break;
			case OCTAL_CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				octal_const();
				}
				break;
			case HEXADECIMAL_CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				hexadecimal_const();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decimal_constContext extends ParserRuleContext {
		public TerminalNode DECIMAL_CONST() { return getToken(sysyParser.DECIMAL_CONST, 0); }
		public Decimal_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_const; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitDecimal_const(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decimal_constContext decimal_const() throws RecognitionException {
		Decimal_constContext _localctx = new Decimal_constContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_decimal_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(DECIMAL_CONST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Octal_constContext extends ParserRuleContext {
		public TerminalNode OCTAL_CONST() { return getToken(sysyParser.OCTAL_CONST, 0); }
		public Octal_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octal_const; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitOctal_const(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Octal_constContext octal_const() throws RecognitionException {
		Octal_constContext _localctx = new Octal_constContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_octal_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(OCTAL_CONST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Hexadecimal_constContext extends ParserRuleContext {
		public TerminalNode HEXADECIMAL_CONST() { return getToken(sysyParser.HEXADECIMAL_CONST, 0); }
		public Hexadecimal_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexadecimal_const; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitHexadecimal_const(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Hexadecimal_constContext hexadecimal_const() throws RecognitionException {
		Hexadecimal_constContext _localctx = new Hexadecimal_constContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_hexadecimal_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(HEXADECIMAL_CONST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return addexp_sempred((AddexpContext)_localctx, predIndex);
		case 18:
			return mulexp_sempred((MulexpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean addexp_sempred(AddexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mulexp_sempred(MulexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00d5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\5\3?\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\7\t[\n\t\f\t\16\t^\13\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\5\ng\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\7\16u\n\16\f\16\16\16x\13\16\3\16\3\16\3\17\3\17\5\17~\n\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u0086\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u008d\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u0099\n\23\f\23\16\23\u009c\13\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u00a4\n\24\f\24\16\24\u00a7\13\24\3\25\3\25\3\25\3\25\5\25\u00ad\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u00b4\n\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u00bc\n\26\3\27\3\27\3\27\7\27\u00c1\n\27\f\27\16\27\u00c4\13\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u00cd\n\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\35\2\4$&\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668\2\4\3\2\r\16\3\2\17\21\2\u00cb\2:\3\2\2\2\4>\3\2\2\2"+
		"\6@\3\2\2\2\bL\3\2\2\2\nN\3\2\2\2\fR\3\2\2\2\16T\3\2\2\2\20V\3\2\2\2\22"+
		"f\3\2\2\2\24h\3\2\2\2\26j\3\2\2\2\30p\3\2\2\2\32r\3\2\2\2\34}\3\2\2\2"+
		"\36\u008c\3\2\2\2 \u008e\3\2\2\2\"\u0090\3\2\2\2$\u0092\3\2\2\2&\u009d"+
		"\3\2\2\2(\u00b3\3\2\2\2*\u00bb\3\2\2\2,\u00bd\3\2\2\2.\u00c5\3\2\2\2\60"+
		"\u00c7\3\2\2\2\62\u00cc\3\2\2\2\64\u00ce\3\2\2\2\66\u00d0\3\2\2\28\u00d2"+
		"\3\2\2\2:;\5\26\f\2;\3\3\2\2\2<?\5\6\4\2=?\5\20\t\2><\3\2\2\2>=\3\2\2"+
		"\2?\5\3\2\2\2@A\7\3\2\2AB\5\b\5\2BG\5\n\6\2CD\7\4\2\2DF\5\n\6\2EC\3\2"+
		"\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\5\2\2K\7\3"+
		"\2\2\2LM\7\6\2\2M\t\3\2\2\2NO\5\60\31\2OP\7\7\2\2PQ\5\f\7\2Q\13\3\2\2"+
		"\2RS\5\16\b\2S\r\3\2\2\2TU\5$\23\2U\17\3\2\2\2VW\5\b\5\2W\\\5\22\n\2X"+
		"Y\7\4\2\2Y[\5\22\n\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2"+
		"\2^\\\3\2\2\2_`\7\5\2\2`\21\3\2\2\2ag\5\60\31\2bc\5\60\31\2cd\7\7\2\2"+
		"de\5\24\13\2eg\3\2\2\2fa\3\2\2\2fb\3\2\2\2g\23\3\2\2\2hi\5\"\22\2i\25"+
		"\3\2\2\2jk\5\30\r\2kl\5\60\31\2lm\7\b\2\2mn\7\t\2\2no\5\32\16\2o\27\3"+
		"\2\2\2pq\7\6\2\2q\31\3\2\2\2rv\7\n\2\2su\5\34\17\2ts\3\2\2\2ux\3\2\2\2"+
		"vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\13\2\2z\33\3\2\2\2{~\5\4"+
		"\3\2|~\5\36\20\2}{\3\2\2\2}|\3\2\2\2~\35\3\2\2\2\177\u0080\5 \21\2\u0080"+
		"\u0081\7\7\2\2\u0081\u0082\5\"\22\2\u0082\u0083\7\5\2\2\u0083\u008d\3"+
		"\2\2\2\u0084\u0086\5\"\22\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u008d\7\5\2\2\u0088\u0089\7\f\2\2\u0089\u008a\5\""+
		"\22\2\u008a\u008b\7\5\2\2\u008b\u008d\3\2\2\2\u008c\177\3\2\2\2\u008c"+
		"\u0085\3\2\2\2\u008c\u0088\3\2\2\2\u008d\37\3\2\2\2\u008e\u008f\5\60\31"+
		"\2\u008f!\3\2\2\2\u0090\u0091\5$\23\2\u0091#\3\2\2\2\u0092\u0093\b\23"+
		"\1\2\u0093\u0094\5&\24\2\u0094\u009a\3\2\2\2\u0095\u0096\f\3\2\2\u0096"+
		"\u0097\t\2\2\2\u0097\u0099\5&\24\2\u0098\u0095\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b%\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u009e\b\24\1\2\u009e\u009f\5(\25\2\u009f\u00a5\3\2\2\2"+
		"\u00a0\u00a1\f\3\2\2\u00a1\u00a2\t\3\2\2\u00a2\u00a4\5(\25\2\u00a3\u00a0"+
		"\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\'\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00b4\5*\26\2\u00a9\u00aa\5\60\31"+
		"\2\u00aa\u00ac\7\b\2\2\u00ab\u00ad\5,\27\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\t\2\2\u00af\u00b4\3\2\2\2\u00b0"+
		"\u00b1\5.\30\2\u00b1\u00b2\5(\25\2\u00b2\u00b4\3\2\2\2\u00b3\u00a8\3\2"+
		"\2\2\u00b3\u00a9\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4)\3\2\2\2\u00b5\u00b6"+
		"\7\b\2\2\u00b6\u00b7\5\"\22\2\u00b7\u00b8\7\t\2\2\u00b8\u00bc\3\2\2\2"+
		"\u00b9\u00bc\5 \21\2\u00ba\u00bc\5\62\32\2\u00bb\u00b5\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc+\3\2\2\2\u00bd\u00c2\5\"\22\2\u00be"+
		"\u00bf\7\4\2\2\u00bf\u00c1\5\"\22\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3-\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c5\u00c6\t\2\2\2\u00c6/\3\2\2\2\u00c7\u00c8\7\25\2\2\u00c8"+
		"\61\3\2\2\2\u00c9\u00cd\5\64\33\2\u00ca\u00cd\5\66\34\2\u00cb\u00cd\5"+
		"8\35\2\u00cc\u00c9\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\63\3\2\2\2\u00ce\u00cf\7\22\2\2\u00cf\65\3\2\2\2\u00d0\u00d1\7\23\2\2"+
		"\u00d1\67\3\2\2\2\u00d2\u00d3\7\24\2\2\u00d39\3\2\2\2\21>G\\fv}\u0085"+
		"\u008c\u009a\u00a5\u00ac\u00b3\u00bb\u00c2\u00cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}