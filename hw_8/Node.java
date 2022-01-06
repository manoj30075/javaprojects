/**
 * class that contains node class variables
 */
class Node<T extends Comparable<T>> {
    T key;
    Node<T> left, right;

    public Node(T data) {
        key = data;
        left = null;
        right = null;
    }
}