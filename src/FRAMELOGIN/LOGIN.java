
package FRAMELOGIN;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

import GameClient.*;

public class LOGIN extends JFrame {

    USER user = new USER();
    ArrayList<USER> USERS;
    public LOGIN(ArrayList<USER> users) {
        this.USERS = users;
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        // AutoCompleteDocument.

    }


    JButton Login = new JButton();
    JLabel StartRegister = new JLabel();
    JButton hide = new JButton();
    JButton close = new JButton();
    JLabel title = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel passLabel = new JLabel();
    JPanel header = new JPanel();
    JPanel body = new JPanel();
    JPasswordField PassWordField = new JPasswordField();
    JTextField UserNameField = new JTextField();


    public void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new Color(248, 148, 6));

        title.setFont(new Font("Noto Sans Mono", 1, 24)); 
        title.setForeground(new Color(254, 254, 254));
        title.setText("Login");

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

        GroupLayout jPanel1Layout = new GroupLayout(header);
        header.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 413, Short.MAX_VALUE)
                .addComponent(close, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hide, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(hide, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(close, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 60));

        body.setBackground(new Color(38, 38, 38));
        body.setForeground(new Color(254, 254, 254));

        usernameLabel.setFont(new Font("Noto Sans Mono", 0, 24)); 
        usernameLabel.setForeground(new Color(254, 254, 254));
        usernameLabel.setText("Username : ");

        passLabel.setFont(new Font("Noto Mono", 0, 24)); 
        passLabel.setForeground(new Color(254, 254, 254));
        passLabel.setText("Password: ");

        UserNameField.setFont(new Font("Noto Sans Mono", 0, 24)); 
        UserNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AutoCompelete(evt);
            }
        });

        PassWordField.setFont(new Font("Noto Sans Mono", 0, 24));

        Login.setBackground(new Color(248, 148, 6));
        Login.setFont(new Font("Noto Mono", 0, 24)); 
        Login.setText("Login");
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        StartRegister.setFont(new Font("Noto Mono", 0, 24));
        StartRegister.setForeground(new Color(254, 254, 254));
        StartRegister.setText("Do not have an account? Sign up now");
        StartRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                StartRegisterMouseClicked(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(body);
        body.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(usernameLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(passLabel)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(PassWordField, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(UserNameField))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(StartRegister)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Login, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(UserNameField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PassWordField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(Login, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(StartRegister)
                .addGap(47, 47, 47))
        );

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 690, 460));

        pack();
    }

    // Auto complete
    private void AutoCompelete(java.awt.event.KeyEvent evt) {                                        
        if(!(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_DELETE))
        {
           
            String to_check=UserNameField.getText();
            String res = intellijSearch(to_check);
            int to_check_len=to_check.length();

            if (!(res.equals(""))){
            UserNameField.setText(res);
            UserNameField.setSelectionStart(to_check_len);
            UserNameField.setSelectionEnd(res.length());
            }
        }
    }  

    public void hideAction(ActionEvent evt) {
        System.exit(0);
    }

    public void closeAction(ActionEvent evt) {
        this.setState(JFrame.ICONIFIED);
    }

    // Chua co tai khoan
    public void StartRegisterMouseClicked(MouseEvent evt) {
        REGISTERFORM gs = new REGISTERFORM(this,USERS);
        gs.setVisible(true);
        gs.pack();
        gs.setLocationRelativeTo(null);
        gs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    public void LoginActionPerformed(ActionEvent evt) {
        if (findUser(UserNameField.getText()) != -1){
            user = USERS.get(findUser(UserNameField.getText()));
            int thutu = findUser(UserNameField.getText());
            System.out.println("*"+(String.valueOf(PassWordField.getPassword()))+"*");
            System.out.println("*"+user.getPassword()+"*");
            String pass2 = String.valueOf(PassWordField.getPassword());
            System.out.println((user.getPassword().equals(pass2)));

            if (user.getPassword().equals(String.valueOf(PassWordField.getPassword()))){
                GameClient gs = new GameClient(this,USERS,thutu);
                gs.setVisible(true);
                gs.pack();
                gs.setLocationRelativeTo(null);
                gs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(false);
            } else{
                System.out.println("Sai Mat Khau");
                JOptionPane.showMessageDialog(this,"Wrong password");
            }

        } else {
            JOptionPane.showMessageDialog(this,"Username does not exist");
        }
        
    }

    // Tim kiem tai khoan gan giong
    public String intellijSearch(String username) {

        for (USER user : USERS){
            if (user.getUsername().indexOf(username) == 0){
                return user.getUsername();
            }
        }

        return "";
    }

    // Tim kiem tai khoan
    public int findUser(String username){
        
        for (int i = 0; i < USERS.size(); i++){
            if (this.USERS.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

}
