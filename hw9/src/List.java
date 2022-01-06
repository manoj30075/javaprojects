/**
 * List that creates arraylist based on user input and has
 * its.
 *
 * @author Manoj kumar reddy Palasamudram mp6112
 * @author Ashwath Sreedhar Halemane ah7387
 */

import java.util.ArrayList;

public class List<T>{
    ArrayList<T> list;

    List() {
        this.list = new ArrayList<>();
    }

    // return length of the List
    public int length() {
        return list.size();
    }

    // prints the elements in the list
    public void print() {
        for (T t: list) {
            System.out.println(t);
        }
    }

    // adds an element to the list
    public void add(T t) {
        this.list.add(t);
    }

    // returns element in the list of index
    public T get(int i) {
        return this.list.get(i);
    }
}
