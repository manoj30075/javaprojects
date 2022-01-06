public class X_1	{
    public void throwsE() throws Exception {
        throw new Exception();
    }
    public int tryCatchFinally() {
        try {
            try {
                System.out.println("Inner TRY");
                throwsE();
                return 1;
            } catch (Exception e) {
                System.out.println("Inner CATCH");
                throwsE();
                return 2;
            } finally {
                System.out.println("Inner FINALLY!");
                throwsE();
                System.exit(1);
                return 3;
            }
        } catch (Exception e) {
            System.out.println("Outer CATCH");
            return 4;
        } finally {
            System.out.println("Outer FINALLY");
            return 6;
        }
    }
    public static void main(String[] args )	{
        System.out.println("new X_1().tryCatchFinally(); = " +
                new X_1().tryCatchFinally() );
    }
}