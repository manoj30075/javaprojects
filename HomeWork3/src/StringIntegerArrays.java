import java.util.Arrays;

public class StringIntegerArrays {
    public static void main(String[] args) {
        String aString, bString, cString, dString, eString,fString,gString,hString,iString;

        if ( args.length == 0 ) {
            aString = "123425" + "25";
            bString = "12342525";
            cString = "5";
            dString = "25" + "2" + cString;
            eString = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
            fString = "A, B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
            gString = aString + ( bString + cString ) + dString;
            hString = "2525" +  "+" + "2525";
            iString = "2525+2525";

            System.out.println("I.  " + aString.equals(bString));
            System.out.println("II.   " + (aString == bString));
            System.out.println("III.  " + aString.equals(dString));
            System.out.println("IV.   " + (aString == dString));
            System.out.println("V.  " + hString.equals(iString));
            System.out.println("VI.   " + (hString == iString));

            int a = (int)aString.charAt(0) - 48;

            int b = (int)aString.charAt(1) - 48;

            System.out.println("VII.    "+dString.substring(a-1, b));
            //Extract the chara
            int index = fString.indexOf('*');
            System.out.println("VIII.    "+ eString.charAt(index));
            char[] bSStringp = bString.toCharArray();

            Arrays.sort(bSStringp);
            //System.out.println(bSStringp);

            String string = new String(bSStringp);

            System.out.println("IX.    "+ string.substring(3, 4));

        } else {
            aString = "12342" + new String("" + 5) +  "25";
            bString = "12342525";
            cString = "5";
            dString = "" + "25" + "" + "2" + cString;
            eString = "b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
            fString = "B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
            gString = ( ( aString + bString )  + "" + 5 ) + dString;
            hString = "2525" +  "+" + "2525";
            iString = "25" + ( 2 + 5 ) + "+2525";

            System.out.println("I.  " + aString.equals(bString));
            System.out.println("II.   " + (aString == bString));
            System.out.println("III.  " + aString.equals(dString));
            System.out.println("IV.   " + (aString == dString));
            System.out.println("V.  " + hString.equals(iString));
            System.out.println("VI.   " + (hString == iString));


            int a = (int)aString.charAt(0) - 48;
            int b = (int)aString.charAt(1) - 48;
            System.out.println("VII.    "+dString.substring(a-1, b));
            int index = fString.indexOf('*');
            System.out.println("VIII.    "+ eString.charAt(index));
            int last = Integer.parseInt(bString);
            System.out.println(last);

            char[] bSStringp = bString.toCharArray();

            Arrays.sort(bSStringp);

            String string = new String(bSStringp);

            System.out.println("IX.    "+ string.substring(3, 4));
        }
    }
}
