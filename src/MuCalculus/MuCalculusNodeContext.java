package MuCalculus;

import ObserverPattern.Subject;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

/**
 * Created by laj on 29-2-2016.
 */
public class MuCalculusNodeContext extends ParserRuleContext implements Observer{
    public MuCalculusNodeContext(ParserRuleContext parent, int invokingState) {
        super(parent, invokingState);
    }
    public Set<String> dependencies = new HashSet<>();
    public boolean changed = true;
    public BitSet value;

    @Override
    public void update(Observable o, Object arg) {
        changed = true;
    }
}
