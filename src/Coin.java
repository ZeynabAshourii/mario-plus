package src;

import java.awt.*;

public class Coin extends Tile{
    private int number = 0;
    public Coin(int x, int y, int width, int height, boolean solid, Id id, Handler handler , User user) {
        super(x, y, width, height, solid, id, handler , user);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Game.coinPic.getSheet() , x , y , width , height , null);
    }
    int playerX = 300;
    int playerY = 512;

    @Override
    public void update() {
        if(user.typeMario == 3){
        if((-handler.game.camera.getX() <= getX()) && (getX()+width <= -handler.game.camera.getX() + 1080) && (-handler.game.camera.getY() <= getY()) && (getY()+height <= -handler.game.camera.getY() + 771) ){
            for(int i = 0; i < handler.entities.size(); i++){
                if(handler.entities.get(i).getId() == Id.player){
                    playerX = handler.entities.get(i).getX();
                    playerY = handler.entities.get(i).getY();
                }
            }
            double norm = Math.sqrt((x-playerX)*(x-playerX) + (y-playerY)*(y-playerY));
            //System.out.println(norm);
//            System.out.println("velX" + (double) (300-x)/norm);
//            System.out.println("velY" + (double) (512-y)/norm);
//            setVelX((x-300)/norm );
//            setVelY((512-y)/norm + 1);
            if( norm !=0) {
                setVelX((int) (5*(playerX - x) / norm));
                setVelY((int) (5*(playerY - y) / norm));

            }
            x += velX;
            y += velY;
        }
        }
    }
}
