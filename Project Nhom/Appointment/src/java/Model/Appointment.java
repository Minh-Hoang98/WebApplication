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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OS
 */
public class Appointment {

    private String pID;
    private String pName;
    private String dID;
    private String dName;
    private String department;
    private String roomType;
    private Date appointmentDate;
    private String appointmentTime;
    private String message;

    public Appointment() {
    }

    public Appointment(String pID, String pName, String dID, String dName, String department, String roomType, Date appointmentDate, String appointmentTime, String message) {
        this.pID = pID;
        this.pName = pName;
        this.dID = dID;
        this.dName = dName;
        this.department = department;
        this.roomType = roomType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.message = message;
    }

    public Appointment(String pID, String pName, String dID, String dName, String department, String roomType, String appointmentDate, String appointmentTime, String message) throws ParseException {
        this.pID = pID;
        this.pName = pName;
        this.dID = dID;
        this.dName = dName;
        this.department = department;
        this.roomType = roomType;
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simple.parse(appointmentDate);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        this.appointmentDate = sqldate;
        this.appointmentTime = appointmentTime;
        this.message = message;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getdID() {
        return dID;
    }

    public void setdID(String dID) {
        this.dID = dID;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Appointment> getAllAppointment() {
        List<Appointment> list = new ArrayList<Appointment>();
        try {
            Connection conn = getConnection.getSQLConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select PatientID,PatientName,DoctorID,DoctorName,Department,Roomtype,AppointmentDate,AppointmentTime,Message from Appointment");
            while (rs.next()) {
                String pId = rs.getString(1);
                String pName = rs.getString(2);
                String dId = rs.getString(3);
                String dName = rs.getString(4);
                String department = rs.getString(5);
                String roomtype = rs.getString(6);
                Date appointmentDate = rs.getDate(7);
                String appointmentTime = rs.getString(8);
                String message = rs.getString(9);
                list.add(new Appointment(pId, pName, dId, dName, department, roomtype, appointmentDate, appointmentTime, message));
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Appointment> getAllAppointmentOfficial() {
        List<Appointment> list = new ArrayList<Appointment>();
        try {
            Connection conn = getConnection.getSQLConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select PatientID,PatientName,DoctorID,DoctorName,Department,Roomtype,AppointmentDate,AppointmentTime,Message from AppointmentOfficial");
            while (rs.next()) {
                String pId = rs.getString(1);
                String pName = rs.getString(2);
                String dId = rs.getString(3);
                String dName = rs.getString(4);
                String department = rs.getString(5);
                String roomtype = rs.getString(6);
                Date appointmentDate = rs.getDate(7);
                String appointmentTime = rs.getString(8);
                String message = rs.getString(9);
                list.add(new Appointment(pId, pName, dId, dName, department, roomtype, appointmentDate, appointmentTime, message));
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Appointment s = new Appointment();
        List<Appointment> list = s.getAllAppointmentOfficial();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getdName() + " " + list.get(i).getAppointmentTime() + " " + list.get(i).getAppointmentDate());
        }
    }
}
