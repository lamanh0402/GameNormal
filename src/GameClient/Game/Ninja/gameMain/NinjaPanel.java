package GameClient.Game.Ninja.gameMain;


import javax.swing.*;

import GameClient.GameClient;
import GameClient.Game.Ninja.entity.Player;
import GameClient.Game.Ninja.entity.Weapon;
import GameClient.Game.Ninja.monster.*;
import GameClient.Game.Ninja.map.Map;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class NinjaPanel extends JPanel implements Runnable {

    public final int originalTileSize = 32;
    public final int scale = 2;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenWidth = 16;
    public final int maxScreenHeight = 12;
    public final int screenWidth = tileSize*maxScreenWidth;
    public final int screenHeight = tileSize*maxScreenHeight; // 768*576 px]

    GameClient gameClient;
    KeyHandler  keyH = new KeyHandler();;
    Thread      gameThread;
    Player      player;
    Map         map;
    ArrayList<FruitGoc> fruits = new ArrayList<FruitGoc>();

    int playerX = 100;
    int playerY = 100;
    public int playerSpeed = 5;

    int mouth = 300;
    public int step;

    int Score = 0;
    int BestScore = 0;

    int FPS;
    public long timer = 0;
    public long currentTime;
    Random rand = new Random();

    NinjaFrame ninjaFrame;

    BufferedImage score = getPlayerImage("./spites/Apple-1.png"), 
                    bestScore = getPlayerImage("./spites/BestScore.png"),
                    hearts = getPlayerImage("./spites/Hearts.png");

    public NinjaPanel(GameClient gameClient, NinjaFrame ninjaFrame) {
        
        this.ninjaFrame = ninjaFrame;
        this.gameClient = gameClient;

        this.BestScore = gameClient.USERS.get(gameClient.thutu).getRecord1();
        System.out.println("panel");
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(133, 58, 4));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        start();
    }

    public BufferedImage getPlayerImage(String Path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(Path));
        } catch (Exception e) {
            System.out.println("loi file player anh");
        }
        return null;
    }

    public void start() {

        
        player = new Player(this, keyH);
        map = new Map(this, player, keyH);

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / 60;
        double delta = 0;
        long lastTime = System.nanoTime();
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta > 0) {
                if (player.hearts>0)
                Update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                FPS = drawCount;
                drawCount = 0;
                timer = 0;
                MonsterManager();
            }

        }
    }
    
    public void Update() {
        player.update();
        map.update();
        for (int i = 0; i <fruits.size(); i++){

            if (fruits.get(i) instanceof Fruit)
            ((Fruit)fruits.get(i)).update();
            else ((Bomb)fruits.get(i)).update();

            if (fruits.get(i).cuted){
                fruits.remove(i);
            }
        }
        checkCollisions();

    }

    public void checkCollisions(){
        for (int i = 0; i <fruits.size(); i++){

            
            if (((player.Collisions.getBounds().intersects(fruits.get(i).collision.getBounds())))){
                if ((fruits.get(i) instanceof Fruit))
                Score++;
                else player.hearts--;
                fruits.remove(i);
                System.out.println(Score);
            }
            
        }
    }

    public void MonsterManager(){
        if (rand.nextInt(100) > 40)
        fruits.add(new Bomb(this,map));
        else fruits.add(new Fruit(this,map));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (player.hearts>0){

        map.draw(g2);

        player.draw(g2);
        
        for (int i = 0; i <fruits.size(); i++){
            if ((fruits.get(i) instanceof Fruit))
            ((Fruit)fruits.get(i)).draw(g2);
            else ((Bomb)fruits.get(i)).draw(g2);
        }

        map.drawWall(g2);
        
        
        g.setColor(new Color(10, 10, 10));
            g.setFont(new Font("Ink Free", Font.BOLD, 24));
            if (this.Score > this.BestScore) {
                
                BestScore = Score;
            }
            
            g.drawImage(score, 10, 5, 15*scale, 15*scale,null);
            g.drawString((String)("x"+Score), 20+10*scale, 30);

            g.drawImage(hearts, screenWidth/2-100, 5, 15*scale, 15*scale,null);
            g.drawString((String) ("x" + player.hearts), screenWidth/2-70, 30);

            g.drawImage(bestScore, screenWidth-150, 5, 15*scale, 15*scale,null);
            g.drawString((String) ("x" + (BestScore)), screenWidth-120, 30);

        } else {
            gameOver(g);
            if (keyH.exit){
                this.gameClient.updateRecord(1, this.BestScore);
                exit();
            } 
        }

    }

    public void gameOver(Graphics g) {

        // game Over text
        this.setBackground(Color.BLACK);
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over!", (screenWidth - metrics.stringWidth("Game Over!")) / 2, screenWidth/2-100*scale);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        metrics = getFontMetrics(g.getFont());
        g.drawString((String) ("Your Score: " + Score),
                (screenWidth - metrics.stringWidth((String) ("Your Score: " + Score))) / 2, screenWidth/2-100*scale +100);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        metrics = getFontMetrics(g.getFont());
        g.drawString("Press ESC to save Record!",
                (screenWidth - metrics.stringWidth("Press ESC to save Record!")) / 2, screenWidth/2-100*scale+200);

    }

    public void exit() {
        gameClient.setVisible(true);
        this.ninjaFrame.dispose();

    }

}