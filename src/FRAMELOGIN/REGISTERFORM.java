
package FRAMELOGIN;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.*;
import java.util.ArrayList;
import java.awt.*;
import java.sql.*;
import Main.*;

public class REGISTERFORM extends JFrame {

    LOGIN LI;

    USER user;
    ArrayList<USER> USERS;

    JTextField IngameField = new JTextField();
    JLabel Mess = new JLabel();
    JPasswordField PasswordField = new JPasswordField();
    JPasswordField PasswordField2 = new JPasswordField();
    JTextField UserNameField = new JTextField();
    JButton Register = new JButton();
    JButton hide = new JButton();
    JButton close = new JButton();
    JButton BackToLogin = new JButton();
    JLabel ingameLabel = new JLabel();
    JLabel title = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel passLabel = new JLabel();
    JLabel passLabel2 = new JLabel();
    JPanel header = new JPanel();
    JPanel body = new JPanel();

    public REGISTERFORM(LOGIN LI, ArrayList<USER> USER) {
        this.USERS = USER;
        this.LI = LI;
        initComponents();
    }

    public REGISTERFORM() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(38, 38, 38));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new Color(248, 148, 6));

        title.setFont(new Font("Noto Sans Mono", 1, 24));
        title.setForeground(new Color(254, 254, 254));
        title.setText("Register");

        hide.setBackground(new Color(255, 30, 30));
        hide.setFont(new Font("Ubuntu", 0, 18));
        hide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideAction(evt);
            }
        });

        close.setBackground(new Color(250, 250, 0));
        close.setFont(new Font("Ubuntu", 0, 18));
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeAction(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(header);
        header.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
                                .addComponent(close, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hide, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(title)
                                        .addComponent(close, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(hide, GroupLayout.PREFERRED_SIZE, 39,
                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE)));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 80));

        body.setBackground(new Color(38, 38, 38));

        ingameLabel.setFont(new Font("Noto Sans Mono", 0, 24));
        ingameLabel.setForeground(new Color(254, 254, 254));
        ingameLabel.setText("Fullname:");

        usernameLabel.setBackground(new Color(247, 247, 247));
        usernameLabel.setFont(new Font("Noto Sans Mono", 0, 24));
        usernameLabel.setForeground(new Color(254, 254, 254));
        usernameLabel.setText("Username:");

        passLabel.setFont(new Font("Noto Sans Mono", 0, 24));
        passLabel.setForeground(new Color(254, 254, 254));
        passLabel.setText("Password: ");

        passLabel2.setFont(new Font("Noto Sans Mono", 0, 24));
        passLabel2.setForeground(new Color(254, 254, 254));
        passLabel2.setText("Re-enter Password: ");

        IngameField.setFont(new Font("Noto Sans Mono", 0, 27));

        UserNameField.setFont(new Font("Noto Sans Mono", 0, 27));

        PasswordField.setFont(new Font("Noto Sans Mono", 0, 36));

        PasswordField2.setFont(new Font("Noto Sans Mono", 0, 36));

        Register.setBackground(new Color(60, 168, 50));
        Register.setFont(new Font("Noto Sans Mono", 0, 24));
        Register.setForeground(new Color(254, 254, 254));
        Register.setText("Register");
        Register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegisterAction(evt);
            }
        });

        BackToLogin.setBackground(new Color(248, 148, 6));
        BackToLogin.setFont(new Font("Noto Mono", 0, 24));
        BackToLogin.setForeground(new Color(254, 254, 254));
        BackToLogin.setText("Login");
        BackToLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LoginAction(evt);
            }
        });

        Mess.setFont(new Font("Noto Mono", 0, 24));
        Mess.setForeground(new Color(255, 0, 0));
        Mess.setText("");

        GroupLayout bodyPanel = new GroupLayout(body);
        body.setLayout(bodyPanel);
        bodyPanel.setHorizontalGroup(
            bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanel.createSequentialGroup()
                .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanel.createSequentialGroup()
                        .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanel.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passLabel2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanel.createSequentialGroup()
                                        .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ingameLabel)
                                            .addComponent(usernameLabel))
                                        .addGap(14, 14, 14))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanel.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PasswordField)
                            .addComponent(IngameField)
                            .addComponent(UserNameField)
                            .addComponent(PasswordField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bodyPanel.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(BackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanel.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Mess, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        bodyPanel.setVerticalGroup(
            bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanel.createSequentialGroup()
                .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanel.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(ingameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bodyPanel.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(IngameField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passLabel))))
                .addGap(31, 31, 31)
                .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel2)
                    .addComponent(PasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(Mess, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bodyPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 870, 590));

        pack();
    }

    private void closeAction(ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }

    private void hideAction(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }

    private void RegisterAction(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        if (UserNameField.getText().length() == 0 ||
                IngameField.getText().length() == 0 ||
                String.valueOf(PasswordField.getPassword()).length() == 0 ||
                String.valueOf(PasswordField2.getPassword()).length() == 0) {
            Mess.setText("Please type full");
        } else {
            if (findUser(UserNameField.getText()) == -1) {
                if (String.valueOf(PasswordField.getPassword()).equals(String.valueOf(PasswordField2.getPassword()))) {
                    String username = UserNameField.getText();
                    String ingame = IngameField.getText();
                    String password = String.valueOf(PasswordField.getPassword());
                    System.out.println(username + ingame + password);
                    addAccout(username, ingame, password, 0, 0, 0, 0);
                } else
                    Mess.setText("Password do not match!");
            } else {
                Mess.setText("Username exist");
            }
            System.out.println(findUser(UserNameField.getText()));

        }

    }

    private void IngameFieldActionPerformed(ActionEvent evt) {
    }

    private void LoginAction(ActionEvent evt) {
        this.LI.setVisible(true);
        this.dispose();
    }

    private void UserNameFieldActionPerformed(ActionEvent evt) {

    }

    public void addAccout(String username, String ingame, String password, int record1, int record2, int record3,
            int record4) {
        try {
            Connection conn = new ConnectSQL().getConnection();
            Statement st = conn.createStatement();
            // st.executeQuery("Select * from accout");
            st.executeUpdate("INSERT INTO accout(username,ingame,password,record1,record2,record3,record4)"
                    + "VALUES ('" + username + "','" + ingame + "','" + password + "',0,0,0,0)");
            USERS.add(new USER(username, ingame, password));
            JOptionPane.showMessageDialog(this, "Register successful!");

        } catch (SQLException e) {
            System.out.println("Add accout error");
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public int findUser(String username) {

        for (int i = 0; i < USERS.size(); i++) {
            if (this.USERS.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

}
