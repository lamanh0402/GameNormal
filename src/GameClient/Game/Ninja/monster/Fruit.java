package GameClient.Game.Ninja.monster;

import GameClient.Game.Ninja.gameMain.NinjaPanel;
import GameClient.Game.Ninja.map.Map;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fruit extends FruitGoc{
    
    

    BufferedImage apple = getPlayerImage("./sprites/Apple-1.png");

    Random rand = new Random();

    int rotate;

    NinjaPanel gp; 
    Map map;


    public Fruit(NinjaPanel gp, Map map ) {

        speed = 2;

        this.gp = gp;
        this.map = map;
        newApple();
    }

    public BufferedImage getPlayerImage(String Path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(Path));
        } catch (Exception e) {
            System.out.println("loi file fruit anh");
        }
        return null;
    }

    public void newApple(){
        speed = rand.nextInt(2)+2;
        x=(4+rand.nextInt(13))*gp.tileSize/2; 
        y=(4+rand.nextInt(13))*gp.tileSize/2;
        rotate = rand.nextInt(360);

        collision = new Rectangle(map.Mapx+x,map.Mapy+y,gp.tileSize,gp.tileSize);

        cuted = false;
    }

    public void setDefaultValues() {
        x=0;
        y=0;
    }

    public void update() {
        x+= Math.cos(Math.toRadians(rotate))*speed;
        y+= Math.sin(Math.toRadians(rotate))*speed;

        collision.setBounds(map.Mapx+x, map.Mapy+y, gp.tileSize,gp.tileSize);

        if (collision.getMinX() <= map.MapMinX
        || collision.getMinY() <= map.MapMinY
        || collision.getMaxX() >= map.MapMaxX
        || collision.getMaxY() >= map.MapMaxY) cuted = true;


        
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(apple,map.Mapx+x,map.Mapy+y,gp.tileSize, gp.tileSize,null);
        // System.out.println("dain");
    }

}
