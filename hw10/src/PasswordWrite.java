import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class PasswordWrite {
    public static void main(String[] args) {
        /***
         * Write a password to a file
         */
        try {
            FileOutputStream fos = new FileOutputStream(args[0]);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Password("Test124"));
            String encodedString = Base64.getEncoder().encodeToString("Test123".getBytes());
            oos.writeBytes(encodedString);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
