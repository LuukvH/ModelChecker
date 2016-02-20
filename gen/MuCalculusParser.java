// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\MuCalculus.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MuCalculusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, FALSE=12, TRUE=13, LITERAL=14, RECURSIONVARIABLE=15;
	public static final int
		RULE_formulae = 0, RULE_conjunction = 1, RULE_disjunction = 2, RULE_diamond = 3, 
		RULE_box = 4, RULE_leastfixpoint = 5, RULE_greatestfixpoint = 6;
	public static final String[] ruleNames = {
		"formulae", "conjunction", "disjunction", "diamond", "box", "leastfixpoint", 
		"greatestfixpoint"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'&&'", "')'", "'<'", "'>'", "'['", "']'", "'mu'", "' '", 
		"'.'", "'nu'", "'false'", "'true'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"FALSE", "TRUE", "LITERAL", "RECURSIONVARIABLE"
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
	public String getGrammarFileName() { return "MuCalculus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MuCalculusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormulaeContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(MuCalculusParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(MuCalculusParser.TRUE, 0); }
		public TerminalNode RECURSIONVARIABLE() { return getToken(MuCalculusParser.RECURSIONVARIABLE, 0); }
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public DiamondContext diamond() {
			return getRuleContext(DiamondContext.class,0);
		}
		public BoxContext box() {
			return getRuleContext(BoxContext.class,0);
		}
		public LeastfixpointContext leastfixpoint() {
			return getRuleContext(LeastfixpointContext.class,0);
		}
		public GreatestfixpointContext greatestfixpoint() {
			return getRuleContext(GreatestfixpointContext.class,0);
		}
		public FormulaeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulae; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitFormulae(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitFormulae(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaeContext formulae() throws RecognitionException {
		FormulaeContext _localctx = new FormulaeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formulae);
		try {
			setState(23);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(FALSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				match(TRUE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(16);
				match(RECURSIONVARIABLE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(17);
				conjunction();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(18);
				disjunction();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(19);
				diamond();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(20);
				box();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(21);
				leastfixpoint();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(22);
				greatestfixpoint();
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

	public static class ConjunctionContext extends ParserRuleContext {
		public List<FormulaeContext> formulae() {
			return getRuleContexts(FormulaeContext.class);
		}
		public FormulaeContext formulae(int i) {
			return getRuleContext(FormulaeContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(T__0);
			setState(26);
			formulae();
			setState(27);
			match(T__1);
			setState(28);
			formulae();
			setState(29);
			match(T__2);
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

	public static class DisjunctionContext extends ParserRuleContext {
		public List<FormulaeContext> formulae() {
			return getRuleContexts(FormulaeContext.class);
		}
		public FormulaeContext formulae(int i) {
			return getRuleContext(FormulaeContext.class,i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__0);
			setState(32);
			formulae();
			setState(33);
			match(T__1);
			setState(34);
			formulae();
			setState(35);
			match(T__2);
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

	public static class DiamondContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(MuCalculusParser.LITERAL, 0); }
		public FormulaeContext formulae() {
			return getRuleContext(FormulaeContext.class,0);
		}
		public DiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitDiamond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiamondContext diamond() throws RecognitionException {
		DiamondContext _localctx = new DiamondContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_diamond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__3);
			setState(38);
			match(LITERAL);
			setState(39);
			match(T__4);
			setState(40);
			formulae();
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

	public static class BoxContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(MuCalculusParser.LITERAL, 0); }
		public FormulaeContext formulae() {
			return getRuleContext(FormulaeContext.class,0);
		}
		public BoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_box; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterBox(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitBox(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitBox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoxContext box() throws RecognitionException {
		BoxContext _localctx = new BoxContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_box);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__5);
			setState(43);
			match(LITERAL);
			setState(44);
			match(T__6);
			setState(45);
			formulae();
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

	public static class LeastfixpointContext extends ParserRuleContext {
		public TerminalNode RECURSIONVARIABLE() { return getToken(MuCalculusParser.RECURSIONVARIABLE, 0); }
		public FormulaeContext formulae() {
			return getRuleContext(FormulaeContext.class,0);
		}
		public LeastfixpointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leastfixpoint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterLeastfixpoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitLeastfixpoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitLeastfixpoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeastfixpointContext leastfixpoint() throws RecognitionException {
		LeastfixpointContext _localctx = new LeastfixpointContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_leastfixpoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__7);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(48);
				match(T__8);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(54);
			match(RECURSIONVARIABLE);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(55);
				match(T__8);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(61);
			match(T__9);
			setState(62);
			formulae();
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

	public static class GreatestfixpointContext extends ParserRuleContext {
		public TerminalNode RECURSIONVARIABLE() { return getToken(MuCalculusParser.RECURSIONVARIABLE, 0); }
		public FormulaeContext formulae() {
			return getRuleContext(FormulaeContext.class,0);
		}
		public GreatestfixpointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greatestfixpoint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterGreatestfixpoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitGreatestfixpoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitGreatestfixpoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreatestfixpointContext greatestfixpoint() throws RecognitionException {
		GreatestfixpointContext _localctx = new GreatestfixpointContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_greatestfixpoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__10);
			{
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(65);
				match(T__8);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(71);
			match(RECURSIONVARIABLE);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(72);
				match(T__8);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(78);
			match(T__9);
			setState(79);
			formulae();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\32\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\7\7\64\n\7\f\7\16\7\67"+
		"\13\7\3\7\3\7\7\7;\n\7\f\7\16\7>\13\7\3\7\3\7\3\7\3\b\3\b\7\bE\n\b\f\b"+
		"\16\bH\13\b\3\b\3\b\7\bL\n\b\f\b\16\bO\13\b\3\b\3\b\3\b\3\b\2\2\t\2\4"+
		"\6\b\n\f\16\2\2X\2\31\3\2\2\2\4\33\3\2\2\2\6!\3\2\2\2\b\'\3\2\2\2\n,\3"+
		"\2\2\2\f\61\3\2\2\2\16B\3\2\2\2\20\32\7\16\2\2\21\32\7\17\2\2\22\32\7"+
		"\21\2\2\23\32\5\4\3\2\24\32\5\6\4\2\25\32\5\b\5\2\26\32\5\n\6\2\27\32"+
		"\5\f\7\2\30\32\5\16\b\2\31\20\3\2\2\2\31\21\3\2\2\2\31\22\3\2\2\2\31\23"+
		"\3\2\2\2\31\24\3\2\2\2\31\25\3\2\2\2\31\26\3\2\2\2\31\27\3\2\2\2\31\30"+
		"\3\2\2\2\32\3\3\2\2\2\33\34\7\3\2\2\34\35\5\2\2\2\35\36\7\4\2\2\36\37"+
		"\5\2\2\2\37 \7\5\2\2 \5\3\2\2\2!\"\7\3\2\2\"#\5\2\2\2#$\7\4\2\2$%\5\2"+
		"\2\2%&\7\5\2\2&\7\3\2\2\2\'(\7\6\2\2()\7\20\2\2)*\7\7\2\2*+\5\2\2\2+\t"+
		"\3\2\2\2,-\7\b\2\2-.\7\20\2\2./\7\t\2\2/\60\5\2\2\2\60\13\3\2\2\2\61\65"+
		"\7\n\2\2\62\64\7\13\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\668\3\2\2\2\67\65\3\2\2\28<\7\21\2\29;\7\13\2\2:9\3\2\2\2;>\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\f\2\2@A\5\2\2\2A\r"+
		"\3\2\2\2BF\7\r\2\2CE\7\13\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2"+
		"GI\3\2\2\2HF\3\2\2\2IM\7\21\2\2JL\7\13\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2"+
		"\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\f\2\2QR\5\2\2\2R\17\3\2\2\2\7\31"+
		"\65<FM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}