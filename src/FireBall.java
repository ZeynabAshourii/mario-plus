package src;

import java.awt.*;

public class FireBall extends Entity {
    public FireBall(int x, int y, int width, int height, Id id, Handler handler, User user , int facing) {
        super(x, y, width, height, id, handler, user);
        switch (facing){
            case 0 :
                if(user.typeMario == 4){
                    setVelX(-10);
                }
                else {
                    setVelX(-4);
                }
                break;
            case 1:
                if(user.typeMario == 4) {
                    setVelX(10);
                }
                else {
                    setVelX(4);
                }
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Game.fireBall.getSheet() , getX() , getY() , width , height , null);
    }

    @Override
    public void update() {
        x += velX;
        y += velY;

        for (int i = 0; i <handler.tiles.size(); i++){
            Tile tile = handler.tiles.get(i);
            if(tile.isSolid()){
                if(getBoundsLeft().intersects(tile.getBounds()) || getBoundsRight().intersects(tile.getBounds())) die();

                if(getBoundsBottom().intersects(tile.getBounds())){
                    jumping = true;
                    falling  = false;
                    gravity = 4.0;
                } else if (!falling && !jumping) {
                    falling = true;
                    gravity = 1.0;
                }
            }
        }
        for(int i = 0 ; i < handler.entities.size(); i++){
            Entity entity = handler.entities.get(i);
            if(getBounds().intersects(entity.getBounds())) {

                if (entity.getId() == Id.goomba || entity.getId() == Id.plant) {
                    die();
                    entity.die();
                    handler.game.coin[handler.game.section][handler.game.level] += 2;
                    handler.game.score[handler.game.section][handler.game.level] += 20*handler.game.coefficientScore;
                    handler.game.score[handler.game.section][handler.game.level] += 15*handler.game.coefficientScore;
                }
            }
        }
        if(jumping){
            gravity -= 0.17;
            setVelY((int)-gravity);
            if(gravity <= 0.5){
                jumping = false;
                falling = true;
            }
        }
        if(falling){
            gravity += 0.17;
            setVelY((int)gravity);
        }
    }
}
