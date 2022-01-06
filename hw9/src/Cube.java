/*
  Cube class
 */
public class Cube extends Square{
    Cube (int side) {
        super(side);
    }

    /***
     * Prints the length of the Cube
     * @return
     */
    @Override
    public String toString() {
        return "Cube{" +
                "length=" + length +
                '}';
    }
}
