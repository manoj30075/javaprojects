/**
 * Test to check the working of List class
 *
 * @author Manoj kumar reddy Palasamudram mp6112
 * @author Ashwath Sreedhar Halemane ah7387
 */


public class Test {
    /***
     * Sum of the lengths in list which accepts Cube as upperbound
     * @param list
     * @return
     */
    public static int sum(List<? extends Cube> list) {
        int sum = 0;
        for (int i = 0; i < list.length(); i++) {
            sum += list.get(i).length;
        }
        return sum;
    }

    /***
     * Sum of the lengths in list which accepts Square as lowerbound
     * @param list
     * @return
     */
    public static int sum2(List<? super Square> list) {
        int sum = 0;
        for (int i = 0; i < list.length(); i++) {
            sum += ((Line) list.get(i)).length;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Line> list1 = new List<>();
        list1.add(new ThreeDCube(5));
        list1.add(new Cube(4));
        list1.add(new Square(3));
        list1.add(new Line(2));

        List<Cube> list2 = new List<>();
        list2.add(new ThreeDCube(4));
        list2.add(new Cube(4));

        List<Line> list3 = new List<>();
        list3.add(new Line(10));
        list3.add(new Square(20));

        list1.print();
        System.out.println(sum(list2));
        System.out.println(sum2(list3));

    }
}
