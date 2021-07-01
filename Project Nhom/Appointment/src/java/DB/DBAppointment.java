/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Appointment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OS
 */
public class DBAppointment {

    private static final String DELETEApp = "Delete from Appointment where DoctorID=? and PatientID=?";
    private static final String INSERTAppO = "Insert into AppointmentOfficial values(?,?,?,?,?,?,?,?,?)";

    //get List Appointment
    public static List<Appointment> getAllAppointment() {
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

    public static List<Appointment> getAllAppointmentOfficial() {
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

    //Book Appointment from Patient
    public static int insertAppointment(String pId, String pName, String dId, String dName, String department, String roomtype, String appointmentDate, String appointmentTime,
            String message) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareCall("Insert into Appointment values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pId);
            ps.setString(2, pName);
            ps.setString(3, dId);
            ps.setString(4, dName);
            ps.setString(5, department);
            ps.setString(6, roomtype);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simple.parse(appointmentDate);
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(7, sqldate);
            ps.setString(8, appointmentTime);
            ps.setString(9, message);
            i = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    //Delete Appointment
    public static int deleteAppointmentByDoctor(String dId, String pId) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement(DELETEApp);
            ps.setString(1, dId);
            ps.setString(2, pId);
            i = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

//get List appointment by DoctorID to know doctor have any appointment?
    public static List<Appointment> getAppointmentByDoctor(String dId) {
        List<Appointment> list = new ArrayList<Appointment>();
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select PatientID,PatientName,DoctorID,DoctorName,Department,Roomtype,AppointmentDate,AppointmentTime,Message from Appointment where DoctorID=?");
            ps.setString(1, dId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pId = rs.getString(1);
                String pName = rs.getString(2);
                String did = rs.getString(3);
                String dName = rs.getString(4);
                String department = rs.getString(5);
                String roomtype = rs.getString(6);
                Date appointmentDate = rs.getDate(7);
                String appointmentTime = rs.getString(8);
                String message = rs.getString(9);
                list.add(new Appointment(pId, pName, dId, dName, department, roomtype, appointmentDate, appointmentTime, message));
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
 public static List<Appointment> getAppointmentByPatient(String pId) {
        List<Appointment> list = new ArrayList<Appointment>();
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select PatientID,PatientName,DoctorID,DoctorName,Department,Roomtype,AppointmentDate,AppointmentTime,Message from AppointmentOfficial where PatientID=?");
            ps.setString(1, pId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dId = rs.getString(1);
                String pName = rs.getString(2);
                String did = rs.getString(3);
                String dName = rs.getString(4);
                String department = rs.getString(5);
                String roomtype = rs.getString(6);
                Date appointmentDate = rs.getDate(7);
                String appointmentTime = rs.getString(8);
                String message = rs.getString(9);
                list.add(new Appointment(pId, pName, dId, dName, department, roomtype, appointmentDate, appointmentTime, message));
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    //get List appointment by DoctorID to edit Appointment exactly
    public static Appointment getAppointmentToEdit(String dId, String pId) {
        Appointment s = null;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select PatientID,PatientName,DoctorID,DoctorName,Department,Roomtype,AppointmentDate,AppointmentTime,Message from Appointment where DoctorID=? and PatientID=?");
            ps.setString(1, dId);
            ps.setString(2, pId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString(1);
                String pName = rs.getString(2);
                String did = rs.getString(3);
                String dName = rs.getString(4);
                String department = rs.getString(5);
                String roomtype = rs.getString(6);
                Date appointmentDate = rs.getDate(7);
                String appointmentTime = rs.getString(8);
                String message = rs.getString(9);
                s = new Appointment(pid, pName, did, dName, department, roomtype, appointmentDate, appointmentTime, message);
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }
//Doctor accept Appointment

    public static void insertAppointmentOfficial(String pId, String pName, String dId, String dName, String department, String roomtype, String appointmentDate, String appointmentTime,
            String message) throws ClassNotFoundException, SQLException, ParseException {
        Connection conn = getConnection.getSQLConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement psDE = conn.prepareStatement(DELETEApp);
            psDE.setString(1, dId);
            psDE.setString(2, pId);
            psDE.addBatch();
            int[] rows = psDE.executeBatch();
            System.out.println(Arrays.toString(rows));
            PreparedStatement ps = conn.prepareStatement(INSERTAppO);
            ps.setString(1, pId);
            ps.setString(2, pName);
            ps.setString(3, dId);
            ps.setString(4, dName);
            ps.setString(5, department);
            ps.setString(6, roomtype);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simple.parse(appointmentDate);
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(7, sqldate);
            ps.setString(8, appointmentTime);
            ps.setString(9, message);
            ps.addBatch();
            int[] rows2 = ps.executeBatch();
            System.out.println(Arrays.toString(rows2));
            conn.commit();
        } catch (Exception e) {
            System.out.println("SQL Error");
            //if have any error
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    //Delete Appointment that doctor met patient
    public static int deleteAppointmentOfficial(String dId, String pId, String roomType, String appointmentDate) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareCall("Delete from AppointmentOfficial where DoctorID=? and PatientID=? and RoomType=? and AppointmentDate=?");
            ps.setString(1, dId);
            ps.setString(2, pId);
            ps.setString(3, roomType);
            ps.setString(4, appointmentDate);
            i = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        //updateAppointmentByDoctor(780, "NORMAL2", "2019-9-8", "20:45:CH", "DT_001", "PT_001");
        //  insertAppointment("PT_001", "Dặng Phương Hà", "DT_003", "Vương Tuấn Kiên", "Health Administration", 450, "VIP", "2019-9-7", "11:15:SA", "Help me!!");
      List<Appointment> k = getAppointmentByPatient("PT_001");
        for (int i = 0; i < k.size(); i++) {
            System.out.println(k.get(i).getAppointmentDate());
        }
     
        
//        insertAppointmentOfficial("PT_001", "Ã???Ã?Â¯Ã?Â¿Ã?Â½? QuÃ???Ã??Ã?Â½ QuÃ???Ã??Ã?Â¢n", "DT_003", "Vuong Tu?n KiÃªn", "Microbiology", 1200, "NORMAL3", "2019-05-04", "07:45", "Cuu");
    }
}
