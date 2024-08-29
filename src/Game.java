package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Game extends JPanel implements Runnable , ActionListener , Serializable {
    public static final int WIDTH = 270;
    public static final int HEIGHT = WIDTH/14*10;
    public static final int SCALE = 4;
    private Thread thread;
    private boolean running = false;
    //private BufferedImage image;
    public Handler handler;
    public static SpriteSheet wallPic;
    public static SpriteSheet marioPic[] = new SpriteSheet[10];
    public static  SpriteSheet mushroomPic;
    public static SpriteSheet goombaPic[] = new SpriteSheet[6];
    public static SpriteSheet powerUp;
    public static SpriteSheet used1PowerUp;
    public static SpriteSheet used2PowerUp;
    public static SpriteSheet coinPic;

    public static SpriteSheet nextSection;
    public static SpriteSheet nextLevel;
    public static SpriteSheet circleFire;
    public static SpriteSheet fireBall;
    public Camera camera;
    public int section = 0;
    public int level = 0;
    public int lives = 3;
    public int deathScreenTime = 0;
    public boolean showDeathScreen = false;
    public boolean finishedGame = false;
    public boolean gameOver = false;
    public User user;
    private JButton back;
    private JFrame frame;
    public int coefficientScore = 1;
    public int[][] score = new int[2][2];
    public int allScores = 0;

    public int[][] coin = new int[2][2];
    public int allCoins = 0;
    public int timeLimit = 60;
    public long endTime;
    public long timeElapsed;
    public int whichGame;

    public Game(User user , int whichGame){
        this.user = user;
        this.whichGame = whichGame;
        Player.fire = false;
        score[section][level] = 0;
        coin[section][level] = 0;
        coefficientScore = 1;
//        this.setSize(WIDTH*SCALE , HEIGHT*SCALE);
        frame = new JFrame();
        frame.setSize(1080+40 , 771);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        //frame.addKeyListener(this);

        this.setSize(1080, 771);
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();
        frame.add(this);
//            Main main = new Main();
//            frame.add(main);


        //frame.addKeyListener(this);
        //this.addKeyListener(this);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        //this.setResizable(false);

        back = new JButton("back");
        frame.add(back);
        back.setBounds(1080,0,40,80);
        back.addActionListener(this);

        frame.setVisible(true);
        this.start();




    }
    private void init(){
//        try {
//            image = ImageIO.read(getClass().getResource("/images/level1.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        handler = new Handler(image);
        handler = new Handler(user , this);

        camera = new Camera();

        wallPic = new SpriteSheet("Bricks.gif");

        mushroomPic = new SpriteSheet("mushroom1.jpg");

        if(user.typeMario == 0) {
            marioPic[0] = new SpriteSheet("Mario_Standing.gif");
            //marioPic[0] = new SpriteSheet("img_1.png");
            marioPic[1] = new SpriteSheet("Mario_Walk_1.gif");
            marioPic[2] = new SpriteSheet("Mario_Walk_2.gif");
            marioPic[3] = new SpriteSheet("Mario_Walk_3.gif");
            marioPic[4] = new SpriteSheet("Mario_Standing.gif");
            marioPic[5] = new SpriteSheet("Mario_StandingL.gif");
            marioPic[6] = new SpriteSheet("Mario_Walk_3L.gif");
            marioPic[7] = new SpriteSheet("Mario_Walk_2L.gif");
            marioPic[8] = new SpriteSheet("Mario_Walk_1L.gif");
            marioPic[9] = new SpriteSheet("Mario_StandingL.gif");
        } else if (user.typeMario == 1) {
            marioPic[0] = new SpriteSheet("img.png");
            marioPic[1] = new SpriteSheet("img_1.png");
            marioPic[2] = new SpriteSheet("img_2.png");
            marioPic[3] = new SpriteSheet("img_3.png");
            marioPic[4] = new SpriteSheet("img.png");
            marioPic[5] = new SpriteSheet("imgL.png");
            marioPic[6] = new SpriteSheet("img_3L.png");
            marioPic[7] = new SpriteSheet("img_2L.png");
            marioPic[8] = new SpriteSheet("img_1L.png");
            marioPic[9] = new SpriteSheet("imgL.png");
        } else if (user.typeMario == 2) {
            marioPic[0] = new SpriteSheet("img_7.png");
            marioPic[1] = new SpriteSheet("img_4.png");
            marioPic[2] = new SpriteSheet("img_5.png");
            marioPic[3] = new SpriteSheet("img_6.png");
            marioPic[4] = new SpriteSheet("img_7.png");
            marioPic[5] = new SpriteSheet("img_7L.png");
            marioPic[6] = new SpriteSheet("img_6L.png");
            marioPic[7] = new SpriteSheet("img_5L.png");
            marioPic[8] = new SpriteSheet("img_4L.png");
            marioPic[9] = new SpriteSheet("img_7L.png");
        } else if (user.typeMario == 3) {
            marioPic[0] = new SpriteSheet("img_11.png");
            marioPic[1] = new SpriteSheet("img_8.png");
            marioPic[2] = new SpriteSheet("img_9.png");
            marioPic[3] = new SpriteSheet("img_10.png");
            marioPic[4] = new SpriteSheet("img_11.png");
            marioPic[5] = new SpriteSheet("img_11L.png");
            marioPic[6] = new SpriteSheet("img_10L.png");
            marioPic[7] = new SpriteSheet("img_9L.png");
            marioPic[8] = new SpriteSheet("img_8L.png");
            marioPic[9] = new SpriteSheet("img_11L.png");
        } else if (user.typeMario == 4) {
            marioPic[0] = new SpriteSheet("img_15.png");
            marioPic[1] = new SpriteSheet("img_12.png");
            marioPic[2] = new SpriteSheet("img_13.png");
            marioPic[3] = new SpriteSheet("img_14.png");
            marioPic[4] = new SpriteSheet("img_15.png");
            marioPic[5] = new SpriteSheet("img_15L.png");
            marioPic[6] = new SpriteSheet("img_14L.png");
            marioPic[7] = new SpriteSheet("img_13L.png");
            marioPic[8] = new SpriteSheet("img_12L.png");
            marioPic[9] = new SpriteSheet("img_15L.png");
        }


        goombaPic[0] = new SpriteSheet("Green_Koopa_TroopaR.gif");
        goombaPic[1] = new SpriteSheet("Green_Koopa_Troopa2R.gif");
        goombaPic[2] = new SpriteSheet("Green_Koopa_TroopaR.gif");
        goombaPic[3] = new SpriteSheet("Green_Koopa_Troopa.gif");
        goombaPic[4] = new SpriteSheet("Green_Koopa_Troopa2.gif");
        goombaPic[5] = new SpriteSheet("Green_Koopa_Troopa.gif");

        nextSection = new SpriteSheet("door1.jpg");
        nextLevel = new SpriteSheet("Castle.gif");

        powerUp = new SpriteSheet("Question_Block.gif");
        used1PowerUp = new SpriteSheet("Ground.gif");
        //used2PowerUp = new SpriteSheet("brick().jgp");
        coinPic = new SpriteSheet("Coin.gif");
        circleFire = new SpriteSheet("star5.PNG");
        fireBall = new SpriteSheet("p_fireball1.png");


        addKeyListener(new KeyInput(user , handler));

        //handler.createlevel(image);

        //handler.addEntity(new Player(300 , 512 ,64 , 64 , true , Id.player , handler ));
        //handler.addTile(new Wall( 200 , 200 , 64 , 64 , true , Id.wall , handler));
    }
    public synchronized void start(){
       if(running){
           return;
       }
       running = true;
       thread = new Thread(this , "Thread");
       thread.start();

    }
    private synchronized void stop(){

        if(!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        init();
        this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();


        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0.0;
        double ns = 1000000000.0/60.0;
        int frames = 0;
        int updates = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            while (delta >= 1){
                try {
                    update();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                updates++;
                delta--;
            }
            repaint();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            g.setFont(new Font("Courier", Font.BOLD, 20));
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            if(!showDeathScreen && !gameOver && !finishedGame){
                g.setColor(Color.white);
                endTime = System.nanoTime()/1000000000L;
                timeElapsed = endTime - handler.startTime;
                if(timeElapsed > timeLimit){
                    for(int i = 0; i < handler.entities.size(); i++){
                        Entity entity = handler.entities.get(i);
                        if(entity.getId() == Id.player){
                            //g.drawString("Time Limit" , 300 , 300 );
                            entity.die();
                        }
                    }
                }
                g.drawString( " Time : " + String.valueOf(timeElapsed), 150 , 20 );
                g.drawImage(Game.coinPic.getSheet(), 50, 20, 75, 75, null);
                g.setColor(Color.yellow);
                g.drawString("x" + coin[section][level], 100, 95);
                g.setColor(Color.red);
                g.drawString("Score : " + score[section][level] , 150 , 40);
            }

            if(showDeathScreen){
                if(!gameOver) {
                    g.drawImage(Game.marioPic[0].getSheet(), 500, 300, 100, 100, null);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Courier", Font.BOLD, 50));
                    g.drawString("x" + lives, 610, 370);
                }
                else{
                    g.drawImage(Game.marioPic[0].getSheet(), 500, 300, 100, 100, null);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Courier", Font.BOLD, 50));
                    g.drawString("Game Over", 610, 370);
                }
            }
            if(finishedGame && !gameOver){
                g.setColor(Color.green);
                g.drawString("Game Finished", 610, 370);
            }

            g.translate(camera.getX(), camera.getY());
            //g.fillRect(-camera.getX(), -camera.getY(), 4 , 4);
            if(!showDeathScreen) handler.paint(g);
        }
        catch (Exception e){}
    }

    public void update() throws InterruptedException {
        handler.update();
        for(Entity entity : handler.entities){
            if(entity.getId() == Id.player){
                if(!entity.goingDownPipe) camera.update(entity);
            }
        }

        if(showDeathScreen && !gameOver){
            deathScreenTime++;
        }
        if(deathScreenTime >= 100){
            showDeathScreen = false;
            deathScreenTime = 0;
            handler.clearLevel();
            handler.createlevel();
        }
        if(finishedGame){
            user.scores.add(allScores);
        }
    }
    public static int getFrameWidth(){
        return WIDTH*SCALE;
    }
    public static int getFrameHeight(){
        return HEIGHT*SCALE;
    }
    public void switchLevel() {
        score[section][level] += 20*coefficientScore*lives;
        score[section][level] += coefficientScore*(timeLimit - timeElapsed);
        allScores += score[section][level];
        allCoins += coin[section][level];
        section++;
        if(section == 2){
            section = 0;
            level++;
        }
        if(level == 2){
            finishedGame = true;
        }
        handler.clearLevel();
        handler.createlevel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(back)){
            user.coin += allCoins;
//            JComponent component = (JComponent) e.getSource();
//            Window window = SwingUtilities.getWindowAncestor(component);
//            window.dispose();
            handler.clearLevel();
            if(whichGame == 1){
                if(finishedGame){
                    user.game1 = false;
                    user.s1 = 0;
                    user.l1 = 0;
                }
                else {
                    user.s1 = section;
                    user.l1 = level;
                }
            }else if (whichGame == 2){
                if(finishedGame){
                    user.game2 = false;
                    user.s2 = 0;
                    user.l2 = 0;
                }
                else {
                    user.s2 = section;
                    user.l2 = level;
                }
            }else if(whichGame == 3){
                if(finishedGame){
                    user.game3 = false;
                    user.s3 = 0;
                    user.l3 = 0;
                }
                else {
                    user.s3 = section;
                    user.l3 = level;
                }
            }
            frame.dispose();
            Frame31 frame31 = new Frame31(user);
            frame31.setVisible(true);
        }

    }


//    public static void main(String[] args) throws FileNotFoundException {
//        User user1 = new User("zey" , "pas");
//        user1.typeMario = 0;
//        new Game(user1);
//    }
}