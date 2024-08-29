package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Frame1 extends JFrame implements ActionListener {
    private JButton signUp;
    private JButton signIn;
    private JButton exit;
    public Frame1() throws IOException {

        if(User.users.isEmpty()){
            User.readUser();
        }


        this.setSize(1080 , 771);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        signUp = new JButton("Sign up");
        this.add(signUp);
        signUp.setBounds(460,200,160, 80);
        signUp.setFocusable(false);
        signUp.addActionListener(this);
        signIn = new JButton("Sign in");
        this.add(signIn);
        signIn.setBounds(460 , 320 , 160 , 80);
        signIn.setFocusable(false);
        signIn.addActionListener(this);
        exit = new JButton("Exit");
        this.add(exit);
        exit.setBounds(460 , 440 , 160 , 80);
        exit.setFocusable(false);
        exit.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(signUp)){
            dispose();
            SignUp signUp1 = new SignUp();
            signUp1.setVisible(true);

        }
        else if(e.getSource().equals(signIn)){
            dispose();
            SignIn signIn1 = new SignIn();
            signIn1.setVisible(true);

        }
        else if(e.getSource().equals(exit)){

            try {
                User.resetUser();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            setVisible(false);
        }
    }
    public static void main(String[] args) throws IOException {
        Frame1 frame1 = new Frame1();
    }

}

