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
		RBRACE=9, LBRACKET=10, RBRACKET=11, RETURN=12, ADD=13, SUB=14, NOT=15, 
		MUL=16, DIV=17, MOD=18, IF=19, ELSE=20, WHILE=21, BREAK=22, CONTINUE=23, 
		LESS=24, GREATER=25, LESS_OR_EQUAL=26, GREATER_OR_EQUAL=27, LOGICAL_EQUAL=28, 
		LOGICAL_NOT_EQUAL=29, LOGICAL_AND=30, LOGICAL_OR=31, DECIMAL_CONST=32, 
		OCTAL_CONST=33, HEXADECIMAL_CONST=34, IDENT=35, WHITE_SPACE=36;
	public static final int
		RULE_compunit = 0, RULE_decl = 1, RULE_constdecl = 2, RULE_btype = 3, 
		RULE_constdef = 4, RULE_constinitval = 5, RULE_constexp = 6, RULE_vardecl = 7, 
		RULE_vardef = 8, RULE_initval = 9, RULE_funcdef = 10, RULE_functype = 11, 
		RULE_block = 12, RULE_blockitem = 13, RULE_stmt = 14, RULE_lval = 15, 
		RULE_exp = 16, RULE_cond = 17, RULE_unaryexp = 18, RULE_primaryexp = 19, 
		RULE_funcrparams = 20, RULE_unaryop = 21, RULE_addexp = 22, RULE_mulexp = 23, 
		RULE_relexp = 24, RULE_eqexp = 25, RULE_landexp = 26, RULE_lorexp = 27, 
		RULE_ident = 28, RULE_number = 29, RULE_decimal_const = 30, RULE_octal_const = 31, 
		RULE_hexadecimal_const = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"compunit", "decl", "constdecl", "btype", "constdef", "constinitval", 
			"constexp", "vardecl", "vardef", "initval", "funcdef", "functype", "block", 
			"blockitem", "stmt", "lval", "exp", "cond", "unaryexp", "primaryexp", 
			"funcrparams", "unaryop", "addexp", "mulexp", "relexp", "eqexp", "landexp", 
			"lorexp", "ident", "number", "decimal_const", "octal_const", "hexadecimal_const"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "','", "';'", "'int'", "'='", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "'return'", "'+'", "'-'", "'!'", "'*'", "'/'", "'%'", "'if'", 
			"'else'", "'while'", "'break'", "'continue'", "'<'", "'>'", "'<='", "'>='", 
			"'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONST", "DOT", "SEMI", "INT", "EQUAL", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "LBRACKET", "RBRACKET", "RETURN", "ADD", "SUB", "NOT", "MUL", 
			"DIV", "MOD", "IF", "ELSE", "WHILE", "BREAK", "CONTINUE", "LESS", "GREATER", 
			"LESS_OR_EQUAL", "GREATER_OR_EQUAL", "LOGICAL_EQUAL", "LOGICAL_NOT_EQUAL", 
			"LOGICAL_AND", "LOGICAL_OR", "DECIMAL_CONST", "OCTAL_CONST", "HEXADECIMAL_CONST", 
			"IDENT", "WHITE_SPACE"
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
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					decl();
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(72);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				constdecl();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
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
			setState(78);
			match(CONST);
			setState(79);
			btype();
			setState(80);
			constdef();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(81);
				match(DOT);
				setState(82);
				constdef();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
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
			setState(90);
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
		public List<TerminalNode> LBRACKET() { return getTokens(sysyParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(sysyParser.LBRACKET, i);
		}
		public List<ConstexpContext> constexp() {
			return getRuleContexts(ConstexpContext.class);
		}
		public ConstexpContext constexp(int i) {
			return getRuleContext(ConstexpContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(sysyParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(sysyParser.RBRACKET, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			ident();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET) {
				{
				{
				setState(93);
				match(LBRACKET);
				setState(94);
				constexp();
				setState(95);
				match(RBRACKET);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(EQUAL);
			setState(103);
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
		public TerminalNode LBRACE() { return getToken(sysyParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(sysyParser.RBRACE, 0); }
		public List<ConstinitvalContext> constinitval() {
			return getRuleContexts(ConstinitvalContext.class);
		}
		public ConstinitvalContext constinitval(int i) {
			return getRuleContext(ConstinitvalContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(sysyParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(sysyParser.DOT, i);
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
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADD:
			case SUB:
			case NOT:
			case DECIMAL_CONST:
			case OCTAL_CONST:
			case HEXADECIMAL_CONST:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				constexp();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(LBRACE);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LBRACE) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
					{
					setState(107);
					constinitval();
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==DOT) {
						{
						{
						setState(108);
						match(DOT);
						setState(109);
						constinitval();
						}
						}
						setState(114);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(117);
				match(RBRACE);
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
			setState(120);
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
			setState(122);
			btype();
			setState(123);
			vardef();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(124);
				match(DOT);
				setState(125);
				vardef();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
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
		public List<TerminalNode> LBRACKET() { return getTokens(sysyParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(sysyParser.LBRACKET, i);
		}
		public List<ConstexpContext> constexp() {
			return getRuleContexts(ConstexpContext.class);
		}
		public ConstexpContext constexp(int i) {
			return getRuleContext(ConstexpContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(sysyParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(sysyParser.RBRACKET, i);
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
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				ident();
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACKET) {
					{
					{
					setState(134);
					match(LBRACKET);
					setState(135);
					constexp();
					setState(136);
					match(RBRACKET);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				ident();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACKET) {
					{
					{
					setState(144);
					match(LBRACKET);
					setState(145);
					constexp();
					setState(146);
					match(RBRACKET);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				match(EQUAL);
				setState(154);
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
		public TerminalNode LBRACE() { return getToken(sysyParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(sysyParser.RBRACE, 0); }
		public List<InitvalContext> initval() {
			return getRuleContexts(InitvalContext.class);
		}
		public InitvalContext initval(int i) {
			return getRuleContext(InitvalContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(sysyParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(sysyParser.DOT, i);
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
		int _la;
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADD:
			case SUB:
			case NOT:
			case DECIMAL_CONST:
			case OCTAL_CONST:
			case HEXADECIMAL_CONST:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				exp();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(LBRACE);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LBRACE) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
					{
					setState(160);
					initval();
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==DOT) {
						{
						{
						setState(161);
						match(DOT);
						setState(162);
						initval();
						}
						}
						setState(167);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(170);
				match(RBRACE);
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
			setState(173);
			functype();
			setState(174);
			ident();
			setState(175);
			match(LPAREN);
			setState(176);
			match(RPAREN);
			setState(177);
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
			setState(179);
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
			setState(181);
			match(LBRACE);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << SEMI) | (1L << INT) | (1L << LPAREN) | (1L << LBRACE) | (1L << RETURN) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << IF) | (1L << WHILE) | (1L << BREAK) | (1L << CONTINUE) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
				{
				{
				setState(182);
				blockitem();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
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
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				decl();
				}
				break;
			case SEMI:
			case LPAREN:
			case LBRACE:
			case RETURN:
			case ADD:
			case SUB:
			case NOT:
			case IF:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case DECIMAL_CONST:
			case OCTAL_CONST:
			case HEXADECIMAL_CONST:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode IF() { return getToken(sysyParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(sysyParser.LPAREN, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(sysyParser.RPAREN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(sysyParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(sysyParser.WHILE, 0); }
		public TerminalNode BREAK() { return getToken(sysyParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(sysyParser.CONTINUE, 0); }
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
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				lval();
				setState(195);
				match(EQUAL);
				setState(196);
				exp();
				setState(197);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
					{
					setState(200);
					exp();
					}
				}

				setState(203);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(IF);
				setState(205);
				match(LPAREN);
				setState(206);
				cond();
				setState(207);
				match(RPAREN);
				setState(208);
				stmt();
				setState(211);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(209);
					match(ELSE);
					setState(210);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				match(WHILE);
				setState(214);
				match(LPAREN);
				setState(215);
				cond();
				setState(216);
				match(RPAREN);
				setState(217);
				stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(219);
				match(BREAK);
				setState(220);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(221);
				match(CONTINUE);
				setState(222);
				match(SEMI);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(223);
				match(RETURN);
				setState(224);
				exp();
				setState(225);
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
		public List<TerminalNode> LBRACKET() { return getTokens(sysyParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(sysyParser.LBRACKET, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(sysyParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(sysyParser.RBRACKET, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			ident();
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(230);
					match(LBRACKET);
					setState(231);
					exp();
					setState(232);
					match(RBRACKET);
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
			setState(239);
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

	public static class CondContext extends ParserRuleContext {
		public LorexpContext lorexp() {
			return getRuleContext(LorexpContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			lorexp(0);
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
		enterRule(_localctx, 36, RULE_unaryexp);
		int _la;
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				primaryexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				ident();
				setState(245);
				match(LPAREN);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DECIMAL_CONST) | (1L << OCTAL_CONST) | (1L << HEXADECIMAL_CONST) | (1L << IDENT))) != 0)) {
					{
					setState(246);
					funcrparams();
					}
				}

				setState(249);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				unaryop();
				setState(252);
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
		enterRule(_localctx, 38, RULE_primaryexp);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(LPAREN);
				setState(257);
				exp();
				setState(258);
				match(RPAREN);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				lval();
				}
				break;
			case DECIMAL_CONST:
			case OCTAL_CONST:
			case HEXADECIMAL_CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
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
		enterRule(_localctx, 40, RULE_funcrparams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			exp();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(265);
				match(DOT);
				setState(266);
				exp();
				}
				}
				setState(271);
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
		public TerminalNode NOT() { return getToken(sysyParser.NOT, 0); }
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
		enterRule(_localctx, 42, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT))) != 0)) ) {
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_addexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(275);
			mulexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addexp);
					setState(277);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(278);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(279);
					mulexp(0);
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_mulexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(286);
			unaryexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulexp);
					setState(288);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(289);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(290);
					unaryexp();
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class RelexpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public RelexpContext relexp() {
			return getRuleContext(RelexpContext.class,0);
		}
		public TerminalNode LESS() { return getToken(sysyParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(sysyParser.GREATER, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(sysyParser.LESS_OR_EQUAL, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(sysyParser.GREATER_OR_EQUAL, 0); }
		public RelexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitRelexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelexpContext relexp() throws RecognitionException {
		return relexp(0);
	}

	private RelexpContext relexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelexpContext _localctx = new RelexpContext(_ctx, _parentState);
		RelexpContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_relexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(297);
			addexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relexp);
					setState(299);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(300);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_OR_EQUAL) | (1L << GREATER_OR_EQUAL))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(301);
					addexp(0);
					}
					} 
				}
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class EqexpContext extends ParserRuleContext {
		public RelexpContext relexp() {
			return getRuleContext(RelexpContext.class,0);
		}
		public EqexpContext eqexp() {
			return getRuleContext(EqexpContext.class,0);
		}
		public TerminalNode LOGICAL_EQUAL() { return getToken(sysyParser.LOGICAL_EQUAL, 0); }
		public TerminalNode LOGICAL_NOT_EQUAL() { return getToken(sysyParser.LOGICAL_NOT_EQUAL, 0); }
		public EqexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitEqexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqexpContext eqexp() throws RecognitionException {
		return eqexp(0);
	}

	private EqexpContext eqexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqexpContext _localctx = new EqexpContext(_ctx, _parentState);
		EqexpContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_eqexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(308);
			relexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqexp);
					setState(310);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(311);
					_la = _input.LA(1);
					if ( !(_la==LOGICAL_EQUAL || _la==LOGICAL_NOT_EQUAL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(312);
					relexp(0);
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	public static class LandexpContext extends ParserRuleContext {
		public EqexpContext eqexp() {
			return getRuleContext(EqexpContext.class,0);
		}
		public LandexpContext landexp() {
			return getRuleContext(LandexpContext.class,0);
		}
		public TerminalNode LOGICAL_AND() { return getToken(sysyParser.LOGICAL_AND, 0); }
		public LandexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_landexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitLandexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LandexpContext landexp() throws RecognitionException {
		return landexp(0);
	}

	private LandexpContext landexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LandexpContext _localctx = new LandexpContext(_ctx, _parentState);
		LandexpContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_landexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(319);
			eqexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LandexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_landexp);
					setState(321);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(322);
					match(LOGICAL_AND);
					setState(323);
					eqexp(0);
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class LorexpContext extends ParserRuleContext {
		public LandexpContext landexp() {
			return getRuleContext(LandexpContext.class,0);
		}
		public LorexpContext lorexp() {
			return getRuleContext(LorexpContext.class,0);
		}
		public TerminalNode LOGICAL_OR() { return getToken(sysyParser.LOGICAL_OR, 0); }
		public LorexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lorexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sysyVisitor ) return ((sysyVisitor<? extends T>)visitor).visitLorexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LorexpContext lorexp() throws RecognitionException {
		return lorexp(0);
	}

	private LorexpContext lorexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LorexpContext _localctx = new LorexpContext(_ctx, _parentState);
		LorexpContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_lorexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(330);
			landexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LorexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lorexp);
					setState(332);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(333);
					match(LOGICAL_OR);
					setState(334);
					landexp(0);
					}
					} 
				}
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 56, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
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
		enterRule(_localctx, 58, RULE_number);
		try {
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				decimal_const();
				}
				break;
			case OCTAL_CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				octal_const();
				}
				break;
			case HEXADECIMAL_CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
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
		enterRule(_localctx, 60, RULE_decimal_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
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
		enterRule(_localctx, 62, RULE_octal_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
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
		enterRule(_localctx, 64, RULE_hexadecimal_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
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
		case 22:
			return addexp_sempred((AddexpContext)_localctx, predIndex);
		case 23:
			return mulexp_sempred((MulexpContext)_localctx, predIndex);
		case 24:
			return relexp_sempred((RelexpContext)_localctx, predIndex);
		case 25:
			return eqexp_sempred((EqexpContext)_localctx, predIndex);
		case 26:
			return landexp_sempred((LandexpContext)_localctx, predIndex);
		case 27:
			return lorexp_sempred((LorexpContext)_localctx, predIndex);
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
	private boolean relexp_sempred(RelexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eqexp_sempred(EqexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean landexp_sempred(LandexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lorexp_sempred(LorexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u0164\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\5\3O\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\7\6d\n\6\f\6\16\6g\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7q\n\7"+
		"\f\7\16\7t\13\7\5\7v\n\7\3\7\5\7y\n\7\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u0081"+
		"\n\t\f\t\16\t\u0084\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u008d\n\n\f\n"+
		"\16\n\u0090\13\n\3\n\3\n\3\n\3\n\3\n\7\n\u0097\n\n\f\n\16\n\u009a\13\n"+
		"\3\n\3\n\3\n\5\n\u009f\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u00a6\n\13\f"+
		"\13\16\13\u00a9\13\13\5\13\u00ab\n\13\3\13\5\13\u00ae\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\16\3\16\7\16\u00ba\n\16\f\16\16\16\u00bd\13\16"+
		"\3\16\3\16\3\17\3\17\5\17\u00c3\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00cc\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d6\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u00e6\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u00ed\n\21\f\21\16\21"+
		"\u00f0\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00fa\n\24\3"+
		"\24\3\24\3\24\3\24\3\24\5\24\u0101\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0109\n\25\3\26\3\26\3\26\7\26\u010e\n\26\f\26\16\26\u0111\13\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u011b\n\30\f\30\16\30\u011e"+
		"\13\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0126\n\31\f\31\16\31\u0129"+
		"\13\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0131\n\32\f\32\16\32\u0134"+
		"\13\32\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u013c\n\33\f\33\16\33\u013f"+
		"\13\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0147\n\34\f\34\16\34\u014a"+
		"\13\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0152\n\35\f\35\16\35\u0155"+
		"\13\35\3\36\3\36\3\37\3\37\3\37\5\37\u015c\n\37\3 \3 \3!\3!\3\"\3\"\3"+
		"\"\2\b.\60\62\64\668#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<>@B\2\7\3\2\17\21\3\2\17\20\3\2\22\24\3\2\32\35\3\2\36"+
		"\37\2\u016a\2G\3\2\2\2\4N\3\2\2\2\6P\3\2\2\2\b\\\3\2\2\2\n^\3\2\2\2\f"+
		"x\3\2\2\2\16z\3\2\2\2\20|\3\2\2\2\22\u009e\3\2\2\2\24\u00ad\3\2\2\2\26"+
		"\u00af\3\2\2\2\30\u00b5\3\2\2\2\32\u00b7\3\2\2\2\34\u00c2\3\2\2\2\36\u00e5"+
		"\3\2\2\2 \u00e7\3\2\2\2\"\u00f1\3\2\2\2$\u00f3\3\2\2\2&\u0100\3\2\2\2"+
		"(\u0108\3\2\2\2*\u010a\3\2\2\2,\u0112\3\2\2\2.\u0114\3\2\2\2\60\u011f"+
		"\3\2\2\2\62\u012a\3\2\2\2\64\u0135\3\2\2\2\66\u0140\3\2\2\28\u014b\3\2"+
		"\2\2:\u0156\3\2\2\2<\u015b\3\2\2\2>\u015d\3\2\2\2@\u015f\3\2\2\2B\u0161"+
		"\3\2\2\2DF\5\4\3\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2I"+
		"G\3\2\2\2JK\5\26\f\2K\3\3\2\2\2LO\5\6\4\2MO\5\20\t\2NL\3\2\2\2NM\3\2\2"+
		"\2O\5\3\2\2\2PQ\7\3\2\2QR\5\b\5\2RW\5\n\6\2ST\7\4\2\2TV\5\n\6\2US\3\2"+
		"\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7\5\2\2[\7\3"+
		"\2\2\2\\]\7\6\2\2]\t\3\2\2\2^e\5:\36\2_`\7\f\2\2`a\5\16\b\2ab\7\r\2\2"+
		"bd\3\2\2\2c_\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2"+
		"hi\7\7\2\2ij\5\f\7\2j\13\3\2\2\2ky\5\16\b\2lu\7\n\2\2mr\5\f\7\2no\7\4"+
		"\2\2oq\5\f\7\2pn\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sv\3\2\2\2tr\3\2"+
		"\2\2um\3\2\2\2uv\3\2\2\2vw\3\2\2\2wy\7\13\2\2xk\3\2\2\2xl\3\2\2\2y\r\3"+
		"\2\2\2z{\5.\30\2{\17\3\2\2\2|}\5\b\5\2}\u0082\5\22\n\2~\177\7\4\2\2\177"+
		"\u0081\5\22\n\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086"+
		"\7\5\2\2\u0086\21\3\2\2\2\u0087\u008e\5:\36\2\u0088\u0089\7\f\2\2\u0089"+
		"\u008a\5\16\b\2\u008a\u008b\7\r\2\2\u008b\u008d\3\2\2\2\u008c\u0088\3"+
		"\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u009f\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0098\5:\36\2\u0092\u0093\7\f"+
		"\2\2\u0093\u0094\5\16\b\2\u0094\u0095\7\r\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0092\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\7\2\2\u009c"+
		"\u009d\5\24\13\2\u009d\u009f\3\2\2\2\u009e\u0087\3\2\2\2\u009e\u0091\3"+
		"\2\2\2\u009f\23\3\2\2\2\u00a0\u00ae\5\"\22\2\u00a1\u00aa\7\n\2\2\u00a2"+
		"\u00a7\5\24\13\2\u00a3\u00a4\7\4\2\2\u00a4\u00a6\5\24\13\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\7\13\2\2\u00ad\u00a0\3\2\2\2\u00ad"+
		"\u00a1\3\2\2\2\u00ae\25\3\2\2\2\u00af\u00b0\5\30\r\2\u00b0\u00b1\5:\36"+
		"\2\u00b1\u00b2\7\b\2\2\u00b2\u00b3\7\t\2\2\u00b3\u00b4\5\32\16\2\u00b4"+
		"\27\3\2\2\2\u00b5\u00b6\7\6\2\2\u00b6\31\3\2\2\2\u00b7\u00bb\7\n\2\2\u00b8"+
		"\u00ba\5\34\17\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3"+
		"\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00bf\7\13\2\2\u00bf\33\3\2\2\2\u00c0\u00c3\5\4\3\2\u00c1\u00c3\5\36"+
		"\20\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\35\3\2\2\2\u00c4\u00c5"+
		"\5 \21\2\u00c5\u00c6\7\7\2\2\u00c6\u00c7\5\"\22\2\u00c7\u00c8\7\5\2\2"+
		"\u00c8\u00e6\3\2\2\2\u00c9\u00e6\5\32\16\2\u00ca\u00cc\5\"\22\2\u00cb"+
		"\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00e6\7\5"+
		"\2\2\u00ce\u00cf\7\25\2\2\u00cf\u00d0\7\b\2\2\u00d0\u00d1\5$\23\2\u00d1"+
		"\u00d2\7\t\2\2\u00d2\u00d5\5\36\20\2\u00d3\u00d4\7\26\2\2\u00d4\u00d6"+
		"\5\36\20\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00e6\3\2\2\2"+
		"\u00d7\u00d8\7\27\2\2\u00d8\u00d9\7\b\2\2\u00d9\u00da\5$\23\2\u00da\u00db"+
		"\7\t\2\2\u00db\u00dc\5\36\20\2\u00dc\u00e6\3\2\2\2\u00dd\u00de\7\30\2"+
		"\2\u00de\u00e6\7\5\2\2\u00df\u00e0\7\31\2\2\u00e0\u00e6\7\5\2\2\u00e1"+
		"\u00e2\7\16\2\2\u00e2\u00e3\5\"\22\2\u00e3\u00e4\7\5\2\2\u00e4\u00e6\3"+
		"\2\2\2\u00e5\u00c4\3\2\2\2\u00e5\u00c9\3\2\2\2\u00e5\u00cb\3\2\2\2\u00e5"+
		"\u00ce\3\2\2\2\u00e5\u00d7\3\2\2\2\u00e5\u00dd\3\2\2\2\u00e5\u00df\3\2"+
		"\2\2\u00e5\u00e1\3\2\2\2\u00e6\37\3\2\2\2\u00e7\u00ee\5:\36\2\u00e8\u00e9"+
		"\7\f\2\2\u00e9\u00ea\5\"\22\2\u00ea\u00eb\7\r\2\2\u00eb\u00ed\3\2\2\2"+
		"\u00ec\u00e8\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef!\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\5.\30\2\u00f2"+
		"#\3\2\2\2\u00f3\u00f4\58\35\2\u00f4%\3\2\2\2\u00f5\u0101\5(\25\2\u00f6"+
		"\u00f7\5:\36\2\u00f7\u00f9\7\b\2\2\u00f8\u00fa\5*\26\2\u00f9\u00f8\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\t\2\2\u00fc"+
		"\u0101\3\2\2\2\u00fd\u00fe\5,\27\2\u00fe\u00ff\5&\24\2\u00ff\u0101\3\2"+
		"\2\2\u0100\u00f5\3\2\2\2\u0100\u00f6\3\2\2\2\u0100\u00fd\3\2\2\2\u0101"+
		"\'\3\2\2\2\u0102\u0103\7\b\2\2\u0103\u0104\5\"\22\2\u0104\u0105\7\t\2"+
		"\2\u0105\u0109\3\2\2\2\u0106\u0109\5 \21\2\u0107\u0109\5<\37\2\u0108\u0102"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109)\3\2\2\2\u010a"+
		"\u010f\5\"\22\2\u010b\u010c\7\4\2\2\u010c\u010e\5\"\22\2\u010d\u010b\3"+
		"\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"+\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\t\2\2\2\u0113-\3\2\2\2\u0114"+
		"\u0115\b\30\1\2\u0115\u0116\5\60\31\2\u0116\u011c\3\2\2\2\u0117\u0118"+
		"\f\3\2\2\u0118\u0119\t\3\2\2\u0119\u011b\5\60\31\2\u011a\u0117\3\2\2\2"+
		"\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d/\3"+
		"\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\b\31\1\2\u0120\u0121\5&\24\2\u0121"+
		"\u0127\3\2\2\2\u0122\u0123\f\3\2\2\u0123\u0124\t\4\2\2\u0124\u0126\5&"+
		"\24\2\u0125\u0122\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\61\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\b\32\1"+
		"\2\u012b\u012c\5.\30\2\u012c\u0132\3\2\2\2\u012d\u012e\f\3\2\2\u012e\u012f"+
		"\t\5\2\2\u012f\u0131\5.\30\2\u0130\u012d\3\2\2\2\u0131\u0134\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\63\3\2\2\2\u0134\u0132\3\2\2"+
		"\2\u0135\u0136\b\33\1\2\u0136\u0137\5\62\32\2\u0137\u013d\3\2\2\2\u0138"+
		"\u0139\f\3\2\2\u0139\u013a\t\6\2\2\u013a\u013c\5\62\32\2\u013b\u0138\3"+
		"\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\65\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\b\34\1\2\u0141\u0142\5\64"+
		"\33\2\u0142\u0148\3\2\2\2\u0143\u0144\f\3\2\2\u0144\u0145\7 \2\2\u0145"+
		"\u0147\5\64\33\2\u0146\u0143\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3"+
		"\2\2\2\u0148\u0149\3\2\2\2\u0149\67\3\2\2\2\u014a\u0148\3\2\2\2\u014b"+
		"\u014c\b\35\1\2\u014c\u014d\5\66\34\2\u014d\u0153\3\2\2\2\u014e\u014f"+
		"\f\3\2\2\u014f\u0150\7!\2\2\u0150\u0152\5\66\34\2\u0151\u014e\3\2\2\2"+
		"\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u01549\3"+
		"\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7%\2\2\u0157;\3\2\2\2\u0158\u015c"+
		"\5> \2\u0159\u015c\5@!\2\u015a\u015c\5B\"\2\u015b\u0158\3\2\2\2\u015b"+
		"\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015c=\3\2\2\2\u015d\u015e\7\"\2\2"+
		"\u015e?\3\2\2\2\u015f\u0160\7#\2\2\u0160A\3\2\2\2\u0161\u0162\7$\2\2\u0162"+
		"C\3\2\2\2!GNWerux\u0082\u008e\u0098\u009e\u00a7\u00aa\u00ad\u00bb\u00c2"+
		"\u00cb\u00d5\u00e5\u00ee\u00f9\u0100\u0108\u010f\u011c\u0127\u0132\u013d"+
		"\u0148\u0153\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}