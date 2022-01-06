public class BSTSet extends SortedStorage {
    public boolean add(String value){
        if (super.find(value)) {
            return false;
        }
        root = addRecursively(root, value);
        if(root!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean add(Integer value){
        if (super.find(value)) {
            return false;
        }
        root = addRecursively(root, value);
        if(root!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean add(Long value){
        if (super.find(value)) {
            return false;
        }
        root = addRecursively(root, value);
        if(root!=null){
            return true;
        }
        else{
            return false;
        }
    }
}
