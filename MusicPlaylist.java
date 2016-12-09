import java.util.*;

/**
 * Created by danayu on 10/26/16.
 */

import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.Iterator;

/** A list that can hold music tracks and control what is currently playing on a
 * music device. New tracks are added through the {@code add} method. The
 * playlist must store which track is currently playing. Whenever the
 * {@code next} method is called a new track is chosen to be played. Information
 * about the currently playing track can be accessed through the
 * {@code currentTrackTitle}, {@code currentArtistName},
 * {@code currentAlbumName}, and the{@code currentTrackLength} methods.
 * Information about the playlist as a whole can be gotten through the
 * {@code getTrackCount} and {@code getTotalPlayLength} methods.
 */

public class MusicPlaylist implements Playlist{
    private List<Song> playList;
    int trackCount;
    int playLength;
    Song currentTrack;
    String trackTitle;
    String artistName;
    String albumName;
    int i;
    int trackLength;
    public int size;


    public MusicPlaylist(){
        this.trackCount = 0;
        this.playLength = 0;
        this.playList = new ArrayList<>();
        this.currentTrack = null;
        this.trackTitle = null;
        this.artistName = null;
        this.albumName = null;
        this.trackLength = 0;
    }

    /** Adds a new track to this playlist.
     *
     */
    public void addTrack(Song song) throws NullPointerException{

        if (song.getTitle() != null && song.getArtistName() != null
                && song.getAlbumName() != null && song.getTrackLength() >=0 ) {
            playList.add(song);
            this.playLength = playLength + song.getTrackLength();
        }

    }

    /** Returns the number of tracks in this playlist.
     *
     * @return the number of tracks in this playlist.
     */
    public int getTrackCount(){

        return playList.size();
    }

    /** Returns the total length in seconds of all tracks in the playlist. If the
     * playlist is empty, this returns 0.
     *
     * @return the total length in seconds of all tracks in the playlist.
     */
    public int getTotalPlayLength() {
        if (playList.size() == 0) {
            return 0;
        }
        return this.playLength;
    }

    /** Randomly mixes the order of the tracks currently stored in this playlist.
     * This operation is allowed to change the currenly selected track.
     */
    public void shuffle() {

        Collections.shuffle(playList);
        //random();
        //setCurrentTrack();

    }

    /**
     * Sets the current track
     */

    public int setCurrentTrack(){
        //System.out.println("Set Current Track method: " + this.i);
        this.currentTrack = playList.get(this.i);
        return this.i;
    }

    /**
     * Randomizes the index at which to determine the current track
     * @return
     */
    public int random() {

        int max = this.playList.size();
        double r = Math.random();
        this.i = (int) (r * max);
        return this.i;
    }

    /** Changes the currently playing track to the next track in the playlist.
     * This operation must automatically start over from the begining of the
     * playlist, if the end of the playlist is reached. If the playlist is
     * empty, this operation does nothing.
     */
    public void next() {

        if (this.i < (this.playList.size()) - 1 ){
            setCurrentTrack();
            this.i = this.i + 1;
        }

        else if (this.i == (this.playList.size()) -1) {
            this.i = 0;
            setCurrentTrack();
        }
    }

    /** Returns the current track
     *
     * @return the current track
     */
    public String currentTrackTitle() {

        this.trackTitle = currentTrack.getTitle();

        return this.trackTitle;
    }

    /** Returns the title of the current track
     *
     * @return the title of the current track
     */
    public String currentArtistName() {

        this.artistName = currentTrack.getArtistName();
        return this.artistName;
    }

    /** Returns the album of the current track
     *
     * @return the album of the current track
     */
    public String currentAlbumName() {

        this.albumName = currentTrack.getAlbumName();
        return this.albumName;
    }

    /** Returns the length of the current track
     *
     * @return the length of the current track
     */
    public int currentTrackLength() {

        this.trackLength = currentTrack.getTrackLength();
        return trackLength;
    }

    public void show(){

        for (Song song: playList) {
            song.show();

        }

    }

    public String getTitle(){

        return this.currentTrackTitle();
    }

    public Iterator<Song> iterator(){
        Iterator<Song> it = playList.iterator();

        return it;
    }

    public static void main (String[] args) {

        MusicPlaylist DanasList = new MusicPlaylist();
        Song track1 = new Song("Age Of Consent","New Order","Power, Corruption & Lies", 300);
        Song track2 = new Song("Caravan", "Van Morrison", "Moondance", 20);
        Song track3 = new Song("Fast Car", "Tracy Chapman", "Gilmore Girls", 150);
        Song track4 = new Song("Dance Yourself Clean", "LCD Soundsystem", "This is Happening", 1000);
        Song track5 = new Song(null, "Artist5", "Album5", 0);
        Song track6 = new Song("Null_Artist", null ,"Album6", 2);
        Song track7 = new Song("Negative", "Number", "Track_Length", -2);
        Song track8 = new Song("Final Song", "Mø", "Final Song", 350);

        DanasList.addTrack(track1);
        DanasList.addTrack(track2);
        DanasList.addTrack(track3);
        DanasList.addTrack(track4);
        DanasList.addTrack(track5);
        DanasList.addTrack(track6);
        DanasList.addTrack(track7);
        DanasList.addTrack(track8);

        DanasList.setCurrentTrack();

        System.out.println("Welcome to Dana's Playlist.");
        System.out.println("Enter next at any time to change the song.");
        System.out.println("");


        DanasList.show();
        System.out.println("Total playlist length: " + (DanasList.getTotalPlayLength())/60 + " minutes.");
        System.out.println("");
        System.out.println("You are currently listening to " + DanasList.currentTrackTitle() + " by " + DanasList.currentArtistName()
                + " running at " + (DanasList.currentTrackLength()/60) + " minutes long.");
        System.out.println("Current track album is: " + DanasList.currentAlbumName());

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if (line.equals("next")) {
            DanasList.next();
            System.out.println("You are currently listening to " + DanasList.currentTrackTitle() + " by " + DanasList.currentArtistName()
                    + " running at " + (DanasList.currentTrackLength()/60) + " minutes long.");
            System.out.println("Current track album is: " + DanasList.currentAlbumName());
        }


    }

}

