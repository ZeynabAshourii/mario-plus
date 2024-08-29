package src;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class ProfilePanel extends JPanel implements Runnable , ActionListener {
        public User user;
        private ButtonGroup buttonGroup;
        private JRadioButton mario0b;
        private JRadioButton mario1b;
        private JRadioButton mario2b;
        private JRadioButton mario3b;
        private JRadioButton mario4b;

        private JButton back;
        private JFrame frame;

        public ProfilePanel(User user) {

            this.user = user;

            this.setSize(1080, 771);

            this.setFocusable(true);

            this.requestFocus();
            this.requestFocusInWindow();

            frame = new JFrame();
            frame.setSize(1080 , 771);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);


            frame.add(this , BorderLayout.CENTER);




            buttonGroup = new ButtonGroup();


            if(user.mario0){
                mario0b = new JRadioButton("Normal                                ");
                //mario1b.setBounds(50 , 170 , 150 , 100);
                buttonGroup.add(mario0b);
                mario0b.setFocusable(false);
                mario0b.addActionListener(this);
                this.add(mario0b);
            }
            if(user.mario1){
                mario1b = new JRadioButton("Higher Jumping                                ");
                //mario1b.setBounds(50 , 170 , 150 , 100);
                buttonGroup.add(mario1b);
                mario1b.setFocusable(false);
                mario1b.addActionListener(this);
                this.add(mario1b);
            }
            if(user.mario2){
                mario2b = new JRadioButton("Faster Move                                ");
                //mario1b.setBounds(210 , 170 , 150 , 100);
                buttonGroup.add(mario2b);
                mario2b.setFocusable(false);
                mario2b.addActionListener(this);
                this.add(mario2b);
            }
            if(user.mario3){
                mario3b = new JRadioButton("Attract Coins                                ");
                buttonGroup.add(mario3b);
                //mario1b.setBounds(370 , 170 , 150 , 100);
                mario3b.setFocusable(false);
                mario3b.addActionListener(this);
                this.add(mario3b);
            }
            if(user.mario4){
                mario4b = new JRadioButton("Faster Arrow                ");
                //mario1b.setBounds(530 , 470 , 150 , 100);
                buttonGroup.add(mario4b);
                mario4b.setFocusable(false);
                mario4b.addActionListener(this);
                this.add(mario4b);
            }

            back = new JButton("Back");
            frame.add(back , BorderLayout.AFTER_LAST_LINE);
            back.addActionListener(this);


            Thread thread = new Thread(this::run);
            thread.start();

            frame.setVisible(true);


        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.black);
            g.setFont(new Font("Courier", Font.BOLD, 25));
            g.drawString("Username : " + user.username,  400 , 600);

            g.drawString("Highest Score : " + user.highestScore(), 400 , 650);

            if(user.mario0){
                g.setColor(Color.red);
                g.fillRect(mario0b.getX() , mario0b.getY()+100 , 60 , 60);
            }
            if(user.mario1){
                g.setColor(Color.blue);
                g.fillRect(mario1b.getX() , mario1b.getY()+100 , 60 , 60);
            }
            if(user.mario2){
                g.setColor(Color.gray);
                g.fillRect(mario2b.getX() , mario2b.getY()+100 , 60 , 60);
            }
            if(user.mario3){
                g.setColor(Color.yellow);
                g.fillRect(mario3b.getX() , mario3b.getY()+100 , 60 , 60);
            }
            if(user.mario4){
                g.setColor(Color.orange);
                g.fillRect(mario4b.getX() , mario4b.getY()+100 , 60 , 60);
            }

            if(user.typeMario == 0){
                g.setColor(Color.red);

            } else if (user.typeMario == 1) {
                g.setColor(Color.blue);
            } else if (user.typeMario == 2) {
                g.setColor(Color.gray);
            } else if (user.typeMario == 3) {
                g.setColor(Color.yellow);
            } else if (user.typeMario == 4) {
                g.setColor(Color.orange);
            }
            g.fillRect(400 , 360 , 150 , 150);
            g.drawString("Your Mario : " , 200 , 460);

        }

//        public static void main(String[] args) throws FileNotFoundException {
//            new ProfilePanel(new User("zeynab" , "12345"));
//        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(mario0b)){
                user.typeMario = 0;
            }
            else if(e.getSource().equals(mario1b)){
                user.typeMario = 1;
            }
            else if(e.getSource().equals(mario2b)){
                user.typeMario = 2;
            }
            else if(e.getSource().equals(mario3b)){
                user.typeMario = 3;
            }
            else if(e.getSource().equals(mario4b)){
                user.typeMario = 4;
            } else if (e.getSource().equals(back)) {
                frame.dispose();
                Frame31 frame31 = new Frame31(user);
                frame31.setVisible(true);
            }
        }

    @Override
    public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                    repaint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}
