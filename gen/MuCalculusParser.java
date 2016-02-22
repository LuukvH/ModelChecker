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
		T__9=10, T__10=11, FALSE=12, TRUE=13, NUMBER=14, STRING=15, RECURSIONVARIABLE=16, 
		WHITESPACE=17;
	public static final int
		RULE_formulae = 0, RULE_conjunction = 1, RULE_disjunction = 2, RULE_diamond = 3, 
		RULE_box = 4, RULE_leastfixpoint = 5, RULE_greatestfixpoint = 6, RULE_left = 7, 
		RULE_right = 8, RULE_label = 9, RULE_mfalse = 10, RULE_mtrue = 11, RULE_startrecursion = 12, 
		RULE_endrecursion = 13;
	public static final String[] ruleNames = {
		"formulae", "conjunction", "disjunction", "diamond", "box", "leastfixpoint", 
		"greatestfixpoint", "left", "right", "label", "mfalse", "mtrue", "startrecursion", 
		"endrecursion"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'&&'", "')'", "'||'", "'<'", "'>'", "'['", "']'", "'mu'", 
		"'.'", "'nu'", "'false'", "'true'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"FALSE", "TRUE", "NUMBER", "STRING", "RECURSIONVARIABLE", "WHITESPACE"
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
		public MfalseContext mfalse() {
			return getRuleContext(MfalseContext.class,0);
		}
		public MtrueContext mtrue() {
			return getRuleContext(MtrueContext.class,0);
		}
		public EndrecursionContext endrecursion() {
			return getRuleContext(EndrecursionContext.class,0);
		}
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
			setState(37);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				mfalse();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				mtrue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				endrecursion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				conjunction();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				disjunction();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(33);
				diamond();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(34);
				box();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(35);
				leastfixpoint();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(36);
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
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public RightContext right() {
			return getRuleContext(RightContext.class,0);
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
			setState(39);
			match(T__0);
			setState(40);
			left();
			setState(41);
			match(T__1);
			setState(42);
			right();
			setState(43);
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
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public RightContext right() {
			return getRuleContext(RightContext.class,0);
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
			setState(45);
			match(T__0);
			setState(46);
			left();
			setState(47);
			match(T__3);
			setState(48);
			right();
			setState(49);
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
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
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
			setState(51);
			match(T__4);
			setState(52);
			label();
			setState(53);
			match(T__5);
			setState(54);
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
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
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
			setState(56);
			match(T__6);
			setState(57);
			label();
			setState(58);
			match(T__7);
			setState(59);
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
		public StartrecursionContext startrecursion() {
			return getRuleContext(StartrecursionContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__8);
			setState(62);
			startrecursion();
			setState(63);
			match(T__9);
			setState(64);
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
		public StartrecursionContext startrecursion() {
			return getRuleContext(StartrecursionContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__10);
			setState(67);
			startrecursion();
			setState(68);
			match(T__9);
			setState(69);
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

	public static class LeftContext extends ParserRuleContext {
		public FormulaeContext formulae() {
			return getRuleContext(FormulaeContext.class,0);
		}
		public LeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftContext left() throws RecognitionException {
		LeftContext _localctx = new LeftContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_left);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
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

	public static class RightContext extends ParserRuleContext {
		public FormulaeContext formulae() {
			return getRuleContext(FormulaeContext.class,0);
		}
		public RightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_right; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightContext right() throws RecognitionException {
		RightContext _localctx = new RightContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_right);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MuCalculusParser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
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

	public static class MfalseContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(MuCalculusParser.FALSE, 0); }
		public MfalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mfalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterMfalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitMfalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitMfalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MfalseContext mfalse() throws RecognitionException {
		MfalseContext _localctx = new MfalseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mfalse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(FALSE);
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

	public static class MtrueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(MuCalculusParser.TRUE, 0); }
		public MtrueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mtrue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterMtrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitMtrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitMtrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MtrueContext mtrue() throws RecognitionException {
		MtrueContext _localctx = new MtrueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mtrue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(TRUE);
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

	public static class StartrecursionContext extends ParserRuleContext {
		public TerminalNode RECURSIONVARIABLE() { return getToken(MuCalculusParser.RECURSIONVARIABLE, 0); }
		public StartrecursionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startrecursion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterStartrecursion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitStartrecursion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitStartrecursion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartrecursionContext startrecursion() throws RecognitionException {
		StartrecursionContext _localctx = new StartrecursionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_startrecursion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(RECURSIONVARIABLE);
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

	public static class EndrecursionContext extends ParserRuleContext {
		public TerminalNode RECURSIONVARIABLE() { return getToken(MuCalculusParser.RECURSIONVARIABLE, 0); }
		public EndrecursionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endrecursion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).enterEndrecursion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuCalculusListener ) ((MuCalculusListener)listener).exitEndrecursion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuCalculusVisitor ) return ((MuCalculusVisitor<? extends T>)visitor).visitEndrecursion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndrecursionContext endrecursion() throws RecognitionException {
		EndrecursionContext _localctx = new EndrecursionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_endrecursion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(RECURSIONVARIABLE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2(\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\2\2"+
		"\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2Q\2\'\3\2\2\2\4)\3\2\2\2\6"+
		"/\3\2\2\2\b\65\3\2\2\2\n:\3\2\2\2\f?\3\2\2\2\16D\3\2\2\2\20I\3\2\2\2\22"+
		"K\3\2\2\2\24M\3\2\2\2\26O\3\2\2\2\30Q\3\2\2\2\32S\3\2\2\2\34U\3\2\2\2"+
		"\36(\5\26\f\2\37(\5\30\r\2 (\5\34\17\2!(\5\4\3\2\"(\5\6\4\2#(\5\b\5\2"+
		"$(\5\n\6\2%(\5\f\7\2&(\5\16\b\2\'\36\3\2\2\2\'\37\3\2\2\2\' \3\2\2\2\'"+
		"!\3\2\2\2\'\"\3\2\2\2\'#\3\2\2\2\'$\3\2\2\2\'%\3\2\2\2\'&\3\2\2\2(\3\3"+
		"\2\2\2)*\7\3\2\2*+\5\20\t\2+,\7\4\2\2,-\5\22\n\2-.\7\5\2\2.\5\3\2\2\2"+
		"/\60\7\3\2\2\60\61\5\20\t\2\61\62\7\6\2\2\62\63\5\22\n\2\63\64\7\5\2\2"+
		"\64\7\3\2\2\2\65\66\7\7\2\2\66\67\5\24\13\2\678\7\b\2\289\5\2\2\29\t\3"+
		"\2\2\2:;\7\t\2\2;<\5\24\13\2<=\7\n\2\2=>\5\2\2\2>\13\3\2\2\2?@\7\13\2"+
		"\2@A\5\32\16\2AB\7\f\2\2BC\5\2\2\2C\r\3\2\2\2DE\7\r\2\2EF\5\32\16\2FG"+
		"\7\f\2\2GH\5\2\2\2H\17\3\2\2\2IJ\5\2\2\2J\21\3\2\2\2KL\5\2\2\2L\23\3\2"+
		"\2\2MN\7\21\2\2N\25\3\2\2\2OP\7\16\2\2P\27\3\2\2\2QR\7\17\2\2R\31\3\2"+
		"\2\2ST\7\22\2\2T\33\3\2\2\2UV\7\22\2\2V\35\3\2\2\2\3\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}