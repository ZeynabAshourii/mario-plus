package src;

import java.awt.*;

public abstract class Entity {
    public int x;
    public int y;
    public int width;
    public int height;
    public int facing ;
    public boolean goingDownPipe = false;

    public boolean jumping = false;
    public boolean falling = true;
    public int velX;
    public int velY;

    public Id id;
    public double gravity = 0.0;
    public Handler handler;
    public User user;


    public Entity(int x , int y, int width , int height, Id id , Handler handler , User user){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.handler = handler;
        this.user = user;
    }


    public abstract void paint(Graphics g);

    public abstract void update() throws InterruptedException;
    public void die(){
        handler.removeEntity(this);
        if(this.getId() == Id.player){
            handler.game.lives--;
            handler.game.showDeathScreen = true;
            Player.fire = false;
            handler.game.score[handler.game.section][handler.game.level] = 0;
            handler.game.coin[handler.game.section][handler.game.level] = 0;
            handler.game.coefficientScore = 1;
            if(handler.game.lives <= 0){
                handler.game.gameOver = true;
                handler.game.finishedGame = true;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Id getId(){
        return id;
    }





    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    public Rectangle getBounds(){
        return  new Rectangle(getX() , getY() , width , height);
    }
//    public Rectangle getBoundsTop(){
//        return new Rectangle(getX()+10 , getY() ,  width-20 , 5 );
//    }
//    public Rectangle getBoundsBottom(){
//        return new Rectangle(getX()+10 , getY()+height-5 , width-20 , 5);
//    }
//    public Rectangle getBoundsLeft(){
//        return new Rectangle(getX() , getY()+10 , 5 , height-20);
//    }
//    public Rectangle getBoundsRight(){
//        return new Rectangle(getX()+width-5 , getY()+10 , 5 , height-20);
//    }
    public Rectangle getBoundsTop(){
        return new Rectangle(getX()+10 , getY() ,  width-20 , 5 );
    }
    public Rectangle getBoundsBottom(){
        return new Rectangle(getX()+10 , getY()+height-5 , width-20 , 5);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle(getX() , getY()+10 , 5 , height-20);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle(getX()+width-5 , getY()+10 , 5 , height-20);
    }
}
