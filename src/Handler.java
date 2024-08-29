package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Locale;

public class Handler  {
    public LinkedList<Entity> entities = new LinkedList<>();
    public LinkedList<Tile> tiles = new LinkedList<>();
    public User user;
    public Game game;
    public long startTime = 0;
    public int deathY = 0;
    public Handler(User user , Game game){
        this.user = user;
        this.game = game;
        createlevel();
    }
    public void paint(Graphics g){
        for(int i = 0 ; i < entities.size(); i++){
            Entity entity = entities.get(i);
            //if(Game.getVisibleArea() != null && entity.getBounds().intersects(Game.getVisibleArea())) {
                entity.paint(g);
            //}
        }
        for(int i = 0 ; i < tiles.size(); i++){
        Tile tile = tiles.get(i);
            //if(Game.getVisibleArea() != null && tile.getBounds().intersects(Game.getVisibleArea())) {
                tile.paint(g);
            //}
        }
    }
    public void update() throws InterruptedException {
        for(int i = 0; i < entities.size(); i++){
            Entity entity = entities.get(i);
            entity.update();
        }
        for(int i = 0; i < tiles.size(); i++){
            Tile tile = tiles.get(i);
            //if(Game.getVisibleArea() != null && tile.getBounds().intersects(Game.getVisibleArea())) {
                tile.update();
//                if(tile.getId() == Id.coin) {
//                    System.out.println(tile.getX());
//                    System.out.println(tile.getY());
//                }
            //}
        }

    }
    public void addEntity(Entity entity){
        entities.add(entity);
    }
    public void removeEntity(Entity entity){
        entities.remove(entity);
    }
    public void addTile(Tile tile){
        tiles.add(tile);
    }
    public void removeTile(Tile tile){
        tiles.remove(tile);
    }
    public void createlevel(){
        startTime = System.nanoTime()/1000000000L;
        deathY = 0;

        if(game.section == 0 && game.level == 1) {
//            addTile(new PowerUpBlock(500, 140 + 64*4-20, 64, 64, true, Id.powerUp, this, user));
//
//            for (int i = 0; i < 29; i++) {
//                addTile((new Wall(i * 64, Game.HEIGHT * Game.SCALE - 64, 64, 64, true, Id.wall, this, user)));
//                if (i > 4 && i != 28) {
//                    addTile(new Wall(i * 64, 364 + 64*3, 64, 64, true, Id.wall, this, user));
//                }
//            }
//            for (int i = 0; i < 11; i++) {
//                addTile(new Wall(0, i * 64, 64, 64, true, Id.wall, this, user));
//                if (i * 64 + 64 * 7 != Game.HEIGHT * Game.SCALE - 64 * 4)
//                    addTile(new Wall(2368, i * 64 + 64 * 7, 64, 64, true, Id.wall, this, user));
//            }
//            for (int i = 0; i < 6; i++) {
//                addTile(new Wall(1792, Game.HEIGHT * Game.SCALE + 64 * i, 64, 64, true, Id.wall, this, user));
//            }
//            for (int i = 0; i < 10; i++) {
//                if(i != 7) {
//                    addTile(new Wall(1792 + 64 * i, Game.HEIGHT * Game.SCALE + 64 * 6, 64, 64, true, Id.wall, this, user));
//                }
//                if (i != 2 && i != 6) {
//                    addTile(new Wall(1792 + 64 * i, Game.HEIGHT * Game.SCALE - 64, 64, 64, true, Id.wall, this, user));
//                }
//            }
//            for (int i = 0; i < 10; i++) {
//                addTile(new Coin(320 + 64 * i, 300 + 64, 64, 64, true, Id.coin, this, user));
//            }
//
//
//            addTile(new Pipe(1920, Game.HEIGHT * Game.SCALE - 64 * 2, 64, 64 * 3, true, Id.pipe, this, 2, user , true));
//            addTile(new Pipe(1920 + 64 * 4, Game.HEIGHT * Game.SCALE - 64 * 2, 64, 64 * 3, true, Id.pipe, this, 0, user , false));
//
//            addEntity(new Mushroom(500, Game.HEIGHT * Game.SCALE - 64 * 3, 64, 64, Id.mushroom, this, user));
//            addTile(new Door(1920 + 64*5 , Game.HEIGHT * Game.SCALE - 64 * 4, 64, 64, true, Id.door, this, user));
//
//
//            addEntity(new Player(300, 512, 48, 48, Id.player, this, user));
//
//            addEntity(new Goomba(450, Game.HEIGHT * Game.SCALE - 64 * 2, 64, 64, Id.goomba, this, user));
//
//            //addTile(new Door(2368, Game.HEIGHT * Game.SCALE - 64 * 4, 64, 64, true, Id.door, this, user));


            for (int i = 0; i < 71; i++) {
                if(i != 64 && i != 12 && i != 9) addTile((new Wall(i * 64, Game.HEIGHT * Game.SCALE , 64, 64, true, Id.wall, this, user)));
                if (i%17 > 5) {
                    if( i == 29  || i == 27 || i == 30 || i == 26 ) {
                        addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*8, 64, 64, true, Id.wall, this, user));
                    }
                    addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*4, 64, 64, true, Id.wall, this, user));
                    if(i%5 !=0) addTile(new Coin( 64 * i, Game.HEIGHT * Game.SCALE -64*5, 64, 64, true, Id.coin, this, user));
                    if(i%10 == 2) addTile(new Coin(64*i , Game.HEIGHT * Game.SCALE - 64, 64 , 64 , true , Id.coin , this , user));
                }
            }
            addTile(new Wall(33*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            addTile(new Wall(23*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            for (int i = 0; i < 9; i++) {
                addTile(new Wall(71*64 ,Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
                if(i != 0) addTile(new Wall(0, Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
            }

            addTile(new PowerUpBlock(64*28, Game.HEIGHT * Game.SCALE - 64*8, 64, 64, true, Id.powerUp, this, user));
            addEntity(new Goomba(64*23, Game.HEIGHT * Game.SCALE - 64, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*29, Game.HEIGHT * Game.SCALE - 64*5, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*60, Game.HEIGHT * Game.SCALE + 64*4, 64, 64, Id.goomba, this, user));
            addTile(new Pipe(9*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(12*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 0, user , false));
            addTile(new Pipe(37*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(41*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 0, user , false));
            addTile(new Pipe(52*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(64*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 0, user , false));
            for(int i = 0 ; i < 4; i++){
                addTile(new Wall(6*64, Game.HEIGHT * Game.SCALE + 64 + 64*i, 64, 64, true, Id.wall, this, user));
                addTile(new Wall(15*64, Game.HEIGHT * Game.SCALE + 64 +  64*i, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 10 ; i++){
                addTile(new Wall(6*64 + 64*i, Game.HEIGHT * Game.SCALE + 64 * 5, 64, 64, true, Id.wall, this, user));
            }

            for(int i = 0 ; i < 4; i++){
                addTile(new Wall(35*64, Game.HEIGHT * Game.SCALE + 64 + 64*i, 64, 64, true, Id.wall, this, user));
                addTile(new Wall(43*64, Game.HEIGHT * Game.SCALE + 64 +  64*i, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 9 ; i++){
                addTile(new Wall(35*64 + 64*i, Game.HEIGHT * Game.SCALE + 64 * 5, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 4; i++){
                addTile(new Wall(50*64, Game.HEIGHT * Game.SCALE + 64 + 64*i, 64, 64, true, Id.wall, this, user));
                addTile(new Wall(66*64, Game.HEIGHT * Game.SCALE + 64 +  64*i, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 17 ; i++){
                addTile(new Wall(50*64 + 64*i, Game.HEIGHT * Game.SCALE + 64 * 5, 64, 64, true, Id.wall, this, user));
            }
            addEntity(new Player(64, 640, 48, 48, Id.player, this, user));

            addTile(new Door(64*70, Game.HEIGHT * Game.SCALE - 64*2, 64, 64, true, Id.door, this, user));

        } else if (game.section == 1 && game.level == 0) {

            for (int i = 0; i < 71; i++) {
                if(i != 64 && i !=63 && i != 36 && i != 54 && i != 39) addTile((new Wall(i * 64, Game.HEIGHT * Game.SCALE , 64, 64, true, Id.wall, this, user)));
                if (i%17 > 6) {
                    if( i == 29 || i == 28 || i == 27 || i == 30 || i == 31 ) {
                        addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*8, 64, 64, true, Id.wall, this, user));
                    }
                    addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*4, 64, 64, true, Id.wall, this, user));
                    if(i%5 !=0) addTile(new Coin( 64 * i, Game.HEIGHT * Game.SCALE -64*5, 64, 64, true, Id.coin, this, user));
                    if(i%10 == 2) addTile(new Coin(64*i , Game.HEIGHT * Game.SCALE - 64, 64 , 64 , true , Id.coin , this , user));
                }
            }
            addTile(new Wall(33*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            addTile(new Wall(24*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            for (int i = 0; i < 9; i++) {
                addTile(new Wall(71*64 ,Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
                if(i != 0) addTile(new Wall(0, Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
            }

            addTile(new PowerUpBlock(64*12, Game.HEIGHT * Game.SCALE - 64*8, 64, 64, true, Id.powerUp, this, user));
            addEntity(new Goomba(64*7, Game.HEIGHT * Game.SCALE - 64, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*29, Game.HEIGHT * Game.SCALE - 64*5, 64, 64, Id.goomba, this, user));
            addTile(new Pipe(36*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(39*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 0, user , false));
            addTile(new Pipe(54*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));

            for(int i = 0 ; i < 4; i++){
                addTile(new Wall(34*64, Game.HEIGHT * Game.SCALE + 64 + 64*i, 64, 64, true, Id.wall, this, user));
                addTile(new Wall(58*64, Game.HEIGHT * Game.SCALE + 64 +  64*i, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 25 ; i++){
                addTile(new Wall(34*64 + 64*i, Game.HEIGHT * Game.SCALE + 64 * 5, 64, 64, true, Id.wall, this, user));
            }
            addEntity(new Player(64, 640, 48, 48, Id.player, this, user));

            addTile(new Door(64*70, Game.HEIGHT * Game.SCALE - 64*2, 64, 64, true, Id.door, this, user));

        }
        else if (game.section == 0 && game.level == 0) {
            for (int i = 0; i < 71; i++) {
                if(i != 46 && i !=45) addTile((new Wall(i * 64, Game.HEIGHT * Game.SCALE , 64, 64, true, Id.wall, this, user)));
                if (i%17 > 6) {
                    if( i == 14 || i == 13 || i == 12 || i == 10 || i == 11 ) {
                        addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*8, 64, 64, true, Id.wall, this, user));
                    }
                    if( i == 14+34 || i == 13+34 || i == 12+34 || i == 10+34 || i == 11+34 ) {
                        addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*8, 64, 64, true, Id.wall, this, user));
                    }
                    addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*4, 64, 64, true, Id.wall, this, user));
                    if(i%5 != 4) addTile(new Coin( 64 * i, Game.HEIGHT * Game.SCALE -64*5, 64, 64, true, Id.coin, this, user));
                    if(i%10 == 8) addTile(new Coin(64*i , Game.HEIGHT * Game.SCALE - 64, 64 , 64 , true , Id.coin , this , user));
                }
            }
            addTile(new Wall(33*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            addTile(new Wall(24*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            for (int i = 0; i < 9; i++) {
                addTile(new Wall(71*64 ,Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
                if(i != 0) addTile(new Wall(0, Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
            }

            addTile(new PowerUpBlock(64*54, Game.HEIGHT * Game.SCALE - 64*4, 64, 64, true, Id.powerUp, this, user));
            addEntity(new Goomba(64*16, Game.HEIGHT * Game.SCALE - 64, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*35, Game.HEIGHT * Game.SCALE + 64*4, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*29, Game.HEIGHT * Game.SCALE - 64*5, 64, 64, Id.goomba, this, user));
            addTile(new Pipe(36*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(39*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 0, user , false));
            addTile(new Pipe(6*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(64*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));

            for(int i = 0 ; i < 4; i++){
                addTile(new Wall(4*64, Game.HEIGHT * Game.SCALE + 64 + 64*i, 64, 64, true, Id.wall, this, user));
                addTile(new Wall(41*64, Game.HEIGHT * Game.SCALE + 64 +  64*i, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 38 ; i++){
                addTile(new Wall(4*64 + 64*i, Game.HEIGHT * Game.SCALE + 64 * 5, 64, 64, true, Id.wall, this, user));
            }
            addEntity(new Player(64, 640, 48, 48, Id.player, this, user));

            addTile(new Door(64*70, Game.HEIGHT * Game.SCALE - 64*2, 64, 64, true, Id.door, this, user));

        }
        else if (game.section == 1 && game.level == 1){
            for (int i = 0; i < 71; i++) {
                if(i != 6 && i !=7 && i != 10 && i != 36 && i != 20 && i != 46) addTile((new Wall(i * 64, Game.HEIGHT * Game.SCALE , 64, 64, true, Id.wall, this, user)));
                if (i%17 > 4) {
                    if( i == 14 || i == 13 || i == 12 || i == 10 || i == 11 ) {
                        addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*8, 64, 64, true, Id.wall, this, user));
                    }
                    if( i == 14+34 || i == 13+34 || i == 12+34 || i == 10+34 || i == 11+34 ) {
                        addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*8, 64, 64, true, Id.wall, this, user));
                    }
                    if(i != 66) addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE -64*4, 64, 64, true, Id.wall, this, user));
                    if(i%5 != 3) addTile(new Coin( 64 * i, Game.HEIGHT * Game.SCALE -64*5, 64, 64, true, Id.coin, this, user));
                    if(i%10 == 6) addTile(new Coin(64*i , Game.HEIGHT * Game.SCALE - 64, 64 , 64 , true , Id.coin , this , user));
                }
            }
            addTile(new Wall(33*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            addTile(new Wall(22*64 ,Game.HEIGHT * Game.SCALE - 64 * 5, 64, 64, true, Id.wall, this, user));
            for (int i = 0; i < 9; i++) {
                addTile(new Wall(71*64 ,Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
                if(i != 0) addTile(new Wall(0, Game.HEIGHT * Game.SCALE - 64 * i, 64, 64, true, Id.wall, this, user));
            }
//
            addTile(new PowerUpBlock(64*66, Game.HEIGHT * Game.SCALE - 64*4, 64, 64, true, Id.powerUp, this, user));
            addEntity(new Goomba(64*16, Game.HEIGHT * Game.SCALE - 64, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*35, Game.HEIGHT * Game.SCALE + 64*4, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*29, Game.HEIGHT * Game.SCALE - 64*5, 64, 64, Id.goomba, this, user));
            addEntity(new Goomba(64*65, Game.HEIGHT * Game.SCALE - 64*5, 64, 64, Id.goomba, this, user));
            addTile(new Pipe(20*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 0, user , false));
            addTile(new Pipe(36*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(10*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 2, user , true));
            addTile(new Pipe(46*64, Game.HEIGHT * Game.SCALE - 64 , 64, 64 * 3, true, Id.pipe, this, 0, user , false));

            for(int i = 0 ; i < 4; i++){
                addTile(new Wall(8*64, Game.HEIGHT * Game.SCALE + 64 + 64*i, 64, 64, true, Id.wall, this, user));
                addTile(new Wall(22*64, Game.HEIGHT * Game.SCALE + 64 +  64*i, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 15 ; i++){
                addTile(new Wall(34*64 + 64*i, Game.HEIGHT * Game.SCALE + 64 * 5, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 4; i++){
                addTile(new Wall(34*64, Game.HEIGHT * Game.SCALE + 64 + 64*i, 64, 64, true, Id.wall, this, user));
                addTile(new Wall(48*64, Game.HEIGHT * Game.SCALE + 64 +  64*i, 64, 64, true, Id.wall, this, user));
            }
            for(int i = 0 ; i < 15 ; i++){
                addTile(new Wall(8*64 + 64*i, Game.HEIGHT * Game.SCALE + 64 * 5, 64, 64, true, Id.wall, this, user));
            }
            addEntity(new Player(64, 640, 48, 48, Id.player, this, user));

            addTile(new Door(64*70, Game.HEIGHT * Game.SCALE - 64*2, 64, 64, true, Id.door, this, user));
        }
        //addTile(new Door(64*5, Game.HEIGHT * Game.SCALE - 64*2, 64, 64, true, Id.door, this, user));

        for(int i =0 ; i < this.tiles.size(); i++){
            if(this.tiles.get(i).getY() > deathY){
                deathY = this.tiles.get(i).getY();
            }
        }


    }

//    public void createlevel(BufferedImage level){
//        int width = level.getWidth();
//        int height = level.getHeight();
//        for(int i = 0; i < height; i++){
//            for(int j = 0; j < width ; j++){
//                int pixel =  level.getRGB(j , i);
//                int red = (pixel >> 16) & 0xff;
//                int green = (pixel >> 8) & 0xff;
//                int blue = (pixel) & 0xff;
//
//                if(red == 0 && green == 0 && blue == 0){
//                    addTile(new Wall(j*64 , i*64 , 64 , 64 , true , Id.wall , this));
//
//                }
//                if(red == 0 && green == 0 && blue == 255){
//                    System.out.println("gav");
//                    addEntity(new Player(j*64 , i*64 , 64 , 64 , true , Id.player , this));
//                }
//
//            }
//        }
//    }

    public void clearLevel(){
        entities.clear();
        tiles.clear();
    }
}
