/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DBAppointment.getAllAppointment;
import static DB.DBDoctor.getAllDoctor;
import static DB.DBPatient.getAllPatient;
import Model.Appointment;
import Model.Doctor;
import Model.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author h
 */
public class DBAdmin {

    private static final String DELETEApp = "Delete from Appointment where DoctorID=? and PatientID=?";

    //Search Doctor
    public static List<Doctor> searchDoctor(Predicate p) {
        List<Doctor> list = getAllDoctor();
        List<Doctor> kq = new ArrayList<Doctor>();
        for (Doctor s : list) {
            if (p.test(s)) {
                kq.add(s);
            }
        }
        return kq;
    }

    //Delete Doctor
    public static int deleteDoctor(String dId) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection.getSQLConnection();
        PreparedStatement ps = conn.prepareCall("Delete from Doctor where DoctorID=?");
        ps.setString(1, dId);
        int i = ps.executeUpdate();
        ps.close();
        conn.close();
        return i;
    }

    //search Patient
    public static List<Patient> searchPatient(Predicate p) {
        List<Patient> list = getAllPatient();
        List<Patient> kq = new ArrayList<>();
        for (Patient s : list) {
            if (p.test(s)) {
                kq.add(s);
            }
        }
        return kq;
    }

    //delete Patient
    public static int deletePatient(String pId) {
        int i = 0;
        try {
            Connection conn = getConnection.getSQLConnection();
            PreparedStatement ps = conn.prepareCall("Delete from Patient where PatientID=?");
            ps.setString(1, pId);
            i = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    //search Appointment
    public static List<Appointment> searchAppointment(Predicate p) {
        List<Appointment> kq = new ArrayList<Appointment>();
        try {
            List<Appointment> list = getAllAppointment();

            for (Appointment s : list) {
                if (p.test(s)) {
                    kq.add(s);
                }
            }         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
          return kq;
    }

    //Delete Appointment
    public static int deleteAppointment(String dId, String pId) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection.getSQLConnection();
        PreparedStatement ps = conn.prepareStatement(DELETEApp);
        ps.setString(1, dId);
        ps.setString(2, pId);
        int i = ps.executeUpdate();
        ps.close();
        conn.close();
        return i;
    }
}
