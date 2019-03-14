/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import spa.Connect;


@WebServlet(name = "clientele_report", urlPatterns = {"/clientele_report"})
public class clientele_report extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            try{
           
            	SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
            	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	//          String current_date = request.getParameter("current_date");
	//          String report_name = request.getParameter("report_name");
	            String current_date = "2018-12-13";
	            Date ymd = yyyyMMdd.parse(current_date);
	            String monthYearFormat = sdf.format(ymd);
	            String full_date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	            
	            
	            if (Connect.getInstance() != null) {

	    			Connection con = Connect.getConnction();
	    			Statement st = con.createStatement();
	            
	    			String query = "SELECT first_name, last_name, contact_no, spa_name FROM spa_clients";
	                
	                String reportPath = "C:\\Users\\Dell\\eclipse-workspace\\TM\\WebContent\\Spa\\Admin\\Reports\\client_report_template.jrxml";
	                Map<String, Object> parameters = new HashMap<String, Object>();
	                parameters.put("month_year", monthYearFormat);
	                parameters.put("date", current_date);
	                parameters.put("full_date_format", full_date_format);
	                
	                //loading the design from the file path
	                JasperDesign jasperDesign = JRXmlLoader.load(reportPath);

	                //Designing the query for the report
	                JRDesignQuery newQuery = new JRDesignQuery();

	                //setting the query text
	                newQuery.setText(query);
	                
	                //seeting the query for the report design
	                jasperDesign.setQuery(newQuery);
	                
	                //compile the jasper report for the design
	                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
	                
	                //creating a JasperPrint object to fill the report
	                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
	                
	                //JasperViewer.viewReport(jasperPrint);
	                JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Dell\\eclipse-workspace\\TM\\WebContent\\Spa\\Admin\\Reports\\NewReport.pdf");
	                
	                response.sendRedirect(request.getContextPath()+"/Spa/Admin/index.jsp");

	                
	            }else {
	            	out.println("Error in establishing connection to the database");
	            }      
                
            }catch(Exception e){
                out.println(e);
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
