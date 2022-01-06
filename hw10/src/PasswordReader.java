import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class PasswordReader {
    public static void main(String[] args) {
        /***
         * Reads the password from the file and prints it to the console
         */
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Password password = (Password) ois.readObject();
            String encoded = ois.readLine();
            byte[] decodedBytes = Base64.getDecoder().decode(encoded);
            String decoded = new String(decodedBytes);

            if (password.getPassword().equals(decoded)) {
                System.out.println("Your password is" + password.getPassword());
            } else {
                System.out.println("Someone has modified the file");
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
