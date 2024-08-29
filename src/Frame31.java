package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Frame31 extends JFrame implements ActionListener {
    private JButton startNewGame;
    private JButton continuationPreviousGame;
    private JButton highestResults;
    private JButton store;
    private JButton profile;
    private JButton back;
    public User user;
    public Frame31(User user){
        this.user = user;

        this.setSize(1080 , 771);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        startNewGame = new JButton("Start New game");
        this.add(startNewGame);
        startNewGame.setBounds(400,80-60,240, 80);
        startNewGame.setFocusable(false);
        startNewGame.addActionListener(this);

        continuationPreviousGame = new JButton("Continuation of the Previous Game");
        this.add(continuationPreviousGame);
        continuationPreviousGame.setBounds(400,200-60,240, 80);
        continuationPreviousGame.setFocusable(false);
        continuationPreviousGame.addActionListener(this);

        highestResults = new JButton("Highest Results");
        this.add(highestResults);
        highestResults.setBounds(400 , 320-60 , 240 , 80);
        highestResults.setFocusable(false);
        highestResults.addActionListener(this);

        store = new JButton("Store");
        this.add(store);
        store.setBounds(400 , 440-60 , 240 , 80);
        store.setFocusable(false);
        store.addActionListener(this);

        profile = new JButton("Profile");
        this.add(profile);
        profile.setBounds(400 , 560-60 , 240 , 80);
        profile.setFocusable(false);
        profile.addActionListener(this);

        back = new JButton("Back");
        this.add(back);
        back.setBounds(400 , 560 + 60 , 240 , 80);
        back.setFocusable(false);
        back.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(startNewGame)){
            dispose();
            Frame41 frame41 = new Frame41(user);
            frame41.setVisible(true);
//            Game game = new Game(user);
//            JFrame frame = new JFrame();
//            frame.setSize(1500 , 1000);
//            frame.setContentPane(game);
//            frame.setContentPane(game);
//            frame.setVisible(true);
//            game.start();
        }
        else if(e.getSource().equals(continuationPreviousGame)){
            dispose();
            Frame42 frame42 = new Frame42(user);
            frame42.setVisible(true);

        }
        else if(e.getSource().equals(highestResults)){
            dispose();
            HighestResults highestResults1 = new HighestResults(user);
            highestResults1.setVisible(true);
        }
        else if(e.getSource().equals(store)){
            dispose();
            StorePanel store1 = new StorePanel(user);
            store1.setVisible(true);
        }
        else if (e.getSource().equals(profile)) {
            dispose();
            ProfilePanel profile1 = new ProfilePanel(user);
            profile1.setVisible(true);
        } else if (e.getSource().equals(back)) {
            dispose();
            Frame1 frame1 = null;
            try {
                frame1 = new Frame1();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame1.setVisible(true);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        new Frame31(new User("ze" , "12"));
//    }

}
