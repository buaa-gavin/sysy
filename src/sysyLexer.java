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
		RBRACE=9, LBRACKET=10, RBRACKET=11, RETURN=12, ADD=13, SUB=14, NOT=15, 
		MUL=16, DIV=17, MOD=18, IF=19, ELSE=20, WHILE=21, BREAK=22, CONTINUE=23, 
		LESS=24, GREATER=25, LESS_OR_EQUAL=26, GREATER_OR_EQUAL=27, LOGICAL_EQUAL=28, 
		LOGICAL_NOT_EQUAL=29, LOGICAL_AND=30, LOGICAL_OR=31, VOID=32, DECIMAL_CONST=33, 
		OCTAL_CONST=34, HEXADECIMAL_CONST=35, IDENT=36, WHITE_SPACE=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CONST", "DOT", "SEMI", "INT", "EQUAL", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "LBRACKET", "RBRACKET", "RETURN", "ADD", "SUB", "NOT", "MUL", 
			"DIV", "MOD", "IF", "ELSE", "WHILE", "BREAK", "CONTINUE", "LESS", "GREATER", 
			"LESS_OR_EQUAL", "GREATER_OR_EQUAL", "LOGICAL_EQUAL", "LOGICAL_NOT_EQUAL", 
			"LOGICAL_AND", "LOGICAL_OR", "VOID", "DECIMAL_CONST", "OCTAL_CONST", 
			"HEXADECIMAL_CONST", "IDENT", "WHITE_SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "','", "';'", "'int'", "'='", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "'return'", "'+'", "'-'", "'!'", "'*'", "'/'", "'%'", "'if'", 
			"'else'", "'while'", "'break'", "'continue'", "'<'", "'>'", "'<='", "'>='", 
			"'=='", "'!='", "'&&'", "'||'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONST", "DOT", "SEMI", "INT", "EQUAL", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "LBRACKET", "RBRACKET", "RETURN", "ADD", "SUB", "NOT", "MUL", 
			"DIV", "MOD", "IF", "ELSE", "WHILE", "BREAK", "CONTINUE", "LESS", "GREATER", 
			"LESS_OR_EQUAL", "GREATER_OR_EQUAL", "LOGICAL_EQUAL", "LOGICAL_NOT_EQUAL", 
			"LOGICAL_AND", "LOGICAL_OR", "VOID", "DECIMAL_CONST", "OCTAL_CONST", 
			"HEXADECIMAL_CONST", "IDENT", "WHITE_SPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u00dc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\3!\3!\3\"\3\"\3\"\7\"\u00b8\n\"\f\"\16\"\u00bb\13\"\5\"\u00bd"+
		"\n\"\3#\3#\6#\u00c1\n#\r#\16#\u00c2\3$\3$\3$\3$\5$\u00c9\n$\3$\6$\u00cc"+
		"\n$\r$\16$\u00cd\3%\5%\u00d1\n%\3%\7%\u00d4\n%\f%\16%\u00d7\13%\3&\3&"+
		"\3&\3&\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\t\3\2\63;\3\2\62;\3\2\629\5\2\62"+
		";CHch\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00e1\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\3M\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2\2\13[\3\2\2\2\r"+
		"]\3\2\2\2\17_\3\2\2\2\21a\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27g\3\2\2\2"+
		"\31i\3\2\2\2\33p\3\2\2\2\35r\3\2\2\2\37t\3\2\2\2!v\3\2\2\2#x\3\2\2\2%"+
		"z\3\2\2\2\'|\3\2\2\2)\177\3\2\2\2+\u0084\3\2\2\2-\u008a\3\2\2\2/\u0090"+
		"\3\2\2\2\61\u0099\3\2\2\2\63\u009b\3\2\2\2\65\u009d\3\2\2\2\67\u00a0\3"+
		"\2\2\29\u00a3\3\2\2\2;\u00a6\3\2\2\2=\u00a9\3\2\2\2?\u00ac\3\2\2\2A\u00af"+
		"\3\2\2\2C\u00bc\3\2\2\2E\u00be\3\2\2\2G\u00c8\3\2\2\2I\u00d0\3\2\2\2K"+
		"\u00d8\3\2\2\2MN\7e\2\2NO\7q\2\2OP\7p\2\2PQ\7u\2\2QR\7v\2\2R\4\3\2\2\2"+
		"ST\7.\2\2T\6\3\2\2\2UV\7=\2\2V\b\3\2\2\2WX\7k\2\2XY\7p\2\2YZ\7v\2\2Z\n"+
		"\3\2\2\2[\\\7?\2\2\\\f\3\2\2\2]^\7*\2\2^\16\3\2\2\2_`\7+\2\2`\20\3\2\2"+
		"\2ab\7}\2\2b\22\3\2\2\2cd\7\177\2\2d\24\3\2\2\2ef\7]\2\2f\26\3\2\2\2g"+
		"h\7_\2\2h\30\3\2\2\2ij\7t\2\2jk\7g\2\2kl\7v\2\2lm\7w\2\2mn\7t\2\2no\7"+
		"p\2\2o\32\3\2\2\2pq\7-\2\2q\34\3\2\2\2rs\7/\2\2s\36\3\2\2\2tu\7#\2\2u"+
		" \3\2\2\2vw\7,\2\2w\"\3\2\2\2xy\7\61\2\2y$\3\2\2\2z{\7\'\2\2{&\3\2\2\2"+
		"|}\7k\2\2}~\7h\2\2~(\3\2\2\2\177\u0080\7g\2\2\u0080\u0081\7n\2\2\u0081"+
		"\u0082\7u\2\2\u0082\u0083\7g\2\2\u0083*\3\2\2\2\u0084\u0085\7y\2\2\u0085"+
		"\u0086\7j\2\2\u0086\u0087\7k\2\2\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2"+
		"\u0089,\3\2\2\2\u008a\u008b\7d\2\2\u008b\u008c\7t\2\2\u008c\u008d\7g\2"+
		"\2\u008d\u008e\7c\2\2\u008e\u008f\7m\2\2\u008f.\3\2\2\2\u0090\u0091\7"+
		"e\2\2\u0091\u0092\7q\2\2\u0092\u0093\7p\2\2\u0093\u0094\7v\2\2\u0094\u0095"+
		"\7k\2\2\u0095\u0096\7p\2\2\u0096\u0097\7w\2\2\u0097\u0098\7g\2\2\u0098"+
		"\60\3\2\2\2\u0099\u009a\7>\2\2\u009a\62\3\2\2\2\u009b\u009c\7@\2\2\u009c"+
		"\64\3\2\2\2\u009d\u009e\7>\2\2\u009e\u009f\7?\2\2\u009f\66\3\2\2\2\u00a0"+
		"\u00a1\7@\2\2\u00a1\u00a2\7?\2\2\u00a28\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4"+
		"\u00a5\7?\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7\u00a8\7?\2\2\u00a8"+
		"<\3\2\2\2\u00a9\u00aa\7(\2\2\u00aa\u00ab\7(\2\2\u00ab>\3\2\2\2\u00ac\u00ad"+
		"\7~\2\2\u00ad\u00ae\7~\2\2\u00ae@\3\2\2\2\u00af\u00b0\7x\2\2\u00b0\u00b1"+
		"\7q\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7f\2\2\u00b3B\3\2\2\2\u00b4\u00bd"+
		"\7\62\2\2\u00b5\u00b9\t\2\2\2\u00b6\u00b8\t\3\2\2\u00b7\u00b6\3\2\2\2"+
		"\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bd"+
		"D\3\2\2\2\u00be\u00c0\7\62\2\2\u00bf\u00c1\t\4\2\2\u00c0\u00bf\3\2\2\2"+
		"\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3F\3"+
		"\2\2\2\u00c4\u00c5\7\62\2\2\u00c5\u00c9\7z\2\2\u00c6\u00c7\7\62\2\2\u00c7"+
		"\u00c9\7Z\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00cc\t\5\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ceH\3\2\2\2\u00cf\u00d1\t\6\2\2"+
		"\u00d0\u00cf\3\2\2\2\u00d1\u00d5\3\2\2\2\u00d2\u00d4\t\7\2\2\u00d3\u00d2"+
		"\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"J\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\t\b\2\2\u00d9\u00da\3\2\2\2"+
		"\u00da\u00db\b&\2\2\u00dbL\3\2\2\2\f\2\u00b9\u00bc\u00c2\u00c8\u00cb\u00cd"+
		"\u00d0\u00d3\u00d5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}