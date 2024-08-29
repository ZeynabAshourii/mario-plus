package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    public User user;
    public Handler handler;
    public KeyInput(User user , Handler handler) {
        this.user = user;
        this.handler = handler;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i = 0 ; i <  handler.entities.size(); i++) {
            Entity entity = handler.entities.get(i);
            if(entity.getId() == Id.player) {
                if(entity.goingDownPipe) return;;
                switch (key) {
                    case KeyEvent.VK_W:
                        for(int j = 0; j < handler.tiles.size(); j++ ){
                            Tile tile = handler.tiles.get(j);
                            if(tile.getId() == Id.pipe){
                                if(tile.facing == 0 && entity.getBoundsTop().intersects(tile.getBounds())){
                                    if(!entity.goingDownPipe){
                                        entity.goingDownPipe = true;
                                    }
                                }
                            }
                        }
                        //entity.setVelY(-5);
                        if (!entity.jumping) {
                            entity.jumping = true;
                            if(user.typeMario == 1) {
                                entity.gravity = 12.0;
                            }
                            else{
                                entity.gravity = 10.0;
                            }
                        }
                        break;
                    case KeyEvent.VK_S:
                        for(int j = 0; j < handler.tiles.size(); j++ ){
                            Tile tile = handler.tiles.get(j);
                            if(tile.getId() == Id.pipe){
                                if(tile.facing == 2 && entity.getBoundsBottom().intersects(tile.getBounds())){
                                    if(!entity.goingDownPipe){
                                        entity.goingDownPipe = true;
                                    }
                                }
                            }
                        }
                        break;
                    case KeyEvent.VK_D:
                        if(user.typeMario == 2){
                            entity.setVelX(8);
                        }
                        else {
                            entity.setVelX(5);
                        }
                        entity.facing = 1;
                        break;
                    case KeyEvent.VK_A:
                        if(user.typeMario == 2) {
                            entity.setVelX(-8);
                        }
                        else {
                            entity.setVelX(-5);
                        }
                        entity.facing = 0;
                        break;
                    case KeyEvent.VK_SPACE:
                        if(Player.fire){
                        switch (entity.facing) {
                            case 0:
                                handler.addEntity(new FireBall(entity.getX() - 24, entity.getY() + 12, 24, 24, Id.fireBall, handler, handler.user, entity.facing));
                                break;
                            case 1:
                                handler.addEntity(new FireBall(entity.getX() + entity.width, entity.getY() + 12, 24, 24, Id.fireBall, handler, handler.user, entity.facing));
                                break;
                        }
                        }
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(Entity entity : handler.entities) {
            if(entity.getId() == Id.player) {
                switch (key) {
                    case KeyEvent.VK_W:
                        entity.setVelY(0);
                        break;
                    case KeyEvent.VK_S:
                        entity.setVelY(0);
                        break;
                    case KeyEvent.VK_D:
                        entity.setVelX(0);
                        break;
                    case KeyEvent.VK_A:
                        entity.setVelX(0);
                        break;
                }

            }
        }
    }
}
