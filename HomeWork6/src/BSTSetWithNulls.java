public class BSTSetWithNulls extends BSTSet{
    int noOfNulls = 0;

    public boolean add(String value)  {
        if(value == null) {
            noOfNulls++;
            return true;
        } else {
            return super.add(value);
        }
    }

    public boolean add(Integer value)  {
        if(value == null) {
            noOfNulls++;
            return true;
        } else {
            return super.add(value);
        }
    }

    public boolean add(Long value)  {
        if(value == null) {
            noOfNulls++;
            return true;
        } else {
            return super.add(value);
        }
    }

    public boolean find(String value)  {
        if(value == null) {
            return noOfNulls > 0;
        } else {
            return super.find(value);
        }
    }

    public boolean find(Integer value)  {
        if(value == null) {
            return noOfNulls > 0;
        } else {
            return super.find(value);
        }
    }

    public boolean find(Long value)  {
        if(value == null) {
            return noOfNulls > 0;
        } else {
            return super.find(value);
        }
    }

    public boolean delete(String value) {
        if(value == null) {
            if (noOfNulls > 0) {
                noOfNulls--;
                return true;
            } else
                return false;
        }
        return super.delete(value);
    }

    public boolean delete(Integer value) {
        if(value == null) {
            if (noOfNulls > 0) {
                noOfNulls--;
                return true;
            } else
                return false;
        }
        return super.delete(value);
    }

    public boolean delete(Long value) {
        if(value == null) {
            if (noOfNulls > 0) {
                noOfNulls--;
                return true;
            } else
                return false;
        }
        return super.delete(value);
    }
}
