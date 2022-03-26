package Main;
import java.sql.*;
import java.util.logging.*;

public class ConnectSQL {
    public Connection getConnection() throws SQLException{
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/USER";
        var user = "root";
        var password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connect Succesful!!");
            System.out.println(conn.getCatalog());
        } catch (SQLException e) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Concect error!!");
        }
        return conn;
    }
}
