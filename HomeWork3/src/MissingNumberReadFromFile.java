import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissingNumberReadFromFile {
    public static void main(String[] args) throws FileNotFoundException {

        String path = new File("").getAbsolutePath().concat("/" +args[0] +"_bits.txt");

        //path.concat("/src/4_bits.txt");

        //loremIpsum = new Scanner(new File(path)).next().split(" ");
        Scanner scanner = new Scanner(new File(path));
        int i = 1;
        while(scanner.hasNextInt())
        {
            int num = scanner.nextInt();
            if (i != num) {
                break;
            }
            i++;
        }

        System.out.printf("Found missing number: %d%n", i);
    }
}


//java MissingNumberReadFromFile -n 18 -f 18_bits.txt