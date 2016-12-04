//import javax.swing.*;
//import java.awt.*;
//import javax.swing.JFrame;
//import java.awt.*;
//import java.util.ArrayList;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.JList;
//import javax.swing.DefaultListModel;
//import javax.swing.SpringLayout;
//import java.util.Iterator;
//import java.util.ListIterator;
///**
// * Created by danayu on 11/7/16.
// */
//public class ShowList extends JFrame {
//    MusicPlaylist myPlaylist;
//    JFrame frame = new JFrame("Dana's jam space");
//    JPanel displayPanel = new JPanel(new BorderLayout());
//    DefaultListModel<Song> listModel = new DefaultListModel<Song>();
//    JList<Song> trackList = new JList<Song>(listModel);
//
//    public ShowList() {
//        this.myPlaylist= new MusicPlaylist();
//        displayPanel.setPreferredSize(new Dimension(300,200));
//        frame.add(displayPanel, BorderLayout.CENTER);
//        displayPanel.add(trackList);
//
//        listModel.addElement(new Song("Title", "Artist", "Album", 200));
//        listModel.addElement(new Song("Title2", "Artist2", "Album2", 200));
//
//        Iterator<Song> it = myPlaylist.iterator();
//
//        while (it.hasNext()) {
//            Song song = it.next();
//            //System.out.println(song);
//            listModel.addElement(song);
//        }
//
//    }
//
//
//    void setUpList(){
//
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        ShowList test = new ShowList();
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                test.setUpList();
//            }
//        });
//
//    }
//}
