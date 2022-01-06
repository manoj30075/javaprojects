class StringLiteralPractice {

    public static String method()   {
        return ( 1 > 0 ? "1234"  : "a");
    }
    public static String met()   {
        return "12";
    }
    public static String hod()   {
        return "34";
    }
    public static void main( String args[] ) {
        String aString = "1234";
        int aInt       =  34;

        System.out.println(" 1:   " + ( "1234" == "1234")  );
        System.out.println(" 2:   " + ( aString == "1234") );
        System.out.println(" 3:   " + ( aString == "12" + "34")  );
        System.out.println(" 4:   " + ( aString == "12" + aInt )  );
        System.out.println(" 5:   " + ( aInt/2 + "12"  + aInt/2 ));
        System.out.println(" 6:   " + ( aString.equals("12" + ( aInt/2 + aInt/2 )) ) );
        System.out.println(" 7:   " + ( aString == method())            );
        System.out.println(" 8:   " + ( aString.equals(new String("1234")         )));
        System.out.println(" 9:   " + ( aString ==
                ( aString.substring(0, 2) + aString.substring(2, 4)))   );
        System.out.println("10:   " + ( aString.equals(
                aString.substring(0, 2) + hod()))         );
    }
}