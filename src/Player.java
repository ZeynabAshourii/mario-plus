package src;

import java.awt.*;
import java.io.Serializable;

public class Player extends Entity {
    private PlayerState state;
    private int pixelsTravelled = 0;

    private int frame = 0;
    private int frameDelay = 0;
    public static boolean fire = false;
    private double startTime = 0;
    public Player(int x, int y, int width, int height , Id id, Handler handler , User user) {
        super(x, y, width, height, id, handler , user);
        state = PlayerState.SMALL;
    }

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.blue);
//        g.fillRect(x , y , width , height);
        try {
            if (facing == 0) {
                g.drawImage(Game.marioPic[frame + 5].getSheet(), x, y, width, height, null);
            } else if (facing == 1) {
                g.drawImage(Game.marioPic[frame].getSheet(), x, y, width, height, null);
            }
        }
        catch (Exception e){
        }
    }

    @Override
    public void update() throws InterruptedException {
        x = x + velX;
        y = y + velY;

//        if(x <= 0){
//            x = 0;
//        }
//        if(y <= 0){
//            y = 0;
//        }
//        if(x + width >= 1080){
//            x = 1080 - width;
//        }
//        if(y + height >= 771){
//            y = 771 - height;
//        }

        if(getY() > handler.deathY + 64) die();

        for(int i = 0; i < handler.tiles.size(); i++){
            Tile tile = handler.tiles.get(i);

            if(tile.isSolid() && !goingDownPipe) {

                //if (tile.getId() == Id.wall) {

                    if (getBoundsTop().intersects(tile.getBounds()) && tile.getId() != Id.coin) {
                        setVelY(0);
                        if (jumping && !goingDownPipe) {
                            jumping = false;
                            gravity = 0.8;
                            falling = true;
                        }
                        if(tile.getId() == Id.powerUp){

                            if(getBoundsTop().intersects(tile.getBounds())){
                                if(tile.actiavted1){
                                    double endTime = (double) System.nanoTime()/1000000000L;
                                    double timeElapsed = endTime - startTime;
                                    if(timeElapsed > 0.2) {
                                        tile.numberOfCollision++;
                                        if(tile.numberOfCollision > 2){
                                            handler.game.score[handler.game.section][handler.game.level] += 10*handler.game.coefficientScore;
                                        }
                                        tile.actiavted2 = true;
                                        startTime = (double) System.nanoTime()/1000000000L;

                                    }

                                }
                                tile.actiavted1 = true;
                                startTime = (double) System.nanoTime()/1000000000L;
                            }
                        }
                        //y = tile.getY() + tile.height;
                    }
                    if (getBoundsBottom().intersects(tile.getBounds()) && tile.getId() != Id.coin) {
                        setVelY(0);
                        if (falling) {
                            falling = false;
                        }
                        //y = tile.getY() - tile.height;
                    } else if (!falling && !jumping) {
                            gravity = 0.8;
                            falling = true;
                    }
                    if (getBoundsRight().intersects(tile.getBounds()) && tile.getId() != Id.coin) {

                        setVelX(0);
                        x = tile.getX() - width;
                        //System.out.println("1");
                    }
                    if (getBoundsLeft().intersects(tile.getBounds()) && tile.getId() != Id.coin) {
                        setVelX(0);
                        x = tile.getX() + tile.width;
                        //System.out.println("2");
                    }
                    if(getBounds().intersects(tile.getBounds()) && tile.getId() == Id.coin){
                        handler.game.coin[handler.game.section][handler.game.level] ++;
                        handler.game.score[handler.game.section][handler.game.level] += 10*handler.game.coefficientScore;

                        tile.die();
                    }
                    if(getBounds().intersects(tile.getBounds())){
                        if(tile.getId() == Id.door){
                            //double startTime1 = (double) System.nanoTime()/1000000000L;
                            double endTime1 = (double) System.nanoTime()/1000000000L;
                            double timeElapsed1 = endTime1 - handler.startTime;
                            if(timeElapsed1 > 1) {
                                handler.game.switchLevel();
                            }

                        }
                    }
               // }
            }

        }
        for(int i = 0 ; i < handler.entities.size() ; i ++){
            Entity entity = handler.entities.get(i);
            if( entity.getId() == Id.mushroom){
                if(getBounds().intersects(entity.getBounds())){

//                    width += width/3;
//                    height += height/3;
//
//                    setX(getX() - width/4);
//                    setY(getY() - height/4);

                    if(state == PlayerState.SMALL){
                        state = PlayerState.BIG;
                        width += width/3;
                        height += height/3;

                        setX(getX() - width/4);
                        setY(getY() - height/4);
                    }

                    entity.die();

                }
            }
            else if (entity.getId() == Id.goomba || entity.getId() == Id.plant){
                if(getBoundsBottom().intersects(entity.getBoundsTop())){
                    entity.die();
                    handler.game.coin[handler.game.section][handler.game.level] += 2;
                    handler.game.score[handler.game.section][handler.game.level] += 20*handler.game.coefficientScore;
                    handler.game.score[handler.game.section][handler.game.level] += 15*handler.game.coefficientScore;
                }
                else if(getBounds().intersects(entity.getBounds())){
                    if(state == PlayerState.BIG){
                        state = PlayerState.SMALL;
                        width -= width/4;
                        height -= height/4;
                        if( getX() < entity.getX()) {
                            x -= width;

                        }
                        else if(getX() > entity.getX()) {
                            x += width;

                        }

                    }
                    else if (state == PlayerState.SMALL) {
                        die();
                    }
                }
            }
            else if (entity.getId() == Id.circleFire) {
                if(getBounds().intersects(entity.getBounds())){
                    fire = true;
                    entity.die();
                }
            }
        }
        if(jumping && !goingDownPipe){
            gravity -= 0.17;
            setVelY((int)-gravity);
            if(gravity <= 0.5){
                jumping = false;
                falling = true;
            }
        }
        if(falling && !goingDownPipe){
            gravity += 0.17;
            setVelY((int)gravity);
        }
        if(velX != 0){
            frameDelay++;
            if(frameDelay >= 3){
                frame++;
                if(frame >= 5){
                    frame = 0;
                }
                frameDelay = 0;
            }
        }
        if(goingDownPipe){
            for(int i = 0; i < handler.tiles.size(); i++){
                Tile tile = handler.tiles.get(i);
                if(tile.getId()  == Id.pipe) {
                    if(getBounds().intersects(tile.getBounds())){

                        switch (tile.facing) {
                            case 0:
                                setVelY(-5);
                                setVelX(0);
                                pixelsTravelled += -velY;
                                break;
                            case 2:
                                setVelY(5);
                                setVelX(0);
                                pixelsTravelled += velY;
                                break;

                        }
                        if (pixelsTravelled > tile.height) {
                            setVelY(0);
                            goingDownPipe = false;
                            pixelsTravelled = 0;
                        }

                    }

                }
            }
        }

    }
}
