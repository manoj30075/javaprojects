/*
  Square class
 */

public class Square extends Line{
    Square(int side) {
        super(side);
    }

    /***
     * Prints the length of the Square
     * @return
     */
    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                '}';
    }
}
