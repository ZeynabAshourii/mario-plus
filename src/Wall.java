package src;

import java.awt.*;
import java.io.Serializable;

public class Wall extends Tile {
    public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler , User user) {
        super(x, y, width, height, solid, id, handler , user);
    }

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect(x , y , width , height);
        try {
            g.drawImage(Game.wallPic.getSheet(), x, y, width, height, null);
        }
        catch (Exception e){
        }
    }

    @Override
    public void update() {

    }
}
