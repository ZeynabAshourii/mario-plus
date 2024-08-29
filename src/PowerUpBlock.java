package src;

import java.awt.*;
import java.io.Serializable;

public class PowerUpBlock extends Tile {
    private boolean poppedUp1 = false;
    private int spriteY1 = getY();
    private boolean poppedUp2 = false;
    private int spriteY2 = getY();
    public PowerUpBlock(int x, int y, int width, int height, boolean solid, Id id, Handler handler , User user) {
        super(x, y, width, height, solid, id, handler , user);
    }

    @Override
    public void paint(Graphics g) {
        try {
//            g.setColor(Color.red);
//            g.drawString(String.valueOf(numberOfCollision), x , y-10 );

            if (!poppedUp1) {
                g.drawImage(Game.mushroomPic.getSheet(), x, spriteY1, width, height, null);
            } else if (!poppedUp2) {
                g.drawImage(Game.circleFire.getSheet(), x, spriteY2, width, height, null);
            }
            if (!actiavted1) {
                g.drawImage(Game.powerUp.getSheet(), x, y, width, height, null);
            } else if(actiavted1 && !actiavted2) {
                g.drawImage(Game.used1PowerUp.getSheet(), x, y, width, height, null);
            } else if (actiavted1 && actiavted2) {
                g.drawImage(Game.wallPic.getSheet(), x, y, width, height, null);
            }

        }
        catch (Exception e){

        }
    }

    @Override
    public void update() {
        if(actiavted1 && !poppedUp1){
            spriteY1--;
            if(spriteY1  <= y-height){
                handler.game.coefficientScore = 2;
                handler.addEntity(new Mushroom( x , spriteY1 , width , height , Id.mushroom , handler , user));
                poppedUp1 = true;
            }
        }
        else if(actiavted2 && !poppedUp2){
            spriteY2--;
            if(spriteY2  <= y-height){
                handler.game.coefficientScore = 3;
                handler.addEntity(new CircleFire( x , spriteY2 , width , height , Id.circleFire, handler , user));
                poppedUp2 = true;
            }
        }


    }
}
