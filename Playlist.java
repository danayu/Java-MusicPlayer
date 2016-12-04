
/**
 * Created by danayu on 10/27/16.
 */
public interface Playlist {

    void addTrack(Song song);

    int getTrackCount();

    int getTotalPlayLength();

    String getTitle();

    String currentArtistName();
}
