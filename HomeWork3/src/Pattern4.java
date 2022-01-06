/**
 * Pattern4.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program is match pattern ^[ab]c$
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */
public class Pattern4 {
    FSM fsm = new FSM();

    public boolean patternMatch(String string) {
        fsm.setState(0);
        fsm.setFinalState(2);
        for (int i = 0; i < string.length(); i++) {
            boolean isAOrB = string.charAt(i) == 'a' || string.charAt(i) == 'b';
            if (fsm.getState() == 0) {
                if (isAOrB) {
                    fsm.setState(1);
                } else {
                    fsm.setState(3);
                }
            } else if (fsm.getState() == 1) {
                if (isAOrB) {
                    fsm.setState(3);
                } else {
                    fsm.setState(2);
                }
            } else if (fsm.getState() == 2) {
                    fsm.setState(3);
            } else if (fsm.getState() == 3) {
                fsm.setState(3);
            }
        }

        if (fsm.getState() == fsm.getFinalState()) {
            return true;
        } else {
            return false;
        }
    }
}
