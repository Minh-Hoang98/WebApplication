package Model;

import DB.getConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author OS
 */
public class Doctor implements Serializable {

    private String dId;
    private String dName;
    private String dEmail;
    private String dPassword;
    private String dGender;
    private Date DOB;
    public String degree;
    public String department;
    //  public float fee;
    public String dContact;
    public String dAddress;
    public Date registerdate;
    private String filename;
    private String savepath;

    public Doctor() {
    }

    public Doctor(String dId, String dName, String dEmail, String dPassword, String dGender, Date DOB, String degree, String department, String dContact, String dAddress, Date registerdate, String filename, String savepath) {
        this.dId = dId;
        this.dName = dName;
        this.dEmail = dEmail;
        this.dPassword = dPassword;
        this.dGender = dGender;
        this.DOB = DOB;
        this.degree = degree;
        this.department = department;
        //   this.fee = fee;
        this.dContact = dContact;
        this.dAddress = dAddress;
        this.registerdate = registerdate;
        this.filename = filename;
        this.savepath = savepath;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdEmail() {
        return dEmail;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

    public String getdPassword() {
        return dPassword;
    }

    public void setdPassword(String dPassword) {
        this.dPassword = dPassword;
    }

    public String getdGender() {
        return dGender;
    }

    public void setdGender(String dGender) {
        this.dGender = dGender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

//    public float getFee() {
//        return fee;
//    }
//    
//    public void setFee(float fee) {
//        this.fee = fee;
//    }
    public String getdContact() {
        return dContact;
    }

    public void setdContact(String dContact) {
        this.dContact = dContact;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    //getListDoctor
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Doctor s = new Doctor();
        List<Doctor> dList = s.getAllDoctor();
        for (int i = 0; i < dList.size(); i++) {
            System.out.println(dList.get(i).getdName() + "  " + dList.get(i).getDOB() + "  " + dList.get(i).getRegisterdate());
        }
    }
}
