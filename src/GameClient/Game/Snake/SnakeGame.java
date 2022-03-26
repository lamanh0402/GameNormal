package GameClient.Game.Snake;
import javax.swing.JFrame;

import GameClient.GameClient;

public class SnakeGame extends JFrame{
    GameClient gameClient;
    public SnakeGame(GameClient gameClient) {
        this.gameClient = gameClient;
        this.add(new GamePanel(gameClient, this));
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
