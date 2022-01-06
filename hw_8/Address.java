/**
* This has the all the variables regarding Address object
*/
public class Address implements Comparable<Address> {
    /**
    * The private variables are accessible only to this class.
    */
    private int houseNumber;
    private String streetName;
    private String nameOfTown;
    private String state;
    private int zipCode;

    /**
     * Constructor which is executed when object is created
     */
    Address(int houseNumber, String streetName, String nameOfTown, String state, int zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.nameOfTown = nameOfTown;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * This is an overridden method used to compare the values of the object
     * @param: Address class
     * @return: int comparedVal
     */
    @Override
    public int compareTo(Address address) {
        int comparedVal = this.nameOfTown.compareTo(address.nameOfTown);
        if (comparedVal == 0) {
            comparedVal = this.streetName.compareTo(address.streetName);
            if (comparedVal == 0) {
                comparedVal = this.state.compareTo(address.state);
                if (comparedVal == 0) {
                    comparedVal = this.houseNumber - address.houseNumber;
                }
            }

        }

        return comparedVal;
    }



    /**
    * method to print the values of the object
    * @return String
    */
//    @Override
//    public String toString() {
//        return " House details : " + houseNumber + " , " + streetName + ", \n" + nameOfTown + "\n" + state + " : " + zipCode;
//    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", streetName='" + streetName + '\'' +
                ", nameOfTown='" + nameOfTown + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
