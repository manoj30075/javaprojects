/**
 * Pattern1.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program is match pattern ^ab$
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */
public class Pattern1 {
    FSM fsm = new FSM();

    public boolean patternMatch(String string) {
        fsm.setState(0);
        fsm.setFinalState(2);
        for (int i = 0; i < string.length(); i++) {
            if (fsm.getState() == 0) {
                if (string.charAt(i) == 'a') {
                    fsm.setState(1);
                } else {
                    fsm.setState(-1);
                }
            } else if (fsm.getState() == 1) {
                if (string.charAt(i) == 'a') {
                    fsm.setState(-1);
                } else {
                    fsm.setState(2);
                }
            } else if (fsm.getState() == 2) {
                fsm.setState(-1);
            }
        }

        System.out.println(fsm.getState());
        System.out.println(fsm.getFinalState());

        if (fsm.getState() == fsm.getFinalState()) {
            return true;
        } else {
            return false;
        }
    }
}
