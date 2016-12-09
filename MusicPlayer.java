/**
 * MusicPlayer creates and controls a music playlist program that allows uer interaction with GUI components
 * Created by danayu on 11/4/16.
*/

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Iterator;



public class MusicPlayer extends JFrame {

    MusicPlaylist myPlaylist;
    JButton next = new JButton("Next");
    JButton shuffle = new JButton("Shuffle");
    JButton add = new JButton("Add Track");
    JTextField addTitle = new JTextField();
    JTextField addArtist = new JTextField();
    JTextField addAlbum = new JTextField();
    JTextField addLength = new JTextField();
    JLabel titleLabel = new JLabel("Title");
    JLabel artistLabel = new JLabel("Artist");
    JLabel albumLabel = new JLabel("Album");
    JLabel lengthLabel = new JLabel("Track length (sec)");

    JPanel displayPanel = new JPanel(new BorderLayout());

    DefaultListModel<Song> listModel = new DefaultListModel<Song>();
    JList<Song> trackList = new JList<Song>(listModel);

    JTextArea textArea = new JTextArea("Welcome to Dana's Jam Space. " + "\n");

    public MusicPlayer() {
        this.myPlaylist = new MusicPlaylist();

        next.addActionListener(
                event -> {

                myPlaylist.next();
                textArea.setText("You are playing " + myPlaylist.currentTrackTitle() + " by " + myPlaylist.currentArtistName() + "\n");
                System.out.println("Index i is at: " + myPlaylist.setCurrentTrack());
                System.out.println("You are playing " + myPlaylist.currentTrackTitle() + " by " + myPlaylist.currentArtistName());

            });


        shuffle.addActionListener(event -> {
                myPlaylist.shuffle();
                listModel.clear();

                Iterator<Song> it = myPlaylist.iterator();

                while (it.hasNext()) {
                    Song song = it.next();
                    listModel.addElement(song);
                }

                trackList = new JList<Song>(listModel);
                textArea.setText("You are playing " + myPlaylist.currentTrackTitle() + " by " + myPlaylist.currentArtistName() + "\n");

            });

        add.addActionListener(event -> {
                Song newSong = new Song(addTitle.getText(),addArtist.getText(),addAlbum.getText(),Integer.valueOf(addLength.getText()));
                myPlaylist.addTrack(newSong);
                clearTrackFields();
                listModel.addElement(newSong);

            });


        myPlaylist.addTrack(new Song("Fast Car", "Tracy Chapman", "Tracy Chapman", 170));
        myPlaylist.addTrack(new Song("How Will I Know", "Whitney", "WHITNEY HOUSTON", 210));
        myPlaylist.addTrack(new Song("Drinkee", "SOFI TUKKER", "SOFI TUKKER", 200));
        myPlaylist.addTrack(new Song("Let it Be", "The Beatles", "The Beatles Album", 250));
        myPlaylist.setCurrentTrack();

        System.out.println(myPlaylist.setCurrentTrack());

        Iterator<Song> it = myPlaylist.iterator();

        while (it.hasNext()) {
            Song song = it.next();
            listModel.addElement(song);
        }

    }

    void clearTrackFields(){
        addTitle.setText("");
        addArtist.setText("");
        addAlbum.setText("");
        addLength.setText("");
    }

    void setUpPlayer(){
        JFrame frame = new JFrame("Dana's jam space");

        displayPanel.setPreferredSize(new Dimension(300,200));

        displayPanel.add(textArea, BorderLayout.NORTH);
        displayPanel.add(trackList,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        displayPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(next, BorderLayout.SOUTH);
        buttonPanel.add(shuffle);


        next.setBounds(20,30,20, 40);

        frame.add(displayPanel, BorderLayout.CENTER);

        JPanel addTrack = new JPanel(new GridLayout(5, 2, 5, 5));
        addTrack.add(titleLabel);
        addTrack.add(addTitle);
        addTrack.add(artistLabel);
        addTrack.add(addArtist);
        addTrack.add(albumLabel);
        addTrack.add(addAlbum);
        addTrack.add(lengthLabel);
        addTrack.add(addLength);
        addTrack.add(add);


        frame.add(addTrack, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    public static void main (String[] args){
        MusicPlayer test = new MusicPlayer();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                test.setUpPlayer();
            }
        });

    }

}
