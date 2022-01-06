/**
 * FSM.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This is Finate state machine class
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */
public class FSM {
    int state;
    int finalState;

    public int getFinalState() {
        return finalState;
    }

    public void setFinalState(int finalState) {
        this.finalState = finalState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
