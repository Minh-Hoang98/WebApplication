/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Patient;
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
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author OS
 */
public class DBPatient {
//List Patient

    public static List<Patient> getAllPatient() {
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

//insert Patient
    public static int insertPatient(String pId, String pName, String pEmail, String pPassword, String gender, String dob, String disease, String status,
            String pContact, String address, String filename, String savepath) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareCall("Insert into Patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pId);
            ps.setString(2, pName);
            ps.setString(3, pEmail);
            ps.setString(4, pPassword);
            ps.setString(5, gender);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simple.parse(dob);
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(6, sqldate);
            ps.setString(7, disease);
            ps.setString(8, status);
            ps.setString(9, pContact);
            ps.setString(10, address);
            ps.setString(11, filename);
            ps.setString(12, savepath);
            i = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
//update Patient

    public static int updatePatient(String pId, String pName, String pEmail, String pPassword, String gender, String dob, String disease, String status,
            String pContact, String address) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareCall("Update Patient set PatientName=?,PEmail=?,PPassword=?,PGender=?,DDOB=?,Disease=?,Status=?,Contact=?,PAddress=? where PatientID=?");
            ps.setString(1, pName);
            ps.setString(2, pEmail);
            ps.setString(3, pPassword);
            ps.setString(4, gender);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simple.parse(dob);
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(5, sqldate);
            ps.setString(6, disease);
            ps.setString(7, status);
            ps.setString(8, pContact);
            ps.setString(9, address);
            ps.setString(10, pId);
            i = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    public static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public static Patient loginPatient(String email, String pass) {
        Patient s = null;
        try {

            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select PatientID,PatientName,PEmail,PPassword,PGender,DDOB,Disease,Status,Contact,PAddress,filename,savepath from Patient where PEmail=? and PPassword=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pEmail = rs.getString(3);
                String password = rs.getString(4);
                String gender = rs.getString(5);
                java.sql.Date dob = rs.getDate(6);
                String disease = rs.getString(7);
                String status = rs.getString(8);
                String contact = rs.getString(9);
                String address = rs.getString(10);
                String filename = rs.getString(11);
                String savepath = rs.getString(12);
                s = new Patient(id, name, pEmail, password, gender, dob, disease, status, contact, address, filename, savepath);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }

    public static Patient getPatientById(String pId) {
        Patient s = null;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select PatientID,PatientName,PEmail,PPassword,PGender,DDOB,Disease,Status,Contact,PAddress,filename,savepath from Patient where PatientID=?");
            ps.setString(1, pId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String dEmail = rs.getString(3);
                String password = rs.getString(4);
                String gender = rs.getString(5);
                java.sql.Date dob = rs.getDate(6);
                String disease = rs.getString(7);
                String status = rs.getString(8);
                String contact = rs.getString(9);
                String address = rs.getString(10);
                String filename = rs.getString(11);
                String savepath = rs.getString(12);
                s = new Patient(id, name, dEmail, password, gender, dob, disease, status, contact, address, filename, savepath);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        //  updatePatient("PT_002", "Ha", "Ha@123.gmail.com", "1234", "Female", "1997-9-8", "AIDS", "Help me!!", "19009086863", "Hoa Hai,Ngu Hanh");
        //      insertPatient("", "Vu Hoang Minh", "Minhxauxi@gmai.com", "1234", "Male", "1932-8-9", "Dau Lung", "", "19998772", "Nguyen Dinh Hien","dfdsf","sdfsdfsf");
        //  Patient k = loginPatient("Ha@123.gmail.com", "1234");
        // System.out.println(k.getDOB());
        //deletePatient("PT_003");
           Patient s=getPatientById("PT_001");
           System.out.println(s.getpAddress());
        //    List<Patient> pList = listPatient();
        // for (int i = 0; i < pList.size(); i++) {
        //      System.out.println(pList.get(i).getpId() + " " + pList.get(i).getpName() + "  " + pList.get(i).getRoomType());
        // }
        //  List<Patient> pkq = searchPatient(p -> ((Patient) p).getpName().contains("H"));
        //  for (int i = 0; i < pkq.size(); i++) {
        //      System.out.println(pkq.get(i).getpName() + "  " + pkq.get(i).getpContact() + "  " + pkq.get(i).getpGender());
        //  }
    }
}
