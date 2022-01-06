/*
 * Test.java
 * Version: 1.0
 * Revisions: 1
 */

/**
 * The class tests the SortedStorageSetWithNulls generics.
 */
public class Test {
    /**
     * main function to test the following code
     * @param args
     */
    public static void main(String[] args) {
        Human[] humans = { new Human("1", "Manoj", "01-01-1996"),
                new Human("2", "kumar", "02-09-1998"),
                new Human("3", "reddy", "10-11-1989"),
                new Human("4", "Ashwath", "06-02-1987"),
                new Human("5", "Halemane", "07-07-2000") };
        SortedStorageSetWithNulls<Human> humanStorage = new SortedStorageSetWithNulls<Human>();

        for (Human human : humans) {
            humanStorage.add(human);
        }

        System.out.println(humanStorage);
        System.out.println();
        
        humanStorage.delete(humans[1]);
        System.out.println("humanstorage after deleting second item");
        System.out.println(humanStorage);
        System.out.println();

        Integer[] test = { 2, 56, 13, 68, 89 };

        System.out.println("Integer storage");
        SortedStorageSetWithNulls<Integer> intStorage = new SortedStorageSetWithNulls<Integer>();
        for (Integer integer : test) {
            intStorage.add(integer);
        }

        System.out.println(intStorage);
        System.out.println();

        System.out.println("String storage:");
        String[] strings = { "manoj", "kumar", "ashwath", "reddy", "hello", "test123" };

        SortedStorageSetWithNulls<String> stringStorage = new SortedStorageSetWithNulls<String>();
        for (String string : strings) {
            stringStorage.add(string);
        }

        System.out.println(stringStorage);
        System.out.println();

        Address[] addresses = {
                new Address(636, "Mallikarjuna st", "Sringeri", "KA", 57713),
                new Address(211, "BSNL St", "Bangalore", "TN", 56602),
                new Address(666, "Devil st", "Phoenix", "AZ", 85001),
                new Address(108, "Govt st", "Kalasipalya", "BP", 87116) };

        SortedStorageSetWithNulls<Address> addressStorage = new SortedStorageSetWithNulls<Address>();

        for (Address address : addresses) {
            addressStorage.add(address);
        }
        System.out.println(addressStorage);
        System.out.println();

        MusicLP[] musics = { new MusicLP(2005, "Prem", "Wasted", 320.34f, 1),
                new MusicLP(2020, "Ajaneesh", "Dia", 280.24f, 1),
                new MusicLP(2012, "DSP", "Srivalli", 340.24f, 1), };

        SortedStorageSetWithNulls<MusicLP> musicStorage = new SortedStorageSetWithNulls<MusicLP>();

        for (MusicLP music : musics) {
            musicStorage.add(music);
        }

        musicStorage.add(null);
        System.out.println(musicStorage);
        System.out.println();

        System.out.println("finding element humanStorage.find(humans[0]):"+ humanStorage.find(humans[0]));
        System.out.println("testing for duplicate element addressStorage.add(addresses[0]): "+ addressStorage.add(addresses[0]));

    }
}
