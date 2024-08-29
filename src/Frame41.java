package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Frame41 extends JFrame implements ActionListener {
    private JButton game1;
    private JButton delete1;
    private JButton game2;
    private JButton delete2;
    private JButton game3;
    private JButton delete3;
    public User user;
    private JButton back;
    public Frame41(User user) {
        this.user = user;
        this.setSize(1080, 771);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        game1 = new JButton("Game 1");
        this.add(game1);
        game1.setBounds(400,200,300, 80);
        game1.setFocusable(false);
        game1.addActionListener(this);
        delete1 = new JButton("delete");
        this.add(delete1);
        delete1.setBounds(310,200,80, 80);
        delete1.setFocusable(false);
        delete1.addActionListener(this);
        game2 = new JButton("Game 2");
        this.add(game2);
        game2.setBounds(400 , 320 , 300 , 80);
        game2.setFocusable(false);
        game2.addActionListener(this);
        delete2 = new JButton("delete");
        this.add(delete2);
        delete2.setBounds(310,320,80, 80);
        delete2.setFocusable(false);
        delete2.addActionListener(this);
        game3 = new JButton("Game 3");
        this.add(game3);
        game3.setBounds(400 , 440 , 300 , 80);
        game3.setFocusable(false);
        game3.addActionListener(this);
        delete3 = new JButton("delete");
        this.add(delete3);
        delete3.setBounds(310,440,80, 80);
        delete3.setFocusable(false);
        delete3.addActionListener(this);
        back = new JButton("Back");
        this.add(back);
        back.setBounds(450 , 600 , 150 , 80);
        back.setFocusable(false);
        back.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(game1)){
            dispose();
            Frame51 frame51 = new Frame51(user , 1);
            frame51.setVisible(true);

        }
        else if(e.getSource().equals(delete1)){
            user.game1 = false;
            user.s1 = 0;
            user.l1 = 0;
        }
        else if(e.getSource().equals(game2)){
            dispose();
            Frame51 frame51 = new Frame51(user , 2);
            frame51.setVisible(true);
        }
        else if(e.getSource().equals(delete2)){
            user.game2 = false;
            user.s2 = 0;
            user.l2 = 0;
        }
        else if(e.getSource().equals(game3)){
            dispose();
            Frame51 frame51 = new Frame51(user , 3);
            frame51.setVisible(true);
        }
        else if(e.getSource().equals(delete3)){
            user.game3 = false;
            user.s3 = 0;
            user.l3 = 0;
        }
        else if (e.getSource().equals(back)) {
            dispose();
            Frame31 frame31 = new Frame31(user);
            frame31.setVisible(true);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        new Frame41(new User("zeynab" , "1236"));
//    }
}
