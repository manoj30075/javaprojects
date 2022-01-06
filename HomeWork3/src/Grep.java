/**
 * FSM.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program is to match the pattern
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Grep {
    static String PATTERN_1 = "^ab$";
    static String PATTERN_2 = ".a+b.";
    static String PATTERN_3 = ".ab.";
    static String PATTERN_4 = "^[ab]c$";
    static String PATTERN_5 = "^(bab|aba)$";

    public static void main(String[] args) {
        Pattern1 p1 = new Pattern1();
        Pattern2 p2 = new Pattern2();
        Pattern3 p3 = new Pattern3();
        Pattern4 p4 = new Pattern4();
        Pattern5 p5 = new Pattern5();

        Scanner sc;
        try {
            sc = new Scanner(new File(args[0]));
            while (sc.hasNext()) {
                String str = sc.next();
                if (p1.patternMatch(str)) {
                    System.out.println(PATTERN_1 + " " + str);
                } else if (p2.patternMatch(str)) {
                    System.out.println(PATTERN_2 + " " + str);
                } else if (p3.patternMatch(str)) {
                    System.out.println(PATTERN_3 + " " + str);
                } else if (p4.patternMatch(str)) {
                    System.out.println(PATTERN_4 + " " + str);
                } else if (p5.patternMatch(str)) {
                    System.out.println(PATTERN_5 + " " + str);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


    }
}
