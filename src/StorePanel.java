package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class StorePanel extends JPanel implements Runnable , ActionListener {
    public User user;
    private JFrame frame;
    private JButton mario1Button;
    private JButton mario2Button;
    private JButton mario3Button;
    private JButton mario4Button;
    private JButton back;

    public StorePanel(User user){
        this.user = user;
        this.setSize(1080, 771);

        this.setFocusable(true);
        this.setLayout(null);
        this.requestFocus();
        this.requestFocusInWindow();

        frame = new JFrame();
        frame.setSize(1080 , 771);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);


        frame.add(this , BorderLayout.CENTER);

        if(!user.mario1){
            mario1Button = new JButton("Buy");
            mario1Button.setBounds(280 , 500 , 80 , 40);
            this.add(mario1Button);
            mario1Button.addActionListener(this);
        }
        if(!user.mario2){
            mario2Button = new JButton("Buy");
            mario2Button.setBounds(480 , 500 , 80 , 40);
            this.add(mario2Button);
            mario2Button.addActionListener(this);
        }
        if(!user.mario3){
            mario3Button = new JButton("Buy");
            mario3Button.setBounds(680 , 500 , 80 , 40);
            this.add(mario3Button);
            mario3Button.addActionListener(this);
        }
        if(!user.mario4){
            mario4Button = new JButton("Buy");
            mario4Button.setBounds(880 , 500 , 80 , 40);
            this.add(mario4Button);
            mario4Button.addActionListener(this);
        }

        back = new JButton("Back");
        back.setBounds(450 , 600 , 150 , 80);
        this.add(back);
        back.addActionListener(this);


        Thread thread = new Thread(this::run);
        thread.start();

        frame.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Courier", Font.BOLD, 25));



        g.setColor(Color.red);
        g.drawString("Normal" , 85 , 200);
        g.fillRect(49 , 320 , 150 , 150);
        g.setColor(Color.blue);
        g.drawString("Higher Jumping" , 235 , 200);
        g.fillRect(248 , 320 , 150 , 150);
        g.setColor(Color.gray);
        g.drawString("Faster Move" , 445 , 200);
        g.fillRect(447 , 320 , 150 , 150);
        g.setColor(Color.yellow);
        g.drawString("Attract Coins" , 645 , 200);
        g.fillRect(646 , 320 , 150 , 150);
        g.setColor(Color.orange);
        g.drawString("Faster Arrow" , 840 , 200);
        g.fillRect(845 , 320 , 150 , 150);

        g.setColor(Color.black);
        g.drawString("Coins : " + user.coin , 490 , 70 );

        g.drawString("0 coins" , 90 , 270);
        g.drawString("50 coins" , 278 , 270);
        g.drawString("50 coins" , 470 , 270);
        g.drawString("50 coins" , 670 , 270);
        g.drawString("50 coins" , 870 , 270);




        g.setColor(Color.green);
        if(user.mario0){
            g.drawString("SOLD" , 90 ,530 );
        }
        if(user.mario1){
            g.drawString("SOLD" , 290  , 530);
        }
        if(user.mario2){
            g.drawString("SOLD" , 490  , 530);
        }
        if(user.mario3){
            g.drawString("SOLD" , 687  , 530);
        }
        if(user.mario4){
            g.drawString("SOLD" , 890 , 530);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(mario1Button)){
            if(user.coin >= 50){
                user.coin -= 50;
                user.mario1 = true;
                this.remove(mario1Button);
            }
            else{
                JOptionPane.showMessageDialog(this, "money isn't enough");
            }

        } else if (e.getSource().equals(mario2Button)) {
            if(user.coin >= 50){
                user.coin -= 50;
                user.mario2 = true;
                this.remove(mario2Button);
            }
            else{
                JOptionPane.showMessageDialog(this, "money isn't enough");
            }

        } else if (e.getSource().equals(mario3Button)) {
            if(user.coin >= 50){
                user.coin -= 50;
                user.mario3 = true;
                this.remove(mario3Button);
            }
            else{
                JOptionPane.showMessageDialog(this, "money isn't enough");
            }
        } else if (e.getSource().equals(mario4Button)) {
            if(user.coin >= 50){
                user.coin -= 50;
                user.mario4 = true;
                this.remove(mario4Button);
            }
            else{
                JOptionPane.showMessageDialog(this, "money isn't enough");
            }
        } else if (e.getSource().equals(back)) {
            frame.dispose();
            Frame31 frame31 = new Frame31(user);
            frame31.setVisible(true);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        new StorePanel(new User("zeynab" , "1234"));
//    }

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
