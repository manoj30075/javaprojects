/**
 * Pattern5.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program is match pattern ^(bab|aba)$
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */
public class Pattern5 {
    FSM fsm = new FSM();

    public boolean patternMatch(String string) {
        fsm.setState(0);
        fsm.setFinalState(3);
        for (int i = 0; i < string.length(); i++) {
            if (fsm.getState() == 0) {
                if (string.charAt(i) == 'a') {
                    fsm.setState(4);
                } else {
                    fsm.setState(1);
                }
            } else if (fsm.getState() == 1) {
                if (string.charAt(i) == 'a') {
                    fsm.setState(2);
                }
            } else if (fsm.getState() == 2) {
                if (string.charAt(i) == 'b') {
                    fsm.setState(3);
                }
            } else if (fsm.getState() == 3) {
                fsm.setState(6);
            } else if (fsm.getState() == 4) {
                if (string.charAt(i) == 'b') {
                    fsm.setState(5);
                }
            } else if (fsm.getState() == 5) {
                if (string.charAt(i) == 'a') {
                    fsm.setState(6);
                }
            }
        }

        if (fsm.getState() == fsm.getFinalState()) {
            return true;
        } else {
            return false;
        }
    }
}
