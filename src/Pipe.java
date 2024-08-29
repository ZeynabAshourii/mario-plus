package src;

import java.awt.*;
import java.io.Serializable;

public class Pipe extends Tile {

    public Pipe(int x, int y, int width, int height, boolean solid, Id id, Handler handler , int facing , User user , boolean plant) {
        super(x, y, width, height, solid, id, handler , user);
        this.facing = facing;

        if(plant) handler.addEntity(new Plant(getX() , getY()-64 , width , 64 , Id.plant , handler , user));
    }

    @Override
    public void paint(Graphics g) {
     g.setColor(new Color(128 , 128 , 128));
     g.fillRect(x , y , width , height);
    }

    @Override
    public void update() {

    }
}
