import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This has the all the variables regarding Human object
 */

public class Human implements Comparable<Human> {
    private Date dateOfBirth;
    private String firstName;
    private String userId;

    public Human(String userId, String firstName, String dateOfBirth) {
        this.firstName = firstName;
        SimpleDateFormat dt = new SimpleDateFormat("mm-dd-yyyyy");
        try {
            this.dateOfBirth = dt.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.userId = userId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserId() {
        return userId;
    }

    /**
     * Prints the Human object values
     * @return
     */
    @Override
    public String toString() {

        return "First Name : " + firstName + " UserID : " + userId + " DOB : " + dateOfBirth;
    }

    /**
     * This is an overridden method used to compare the values of the object
     * @param: Human class
     * @return: int comparedVal
     */
    @Override
    public int compareTo(Human human) {
        int comparedVal = dateOfBirth.compareTo(human.getDateOfBirth());
        if (comparedVal == 0) {
            comparedVal = userId.compareTo(human.getUserId());
            if (comparedVal == 0) {
                comparedVal = firstName.compareTo(human.getFirstName());
            }
        }
        return comparedVal;
    }
}
