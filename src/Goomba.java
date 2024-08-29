package src;

import java.awt.*;
import java.util.Random;

public class Goomba extends Entity {
    private int frame = 0;
    private int frameDelay = 0;
    private Random random = new Random();

    public Goomba(int x, int y, int width, int height, Id id, Handler handler , User user) {
        super(x, y, width, height , id, handler , user);
        switch (random.nextInt(2)){
            case 0 :
                setVelX(-2);
                facing = 0;
                break;
            case 1 :
                setVelX(2);
                facing = 1;
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        try {

            if (facing == 0) {
                g.drawImage(Game.goombaPic[frame + 3].getSheet(), x, y, width, height, null);
            } else if (facing == 1) {
                g.drawImage(Game.goombaPic[frame].getSheet(), x, y, width, height, null);
            }
        }
        catch (Exception e){

        }
    }

    @Override
    public void update() {
        x += velX;
        y += velY;

        for(Tile tile : handler.tiles){
            if(tile.isSolid()){
                if(getBoundsBottom().intersects(tile.getBounds()) && tile.getId() != Id.coin) {
                    //System.out.println("1");
                    setVelY(0);
                    if (falling) {
                        falling = false;
                    }
                }else if (!falling) {
                        falling = true;
                        gravity = 0.8;
                }
                if(getBoundsLeft().intersects(tile.getBounds()) && tile.getId() != Id.coin){
                    //System.out.println("2");
                    setVelX(2);
                    facing = 1;
                }
                if(getBoundsRight().intersects(tile.getBounds()) && tile.getId() != Id.coin){
                    //System.out.println("3");
                    setVelX(-2);
                    facing = 0;
                }
            }
        }

        if(falling){
            gravity += 0.1;
            setVelY((int) gravity);
        }

        if(velX != 0){
            frameDelay++;
            if(frameDelay >= 2){
                frame++;
                if(frame >= 3){
                    frame = 0;
                }
                frameDelay = 0;
            }
        }
    }
}
