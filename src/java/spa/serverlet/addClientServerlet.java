/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spa.serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spa.Client;

@WebServlet(name = "addClientServerlet", urlPatterns = {"/addClientServerlet"})
public class addClientServerlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String nic = request.getParameter("nic");
            String contact = request.getParameter("contact_number");
//          Integer contact_number = Integer.parseInt(contact);
            String email = request.getParameter("email");
            String spa_name = request.getParameter("spa_name");
            String spa_address = request.getParameter("spa_address");
            String spa_contact = request.getParameter("spa_contact");
            String spa_image = request.getParameter("spa_image");
            String username = request.getParameter("user_name");
            String password = request.getParameter("password");
            
            Client client = new Client();
            
            
            try {
            	
            	int result = client.addClient(first_name, last_name, nic, contact, email, spa_name, spa_address, spa_contact, spa_image, username, password);
            	
            	if(result == 1) {
            		request.getSession().setAttribute("message_color", "alert-success");
            		request.getSession().setAttribute("message", "Client successfuly added !");
            	}else {
            		request.getSession().setAttribute("message_color", "alert-danger");
            		request.getSession().setAttribute("message", "Error is adding client !");
            	}
            	
            	response.sendRedirect(request.getContextPath()+"/Spa/Admin/AddClient.jsp");
            	
            }catch(Exception e) {
            	request.getSession().setAttribute("message_color", "alert-danger");
            	request.getSession().setAttribute("message", "Error is adding client !");
            	response.sendRedirect(request.getContextPath()+"/Spa/Admin/AddClient.jsp");
            }
            
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
