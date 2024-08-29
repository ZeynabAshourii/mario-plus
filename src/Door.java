package src;

import java.awt.*;

public class Door extends Tile{
    public Door(int x, int y, int width, int height, boolean solid, Id id, Handler handler, User user) {
        super(x, y, width, height, solid, id, handler, user);
    }

    @Override
    public void paint(Graphics g) {
        if(handler.game.section == 0) {
            g.drawImage(Game.nextSection.getSheet(), getX(), getY(), width, height, null);
        }
        else if(handler.game.section == 1) {
            g.drawImage(Game.nextLevel.getSheet(), getX() , getY() , width , height , null);
        }
    }

    @Override
    public void update() {

    }
}
