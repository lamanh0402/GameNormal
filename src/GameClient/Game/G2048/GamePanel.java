package GameClient.Game.G2048;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import FRAMELOGIN.*;
import GameClient.GameClient;


public class GamePanel extends JPanel implements ActionListener {

    static final int scale = 1;
    static final int UNIT_SIZE = 150*scale;
    static final int SCREEN_WITDH = 612*scale;
    static final int SCREEN_HEIGHT = 650*scale;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_HEIGHT) / UNIT_SIZE*scale;
    final int DELAY = 100;
    int x[][] = new int[6][6];
    int y[][] = new int[6][6];
    Random random;
    Timer timer;
    boolean running = true;
    int sqrX;
    int sqrY;
    char direction = 'U';
    Color[] C = new Color[50000];
    boolean next = true;
    int Max = 2;
    int powww = 1;


    int Score = 0;
    

    GameClient gameClient;
    G2048Game G2048G;

    ArrayList<USER> USERS; 
    int thutu;

    int BestScore; 

    public GamePanel(GameClient gameClient, G2048Game G2048G) {
        this.G2048G = G2048G;
        this.gameClient = gameClient;
        this.USERS = gameClient.USERS;
        this.thutu = gameClient.thutu;
        this.BestScore = gameClient.USERS.get(thutu).getRecord2();

        random = new Random();
        this.setPreferredSize(new DimensionUIResource(SCREEN_WITDH, SCREEN_HEIGHT));
        this.setBackground(new Color(204, 205, 196));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdaper());
        C[2] = new Color(238, 238, 218);
        C[4] = new Color(237, 224, 200);
        C[8] = new Color(242, 177, 121);
        C[16] = new Color(218, 134, 72);
        C[32] = new Color(246, 124, 95);
        C[64] = new Color(246, 94, 59);
        C[128] = C[256] = C[512] = C[1024] = C[2048] = new Color(239, 199, 67);
        C[4096] = C[8192] = C[16384] = new Color(107, 202, 14);
        startGame();
    }
    
    public void startGame() {
        newSQR();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public int poww(int x, int y){
        int s = 1;
        for (int i = 1; i<=y; i++){
            s*=x;
        }
        return s;
    }
    public void draw(Graphics g) {
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.setColor(new ColorUIResource(187, 173, 160));
        for (int i = 0; i <= 4; i++) {
            g.fillRect(i * UNIT_SIZE, 0*scale+38*scale, 10*scale, SCREEN_HEIGHT);
            g.fillRect(0*scale, i * UNIT_SIZE+38*scale, SCREEN_WITDH, 10*scale);
        }

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (x[i][j] > 0) {
                    g.setColor(C[(x[i][j])]);
                    g.fillRect(j * UNIT_SIZE + 10*scale, i * UNIT_SIZE + 10*scale+38*scale, UNIT_SIZE - 10*scale, UNIT_SIZE - 10*scale);
                    g.setColor(new Color(10, 10, 10));
                    g.setFont(new Font("Monospace", Font.LAYOUT_LEFT_TO_RIGHT, 30*scale));
                    g.drawString((String) ((x[i][j]) + ""),
                            j * UNIT_SIZE + ((UNIT_SIZE - metrics.stringWidth((String) ((x[i][j]) + ""))) / 2),
                            i * UNIT_SIZE + 100*scale+38*scale);
                }
            }
            g.setColor(new ColorUIResource(187, 173, 160));
            g.fillRect(0,0,SCREEN_WITDH,48*scale);

            g.setColor(new Color(10, 10, 10));
            g.setFont(new Font("Ink Free", Font.BOLD, 24));
            if (this.Score > this.BestScore) {
                this.gameClient.updateRecord(2, this.BestScore);
                BestScore = Score;
            }
            
            g.drawString((String) ("Score : " + Score), 10, 30);
            g.drawString((String) ("BestScore : " + (BestScore)), SCREEN_WITDH-250, 30);
    }

    public void newSQR() {
        do {
            sqrX = random.nextInt(4);
            sqrY = random.nextInt(4);
        } while (x[sqrX][sqrY] > 0);
        x[sqrX][sqrY] = 2;
    }

    public void join() {
        next = false;
        switch (direction) {
            case 'U':
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 4; i++) {
                        for (int k = i + 1; k < 4; k++) {
                            if (x[k][j] > 0 && x[i][j] == 0) {
                                x[i][j] = x[k][j];
                                x[k][j] = 0;
                                next = true;
                            } else if (x[i][j] == x[k][j] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                Score+=x[i][j];
                                x[k][j] = 0;
                                next = true; 
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                            else if (x[k][j]>0 && x[i][j]>0) break;
                        }

                    }
                }
                break;
            // 
            case 'D':
                for (int j = 0; j < 4; j++) {
                    for (int i = 3; i > 0; i--) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (x[k][j] > 0 && x[i][j] == 0) {
                                x[i][j] = x[k][j];
                                x[k][j] = 0;
                                next = true;
                            } else if (x[i][j] == x[k][j] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                Score+=x[i][j];
                                x[k][j] = 0;
                                next = true;
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                            else if (x[k][j]>0 && x[i][j]>0) break;
                        }

                    }
                }
                break;
            case 'L':
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = j + 1; k < 4; k++) {
                            if (x[i][k] > 0 && x[i][j] == 0) {
                                x[i][j] = x[i][k];
                                x[i][k] = 0;
                                next = true;
                            } else if (x[i][j] == x[i][k] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                Score+=x[i][j];
                                x[i][k] = 0;
                                next = true;
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                            else if (x[i][k]>0 && x[i][j]>0) break;
                        }

                    }
                }
                break;
            case 'R':
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j >= 0; j--) {
                        for (int k = j - 1; k >= 0; k--) {
                            if (x[i][k] > 0 && x[i][j] == 0) {
                                x[i][j] = x[i][k];
                                x[i][k] = 0;
                                next = true;
                            } else if (x[i][j] == x[i][k] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                Score+=x[i][j];
                                x[i][k] = 0;
                                next = true;
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                            else if (x[i][k]>0 && x[i][j]>0) break;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    public void checkEnd() {
        next = false;
        switch (direction) {
            case 'U':
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 4; i++) {
                        for (int k = i + 1; k < 4; k++) {
                            if (x[k][j] > 0 && x[i][j] == 0) {
                                x[i][j] = x[k][j];
                                x[k][j] = 0;
                                next = true;
                            } else if (x[i][j] == x[k][j] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                x[k][j] = 0;
                                next = true; 
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                        }

                    }
                }
                break;
            case 'D':
                for (int j = 0; j < 4; j++) {
                    for (int i = 3; i > 0; i--) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (x[k][j] > 0 && x[i][j] == 0) {
                                x[i][j] = x[k][j];
                                x[k][j] = 0;
                                next = true;
                            } else if (x[i][j] == x[k][j] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                x[k][j] = 0;
                                next = true;
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                        }

                    }
                }
                break;
            case 'L':
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = j + 1; k < 4; k++) {
                            if (x[i][k] > 0 && x[i][j] == 0) {
                                x[i][j] = x[i][k];
                                x[i][k] = 0;
                                next = true;
                            } else if (x[i][j] == x[i][k] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                x[i][k] = 0;
                                next = true;
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                        }

                    }
                }
                break;
            case 'R':
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j >= 0; j--) {
                        for (int k = j - 1; k >= 0; k--) {
                            if (x[i][k] > 0 && x[i][j] == 0) {
                                x[i][j] = x[i][k];
                                x[i][k] = 0;
                                next = true;
                            } else if (x[i][j] == x[i][k] && x[i][j] > 0) {
                                x[i][j] *= 2;
                                x[i][k] = 0;
                                next = true;
                                Max = Math.max(x[i][j],Max);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running)
        repaint();
    }
    public void exit() {
        this.G2048G.dispose();
    }

    public class MyKeyAdaper extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    direction = 'L';
                    // while (checkEnd())
                    join();
                    if (next)
                        newSQR();
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = 'R';
                    // while (checkEnd())
                    join();
                    if (next)
                        newSQR();
                    break;
                case KeyEvent.VK_UP:
                    direction = 'U';
                    // while (checkEnd())
                    join();
                    if (next)
                        newSQR();
                    break;
                case KeyEvent.VK_DOWN:
                    direction = 'D';
                    // while (checkEnd())
                    join();
                    if (next)
                        newSQR();
                    break;
                // case KeyEvent.VK_SPACE:
                //     if (!running) {
                //         regame = true;
                //     }
                //     break;
                case KeyEvent.VK_ESCAPE:
                        gameClient.setVisible(true);
                        exit();
                default:
                    break;
               
            }
        }
    }

}
