package src;

import java.awt.*;
import java.io.Serializable;

public class Plant extends Entity {
    private int pixelsTravelled = 0;
    private int wait;
    private boolean moving;
    private boolean insidePipe;

    public Plant(int x, int y, int width, int height, Id id, Handler handler, User user) {
        super(x, y, width, height, id, handler, user);
        moving = false;
        insidePipe = true;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(getX() , getY() , width , height);
    }

    @Override
    public void update() {
        y += velY;
        if(!moving) wait++;
        if(wait >= 180){
            insidePipe = !insidePipe;
            moving = true;
            wait = 0;
        }
        if(moving){
            if(insidePipe) setVelY(-3);
            else setVelY(3);

            pixelsTravelled += velY;

            if(pixelsTravelled >= height || pixelsTravelled <= -height){
                pixelsTravelled = 0;
                moving = false;
                setVelY(0);
            }
        }
    }
}
