package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Frame42 extends JFrame implements ActionListener {
    private JButton game1;
    private JButton game2;
    private JButton game3;
    private JButton back;
    public User user;
    public Frame42(User user){
       this.user = user;

        this.setSize(1080 , 771);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        game1 = new JButton("Game 1");
        this.add(game1);
        game1.setBounds(450,200-30,160, 80);
        game1.setFocusable(false);
        game1.addActionListener(this);
        game2 = new JButton("Game 2");
        this.add(game2);
        game2.setBounds(450 , 320-30 , 160 , 80);
        game2.setFocusable(false);
        game2.addActionListener(this);
        game3 = new JButton("Game 3");
        this.add(game3);
        game3.setBounds(450 , 440-30 , 160 , 80);
        game3.setFocusable(false);
        game3.addActionListener(this);
        back = new JButton("Back");
        this.add(back);
        back.setBounds(450 , 600 , 160 , 80);
        back.setFocusable(false);
        back.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(game1)){
            if(!user.game1){
                JOptionPane.showMessageDialog(this, "this game isn't exist");
            }
            else {
                dispose();
                Game game = new Game(user , 1);
                game.section = user.s1;
                game.level = user.l1;
            }

        }
        else if(e.getSource().equals(game2)){

            if(!user.game2){
                JOptionPane.showMessageDialog(this, "this game isn't exist");
            }
            else {
                dispose();
                Game game = new Game(user , 2);
                game.section = user.s2;
                game.level = user.l2;
            }
        }
        else if(e.getSource().equals(game3)){
            if(!user.game3){
                JOptionPane.showMessageDialog(this, "this game isn't exist");
            }
            else {
                dispose();
                Game game = new Game(user , 3);
                game.section = user.s3;
                game.level = user.l3;
            }
        } else if (e.getSource().equals(back)) {
            dispose();
            Frame31 frame31 = new Frame31(user);
            frame31.setVisible(true);
        }
    }
//    public static void main(String[] args) throws FileNotFoundException {
//        Frame42 frame42 = new Frame42(new User("zeynab" , "1234"));
//    }
}
