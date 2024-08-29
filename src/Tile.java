package src;

import java.awt.*;

public abstract class Tile {
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean solid = true;
    public boolean actiavted1 = false;
    public boolean actiavted2 = false;
    public int numberOfCollision = 1;
    public int waining = 0;
    public int velX;
    public int velY;
    public int facing;

    public Id id;
    public Handler handler;
    public User user;

    public Tile(int x , int y, int width , int height , boolean solid , Id id , Handler handler , User user){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.handler = handler;
        this.user = user;
    }


    public abstract void paint(Graphics g) ;

    public abstract void update();
    public void die(){
        handler.removeTile(this);
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

    public boolean isSolid() {
        return solid;
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
}
