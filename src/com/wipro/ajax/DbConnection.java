/**
 * 
 */
/**
 * @author NA391766
 *
 */
package com.wipro.ajax;
import com.wipro.leave.*;
import com.wipro.util.StringUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/**
 * Servlet implementation class Dbconnection
 */

public class DbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger log = Logger.getLogger(DbConn.class.getName());  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String empid = request.getParameter("search").toString(); 
	        System.out.println(empid);
	       
	        String buff1 = "";
	        String  buff2  ="";
	        PreparedStatement psmt = null;
	        try {  
	       
	         Connection conn = DbConn.connect();
	         psmt = conn.prepareStatement("select Emp_First_Name,Emp_Last_Name from EMP_DETAILS where Emp_Id=?" );
	         psmt.setString(1, empid);
             ResultSet rs = psmt.executeQuery();
	         
             String empName ="";
           
	         if (rs.next()) {  
	     /*     empName = rs.getString("EMPNAME");*/
	      empName=StringUtil.notNull(
					rs.getString("Emp_First_Name")).concat(" ").concat(
					StringUtil.notNull(rs.getString("Emp_Last_Name")));
	         response.setContentType("text/plain");
	 		response.getWriter().write(empName);

	         }
	       } catch (Exception exp) { 
	    	   log.error(exp);
	    
	       } 
	}
}
