package src;

import java.awt.*;

public class CircleFire extends Entity{
    public CircleFire(int x, int y, int width, int height, Id id, Handler handler, User user) {
        super(x, y, width, height, id, handler, user);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Game.circleFire.getSheet() , getX() , getY() , width , height , null);
    }

    @Override
    public void update() {

    }
}
