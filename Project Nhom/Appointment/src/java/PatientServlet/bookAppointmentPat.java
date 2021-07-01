/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author h
 */
public class bookAppointmentPat extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dId = request.getParameter("dId");
        String pId = request.getParameter("pId");
        //khi bệnh nhân đã đặt lịch 1 bác sĩ rồi thì trong quá trình chờ đợi k đưọc đặt lại để tránh spam quá nhiều cuộc hẹn
        if (DB.DBAppointment.getAppointmentToEdit(dId, pId) == null) {
            request.setAttribute("docAppointment", DB.DBDoctor.getDoctorById(dId));
            request.setAttribute("patAppointment", DB.DBPatient.getPatientById(pId));
            request.getRequestDispatcher("bookAppointmentPat.jsp").forward(request, response);
        } else {
            request.setAttribute("BK", "You booked this Doctor.Please waiting for Doctor respond.");
            request.getRequestDispatcher("listDoctorInPatient.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pId = request.getParameter("pId");
        String pName = request.getParameter("pName");
        String dId = request.getParameter("dId");
        String dName = request.getParameter("dName");
        String department = request.getParameter("department");

        String roomtype = request.getParameter("roomtype");
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime");
        String message = request.getParameter("message");
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
//            if (simple.parse(appointmentDate).compareTo(new Date()) >= 1) {
        int i = DB.DBAppointment.insertAppointment(pId, pName, dId, dName, department, roomtype, appointmentDate, appointmentTime, message);
        if (i > 0) {
            request.setAttribute("bookSuccess", "Booked success.Please waiting for Doctor`s respond.");
            request.getRequestDispatcher("homePat.jsp").forward(request, response);
        } else {
            request.setAttribute("bookFail", "Book Appointment Fail.");
            request.getRequestDispatcher("bookAppointmentPat").forward(request, response);
        }
//            } else {
//                request.setAttribute("DateAppFail", "Đặt Lịch là tương lai ông ơi!!WTF???? Xem lại hộ cái.");
//                request.getRequestDispatcher("bookAppointmentPat").forward(request, response);
//            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
