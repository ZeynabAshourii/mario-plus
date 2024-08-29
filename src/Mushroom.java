package src;

import java.awt.*;
import java.util.Random;

public class Mushroom extends Entity{
    private Random random = new Random();
    public Mushroom(int x, int y, int width, int height, Id id, Handler handler, User user) {
        super(x, y, width, height, id, handler , user);
        switch (random.nextInt(2)){
            case 0 :
                setVelX(3);
                break;
            case 1 :
                setVelX(-3);
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        try {
            g.drawImage(Game.mushroomPic.getSheet(), x, y, width, height, null);
        }
        catch (Exception e){}
    }

    @Override
    public void update() {
        x += velX;
        y += velY;

        for(Tile tile : handler.tiles){

            if(tile.isSolid()) {



                    if (getBoundsBottom().intersects(tile.getBounds()) && tile.getId() != Id.coin) {
                        setVelY(0);
                        if (falling) {
                            falling = false;
                        }
                        //y = tile.getY() - tile.height;
                    } else {
                        if (!falling) {
                            gravity = 0.8;
                            falling = true;
                        }
                    }
                    if (getBoundsRight().intersects(tile.getBounds()) && tile.getId() != Id.coin) {
                        setVelX(-3);
                        //x = tile.getX() - tile.width;
                    }
                    if (getBoundsLeft().intersects(tile.getBounds()) && tile.getId() != Id.coin) {
                        setVelX(3);
                        //x = tile.getX() + tile.width;
                    }
            }

        }

        if(falling){
            gravity += 0.1;
            setVelY((int)gravity);
        }
    }
}
