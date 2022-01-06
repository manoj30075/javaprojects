/**
 * SqrtThread.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program produces the value of square root of 2, using BigDecimal class better precision, using threads the computation becomes faster.
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * To perform the arithmetic operation of 1/sqrt(2) given
 * number of threads and upperbound
 *
 */
public class SqrtThread extends Thread{

    public BigDecimal final_value = new BigDecimal(1.0);
    private final int startRange;
    private final int endRange;

    /**
     * Constructor when upperbound and lowerbounds are passed
     * @param startRange lower range of the new thread
     * @param endRange upper range of the new thread
     */
    public SqrtThread(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    /**
     * This function will be executed when start method is called on a thread.
     * This computes the formula replicating the mathematical expression on BigDecimal objects
     */
    @Override
    public void run() {
        BigDecimal mul = BigDecimal.ONE;
        for (int i = startRange; i < endRange ; i++) {
            double d = 1 - (1 / Math.pow(4*i + 2, 2));
            mul = mul.multiply(BigDecimal.valueOf(d));
        }
        final_value = final_value.multiply(mul);
    }


    public static void main(String[] args){

        int upperBound = 1000;
        int threadCount = 10;

        if(args.length>1){
            upperBound = Integer.parseInt(args[1]);
            threadCount = Integer.parseInt(args[0]);
        }

        else if(args.length == 1){
            System.out.println("Enter valid arguments");
            System.exit(0);
        }

        int numberOfOperationsInAThread = upperBound/threadCount;

        SqrtThread[] myThreads = new SqrtThread[threadCount];

        for (int i = 0; i < myThreads.length; i++) {
            SqrtThread s;
            if(i != myThreads.length-1){
                s = new SqrtThread(i * numberOfOperationsInAThread, (i + 1) * numberOfOperationsInAThread);
            }
            else{
                s = new SqrtThread((i * numberOfOperationsInAThread), upperBound);
            } myThreads[i] = s;
        }

        for(SqrtThread t : myThreads){
            t.start();
        }

        BigDecimal product = BigDecimal.valueOf(1.0);

        for (SqrtThread myThread : myThreads) {
            try {
                myThread.join();
                product = product.multiply(myThread.final_value);
            } catch (InterruptedException e) {
                System.out.println("Thread is running");
            }
        }
        System.out.println(BigDecimal.ONE.divide(product, new MathContext(20)));
    }
}