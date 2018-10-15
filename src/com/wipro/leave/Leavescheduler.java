
package com.wipro.leave;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.wipro.leave.LeaveVO;
import com.wipro.sevices.LeaveServices;
import com.wipro.util.StringUtil;

public class Leavescheduler extends ActionSupport {

	final static Logger log = Logger.getLogger(Leavescheduler.class.getName());
	static final long serialVersionUID = 1L;
	private static List<LeaveVO> duplicateList;
	private static List<LeaveVO> empNameList;
	private static String fromdate;
	private static String todate;
	private static String method;
	private static int pageNumber;
	private int rid;
	private static String backupres;

	private static String oldfromdate;
	private static String leavetype;
	
	public static String getLeavetype() {
		return leavetype;
	}
	public static void setLeavetype(String leavetype) {
		Leavescheduler.leavetype = leavetype;
	}
	public static String getOldfromdate() {
		return oldfromdate;
	}
	public static void setOldfromdate(String oldfromdate) {
		Leavescheduler.oldfromdate = oldfromdate;
	}

	public static List<LeaveVO> listVO;

	 /**
	  * 
	  * @return empNameList
	  */
	 
	 public static List<LeaveVO> getEmpNameList() {
		return empNameList;
	}
/**
 * 
 * @param empNameList the empNameList to be set
 */
	public static void setEmpNameList(List<LeaveVO> empNameList) {
		Leavescheduler.empNameList = empNameList;
	}

	/**
	 * 
	 * @return backupres
	 */

		
	public static String getBackupres() {
		return backupres;
	}
/**
 * 
 * @param backupres the backup resource to be set
 */
	public static void setBackupres(String backupres) {
		Leavescheduler.backupres = backupres;
	}
/**
 * 
 * @return pageNumber
 */
	

	public static int getPageNumber() {
		return pageNumber;
	}
/**
 * 
 * @param pageNumber the pageNumber to set
 */
	public static void setPageNumber(int pageNumber) {
		Leavescheduler.pageNumber = pageNumber;
	}
/**
 * 
 * @return duplicateList
 */
	public static List<LeaveVO> getDuplicateList() {
		return duplicateList;
	}
	/**
	 * 
	 * @param duplicateList the duplicateList to set
	 */
	public static void setDuplicateList(List<LeaveVO> duplicateList) {
		Leavescheduler.duplicateList = duplicateList;
	}

	
	

	/**
	 * @return the current rid
	 */
	public int getRid() {
		return rid;
	}

	/**
	 * @param rid
	 *            the rid to set
	 */
	public void setRid(int rid) {
		this.rid = rid;
	}

	private static String empid;
	private static String empname;
	/**
	 * 
	 * @return the current employee id
	 */
	public static String getEmpid() {
		return empid;
	}
	/**
	 * 
	 * @param empid is the new employee id to be set
	 */
	public static void setEmpid(String empid) {
		Leavescheduler.empid = empid;
	}

	/**
	 * 
	 * @return the current employee name
	 */
	public static String getEmpname() {
		return empname;
	}
	/**
	 * 
	 * @param empname is the new employee name to be set
	 */
	public static void setEmpname(String empname) {
		Leavescheduler.empname = empname;
	}
	/**
	 * 
	 * @return the current from date
	 */
	public static String getFromdate() {
		return fromdate;
	}
	/**
	 * 
	 * @param fromdate is the new from date value to be set
	 */
	public static void setFromdate(String fromdate) {
		Leavescheduler.fromdate = fromdate;
	}
	/**
	 * 
	 * @return the current to date value
	 */
	public static String getTodate() {
		return todate;
	}
	/**
	 * 
	 * @param todate the new to date to be set
	 */
	public static void setTodate(String todate) {
		Leavescheduler.todate = todate;
	}


	public static String getMethod() {
		return method;
	}

	public static void setMethod(String methoddd) {
		method = methoddd;
	}

	private boolean existsBefore;

	public boolean isExistsBefore() {
		return existsBefore;
	}

	public void setExistsBefore(boolean existsBefore) {
		this.existsBefore = existsBefore;
	}



	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
	
		
		
		LeaveVO leaveDetailsVo = new LeaveVO();
	
		LeaveServices leaveService = new LeaveServices();
	
		if ("null".equalsIgnoreCase(method))  {
          
			String fromdate1 = request.getParameter("fromdate");
			String todate1 = request.getParameter("todate");
		
			String empname1 = request.getParameter("empname");
			listVO = new ArrayList<LeaveVO>();
			
	
			leaveDetailsVo.setFromdate(StringUtil.notNull(fromdate1));
			leaveDetailsVo.setTodate(StringUtil.notNull(todate1));
			leaveDetailsVo.setEmpname(StringUtil.notNull(empname1));
			
			if(leaveService.getLeaves(leaveDetailsVo)){
			duplicateList = LeaveVO.getListVO();}
			else {return FAILURE;}
		
			
			
	
			
		}
		else if (method == "delete" || method.equalsIgnoreCase("delete"))
		{
			Leavescheduler lsa = new Leavescheduler();
			Leavescheduler leaveDetailsForm = new Leavescheduler();
	    
	    	
	    	leaveDetailsVo.setEmpid(Leavescheduler.getEmpid());
	    	
		   	leaveDetailsVo.setEmpid(empid);
		   	leaveDetailsVo.setEmpname(empname);
		   	leaveDetailsVo.setFromdate(fromdate);
		   	leaveDetailsVo.setTodate(todate);
			leaveDetailsVo.setBackupres(backupres);
			leaveDetailsVo.setLeavetype(leavetype);
	    	leaveService.deleteLeave(leaveDetailsVo);
	    	
	    	 
	    	 listVO=LeaveVO.getListVO();
	    	 method="first";
	    	 duplicateList = LeaveVO.getListVO();
	     
	     
		}
		else if (method == "update" || method.equalsIgnoreCase("update"))
		{
		Leavescheduler lsa = new Leavescheduler();
		Leavescheduler leaveDetailsForm = new Leavescheduler();
	  
 
leaveDetailsVo.setEmpid(empid);
leaveDetailsVo.setEmpname(empname);
leaveDetailsVo.setFromdate(fromdate);
leaveDetailsVo.setTodate(todate);
leaveDetailsVo.setBackupres(backupres); 
leaveDetailsVo.setOldfromdate(oldfromdate);
leaveDetailsVo.setLeavetype(leavetype);
	leaveService.updateLeave(leaveDetailsVo);
	
	 
	 listVO=LeaveVO.getListVO();
	 method="first";
	 duplicateList = LeaveVO.getListVO();
	}
		// listVO = LeaveVO.getListVO();
		leaveDetailsVo.setMethod(method);
		leaveDetailsVo.setDuplicateList(duplicateList);
		leaveDetailsVo.setPageNumber(pageNumber);
		
		boolean check = leaveService.getLeavesPagination(leaveDetailsVo);
		
		if (check) {
			pageNumber = leaveDetailsVo.getPageNumber();
			listVO = LeaveVO.getListVO();
		}
	
		return SUCCESS;

	}

	/**
	 * @return the listVO
	 */
	public static List<LeaveVO> getListVO() {
		return listVO;
	}

	/**
	 * @param listVO
	 *            the listVO to set
	 */
	public static void setListVO(List<LeaveVO> listVO) {
		Leavescheduler.listVO = listVO;
	}
}
