/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author h
 */
public class Admin {

    private String email;
    private String password;

    public Admin() {
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public List<Patient> getAllPatient(){
           List<Patient> list = new ArrayList<>();
        try {      
            Connection conn = getConnection.getSQLConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select PatientID,PatientName,PEmail,PPassword,PGender,DDOB,Disease,Status,Contact,PAddress,filename,savepath from Patient ");
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String gender = rs.getString(5);
                Date dob = rs.getDate(6);
                String disease = rs.getString(7);
                String status = rs.getString(8);
                String contact = rs.getString(9);
                String address = rs.getString(10);
                String filename = rs.getString(11);
                String savepath = rs.getString(12);
                list.add(new Patient(id, name, email, password, gender, dob, disease, status, contact, address, filename, savepath));
            }
            stmt.close();
            conn.close();
            
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        return list;
    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> list = new ArrayList<Doctor>();
        try {
            Connection conn = getConnection.getSQLConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select DoctorID,DoctorName,DEmail,DPassword,DGender,DDOB,Degree,Department,DContact,DAddress,DRegisterDate,filename,savepath from Doctor");
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String gender = rs.getString(5);
                java.sql.Date dob = rs.getDate(6);
                String degree = rs.getString(7);
                String department = rs.getString(8);
//                float fee = rs.getFloat(9);
                String contact = rs.getString(9);
                String address = rs.getString(10);
                java.sql.Date registerdate = rs.getDate(11);
                String filename = rs.getString(12);
                String savepath = rs.getString(13);
                list.add(new Doctor(id, name, email, password, gender, dob, degree, department, contact, address, registerdate, filename, savepath));
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
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
    public static Admin loginAdmin(String email, String pass) throws ClassNotFoundException, SQLException {
        Admin s = null;
        Connection conn = getConnection.getSQLConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from Admin where Email=? and Password=?");
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String Email = rs.getString(1);
            String Pass = rs.getString(2);
            s = new Admin(Email, Pass);
        }
        return s;
    }
}
