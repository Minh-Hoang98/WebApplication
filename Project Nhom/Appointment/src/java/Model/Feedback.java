/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OS
 */
public class Feedback {

    private String pId;
    private String pName;
    private String service;
    private int point;
    private String quality;
    private String status;
    private Date registerDate;

    public Feedback() {
    }

    public Feedback(String pId, String pName, String service, int point, String quality, String status, Date registerDate) {
        this.pId = pId;
        this.pName = pName;
        this.service = service;
        this.point = point;
        this.quality = quality;
        this.status = status;
        this.registerDate = registerDate;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public List<Feedback> getAllFeedbackPatient() {
        List<Feedback> list = new ArrayList<Feedback>();
        try {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        Feedback s = new Feedback();
        List<Feedback> list = s.getAllFeedbackPatient();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getService());
        }
    }
}
