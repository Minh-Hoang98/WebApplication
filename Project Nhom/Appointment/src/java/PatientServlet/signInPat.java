/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author h
 */
@MultipartConfig(fileSizeThreshold = 2048 * 2048 * 4, maxFileSize = 2048 * 2048 * 20, maxRequestSize = 2048 * 2048 * 100)
public class signInPat extends HttpServlet {

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
         try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            String disease = request.getParameter("disease");
            String status = request.getParameter("status");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");
            
            Part part = request.getPart("file");
            String filename = DB.DBPatient.extractFileName(part);
            String savepath = "C:\\Users\\Administration\\Documents\\NetBeansProjects\\Appointment\\web\\avatarPat" + File.separator + filename;
            File fileSaveDir = new File(savepath);
            part.write(savepath + File.separator);
            
            int i = DB.DBPatient.insertPatient("", name, email, password, gender, dob, disease, status, contact, address, filename, savepath);
            if (i > 0) {
                request.setAttribute("signInPatSuccess", "Register Successful");
                request.getRequestDispatcher("homePage.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("signInPat.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
