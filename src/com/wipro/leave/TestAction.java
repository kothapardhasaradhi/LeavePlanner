package com.wipro.leave;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport { 
	
	private final static String SUCCESS = "success";

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String method1 = request.getParameter("method");
    	Leavescheduler leavescheduler=new Leavescheduler();
    	Leavescheduler.setMethod(method1);

		String empid1 = request.getParameter("empId");
		String empname1 = request.getParameter("empName");
		String fromdate1 = request.getParameter("fromDate");
	String todate1 = request.getParameter("toDate");
	String backupRes1=request.getParameter("backupres");

	String oldfromdate = request.getParameter("oldfromdate");
	System.out.println(backupRes1);
	Leavescheduler.setEmpid(empid1);
	Leavescheduler.setEmpname(empname1);
	Leavescheduler.setFromdate(fromdate1);
	Leavescheduler.setTodate(todate1);
	Leavescheduler.setBackupres(backupRes1);
	Leavescheduler.setOldfromdate(oldfromdate);
		return SUCCESS;

	}
}


