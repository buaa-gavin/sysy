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
		RBRACE=9, RETURN=10, ADD=11, SUB=12, NOT=13, MUL=14, DIV=15, MOD=16, IF=17, 
		ELSE=18, WHILE=19, BREAK=20, CONTINUE=21, LESS=22, GREATER=23, LESS_OR_EQUAL=24, 
		GREATER_OR_EQUAL=25, LOGICAL_EQUAL=26, LOGICAL_NOT_EQUAL=27, LOGICAL_AND=28, 
		LOGICAL_OR=29, DECIMAL_CONST=30, OCTAL_CONST=31, HEXADECIMAL_CONST=32, 
		IDENT=33, WHITE_SPACE=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CONST", "DOT", "SEMI", "INT", "EQUAL", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "RETURN", "ADD", "SUB", "NOT", "MUL", "DIV", "MOD", "IF", "ELSE", 
			"WHILE", "BREAK", "CONTINUE", "LESS", "GREATER", "LESS_OR_EQUAL", "GREATER_OR_EQUAL", 
			"LOGICAL_EQUAL", "LOGICAL_NOT_EQUAL", "LOGICAL_AND", "LOGICAL_OR", "DECIMAL_CONST", 
			"OCTAL_CONST", "HEXADECIMAL_CONST", "IDENT", "WHITE_SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "','", "';'", "'int'", "'='", "'('", "')'", "'{'", "'}'", 
			"'return'", "'+'", "'-'", "'!'", "'*'", "'/'", "'%'", "'if'", "'else'", 
			"'while'", "'break'", "'continue'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONST", "DOT", "SEMI", "INT", "EQUAL", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "RETURN", "ADD", "SUB", "NOT", "MUL", "DIV", "MOD", "IF", "ELSE", 
			"WHILE", "BREAK", "CONTINUE", "LESS", "GREATER", "LESS_OR_EQUAL", "GREATER_OR_EQUAL", 
			"LOGICAL_EQUAL", "LOGICAL_NOT_EQUAL", "LOGICAL_AND", "LOGICAL_OR", "DECIMAL_CONST", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00cd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u00a9\n\37"+
		"\f\37\16\37\u00ac\13\37\5\37\u00ae\n\37\3 \3 \6 \u00b2\n \r \16 \u00b3"+
		"\3!\3!\3!\3!\5!\u00ba\n!\3!\6!\u00bd\n!\r!\16!\u00be\3\"\5\"\u00c2\n\""+
		"\3\"\7\"\u00c5\n\"\f\"\16\"\u00c8\13\"\3#\3#\3#\3#\2\2$\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3"+
		"\2\t\3\2\63;\3\2\62;\3\2\629\5\2\62;CHch\5\2C\\aac|\6\2\62;C\\aac|\5\2"+
		"\13\f\17\17\"\"\2\u00d2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\3G\3\2\2\2\5M\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2\13U\3\2\2\2"+
		"\rW\3\2\2\2\17Y\3\2\2\2\21[\3\2\2\2\23]\3\2\2\2\25_\3\2\2\2\27f\3\2\2"+
		"\2\31h\3\2\2\2\33j\3\2\2\2\35l\3\2\2\2\37n\3\2\2\2!p\3\2\2\2#r\3\2\2\2"+
		"%u\3\2\2\2\'z\3\2\2\2)\u0080\3\2\2\2+\u0086\3\2\2\2-\u008f\3\2\2\2/\u0091"+
		"\3\2\2\2\61\u0093\3\2\2\2\63\u0096\3\2\2\2\65\u0099\3\2\2\2\67\u009c\3"+
		"\2\2\29\u009f\3\2\2\2;\u00a2\3\2\2\2=\u00ad\3\2\2\2?\u00af\3\2\2\2A\u00b9"+
		"\3\2\2\2C\u00c1\3\2\2\2E\u00c9\3\2\2\2GH\7e\2\2HI\7q\2\2IJ\7p\2\2JK\7"+
		"u\2\2KL\7v\2\2L\4\3\2\2\2MN\7.\2\2N\6\3\2\2\2OP\7=\2\2P\b\3\2\2\2QR\7"+
		"k\2\2RS\7p\2\2ST\7v\2\2T\n\3\2\2\2UV\7?\2\2V\f\3\2\2\2WX\7*\2\2X\16\3"+
		"\2\2\2YZ\7+\2\2Z\20\3\2\2\2[\\\7}\2\2\\\22\3\2\2\2]^\7\177\2\2^\24\3\2"+
		"\2\2_`\7t\2\2`a\7g\2\2ab\7v\2\2bc\7w\2\2cd\7t\2\2de\7p\2\2e\26\3\2\2\2"+
		"fg\7-\2\2g\30\3\2\2\2hi\7/\2\2i\32\3\2\2\2jk\7#\2\2k\34\3\2\2\2lm\7,\2"+
		"\2m\36\3\2\2\2no\7\61\2\2o \3\2\2\2pq\7\'\2\2q\"\3\2\2\2rs\7k\2\2st\7"+
		"h\2\2t$\3\2\2\2uv\7g\2\2vw\7n\2\2wx\7u\2\2xy\7g\2\2y&\3\2\2\2z{\7y\2\2"+
		"{|\7j\2\2|}\7k\2\2}~\7n\2\2~\177\7g\2\2\177(\3\2\2\2\u0080\u0081\7d\2"+
		"\2\u0081\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084\7c\2\2\u0084\u0085"+
		"\7m\2\2\u0085*\3\2\2\2\u0086\u0087\7e\2\2\u0087\u0088\7q\2\2\u0088\u0089"+
		"\7p\2\2\u0089\u008a\7v\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c"+
		"\u008d\7w\2\2\u008d\u008e\7g\2\2\u008e,\3\2\2\2\u008f\u0090\7>\2\2\u0090"+
		".\3\2\2\2\u0091\u0092\7@\2\2\u0092\60\3\2\2\2\u0093\u0094\7>\2\2\u0094"+
		"\u0095\7?\2\2\u0095\62\3\2\2\2\u0096\u0097\7@\2\2\u0097\u0098\7?\2\2\u0098"+
		"\64\3\2\2\2\u0099\u009a\7?\2\2\u009a\u009b\7?\2\2\u009b\66\3\2\2\2\u009c"+
		"\u009d\7#\2\2\u009d\u009e\7?\2\2\u009e8\3\2\2\2\u009f\u00a0\7(\2\2\u00a0"+
		"\u00a1\7(\2\2\u00a1:\3\2\2\2\u00a2\u00a3\7~\2\2\u00a3\u00a4\7~\2\2\u00a4"+
		"<\3\2\2\2\u00a5\u00ae\7\62\2\2\u00a6\u00aa\t\2\2\2\u00a7\u00a9\t\3\2\2"+
		"\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad"+
		"\u00a6\3\2\2\2\u00ae>\3\2\2\2\u00af\u00b1\7\62\2\2\u00b0\u00b2\t\4\2\2"+
		"\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4@\3\2\2\2\u00b5\u00b6\7\62\2\2\u00b6\u00ba\7z\2\2\u00b7"+
		"\u00b8\7\62\2\2\u00b8\u00ba\7Z\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00bd\t\5\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bfB\3\2\2\2"+
		"\u00c0\u00c2\t\6\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c6\3\2\2\2\u00c3\u00c5"+
		"\t\7\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7D\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\t\b\2\2"+
		"\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b#\2\2\u00ccF\3\2\2\2\f\2\u00aa\u00ad"+
		"\u00b3\u00b9\u00bc\u00be\u00c1\u00c4\u00c6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}