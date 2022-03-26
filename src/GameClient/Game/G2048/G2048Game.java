package GameClient.Game.G2048;
import javax.swing.JFrame;
import GameClient.GameClient;

public class G2048Game extends JFrame {
    public G2048Game(GameClient gameClient){
        this.add(new GamePanel(gameClient,this));
        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
