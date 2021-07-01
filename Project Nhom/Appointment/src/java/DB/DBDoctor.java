/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author OS
 */
public class DBDoctor {

    //getListDoctor
    public static List<Doctor> getAllDoctor() {
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

    //Insert Doctor
    public static int insertDoctor(String dId, String dName, String dEmail, String dPassword, String gender, String dob, String degree, String department,
            String dContact, String dAddress, String registerDate, String filename, String savepath) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareCall("Insert into Doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, dId);
            ps.setString(2, dName);
            ps.setString(3, dEmail);
            ps.setString(4, dPassword);
            ps.setString(5, gender);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simple.parse(dob);
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(6, sqldate);
            ps.setString(7, degree);
            ps.setString(8, department);
            // ps.setFloat(9, fee);
            ps.setString(9, dContact);
            ps.setString(10, dAddress);
            ps.setString(11, registerDate);
            ps.setString(12, filename);
            ps.setString(13, savepath);
            i = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    //update Doctor
    public static int updateDoctor(String dId, String dName, String dEmail, String dPassword, String gender, String dob, String degree, String department,
            String dContact, String dAddress, String registerDate) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareCall("Update Doctor set DoctorName=?,DEmail=?,DPassword=?,DGender=?,DDOB=?,Degree=?,Department=?,DContact=?,DAddress=?,DRegisterDate=? where DoctorID=?");
            ps.setString(1, dName);
            ps.setString(2, dEmail);
            ps.setString(3, dPassword);
            ps.setString(4, gender);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simple.parse(dob);
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(5, sqldate);
            ps.setString(6, degree);
            ps.setString(7, department);
//        ps.setFloat(8, fee);
            ps.setString(8, dContact);
            ps.setString(9, dAddress);
            ps.setString(10, registerDate);
            ps.setString(11, dId);
            i = ps.executeUpdate();
            ps.close();
            conn.close();
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

//find Doctor by email and password
    public static Doctor loginDoctor(String email, String pass) {
        Doctor s = null;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select DoctorID,DoctorName,DEmail,DPassword,DGender,DDOB,Degree,Department,DContact,DAddress,DRegisterDate,filename,savepath from Doctor where DEmail=? and DPassword=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String emailD = rs.getString(3);
                String password = rs.getString(4);
                String gender = rs.getString(5);
                java.sql.Date dob = rs.getDate(6);
                String degree = rs.getString(7);
                String department = rs.getString(8);
                //  float fee = rs.getFloat(9);
                String contact = rs.getString(9);
                String address = rs.getString(10);
                java.sql.Date registerdate = rs.getDate(11);
                String filename = rs.getString(12);
                String savepath = rs.getString(13);
                s = new Doctor(id, name, email, password, gender, dob, degree, department, contact, address, registerdate, filename, savepath);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }
//Find Doctor by Id

    public static Doctor getDoctorById(String dId) {
            Doctor s = null;
        try { 
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select DoctorID,DoctorName,DEmail,DPassword,DGender,DDOB,Degree,Department,DContact,DAddress,DRegisterDate,filename,savepath from Doctor where DoctorID=?");
            ps.setString(1, dId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String gender = rs.getString(5);
                java.sql.Date dob = rs.getDate(6);
                String degree = rs.getString(7);
                String department = rs.getString(8);
                // float fee = rs.getFloat(9);
                String contact = rs.getString(9);
                String address = rs.getString(10);
                java.sql.Date registerdate = rs.getDate(11);
                String filename = rs.getString(12);
                String savepath = rs.getString(13);
                s = new Doctor(id, name, email, password, gender, dob, degree, department, contact, address, registerdate, filename, savepath);
            }
           
        } catch (Exception ex) {
         ex.printStackTrace();
        }
         return s;
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        //  insertDoctor("", "Manh Cuong", "cuong@123", "1234", "Male", "9-8-1998", "Other", "Breast screening", "0979723150", "Ngu Hanh Son", "2019/10/20", "", "");
        //     updateDoctor("DT_001", "Minh", "Tuan@gmail", "1234", "Male", "1998-7-8", "MBA", "Breast screening  ", "0909097877", "HaiChau", "1990/9/8");
        // deleteDoctor("DT_004");
        //loginDoc
        // Doctor s = loginDoctor("Tuan@gmail", "1234");
        // System.out.println(s.getdName());
        //   getDoctorByID
//          Doctor k = getDoctorById("DT_001");
//            System.out.println(k.getdName());
        //  List<Doctor> kq = search(p -> ((Doctor) p).getGender().equals("F"));
        //  for (int i = 0; i < kq.size(); i++) {
        //     System.out.println(kq.get(i).getdId() + "  " + kq.get(i).getAge() + "  " + kq.get(i).getDepartment() + "  " + kq.get(i).getGender() + "  " + kq.get(i).getRegisterdate());
        // }
        //      Doctor s = loginDoctor("Tuan@gmail", "Phuong123");
        //    System.out.println(s.getFee() + "/n/n");
        //     Doctor k = getDoctorById("DT_001");
        //    System.out.println(k.getdName());
//        Date d = new Date(System.currentTimeMillis());
//        System.out.print(d);
//        SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
//        Date dateS = simple.parse("08/08/2019");
//        System.out.println(dateS);
//        Date date = new Date();
//        System.out.println(date); //2016/11/16 12:08:43
//        System.out.println(date.compareTo(dateS));
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    }
}
