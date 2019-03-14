/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spa.serverlet;

import spa.Authenticate;
import spa.Client;

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

@WebServlet(name = "viewSpaServerlet", urlPatterns = { "/viewSpaServerlet" })
public class viewSpaServerlet extends HttpServlet {

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
		
			String cid = request.getParameter("cid");
			
			Client client = new Client();
			
			try {
				
				ResultSet res = client.displayClient(cid);
				
				
				while(res.next()) {
					request.getSession().setAttribute("cId", res.getString("client_id"));
					request.getSession().setAttribute("cFname", res.getString("first_name"));
					request.getSession().setAttribute("cLname", res.getString("last_name"));
					request.getSession().setAttribute("cNic", res.getString("nic"));
					request.getSession().setAttribute("cContact", res.getString("contact_no"));
					request.getSession().setAttribute("cEmail", res.getString("email"));
					request.getSession().setAttribute("cSname", res.getString("spa_name"));
					request.getSession().setAttribute("cSaddress", res.getString("spa_address"));
					request.getSession().setAttribute("cScontact", res.getString("spa_contact"));
					request.getSession().setAttribute("cSimage", res.getString("spa_image"));
					
				}
				
				response.sendRedirect(request.getContextPath()+"/Spa/Admin/ViewSpa.jsp");

				
			}catch(Exception e) {
				out.println(e);
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
