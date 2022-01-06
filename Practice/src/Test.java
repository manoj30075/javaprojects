
import java.util.*;

public class Test extends Thread    {
    private String info;
    static Vector aVector;

    public Test(Vector aVector, String info) {
        this.aVector = aVector;
        this.info    = info;
    }

    public void inProtected () {
        synchronized ( aVector )     {
            System.err.println(info + ": is in protected()");
            try {
                sleep(100);
            }
            catch (  InterruptedException e ) {
                System.err.println("Interrupted!");
            }
            System.err.println(info + ": exit run");
        }
    }

    public void run () {
        inProtected();
    }

    public static void main (String args []) {
        Test aT5_0 = new Test(new Vector(), "first");
        aT5_0.start();

        Test aT5_1 = new Test(new Vector(), "second");
        aT5_1.start();
    }w
}