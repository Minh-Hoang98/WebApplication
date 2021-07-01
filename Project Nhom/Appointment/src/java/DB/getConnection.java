/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OS
 */
public class getConnection {

    public static Connection getSQLConnection() throws ClassNotFoundException, SQLException {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://Mr_Css:1433;databaseName=ManagerHospital;";
        String userDB = "se1305";
        String passDB = "abcd";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
        return con;
    }

    public static void closeQuietly(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(getConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void rollbackQuietly(Connection con) {
        try {
            con.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(getConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
