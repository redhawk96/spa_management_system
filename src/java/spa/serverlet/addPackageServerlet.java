/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spa.serverlet;

import spa.Package;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addPackageServerlet", urlPatterns = { "/addPackageServerlet" })
public class addPackageServerlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			String client_id = request.getParameter("client_id");
			String spa_category = request.getParameter("spa_category");
			String spa_package = request.getParameter("spa_package");
			String price = request.getParameter("price");
			Double new_Price = Double.parseDouble(price);
			
			Package pack = new Package();
			
			try {
				
				int result = pack.addPackage(client_id, spa_category, spa_package, new_Price);
				
				if(result == 1) {
            		request.getSession().setAttribute("message_color", "alert-success");
            		request.getSession().setAttribute("message", "Package successfuly added !");
            	}else {
            		request.getSession().setAttribute("message_color", "alert-danger");
            		request.getSession().setAttribute("message", "Error is adding Package !");
            	}
            	
            	response.sendRedirect(request.getContextPath()+"/Spa/Admin/ViewSpa.jsp");
            	
            }catch(Exception e) {
            	request.getSession().setAttribute("message_color", "alert-danger");
            	request.getSession().setAttribute("message", "Error is adding Package !");
            	response.sendRedirect(request.getContextPath()+"/Spa/Admin/ViewSpa.jsp");
            }
			

		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
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
