<<<<<<< HEAD:src/aldebaran/AldebaranLexer.java
// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\Aldebaran.g4 by ANTLR 4.5.1
package aldebaran;
=======
package aldebaran;// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\Aldebaran.g4 by ANTLR 4.5.1
>>>>>>> origin/master:src/aldebaran/AldebaranLexer.java
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AldebaranLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, STRING=8, WHITESPACE=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NUMBER", "STRING", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'des ('", "','", "')'", "'('", "',\"'", "'\",'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "NUMBER", "STRING", "WHITESPACE"
	};
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


	public AldebaranLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Aldebaran.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13>\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\6"+
<<<<<<< HEAD:src/aldebaran/AldebaranLexer.java
		"\b)\n\b\r\b\16\b*\3\t\6\t.\n\t\r\t\16\t/\3\t\7\t\63\n\t\f\t\16\t\66\13"+
		"\t\3\n\6\n9\n\n\r\n\16\n:\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\16\17\"\"A\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37"+
		"\3\2\2\2\13!\3\2\2\2\r$\3\2\2\2\17(\3\2\2\2\21-\3\2\2\2\238\3\2\2\2\25"+
		"\26\7f\2\2\26\27\7g\2\2\27\30\7u\2\2\30\31\7\"\2\2\31\32\7*\2\2\32\4\3"+
		"\2\2\2\33\34\7.\2\2\34\6\3\2\2\2\35\36\7+\2\2\36\b\3\2\2\2\37 \7*\2\2"+
		" \n\3\2\2\2!\"\7.\2\2\"#\7$\2\2#\f\3\2\2\2$%\7$\2\2%&\7.\2\2&\16\3\2\2"+
		"\2\')\t\2\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\20\3\2\2\2,.\t"+
		"\3\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\64\3\2\2\2\61\63\t"+
		"\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\22\3"+
		"\2\2\2\66\64\3\2\2\2\679\t\4\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2"+
		"\2\2;<\3\2\2\2<=\b\n\2\2=\24\3\2\2\2\7\2*/\64:\3\b\2\2";
=======
		"\b)\n\b\r\b\16\b*\3\t\6\t.\n\t\r\t\16\t/\3\n\6\n\63\n\n\r\n\16\n\64\3"+
		"\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\5\3\2\62;\5"+
		"\2\62;C\\c|\5\2\13\f\16\17\"\":\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\3\25\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37\3\2\2\2\13!\3\2\2\2\r"+
		"$\3\2\2\2\17(\3\2\2\2\21-\3\2\2\2\23\62\3\2\2\2\25\26\7f\2\2\26\27\7g"+
		"\2\2\27\30\7u\2\2\30\31\7\"\2\2\31\32\7*\2\2\32\4\3\2\2\2\33\34\7.\2\2"+
		"\34\6\3\2\2\2\35\36\7+\2\2\36\b\3\2\2\2\37 \7*\2\2 \n\3\2\2\2!\"\7.\2"+
		"\2\"#\7$\2\2#\f\3\2\2\2$%\7$\2\2%&\7.\2\2&\16\3\2\2\2\')\t\2\2\2(\'\3"+
		"\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\20\3\2\2\2,.\t\3\2\2-,\3\2\2\2."+
		"/\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\22\3\2\2\2\61\63\t\4\2\2\62\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\b\n"+
		"\2\2\67\24\3\2\2\2\6\2*/\64\3\b\2\2";
>>>>>>> origin/master:src/aldebaran/AldebaranLexer.java
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}