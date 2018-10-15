package com.wipro.leave;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.sevices.LeaveServices;
/**
 * 
 * @author NA391766
 *This class is for Employee Backup Resource list
 */
public class BackupResources  extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private final static String SUCCESS = "success";
	
	
	public String execute()throws Exception 
	{
		
	LeaveServices leaveService = new LeaveServices();
	leaveService.backup();
	Leavescheduler.setEmpNameList(LeaveVO.getEmpNameList());
	
	return "TTT";
	
}}
