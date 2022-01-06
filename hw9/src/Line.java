/*
  Line class
 */
public class Line {
    int length;

    Line(int side) {
        this.length = side;
    }

    /***
     * Prints the length of the line
     * @return
     */
    @Override
    public String toString() {
        return "Line{" +
                "length=" + length +
                '}';
    }
}
