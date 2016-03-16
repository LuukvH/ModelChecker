// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\Aldebaran.g4 by ANTLR 4.5.1
package aldebaran;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AldebaranParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, STRING=8, WHITESPACE=9, 
		NewLine=10;
	public static final int
		RULE_aldebaran = 0, RULE_aut_header = 1, RULE_first_state = 2, RULE_nr_of_transitions = 3, 
		RULE_nr_of_states = 4, RULE_aut_edge = 5, RULE_start_state = 6, RULE_label = 7, 
		RULE_end_state = 8;
	public static final String[] ruleNames = {
		"aldebaran", "aut_header", "first_state", "nr_of_transitions", "nr_of_states", 
		"aut_edge", "start_state", "label", "end_state"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'des ('", "','", "')'", "'('", "',\"'", "'\",'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "NUMBER", "STRING", "WHITESPACE", 
		"NewLine"
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

	@Override
	public String getGrammarFileName() { return "Aldebaran.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AldebaranParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AldebaranContext extends ParserRuleContext {
		public Aut_headerContext aut_header() {
			return getRuleContext(Aut_headerContext.class,0);
		}
		public List<Aut_edgeContext> aut_edge() {
			return getRuleContexts(Aut_edgeContext.class);
		}
		public Aut_edgeContext aut_edge(int i) {
			return getRuleContext(Aut_edgeContext.class,i);
		}
		public AldebaranContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aldebaran; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitAldebaran(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AldebaranContext aldebaran() throws RecognitionException {
		AldebaranContext _localctx = new AldebaranContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aldebaran);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			aut_header();
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(19);
				aut_edge();
				}
				}
				setState(24);
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

	public static class Aut_headerContext extends ParserRuleContext {
		public First_stateContext first_state() {
			return getRuleContext(First_stateContext.class,0);
		}
		public Nr_of_transitionsContext nr_of_transitions() {
			return getRuleContext(Nr_of_transitionsContext.class,0);
		}
		public Nr_of_statesContext nr_of_states() {
			return getRuleContext(Nr_of_statesContext.class,0);
		}
		public TerminalNode NewLine() { return getToken(AldebaranParser.NewLine, 0); }
		public TerminalNode EOF() { return getToken(AldebaranParser.EOF, 0); }
		public Aut_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aut_header; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitAut_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aut_headerContext aut_header() throws RecognitionException {
		Aut_headerContext _localctx = new Aut_headerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_aut_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(T__0);
			setState(26);
			first_state();
			setState(27);
			match(T__1);
			setState(28);
			nr_of_transitions();
			setState(29);
			match(T__1);
			setState(30);
			nr_of_states();
			setState(31);
			match(T__2);
			setState(32);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NewLine) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class First_stateContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(AldebaranParser.NUMBER, 0); }
		public First_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_first_state; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitFirst_state(this);
			else return visitor.visitChildren(this);
		}
	}

	public final First_stateContext first_state() throws RecognitionException {
		First_stateContext _localctx = new First_stateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_first_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(NUMBER);
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

	public static class Nr_of_transitionsContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(AldebaranParser.NUMBER, 0); }
		public Nr_of_transitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nr_of_transitions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitNr_of_transitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nr_of_transitionsContext nr_of_transitions() throws RecognitionException {
		Nr_of_transitionsContext _localctx = new Nr_of_transitionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nr_of_transitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(NUMBER);
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

	public static class Nr_of_statesContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(AldebaranParser.NUMBER, 0); }
		public Nr_of_statesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nr_of_states; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitNr_of_states(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nr_of_statesContext nr_of_states() throws RecognitionException {
		Nr_of_statesContext _localctx = new Nr_of_statesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nr_of_states);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(NUMBER);
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

	public static class Aut_edgeContext extends ParserRuleContext {
		public Start_stateContext start_state() {
			return getRuleContext(Start_stateContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public End_stateContext end_state() {
			return getRuleContext(End_stateContext.class,0);
		}
		public TerminalNode NewLine() { return getToken(AldebaranParser.NewLine, 0); }
		public TerminalNode EOF() { return getToken(AldebaranParser.EOF, 0); }
		public Aut_edgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aut_edge; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitAut_edge(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aut_edgeContext aut_edge() throws RecognitionException {
		Aut_edgeContext _localctx = new Aut_edgeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_aut_edge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__3);
			setState(41);
			start_state();
			setState(42);
			match(T__4);
			setState(43);
			label();
			setState(44);
			match(T__5);
			setState(45);
			end_state();
			setState(46);
			match(T__2);
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NewLine) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Start_stateContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(AldebaranParser.NUMBER, 0); }
		public Start_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_state; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitStart_state(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_stateContext start_state() throws RecognitionException {
		Start_stateContext _localctx = new Start_stateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_start_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(NUMBER);
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AldebaranParser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(STRING);
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

	public static class End_stateContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(AldebaranParser.NUMBER, 0); }
		public End_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_state; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldebaranVisitor ) return ((AldebaranVisitor<? extends T>)visitor).visitEnd_state(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_stateContext end_state() throws RecognitionException {
		End_stateContext _localctx = new End_stateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_end_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(NUMBER);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f:\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3\3\3\f\f\61\2\24\3\2\2\2\4\33"+
		"\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n(\3\2\2\2\f*\3\2\2\2\16\63\3\2\2\2\20"+
		"\65\3\2\2\2\22\67\3\2\2\2\24\30\5\4\3\2\25\27\5\f\7\2\26\25\3\2\2\2\27"+
		"\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\3\3\2\2\2\32\30\3\2\2\2\33"+
		"\34\7\3\2\2\34\35\5\6\4\2\35\36\7\4\2\2\36\37\5\b\5\2\37 \7\4\2\2 !\5"+
		"\n\6\2!\"\7\5\2\2\"#\t\2\2\2#\5\3\2\2\2$%\7\t\2\2%\7\3\2\2\2&\'\7\t\2"+
		"\2\'\t\3\2\2\2()\7\t\2\2)\13\3\2\2\2*+\7\6\2\2+,\5\16\b\2,-\7\7\2\2-."+
		"\5\20\t\2./\7\b\2\2/\60\5\22\n\2\60\61\7\5\2\2\61\62\t\2\2\2\62\r\3\2"+
		"\2\2\63\64\7\t\2\2\64\17\3\2\2\2\65\66\7\n\2\2\66\21\3\2\2\2\678\7\t\2"+
		"\28\23\3\2\2\2\3\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}