package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class SignIn extends JFrame implements ActionListener {
    private TextField textField1;
    private JButton button1;
    private boolean save1 = false;
    private TextField textField2;
    private JButton button2;
    private boolean save2 = false;
    private JButton start;
    private JButton back;
    public String username;
    public String password;
    public SignIn(){
        this.setSize(1080 , 771);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Sign in");

        textField1 = new TextField("username");
        this.add(textField1);
        textField1.setBounds(370,100,500,60);
        button1 = new JButton("save");
        this.add(button1);
        button1.setBounds(200,100,100,60);
        button1.addActionListener(this);

        textField2 = new TextField("password");
        this.add(textField2);
        textField2.setBounds(370,200,500,60);
        button2 = new JButton("save");
        this.add(button2);
        button2.setBounds(200,200,100,60);
        button2.addActionListener(this);

        back = new JButton("Back");
        this.add(back);
        back.setBounds(460 , 480 , 160 , 80);
        back.addActionListener(this);

        start = new JButton(" Start !");
        this.add(start);
        start.setBounds(460 , 590 , 160 , 80);
        start.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button1)){
            username = textField1.getText();
            save1 = true;
        }
        else if(e.getSource().equals(button2)){
            password = textField2.getText();
            save2 = true;
        }
        else if(e.getSource().equals(start)){
            if(!save1){
                JOptionPane.showMessageDialog(this, "click on save for username");
            }
            else if(!save2){
                JOptionPane.showMessageDialog(this, "click on save for password");
            }
            else {
                boolean find = false;
                for(int i = 0; i < User.users.size(); i++){
                    if(User.users.get(i).username.equals(username) && User.users.get(i).password.equals(password)){
                        find = true;
                        dispose();
                        Frame31 frame31 = new Frame31(User.users.get(i));
                        frame31.setVisible(true);
                        break;
                    }
                }
                if(!find){
                    JOptionPane.showMessageDialog(this, "username or password is wrong");
                }

            }
        }
        else if(e.getSource().equals(back)){
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

}

