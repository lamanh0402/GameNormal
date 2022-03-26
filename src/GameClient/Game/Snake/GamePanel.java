package GameClient.Game.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JPanel;

import GameClient.GameClient;

public class GamePanel extends JPanel implements ActionListener {
    static final int scale = 1;
    static final int UNIT_SIZE = 25 * scale;

    static final int SCREEN_WITDH = 600 * scale;
    static final int SCREEN_HEIGHT = 600 * scale+UNIT_SIZE;

    static final int GAME_UNITS = (SCREEN_WITDH * SCREEN_HEIGHT) / UNIT_SIZE * scale;
    int DELAY = 150;
    int x[] = new int[GAME_UNITS];
    int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'D';
    boolean running = true;
    Timer timer = new Timer(DELAY, this);
    Random random;
    int mouth = 300;
    boolean bite = true;
    boolean regame = false;

    GameClient gameClient;
    SnakeGame snakeGame = null;

    int BestScore;

    public GamePanel(GameClient gameClient, SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        this.gameClient = gameClient;
        BestScore = gameClient.USERS.get(gameClient.thutu).getRecord3();
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WITDH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdaper());
        this.timer.start();
        startGame();
    }

    public void startGame() {
        timer.stop();
        newApple();
        x = new int[GAME_UNITS];
        y = new int[GAME_UNITS];
        DELAY = 150;
        bodyParts = 6;
        applesEaten = 0;
        direction = 'D';
        mouth = 300;
        bite = true;
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        FontMetrics metrics = getFontMetrics(g.getFont());

        g.setColor(new Color(30, 30, 30));
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WITDH, i * UNIT_SIZE);

        }

        g.setColor(new Color(187, 173, 160));
            g.fillRect(0,0,SCREEN_WITDH,UNIT_SIZE);

        g.setColor(new Color(38,38,38));
        g.setFont(new Font("Ink Free", Font.BOLD, 24));
        if (bodyParts - 6 > BestScore) {
            
            BestScore = bodyParts - 6;
        }

        g.drawString((String) ("Score : " + (bodyParts - 6)), 10, 20);
        g.drawString((String) ("BestScore : " + (BestScore)), SCREEN_WITDH - metrics.stringWidth((String) ("BestScore : " + (BestScore))) - 150, 20);
        g.setColor(Color.RED);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0; i < bodyParts; i++) {
            if (i == 0 && bite) {
                g.setColor(Color.ORANGE);
                g.fillArc(x[i], y[i], UNIT_SIZE, UNIT_SIZE, mouth, 300);
                bite = false;
            } else if (i == 0 && !bite) {
                g.setColor(Color.ORANGE);
                g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                bite = true;
            } else {
                g.setColor(new Color(45, 180, 0));
                g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
        if (!running) {
            gameOver(g);
            if (regame) {
                regame = false;
                DELAY = 150;
                startGame();
            }
        }

    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WITDH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) ((SCREEN_HEIGHT-UNIT_SIZE) / UNIT_SIZE)) * UNIT_SIZE + UNIT_SIZE;

    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] -= UNIT_SIZE;
                break;
            case 'D':
                y[0] += UNIT_SIZE;
                break;
            case 'L':
                x[0] -= UNIT_SIZE;
                break;
            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            timer.stop();
            DELAY = DELAY * 99 / 100;
            timer = new Timer(DELAY, this);
            timer.start(); // hdfjasdfasdfaklsjdhasdfhasdf
            newApple();
        }
    }

    public void checkCollisions() {
        // checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = true;
            }
        }
        // check if head touches left border
        if (x[0] < 0) {
            x[0] = SCREEN_WITDH - UNIT_SIZE;
        }
        // check if head touches right border
        if (x[0] >= SCREEN_WITDH) {
            x[0] = 0;
        }
        // check if head touches top border
        if (y[0] < UNIT_SIZE) {
            y[0] = SCREEN_HEIGHT - UNIT_SIZE;
        }
        // check if head touches bottom border
        if (y[0] >= SCREEN_HEIGHT) {
            y[0] = UNIT_SIZE;
        }
        // if running false
        // if (!running){
        // timer.stop();
        // }
    }

    public void gameOver(Graphics g) {
        // game Over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over!", (SCREEN_WITDH - metrics.stringWidth("Game Over!")) / 2, SCREEN_WITDH/2-100*scale);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        metrics = getFontMetrics(g.getFont());
        g.drawString((String) ("Your Score: " + (bodyParts - 6)),
                (SCREEN_WITDH - metrics.stringWidth((String) ("Your Score: " + (bodyParts - 6)))) / 2, SCREEN_WITDH/2-100*scale +100);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 36));
        metrics = getFontMetrics(g.getFont());
        g.drawString("Press Space to play again!",
                (SCREEN_WITDH - metrics.stringWidth("Press Space to play again!")) / 2, SCREEN_WITDH/2-100*scale +400);
        g.drawString("Press ESC to back to GameClient!",
                (SCREEN_WITDH - metrics.stringWidth("Press ESC to back to GameClient!")) / 2, SCREEN_WITDH/2-100*scale +500);

    }

    public void exit() {
        gameClient.updateRecord(3, BestScore);
        this.snakeGame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdaper extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R' && y[0] != y[1]) {
                        direction = 'L';
                        mouth = 210;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L' && y[0] != y[1]) {
                        direction = 'R';
                        mouth = 30;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D' && x[0] != x[1]) {
                        direction = 'U';
                        mouth = 120;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U' && x[0] != x[1]) {
                        direction = 'D';
                        mouth = 300;
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if (!running) {
                        regame = true;
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    if (!running) {

                        gameClient.setVisible(true);

                        exit();
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
