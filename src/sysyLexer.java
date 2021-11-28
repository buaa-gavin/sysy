// Generated from sysy.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sysyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONST=1, DOT=2, SEMI=3, INT=4, EQUAL=5, LPAREN=6, RPAREN=7, LBRACE=8, 
		RBRACE=9, RETURN=10, ADD=11, SUB=12, MUL=13, DIV=14, MOD=15, DECIMAL_CONST=16, 
		OCTAL_CONST=17, HEXADECIMAL_CONST=18, IDENT=19, WHITE_SPACE=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CONST", "DOT", "SEMI", "INT", "EQUAL", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "RETURN", "ADD", "SUB", "MUL", "DIV", "MOD", "DECIMAL_CONST", 
			"OCTAL_CONST", "HEXADECIMAL_CONST", "IDENT", "WHITE_SPACE"
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


	public sysyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "sysy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\7\21X\n\21\f\21\16\21[\13\21\5\21]\n\21\3\22\3\22\6\22a\n\22"+
		"\r\22\16\22b\3\23\3\23\3\23\3\23\5\23i\n\23\3\23\6\23l\n\23\r\23\16\23"+
		"m\3\24\5\24q\n\24\3\24\7\24t\n\24\f\24\16\24w\13\24\3\25\3\25\3\25\3\25"+
		"\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26\3\2\t\3\2\63;\3\2\62;\3\2\629\5\2\62"+
		";CHch\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u0081\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3"+
		"\2\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2\2\25C"+
		"\3\2\2\2\27J\3\2\2\2\31L\3\2\2\2\33N\3\2\2\2\35P\3\2\2\2\37R\3\2\2\2!"+
		"\\\3\2\2\2#^\3\2\2\2%h\3\2\2\2\'p\3\2\2\2)x\3\2\2\2+,\7e\2\2,-\7q\2\2"+
		"-.\7p\2\2./\7u\2\2/\60\7v\2\2\60\4\3\2\2\2\61\62\7.\2\2\62\6\3\2\2\2\63"+
		"\64\7=\2\2\64\b\3\2\2\2\65\66\7k\2\2\66\67\7p\2\2\678\7v\2\28\n\3\2\2"+
		"\29:\7?\2\2:\f\3\2\2\2;<\7*\2\2<\16\3\2\2\2=>\7+\2\2>\20\3\2\2\2?@\7}"+
		"\2\2@\22\3\2\2\2AB\7\177\2\2B\24\3\2\2\2CD\7t\2\2DE\7g\2\2EF\7v\2\2FG"+
		"\7w\2\2GH\7t\2\2HI\7p\2\2I\26\3\2\2\2JK\7-\2\2K\30\3\2\2\2LM\7/\2\2M\32"+
		"\3\2\2\2NO\7,\2\2O\34\3\2\2\2PQ\7\61\2\2Q\36\3\2\2\2RS\7\'\2\2S \3\2\2"+
		"\2T]\7\62\2\2UY\t\2\2\2VX\t\3\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2"+
		"\2\2Z]\3\2\2\2[Y\3\2\2\2\\T\3\2\2\2\\U\3\2\2\2]\"\3\2\2\2^`\7\62\2\2_"+
		"a\t\4\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c$\3\2\2\2de\7\62\2\2"+
		"ei\7z\2\2fg\7\62\2\2gi\7Z\2\2hd\3\2\2\2hf\3\2\2\2ik\3\2\2\2jl\t\5\2\2"+
		"kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n&\3\2\2\2oq\t\6\2\2po\3\2\2\2"+
		"qu\3\2\2\2rt\t\7\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v(\3\2\2\2"+
		"wu\3\2\2\2xy\t\b\2\2yz\3\2\2\2z{\b\25\2\2{*\3\2\2\2\f\2Y\\bhkmpsu\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}