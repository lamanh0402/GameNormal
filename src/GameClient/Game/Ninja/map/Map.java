package GameClient.Game.Ninja.map;

import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;

import GameClient.Game.Ninja.entity.Player;
import GameClient.Game.Ninja.gameMain.KeyHandler;
import GameClient.Game.Ninja.gameMain.NinjaPanel;

import java.util.ArrayList;

import java.awt.*;

public class Map {

    Player player;
    NinjaPanel gp;
    KeyHandler keyH;

    Tile[] tiles;
    Tile[][] Maps;

    int col;
    int row;

    public int Mapx;
    public int Mapy;

    public int MapMinX;
    public int MapMinY;
    public int MapMaxX;
    public int MapMaxY;

    public Map(NinjaPanel gp, Player player, KeyHandler keyH) {
        System.out.println("Map da mo");
        this.keyH = keyH;
        this.player = player;
        tiles = new Tile[10];
        this.gp = gp;
        getTitle();
        setDefaultValues();
        loadMap();

    }

    public void setDefaultValues() {

        Mapx = 0;
        Mapy = 0;

        col = 30;
        row = 30;
        

        Maps = new Tile[row][col];
    }

    private void getTitle() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("./mapSprites/Map-Floor-1.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("./mapSprites/Map-Floor-2.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("./mapSprites/Map-wall-1.png"));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("./mapSprites/Map-wall-2.png"));

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Loi nhap map");
        }
    }

    public void update() {

        if (keyH.upPressed && !keyH.upcheck && keyH.leftPressed && !keyH.leftcheck) {
            Mapx += gp.playerSpeed * 3 / 4;
            Mapy += gp.playerSpeed * 3 / 4;
        } else if (keyH.upPressed && !keyH.upcheck && keyH.rightPressed && !keyH.rightcheck) {
            Mapx -= gp.playerSpeed * 3 / 4;
            Mapy += gp.playerSpeed * 3 / 4;
        } else if (keyH.downPressed && !keyH.downcheck && keyH.leftPressed && !keyH.leftcheck) {
            Mapx += gp.playerSpeed * 3 / 4;
            Mapy -= gp.playerSpeed * 3 / 4;
        } else if (keyH.downPressed && !keyH.downcheck && keyH.rightPressed && !keyH.rightcheck) {
            Mapx -= gp.playerSpeed * 3 / 4;
            Mapy -= gp.playerSpeed * 3 / 4;
        }  else if (keyH.upPressed && !keyH.upcheck) {
            Mapy += gp.playerSpeed;
        } else if (keyH.downPressed && !keyH.downcheck) {
            Mapy -= gp.playerSpeed;
        } else if (keyH.leftPressed && !keyH.leftcheck) {
            Mapx += gp.playerSpeed;
        } else if (keyH.rightPressed && !keyH.rightcheck) {
            Mapx -= gp.playerSpeed;
        }

        MapMinX = Mapx + gp.tileSize / 2;
        MapMinY = Mapy + gp.tileSize / 2;

        MapMaxX = Mapx + gp.tileSize / 2 *(col-1);
        MapMaxY = Mapy + gp.tileSize / 2 *(row - 1);

        if (MapMinX >= player.Collisions.getMinX()){
            keyH.leftcheck = true;
        }else keyH.leftcheck = false;

        if (MapMinY >= player.Collisions.getMinY()){
            keyH.upcheck = true;
        }else keyH.upcheck = false;

        if (MapMaxX <= player.Collisions.getMaxX()){
            keyH.rightcheck = true;
        }else keyH.rightcheck = false;

        if (MapMaxY <= player.Collisions.getMaxY()){
            keyH.downcheck = true;
        }else keyH.downcheck = false;

        // System.out.println(Mapx+ " " + Mapy+ " " +player.Collisions.getMinX() + " " + MapMinX);
    }

    public void loadMap() {

        try {

            InputStream is = getClass().getResourceAsStream("./mapSprites/Map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int i = 0; i < row; i++) {
                String line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    int num = Integer.parseInt((String) (((int) line.charAt(j) - 48) + ""));
                    Maps[i][j] = tiles[num - 1];
                }
            }

            br.close();

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("loi load map");
        }

    }

    public void draw(Graphics2D g2) {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                g2.drawImage(Maps[i][j].image, Mapx + j * gp.tileSize / 2, Mapy + i * gp.tileSize / 2, gp.tileSize / 2,
                        gp.tileSize / 2, null);

            }
        }

    }

    public void drawWall(Graphics2D g2) {
        update();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (Maps[i][j] == tiles[2]) {
                    g2.drawImage(tiles[3].image, Mapx + j * gp.tileSize / 2,
                            Mapy + i * gp.tileSize / 2 - gp.tileSize / 2 * 2 / 3, gp.tileSize / 2, gp.tileSize / 2,
                            null);
                }

            }
        }

    }

}
