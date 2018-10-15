package com.wipro.leave;

import java.util.ArrayList;
import java.util.List;



public class LeaveVO {
	static final long serialVersionUID = 1L;
	private String empid;
	private String empname;
	private String fromdate;
	private String todate;
	private static String ei;
	private String test;
	private static String oldfromdate;
	private String leavetype;
	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	
	public static String getOldfromdate() {
		return oldfromdate;
	}
	public static void setOldfromdate(String oldfromdate) {
		LeaveVO.oldfromdate = oldfromdate;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	private static List<LeaveVO> duplicateList;
	 private static List<LeaveVO> empNameList;
	 public static List<LeaveVO> getEmpNameList() {
		return empNameList;
	}
	public static void setEmpNameList(List<LeaveVO> empNameList) {
		LeaveVO.empNameList = empNameList;
	}
	private static int pageNumber;
	 private String backupres;
	
	public static int getPageNumber() {
		return pageNumber;
	}
	public String getBackupres() {
		return backupres;
	}
	public void setBackupres(String backupres) {
		this.backupres = backupres;
	}
	public static void setPageNumber(int pageNumber) {
		LeaveVO.pageNumber = pageNumber;
	}
	public static String getMethod() {
		return method;
	}
	public static void setMethod(String method) {
		LeaveVO.method = method;
	}
	private static String method;
	
	
	public static List<LeaveVO> getDuplicateList() {
		return duplicateList;
	}
	public static void setDuplicateList(List<LeaveVO> duplicateList) {
		LeaveVO.duplicateList = duplicateList;
	}
	/**
	 * @return the ei
	 */
	public static String getEi() {
		return ei;
	}
	/**
	 * @param ei the ei to set
	 */
	public static void setEi(String ei) {
		LeaveVO.ei = ei;
	}
	public static List<LeaveVO> listVO ;
	

	
	/**
	 * @param listVO the listVO to set
	 */
	/**
	 * @return the empid
	 */
	public String getEmpid() {
		return empid;
	}
	/**
	 * @return the listVO
	 */
	public static List<LeaveVO> getListVO() {
		return listVO;
	}
	/**
	 * @param listVO the listVO to set
	 */
	public static void setListVO(List<LeaveVO> listVO) {
		LeaveVO.listVO = listVO;
	}
	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	/**
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}
	/**
	 * @param empname the empname to set
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	/**
	 * @return the fromdate
	 */
	public String getFromdate() {
		return fromdate;
	}
	/**
	 * @param fromdate the fromdate to set
	 */
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	/**
	 * @return the todate
	 */
	public String getTodate() {
		return todate;
	}
	/**
	 * @param todate the todate to set
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	

	
}
