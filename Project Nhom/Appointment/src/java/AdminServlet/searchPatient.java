/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminServlet;

import Model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class searchPatient extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException{
       String attribute = request.getParameter("attribute");
        String value = request.getParameter("value");
        if (attribute.equals("ID")) {
            List<Patient> kq = DB.DBAdmin.searchPatient(p -> ((Patient) p).getpId().contains(value));
            request.setAttribute("listPatientSearch", kq);
        } else if (attribute.equals("Name")) {
            List<Patient> kq = DB.DBAdmin.searchPatient(p -> ((Patient) p).getpName().contains(value));
            request.setAttribute("listPatientSearch", kq);
        } else if (attribute.equals("Gender")) {
            List<Patient> kq = DB.DBAdmin.searchPatient(p -> ((Patient) p).getpGender().contains(value));
            request.setAttribute("listPatientSearch", kq);
        } else if (attribute.equals("DOB")) {
            //   SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-");
            List<Patient> kq = DB.DBAdmin.searchPatient(p -> ((Patient) p).getDOB().toString().contains(value));
            request.setAttribute("listPatientSearch", kq);
        } else if (attribute.equals("Disease")) {
            List<Patient> kq = DB.DBAdmin.searchPatient(p -> ((Patient) p).getDisease().contains(value));
            request.setAttribute("listPatientSearch", kq);
        } else {
            System.out.println("Error");
        }
        request.getRequestDispatcher("searchPatientAdm.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
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
