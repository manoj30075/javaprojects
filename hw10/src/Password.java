import java.io.Serial;
import java.io.Serializable;

public class Password implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String password;

    Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
