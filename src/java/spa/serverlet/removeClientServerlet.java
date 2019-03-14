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

@WebServlet(name = "removeClientServerlet", urlPatterns = {"/removeClientServerlet"})
public class removeClientServerlet extends HttpServlet {

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
            
            String client_id = request.getParameter("cid");
            
            Client client = new Client();
            
            
            try {
            	
            	int result = client.removeClient(client_id);
            	
            	if(result == 1) {
            		request.getSession().setAttribute("message_color", "alert-success");
            		request.getSession().setAttribute("message", "Client successfuly removed !");
            	}else {
            		request.getSession().setAttribute("message_color", "alert-danger");
            		request.getSession().setAttribute("message", "Error is removing client !");
            	}
            	
            	response.sendRedirect(request.getContextPath()+"/Spa/Admin/Clientele.jsp");
            	
            }catch(Exception e) {
            	request.getSession().setAttribute("message_color", "alert-danger");
            	request.getSession().setAttribute("message", "Error is removed client !");
            	response.sendRedirect(request.getContextPath()+"/Spa/Admin/Clientele.jsp");
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
