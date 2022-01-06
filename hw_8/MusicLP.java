/**
* This class is used to implement the details of a MusicLP object.
*/
public class MusicLP implements Comparable<MusicLP> {
    /**
    * These are MusicLP object variables
    */
    private int year;
    private String artist;
    private String title;
    private float length;
    private int tracks;

    /**
    * MusicLP constructor is executed when MusicLP object is created
    */
    public MusicLP(int year, String artist, String title, float length, int tracks) {
        this.year = year;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.tracks = tracks;

    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    /**
    * Prints the MusicLP object values
    */
    @Override
    public String toString() {

        return "title : " + title + " artist : " + artist + " year : " + year + " length : " + length + " tracks : " + tracks;
    }

    /**
     * This is an overridden method used to compare the values of the object
     * @param: MusicLP class
     * @return: int comparedVal
     */
    @Override
    public int compareTo(MusicLP music) {
        int comparedVal = artist.compareTo(music.getArtist());
        if (comparedVal == 0) {
            comparedVal = year - music.getYear();
            if (comparedVal == 0) {
                comparedVal = title.compareTo(music.getTitle());
            }
        }
        return comparedVal;
    }
}
