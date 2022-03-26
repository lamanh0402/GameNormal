package Main;

import java.sql.*;

import java.util.ArrayList;
import java.util.Vector;

import FRAMELOGIN.*;
/**
 *
 * @author minhphi
 */
public class Main {
    static ArrayList<USER> USERS = new ArrayList<USER>();
    public static void loadData(){
    
        try {
            Connection conn = new ConnectSQL().getConnection(); 
            int number;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from accout");
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount(); // tra ve so cot
            
            while(rs.next()) {
                    String username = rs.getString(1);
                    String ingame = rs.getString(2);
                    String password = rs.getString(3);
                    int record1 = rs.getInt(4);
                    int record2 = rs.getInt(5);
                    int record3 = rs.getInt(6);
                    int record4 = rs.getInt(7);
                    USERS.add(new USER(username,ingame,password,record1,record2,record3,record4));
                    System.out.println(username+ingame+password+record1+record2+record3+record4);

            }
            System.out.println("Connect successful");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("LoadData error");
        }
        
    }

    public static int findUser(String username){
        
        for (int i = 0; i < USERS.size(); i++){
            if (USERS.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        loadData();
        new LOGIN(USERS).setVisible(true);
        
    }
}
