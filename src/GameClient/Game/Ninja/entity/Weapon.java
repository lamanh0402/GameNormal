package GameClient.Game.Ninja.entity;

import GameClient.Game.Ninja.gameMain.NinjaPanel;
import GameClient.Game.Ninja.gameMain.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Weapon extends Entity {
    NinjaPanel gp;
    Player player;
    KeyHandler keyH;

    BufferedImage sword;
    BufferedImage cut;

    double rota = 30;
    boolean flip = false;

    long timers;
    long time;

    boolean attack = false;
    int attackStep = 0;

    public Weapon(NinjaPanel gp, Player player, KeyHandler keyH, String direction) {
        this.gp = gp;
        this.player = player;
        this.keyH = keyH;
        this.direction = direction;
        setDefaultValues();
    }

    public BufferedImage getPlayerImage(String Path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(Path));
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("loi file anh weapon");
        }
        return null;
    }

    public void setDefaultValues() {
        
        sword = getPlayerImage("./sprites/BloodKatana.png");

    }

    public void update() {
        
        this.direction = player.direction;
        this.timers = gp.currentTime;
        if (this.direction.charAt(1) == 'R') {
            this.rota = 15;
        }
        if (this.direction.charAt(1) == 'L') {
            this.rota = 15;
        }
        if (this.direction.charAt(1) == 'U') {
            this.rota = 105;
        }
        if (this.direction.charAt(1) == 'D') {
            this.rota = 285;
        }

        if (this.direction.charAt(0) == 'R') {
            this.flip = false;
        }
        if (direction.charAt(0) == 'L') {
            this.flip = true;
        }

        if (keyH.attackPressed && time == 0) {
            time = gp.currentTime;
            attack = true;
        }
        if (timers - time > 70000000 * 4) {
            attack = false;
            time = 0;
        } else if (timers - time > 70000000 * 3) {
            attackStep = 4;
        } else if (timers - time > 70000000 * 2) {
            attackStep = 2;
        } else if (timers - time > 70000000 * 1) {
            attackStep = 3;
        } else if (timers - time >= 0) {
            attackStep = 1;
        }

        

    }

    public void draw(Graphics2D g2) {
        // if (player.left){
        //     g2.rotate(Math.toRadians(-(180-rota)), player.x+gp.tileSize/2+ gp.tileSize*5/32 - 25, player.y +gp.tileSize/5*2+ gp.tileSize*14/32);

        //     g2.drawImage(sword, player.x+gp.tileSize/2, player.y +gp.tileSize/5*2 +gp.tileSize - 25, gp.tileSize, -gp.tileSize, null);

        //     g2.rotate(Math.toRadians((180-rota)), player.x+gp.tileSize/2+ gp.tileSize*5/32 - 25, player.y +gp.tileSize/5*2+ gp.tileSize*14/32);
        // }else {

        // g2.rotate(Math.toRadians(-rota), player.x+gp.tileSize/2+ gp.tileSize*5/32, player.y +gp.tileSize/5*2+ gp.tileSize*14/32);

        // g2.drawImage(sword, player.x+gp.tileSize/2, player.y +gp.tileSize/5*2, gp.tileSize, gp.tileSize, null);

        // g2.rotate(Math.toRadians(rota), player.x+gp.tileSize/2+ gp.tileSize*5/32, player.y +gp.tileSize/5*2+ gp.tileSize*14/32);
        // }   
        this.x = player.x+gp.tileSize/2 - 36;
        this.y = player.y +gp.tileSize/5*2 +gp.tileSize - 25 - 47;
        
        if (!attack || attackStep == 4) {
            BufferedImage imge = sword;
            if (!flip) {
                this.x +=32;
                g2.rotate(Math.toRadians(-this.rota), this.x + 10, this.y + 32);
                g2.drawImage(imge, this.x, this.y, gp.tileSize*3/2, gp.tileSize, null);
                g2.rotate(Math.toRadians(this.rota), this.x + 10, this.y + 32);
            } else {
                this.x-=20;
                g2.rotate(Math.toRadians(+this.rota), this.x + 60, this.y + 25);
                g2.drawImage(imge, this.x + gp.tileSize, this.y, -gp.tileSize*3/2, gp.tileSize, null);
                g2.rotate(Math.toRadians(-this.rota), this.x + 60, this.y + 25);
            }

        } else {

            BufferedImage imge = getPlayerImage(String.format("./sprites/cut-%s.png", attackStep));

            if (!flip) {
                this.x +=40;
                g2.rotate(Math.toRadians(-this.rota), this.x + 10, this.y + 32);
                g2.drawImage(imge, this.x, this.y - 16, gp.tileSize * 2, gp.tileSize * 2, null);
                g2.rotate(Math.toRadians(this.rota), this.x + 10, this.y + 32);
            } else {
                this.x-=20;
                g2.rotate(Math.toRadians(+this.rota), this.x + 60, this.y + 25);
                g2.drawImage(imge, this.x + gp.tileSize, this.y - 16, -gp.tileSize * 2, gp.tileSize * 2, null);
                g2.rotate(Math.toRadians(-this.rota), this.x + 60, this.y + 25);
            }
        }
        
    }

}
