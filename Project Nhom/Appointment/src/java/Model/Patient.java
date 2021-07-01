package Model;

import DB.getConnection;
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
public class Patient {

    private String pId;
    private String pName;
    private String pEmail;
    private String pPassword;
    private String pGender;
    private Date DOB;
    private String disease;
    private String status;
    private String pContact;
    private String pAddress;
    private String filename;
    private String savepath;

    public Patient() {
    }

    public Patient(String pId, String pName, String pEmail, String pPassword, String pGender, Date DOB, String disease, String status, String pContact, String pAddress, String filename, String savepath) {
        this.pId = pId;
        this.pName = pName;
        this.pEmail = pEmail;
        this.pPassword = pPassword;
        this.pGender = pGender;
        this.DOB = DOB;
        this.disease = disease;
        this.status = status;
        this.pContact = pContact;
        this.pAddress = pAddress;
        this.filename = filename;
        this.savepath = savepath;
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

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getpPassword() {
        return pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public String getpGender() {
        return pGender;
    }

    public void setpGender(String pGender) {
        this.pGender = pGender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getpContact() {
        return pContact;
    }

    public void setpContact(String pContact) {
        this.pContact = pContact;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
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


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Patient s = new Patient();
        List<Patient> k = s.getAllPatient();
        for (int i = 0; i < k.size(); i++) {
            System.out.println(k.get(i).getpName() + "  " + k.get(i).getDOB() + "  " + k.get(i).getpAddress());
        }
    }
}
