/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Feedback;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author h
 */
public class DBFeedback {
      public static List<Feedback> getAllFeedbackPatient() throws ClassNotFoundException, SQLException {
        List<Feedback> list = new ArrayList<Feedback>();
        Connection conn = getConnection.getSQLConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from FeedbackPatient");
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String service = rs.getString(3);
            int point = rs.getInt(4);
            String quality = rs.getString(5);
            String status = rs.getString(6);
            Date date = rs.getDate(7);
            list.add(new Feedback(id, name, service, point, quality, status, date));
        }
        stmt.close();
        conn.close();
        return list;
    }
      public static int insertFeedbackPatient(String pId, String pName, String service, int point,
            String quality, String status, String registerDate) throws ClassNotFoundException, SQLException, ParseException {
        Connection conn = getConnection.getSQLConnection();
        PreparedStatement ps = conn.prepareCall("Insert into FeedbackPatient values(?,?,?,?,?,?,?)");
        ps.setString(1, pId);
        ps.setString(2, pName);
        ps.setString(3, service);
        ps.setInt(4, point);
        ps.setString(5, quality);      
        ps.setString(6, status);      
        ps.setString(7, registerDate);
        int i = ps.executeUpdate();
        ps.close();
        conn.close();
        return i;
    }
      public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
          insertFeedbackPatient("PT_002", "D?ng Phuong Hà","Good", 4, "Handsome","Every is OK", "2019-9-8");
    }

}
