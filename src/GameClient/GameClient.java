package GameClient;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.BorderFactory.*;
import java.sql.*;
import Main.*;

import java.util.ArrayList;
import java.util.logging.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import FRAMELOGIN.*;
import GameClient.Game.G2048.G2048Game;
import GameClient.Game.Snake.SnakeGame;
import GameClient.Game.Ninja.gameMain.NinjaFrame;
import GameClient.Game.Ninja.map.Map;


public class GameClient extends javax.swing.JFrame {

    LOGIN LI;
    public ArrayList<USER> USERS;
    public int thutu;

    JPanel header = new javax.swing.JPanel();
    JLabel title = new javax.swing.JLabel();
    JButton hide = new javax.swing.JButton();
    JButton close = new javax.swing.JButton();
    JPanel body = new javax.swing.JPanel();
    JPanel listGame = new javax.swing.JPanel();
    JButton ninjabtn = new javax.swing.JButton();
    JButton g2048btn = new javax.swing.JButton();
    JButton snakebtn = new javax.swing.JButton();
    JButton comingGame = new javax.swing.JButton();
    JLabel username = new javax.swing.JLabel();
    JButton Logout = new javax.swing.JButton();

    public GameClient(LOGIN LI, ArrayList<USER> USERS, int thutu) {
        this.thutu = thutu;
        this.USERS = USERS;
        this.LI = LI;
        

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(new Color(38, 38, 38));
        this.setUndecorated(true);
        this.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        this.setResizable(false);

        initComponents();
    }
    public GameClient() {
        initComponents();
    }

    private void initComponents() {

        
        //Design UI
        {

        header.setBackground(new Color(248, 148, 6));

        title.setFont(new Font("Noto Sans Mono", 1, 36)); 
        title.setForeground(new Color(254, 254, 254));
        title.setText("Game Client ");

        hide.setBackground(new Color(255, 30, 30));
        hide.setFont(new Font("Ubuntu", 0, 18)); 
        hide.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        close.setBackground(new Color(250, 250, 0));
        close.setFont(new Font("Ubuntu", 0, 18)); 
        close.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        close.setFocusPainted(false);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(header);
        header.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1420, Short.MAX_VALUE)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hide, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(hide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 80));

        body.setBackground(new Color(38, 38, 38));

        listGame.setBackground(new Color(38, 38, 38));
        listGame.setLayout(new GridLayout(2, 2, 20, 20));

        ninjabtn.setBackground(new Color(45, 45, 45));
        ninjabtn.setFont(new Font("Noto Sans Mono", 0, 36)); 
        ninjabtn.setForeground(new Color(255, 255, 255));
        ninjabtn.setIcon(new ImageIcon(getPlayerImage("./Logo/BabyDragon-1.png")));
        ninjabtn.setText("<html>Ninja Fruit<br>Best record: <html>"+USERS.get(thutu).getRecord1());
        ninjabtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ninjabtn.setFocusPainted(false);
        ninjabtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NinjaAction(evt);
            }

            
        });
        listGame.add(ninjabtn);

        g2048btn.setBackground(new Color(45, 45, 45));
        g2048btn.setFont(new Font("Noto Sans Mono", 0, 36)); 
        g2048btn.setForeground(new Color(255, 255, 255));
        g2048btn.setIcon(new ImageIcon(getPlayerImage("./Logo/g2048.png")));
        g2048btn.setText("<html>2048<br>Best score: <html>"+USERS.get(thutu).getRecord2());
        g2048btn.setToolTipText("");
        g2048btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g2048btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G2048Action(evt);
            }
        });
        listGame.add(g2048btn);

        snakebtn.setBackground(new Color(45, 45, 45));
        snakebtn.setFont(new Font("Noto Sans Mono", 0, 36)); 
        snakebtn.setForeground(new Color(255, 255, 255));
        snakebtn.setIcon(new ImageIcon(getPlayerImage("./Logo/snake.png")));
        snakebtn.setText("<html>Snake<br>Best score: <html>"+USERS.get(thutu).getRecord3());
        snakebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        snakebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                snakeAction(evt);
            }
        });
        listGame.add(snakebtn);

        comingGame.setBackground(new Color(45, 45, 45));
        comingGame.setFont(new Font("Noto Sans Mono", 0, 36)); 
        comingGame.setForeground(new Color(255, 255, 255));
        comingGame.setIcon(new ImageIcon(getClass().getResource("./Logo/meoee.gif")));
        comingGame.setText("Coming soon...");
        comingGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listGame.add(comingGame);

        username.setFont(new Font("Ubuntu", 0, 36)); 
        username.setForeground(new Color(250, 250, 250));
        username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        username.setText(this.USERS.get(thutu).getIngame());

        Logout.setBackground(new Color(244, 23, 23));
        Logout.setFont(new Font("Ubuntu", 0, 36)); 
        Logout.setForeground(new Color(255, 255, 255));
        Logout.setText("Log out");
        Logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Logout.setFocusPainted(false);
        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(body);
        body.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(username, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Logout))
                    .addComponent(listGame, GroupLayout.PREFERRED_SIZE, 1767, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Logout, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(listGame, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1900, 860));

        pack();
    }
        }

       
    public Image getPlayerImage(String Path) {

        try {

            return ((Image)ImageIO.read(getClass().getResourceAsStream(Path))).getScaledInstance(300,300,0);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("loi file anh");

        }

        return null;
        
    }

    private void NinjaAction(ActionEvent evt) {
        try {
            new NinjaFrame(this).setVisible(true);
            System.out.println("Ninja");
            this.dispose();
        } catch (Exception e) {
            System.out.println("loi mo frame");
        }
        
        
        
    }

    private void G2048Action(ActionEvent evt){
        new G2048Game(this).setVisible(true);
        this.dispose();
    }
    
    private void snakeAction(ActionEvent evt){
        new SnakeGame(this).setVisible(true);
        this.dispose();
    }
    
    private void jButton2ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.setState(JFrame.ICONIFIED);
    }

    private void jButton7ActionPerformed(ActionEvent evt) {
        this.LI.setVisible(true);
        this.dispose();
    }

    public void updateRecord(int magame,int score) {
        try {
            Connection conn = new ConnectSQL().getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE accout SET record"+magame+" = "+score+" where username = '"+USERS.get(thutu).getUsername()+"'");
            switch (magame) {
                case 1:
                    USERS.get(thutu).setRecord1(score);
                    break;
                case 2:
                    USERS.get(thutu).setRecord2(score);
                    break;
                case 3:
                    USERS.get(thutu).setRecord3(score);

                    break;
                case 4:
                    USERS.get(thutu).setRecord4(score);
                    break;
            
                default:
                    break;
            }
            initComponents();
            System.out.println("updateRecord successful");

        } catch (SQLException e) {
            System.out.println("Add accout error");
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, e);

        }
    }


}
