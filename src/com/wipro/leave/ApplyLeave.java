
/** This class implements an application that takes user input to apply leave
 * @author NA391766
 *
 */
package com.wipro.leave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.wipro.sevices.*;
import com.wipro.leave.*;
import com.wipro.leave.Leavescheduler;
import com.wipro.leave.LeaveVO;
import com.wipro.leave.DbConn;

public class ApplyLeave{
	final static Logger log = Logger.getLogger(ApplyLeave.class.getName());
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
	private String empid;
	private String empname;
	private String fromdate;
	private String todate;
	private String backupres;
	private String leavetype;
	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	/**
	 * Backup Resource name
	 * @return current backupres's name
	 */
	public String getBackupres() {
		return backupres;
	}
	/**
	 * This is a setter which sets the backup resource
	 * @param backupres the backup resource to be set
	 */
	public void setBackupres(String backupres) {
		this.backupres = backupres;
	}
	/**
	 * 
	 * @return the current employee id
	 */
	public String getEmpid() {return empid;}
	/**
	 * 
	 * @param empid is the new employee id to be set
	 */
	public void setEmpid(String empid) {this.empid = empid;}
/**
 * 
 * @return the current employee name
 */
	public String getEmpname() {return empname;}
	/**
	 * 
	 * @param empname is the new employee name to be set
	 */
    public void setEmpname(String empname) {this.empname = empname;}
/**
 * 
 * @return the current from date
 */
	public String getFromdate() {return fromdate;}
	/**
	 * 
	 * @param fromdate is the new from date value to be set
	 */
	public void setFromdate(String fromdate) {this.fromdate = fromdate;}
/**
 * 
 * @return the current to date value
 */
	public String getTodate() {return todate;}
	/**
	 * 
	 * @param todate the new to date to be set
	 */
	public void setTodate(String todate) {this.todate = todate;}

/**
 * This method is used to set the form variables with the input variables as well as for retrieving the applied leave data  
 * @return it returns the apply leave form values as output
 * @throws SQLException
 */

	public String execute() throws SQLException
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String Empid=request.getParameter("empid");
    	String Empname=request.getParameter("empname");
     	String Fromdate=request.getParameter("fromdate");
    	String Todate=request.getParameter("todate");
    	String Leavetype=request.getParameter("leavetype");
    	String backupRes1=request.getParameter("backupres");
  
     	Leavescheduler leaveDetailsForm = new Leavescheduler();
    	LeaveVO leaveDetailsVo = new LeaveVO();
    	
    	leaveDetailsVo.setEmpid(Empid);
    	leaveDetailsVo.setEmpname(Empname);
        leaveDetailsVo.setFromdate(Fromdate);
    	leaveDetailsVo.setTodate(Todate);
    	leaveDetailsVo.setLeavetype(Leavetype);
    	leaveDetailsVo.setBackupres(backupRes1);
    	LeaveServices leaveService = new LeaveServices();
    	
    	boolean existsBefore=leaveService.detailsExists(leaveDetailsVo);
    	/**
    	 * checks if the same application is previously submitted
    	 */
    	if(existsBefore)
    	{
    		   return FAILURE;
    	}
    	
    	leaveService.applyLeave(leaveDetailsVo);
    	leaveDetailsForm.setListVO(leaveDetailsVo.getListVO());

         return SUCCESS;}
}