package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    //private BufferedImage sheet;
    private Image sheet;
    public SpriteSheet(String path){
//        try {
            //sheet = ImageIO.read(getClass().getResource("/images/" + path));
            sheet = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/src/images/" + path));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
//    public BufferedImage getSprite(int x , int y){
//        return sheet.getSubimage(x*32 - 32 , y*32-32 , 32 , 32);
//    }

    public Image getSheet() {
        return sheet;
    }
}