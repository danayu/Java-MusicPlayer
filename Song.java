
/**
 * Song object that stores a trackTitle, trackLength, albumName, artistName for each song object
 * Created by danayu on 10/26/16.
 */
public class Song {

    private int trackLength;
    private String trackTitle;
    private String artistName;
    private String albumName;

    public Song(String trackTitle, String artistName, String albumName, int trackLength) {
        this.trackLength = trackLength;
        this.trackTitle = trackTitle;
        this.artistName = artistName;
        this.albumName = albumName;

    }

    public String toString(){

        return trackTitle;
    }

    public void show(){
        System.out.println(this.trackTitle);
    }

    public String getTitle(){
        return this.trackTitle;
    }

    public int getTrackLength() {
        return this.trackLength;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public String getAlbumName() {
        return this.albumName;
    }
}
