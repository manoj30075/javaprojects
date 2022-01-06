/**
 * SortedStorage.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program implements Binary search tree with set like properties *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

/**
 * This class includes Node class, functions to add, delete, find elements in BST
 * the emptyStringArray
 */
class SortedStorage<T>{
    class Node{
        T value;
        Node right;
        Node left;

        //constructor for node
        Node(T value){
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    /**
     * add function adds the string to the BST
     * @param value takes the value in string format, which must be added to the BST
     * @return return true if added, returns false otherwise
     */
    public boolean add(T value){
        root = addRecursively(root, value);
        if(root!=null){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * addRecursively function calls recursively to add string to the right location in BST
     * @param root root is the starting point of the Node in the BST
     * @param value value is the string which must be added to the BST
     * @return returns node of the root which it points to currently
     */
    Node addRecursively(Node root, T value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if((root.value.))){
            root.right = addRecursively(root.right, value);
        }
        else if (Integer.parseInt(root.value) >  Integer.parseInt(value)){
            root.left = addRecursively(root.left, value);
        }

        return root;
    }

    /**
     * find function finds the string to the BST
     * @param value takes the value in string format, which must be found to the BST
     * @return return true if found, returns false otherwise
     */
//    int calculatNulls(){
//
//        for()
//        return sumOfNulls;
//    }
    boolean find(String value){
        Node val = findRecursively(root, value);
        return val != null;
    }

    boolean find(Long value){
        Node val = findRecursively(root, value);
        return val != null;
    }

    boolean find(Integer value){
        Node val = findRecursively(root, value);
        return val != null;
    }

    /**
     * findRecursively function calls recursively to find string at the right location in BST
     * @param root root is the starting point of the Node in the BST
     * @param value value is the string which must be found to the BST
     * @return returns node of the root which it points to currently
     */
    Node findRecursively(Node root, String value){
//        int comparison = root.value.compareTo(value);

        if (root == null) {
            return root;
        }
        if(root.value == value){
            return root;
        }
        else if(Integer.parseInt(root.value) > Integer.parseInt(value)){
            return findRecursively(root.left, value);
        }else{
            return findRecursively(root.right, value);
        }
    }

    Node findRecursively(Node root, Long value){

        if (root == null) {
            return root;
        }
        if(root.longValue.equals(value)){
            return root;
        }
        else if(root.longValue.compareTo(value) > 0){
            return findRecursively(root.left, value);
        }else{
            return findRecursively(root.right, value);
        }
    }

    Node findRecursively(Node root, Integer value){

        if (root == null) {
            return root;
        }
        if(root.intValue == value){
            return root;
        }
        else if(root.intValue > value){
            return findRecursively(root.left, value);
        }else{
            return findRecursively(root.right, value);
        }
    }

    /**
     * delete function delete the string to the BST
     * @param value takes the value in string format, which must be deleted to the BST
     * @return return true if deleted, returns false otherwise
     */
    boolean delete(String value) {
        root = deleteRecursive(root, value);
        if(root != null){
            return true;
        }
        else{
            return false;
        }
    }

    boolean delete(Integer value) {
        root = deleteRecursive(root, value);
        if(root != null){
            return true;
        }
        else{
            return false;
        }
    }

    boolean delete(Long value) {
        root = deleteRecursive(root, value);
        if(root != null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * deleteRecursively function calls recursively to delete string at the right location in BST
     * @param root root is the starting point of the Node in the BST
     * @param value value is the string which must be deleted to the BST
     * @return returns node of the root which it points to currently
     */
    Node deleteRecursive(Node root, String value) {
        if (value == null) {
            value = "0";
        }
        //tree is empty
        if (root == null)
        {
            return root;
        }

        //traverse the tree
        if (root.value.compareTo(value) > 0)     //traverse left subtree
            root.left = deleteRecursive(root.left, value);
        else if (root.value.compareTo(value) < 0)  //traverse right subtree
            root.right = deleteRecursive(root.right, value);
        else {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;


            root.value = minimumValue(root.right);


            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    Node deleteRecursive(Node root, Integer value) {
        //tree is empty
        if (root == null)
        {
            return root;
        }

        //traverse the tree
        if (root.intValue > value)     //traverse left subtree
            root.left = deleteRecursive(root.left, value);
        else if (root.intValue < value)  //traverse right subtree
            root.right = deleteRecursive(root.right, value);
        else {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;


            root.value = minimumValue(root.right);


            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    Node deleteRecursive(Node root, Long value) {
        //tree is empty
        if (root == null)
        {
            return root;
        }

        //traverse the tree
        if (root.longValue.compareTo(value) > 0)     //traverse left subtree
            root.left = deleteRecursive(root.left, value);
        else if (root.longValue.compareTo(value) < 0)  //traverse right subtree
            root.right = deleteRecursive(root.right, value);
        else {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;


            root.value = minimumValue(root.right);


            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }


    String minimumValue(Node root){
        String minVal = root.value;

        while (root.left != null){
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    }

    boolean includesNull(String value){
        return includesNullRecursive(root, value);
    }

    boolean includesNullRecursive(Node root, String val){
        if(root.value.compareTo("null") == 0){
            return true;
        }
        else{
            return false;
        }
    }


    // helper to traverse the BST
    void inorder() {
        inorderRecursive(root);
    }

    // recursively we are traversing the BST
    void inorderRecursive(SortedStorage.Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.value + " ");
            inorderRecursive(root.right);
        }
    }

    //constructor for BST to initialize it to null
    SortedStorage() {
        root = null;
    }
}

class MainC {
    public static void main(String[] args) {
        SortedStorage bst = new SortedStorage();

        bst.add("2");
        bst.add("3");
        bst.add("5");

        bst.add("null");
        //bst.add("null");
        bst.delete("null");
        System.out.println(bst.find("3"));
        bst.delete("3");

        bst.inorder();


    }
}



