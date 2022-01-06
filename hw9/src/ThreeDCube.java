/*
  ThreeDCube class
 */

public class ThreeDCube extends Cube {
    ThreeDCube(int side) {
        super(side);
    }

    /***
     * Prints the length of the ThreeDCube
     * @return
     */
    @Override
    public String toString() {
        return "ThreeDCube{" +
                "length=" + length +
                '}';
    }
}
