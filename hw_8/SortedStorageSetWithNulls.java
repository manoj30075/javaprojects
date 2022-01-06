/*
 * SortedStorageSetWithNulls.java
 *
 * Version: 1.0
 *
 * Revisions: 1
 */

/**
 * BST that can store objects and behaves like set.
 *
 * @author Manoj kumar reddy Palasamudram mp6112
 * @author Ashwath Sreedhar Halemane ah7387
 */
public class SortedStorageSetWithNulls<T extends Comparable<T>> implements StorageInterface<T> {
    Node<T> root;
    int numberOfNullObjects = 0;

    SortedStorageSetWithNulls() {
        root = null;
    }

    /**
     * adding a node in BST
     * @param key the key to be added
     * @return: boolean type. True if done, else false.
     */
    @Override
    public boolean add(T key) {
        if (key != null && find(key))
            return false;
        if (key == null) {
            numberOfNullObjects++;
            return true;
        }
        root = addRecursively(root, key);
        if (root != null)
            return true;
        else
            return false;
    }

    /**
     * Finds the key in BST
     * @param key
     * @return: (Boolean type) true if found
     */
    public boolean find(T key) {
        if (key == null)
            return false;
        Node<T> answer = searchRecursive(root, key);
        if (answer != null)
            return true;
        else
            return false;
    }

    /**
     * recursive search in BST
     * @param root which is a node and key which is of string type
     * @return node if found
     */
    Node<T> searchRecursive(Node<T> root, T key) {
        if (root == null || root.key == key)
            return root;
        if (key.compareTo(root.key) < 0)
            return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }

    /**
     * Recursively add the nodes in BST
     * @param root Node
     * @param key  The value to be inserted
     * @return Node root element
     */
    Node<T> addRecursively(Node<T> root, T key) {
        if (root == null) {
            root = new Node<T>(key);
            return root;
        }

        if (key.compareTo(root.key) < 0){
            root.left = addRecursively(root.left, key);
        }
        else if (key.compareTo(root.key) >= 0) {
            root.right = addRecursively(root.right, key);
        }
        return root;
    }

    /**
     * delete node in BST
     * @param root root of the bst
     * @param key, which contains the value.
     * @return: root that gets deleted.
     */
    Node<T> deleteRecursively(Node<T> root, T key) {
        if (root == null)
            return root;

        if (key.compareTo(root.key) < 0)
            root.left = deleteRecursively(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteRecursively(root.right, key);

        else {
            // leaf node condition
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else { // two children condition
                   // checking for minimum in the right sub tree
                T value = minValue(root.right);
                // replacing current node with the minimum value
                root.key = value;
                // try deleting the duplicate value by passing right sub tree recursively
                root.right = deleteRecursively(root.right, value);
            }
        }
        return root;
    }

    /**
     * Returns minvalue from root
     *
     * @param root the part of tree
     *
     * @return min value
     */
    T minValue(Node<T> root) {
        T minval = root.key;
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }



    /**
     * Method called when inorder traversal is to be done.
     * @param: root which is a node
     * @return: String type
     */
    String inorderRecursive(Node<T> root) {
        String newString = "";
        if (root != null) {
            newString +=" ( left: " + inorderRecursive(root.left) + " ) " +"\n";
            newString += " " +  root.key +"\n";
            newString +="( right: " + inorderRecursive(root.right) + ")";
        } else {
            newString = "null";
        }
        return newString;
    }


    /**
     * Delete a key from the BST
     * @param: key which is to be removed
     * @return: boolean
     */
    @Override
    public boolean delete(T key) {
        if (key == null) {
            if (numberOfNullObjects == 0) {
                return false;
            } else {
                numberOfNullObjects--;
                return true;
            }
        } else if (!find(key)) {
            return false;
        }
        root = deleteRecursively(root, key);
        return true;

    }

    
    @Override
    public boolean includesNull() {
        if (numberOfNullObjects > 0) {
            return true;
        }
        return false;
    }

    /**
     * Main function
     * @param args
     *
     * @return: none
     */
    public static void main(String[] args) {

    }

    /**
     * prints the BST
     * @return: String type, which prints the tree.
     */
    @Override
    public String toString() {
        return inorderRecursive(root) + "\n with nulls :" + numberOfNullObjects;
    }

}
