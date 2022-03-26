package GameClient.Game.Ninja.entity;

import java.awt.*;
import java.awt.image.*;

public class Entity {

    public int x, y;
    public int speed = 5;

    public BufferedImage stand, move;
    public String direction = "RR";

    public Rectangle Collisions;

}
