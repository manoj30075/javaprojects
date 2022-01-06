public class X extends Thread    {
    static Object o = new Object();
    int id;
    public X(int id)	{

        this.id = id;

        o       = new Object();
    }
    public void run () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ( id == 0 )	{
            new X(1).start();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            new X(2).start();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        synchronized ( o ) {
            try {
                System.err.println(id + " --->");
                o.notifyAll();
                o.wait();
                o.notifyAll();
                System.err.println(id + " <---");
            }
            catch (  InterruptedException e ) {
            }
        }
    }
    public static void main (String args []) {
        new X(0).start();
    }
}