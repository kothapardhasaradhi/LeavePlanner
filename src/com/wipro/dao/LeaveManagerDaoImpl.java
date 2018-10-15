package com.wipro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.leave.DbConn;
import com.wipro.leave.LeaveVO;
import com.wipro.util.StringUtil;

/**
 * This class includes the implementations for update ,delete methods and method
 * for retrieving whole data,
 * 
 */
public class LeaveManagerDaoImpl extends ActionSupport {
	final static Logger log = Logger.getLogger(LeaveManagerDaoImpl.class
			.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * This Method checks if the there is any duplicate leave application
	 * 
	 * @param leaveDetailsVo
	 *            consists of the leave details set to VO
	 * @return a boolean value determining whether the details exist previously
	 *         or not
	 */
	public boolean detailsExists(LeaveVO leaveDetailsVo) {
		// TODO Auto-generated method stub

		Connection conn = DbConn.connect();

		try {

			PreparedStatement psmt = null;
			psmt = conn
					.prepareStatement("select * from  register where EMPNAME=? AND FROMDATE=?");
			psmt.setString(1, leaveDetailsVo.getEmpname());
			psmt.setString(2, leaveDetailsVo.getFromdate());
			ResultSet resultset = psmt.executeQuery();
			if (resultset.next())
				return true;
			else
				return false;

		} catch (SQLException exception) {
			log.error(exception);

		} finally {
			try {
				conn.close();
			} catch (SQLException exception) {
				log.error(exception);

			}
		}

		return false;
	}

	/**
	 * 
	 * @param leaveDetailsVo
	 *            it contains the user data received through apply leave form
	 * @return boolean value that determines whether the apply leave details are
	 *         perfectly stored into the database or not
	 */
	public boolean applyLeave(LeaveVO leaveDetailsVo) {
		ArrayList<LeaveVO> retrieveleave = new ArrayList<LeaveVO>();
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbConn.connect();

			psmt = conn
					.prepareStatement("insert into register values(?,?,?,?,?,?)");
			psmt.setString(1, leaveDetailsVo.getEmpid());
			psmt.setString(2, leaveDetailsVo.getEmpname());
			psmt.setString(3, leaveDetailsVo.getFromdate());
			psmt.setString(4, leaveDetailsVo.getTodate());

			psmt.setString(5, leaveDetailsVo.getBackupres());
			psmt.setString(6, leaveDetailsVo.getLeavetype());
			int i = psmt.executeUpdate();
			if (i > 0) {
				System.out.println("successfully inserted");

				psmt = conn
						.prepareStatement("select * from register  order by EMPID asc");
				rs = psmt.executeQuery();

				while (rs.next()) {
					LeaveVO vo = new LeaveVO();
					vo.setEmpid(rs.getString("EMPID"));

					vo.setEmpname(rs.getString("EMPNAME"));

					vo.setTodate(rs.getString("TODATE"));

					vo.setFromdate(rs.getString("FROMDATE"));

					vo.setBackupres(rs.getString("BACKUPRESOURCE"));
					vo.setLeavetype(rs.getString("LEAVETYPE"));
					retrieveleave.add(vo);

				}

				LeaveVO.setListVO(retrieveleave);

				return true;
			}

			conn.close();
		} catch (SQLException exception) {

			log.error(exception);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (psmt != null)

					psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return false;
	}

	/**
	 * This method is used for deleting employee leave details from the database
	 * 
	 * @param leaveSchedulerVO
	 *            is the object for VO consists of the employee leave details
	 *            information
	 * @return boolean value
	 */
	public boolean deleteEmpLeave(LeaveVO leaveSchedulerVO) {

		ArrayList<LeaveVO> retrieveleave = new ArrayList<LeaveVO>();
		String empId = leaveSchedulerVO.getEmpid();
		String frmDt = leaveSchedulerVO.getFromdate();
		System.out.println("empid in Daoimpl" + empId);
		PreparedStatement psmt = null;
		PreparedStatement psmt1 = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbConn.connect();
		
			psmt = null;
			psmt = conn
					.prepareStatement(" DELETE FROM register  WHERE EMPID=? AND FROMDATE=?");

			psmt.setString(1, empId);
			psmt.setString(2, frmDt);
			psmt.executeUpdate();
			
			psmt1 = conn
					.prepareStatement("select * from register order by EMPID asc");

			rs = psmt1.executeQuery();
			String levDate = "";
			
			while (rs.next()) {
				LeaveVO vo = new LeaveVO();
				vo.setEmpid(rs.getString("EMPID"));
			
				vo.setEmpname(rs.getString("EMPNAME"));
				vo.setTodate(rs.getString("TODATE"));
				vo.setFromdate(rs.getString("FROMDATE"));
				vo.setBackupres(rs.getString("BACKUPRESOURCE"));
				vo.setLeavetype(rs.getString("LEAVETYPE"));
				retrieveleave.add(vo);

			}
			LeaveVO.setListVO(retrieveleave);

			conn.close();
			return true;

		}

		catch (SQLException exception) {
			log.error(exception);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (psmt != null)

					psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return true;
	}

	/**
	 * This method is used for updating employee leave details in the database
	 * with edited values
	 * 
	 * @param leaveSchedulerVO
	 *            is the object for VO which consists of the employee leave
	 *            details information
	 * @return boolean value
	 */
	public boolean updateEmpLeave(LeaveVO leaveSchedulerVO) {
		int j = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		PreparedStatement psmt1 = null;
		
		try {

			String empid11 = leaveSchedulerVO.getEmpid();
			String frmDt = leaveSchedulerVO.getFromdate();
			String toDt = leaveSchedulerVO.getTodate();
			String backupRes = leaveSchedulerVO.getBackupres();

			String oldfromdate = leaveSchedulerVO.getOldfromdate();

			conn = DbConn.connect();
			
			if (empid11 != null) {

				psmt1 = conn
						.prepareStatement("update register SET FROMDATE=?,TODATE=?,BACKUPRESOURCE=? where EMPID=? AND FROMDATE=?");
				psmt1.setString(1, frmDt);
				psmt1.setString(2, toDt);
				psmt1.setString(3, backupRes);
				psmt1.setString(4, empid11);
				psmt1.setString(5, oldfromdate);

				j = psmt1.executeUpdate();

				if (j > 0) {
				
					ArrayList<LeaveVO> retrieveleave = new ArrayList<LeaveVO>();
					psmt = conn
							.prepareStatement("select * from register  order by EMPID asc");

					rs = psmt.executeQuery();

					while (rs.next()) {
						LeaveVO vo = new LeaveVO();

						vo.setEmpid(rs.getString("EMPID"));

						vo.setEmpname(rs.getString("EMPNAME"));

						vo.setTodate(rs.getString("TODATE"));

						vo.setFromdate(rs.getString("FROMDATE"));

						vo.setBackupres(rs.getString("BACKUPRESOURCE"));
						vo.setLeavetype(rs.getString("LEAVETYPE"));
						retrieveleave.add(vo);

					}
					LeaveVO.setListVO(retrieveleave);
				
					return true;
				}
			}
		} catch (SQLException exception) {

			log.error(exception);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (psmt != null)

					psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	
		return false;
	}

	/**
	 * This method is used for fetching entire leave details existing in the
	 * database
	 * 
	 * @param leaveSchedulerVO
	 *            is the object for VO which consists of the employee leave
	 *            details information
	 * @return boolean value
	 */
	public boolean EmpLeaveDetails(LeaveVO leaveDetailsVo) {

	
		ArrayList<LeaveVO> retrieveleave = new ArrayList<LeaveVO>();
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

			conn = DbConn.connect();
			
			String fromdt1 = leaveDetailsVo.getFromdate();
			String todt1 = leaveDetailsVo.getTodate();
			String empName1 = leaveDetailsVo.getEmpname();

			/**
			 * * range of dates
			 */

			if (!fromdt1.equalsIgnoreCase("") && !todt1.equalsIgnoreCase("")) {
				psmt = conn
						.prepareStatement("select * from register where FROMDATE>=? AND TODATE<=? order by FROMDATE desc");
				psmt.setString(1, leaveDetailsVo.getFromdate());
				psmt.setString(2, leaveDetailsVo.getTodate());

			}
			/** employee name search */
			else if (!(empName1.equalsIgnoreCase(""))) {
				psmt = conn
						.prepareStatement("select * from register where EMPNAME LIKE ? order by FROMDATE desc");
				psmt.setString(1, "%" + empName1 + "%");
			}

			/** to date null condition */
			else if (("").equalsIgnoreCase(todt1)
					&& !fromdt1.equalsIgnoreCase("")) {
				psmt = conn
						.prepareStatement("select * from register where FROMDATE>=? order by FROMDATE desc");
				psmt.setString(1, fromdt1);
			}
			/** from date null condition */
			else if (("").equalsIgnoreCase(fromdt1)
					&& !todt1.equalsIgnoreCase("")) {
				psmt = conn
						.prepareStatement("select * from register where TODATE<=? order by FROMDATE desc");
				psmt.setString(1, todt1);
			}

			/** from & to null case */
			else {
				psmt = conn
						.prepareStatement("select * from register  order by FROMDATE desc");
				/*
				 * psmt1 = conn
				 * .prepareStatement("select * from resource  order by EMPID asc"
				 * );
				 */
			}
			rs = psmt.executeQuery();

			String levDate = "";
			boolean flag=false;
			while (rs.next()) {
				flag=true;
				LeaveVO vo = new LeaveVO();

				vo.setEmpid(rs.getString("EMPID"));
				vo.setEmpname(rs.getString("EMPNAME"));
				vo.setTodate(rs.getString("TODATE"));
				vo.setFromdate(rs.getString("FROMDATE"));
				vo.setBackupres(rs.getString("BACKUPRESOURCE"));
				vo.setLeavetype(rs.getString("LEAVETYPE"));
			
				retrieveleave.add(vo);
			}
if(!flag){ return false;}
			LeaveVO.setListVO(retrieveleave);

			conn.close();

		}

		catch (SQLException exception) {

			log.error(exception);

		} finally {

			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			try {
				if (psmt != null)

					psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * This method is used for generating list backup resources available from
	 * the database
	 * 
	 * @return map that stores associations between keys (employee name) and its
	 *         values,or key/value pairs
	 */
	public Map<String, String> backup() {

		Map<String, String> map = new TreeMap<String, String>();
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbConn.connect();

			psmt = conn
					.prepareStatement("select Emp_First_Name,Emp_Last_Name from EMP_DETAILS order by Emp_First_Name asc");
			rs = psmt.executeQuery();

			while (rs.next()) {
				String empName = StringUtil.notNull(
						rs.getString("Emp_First_Name")).concat(" ").concat(
						StringUtil.notNull(rs.getString("Emp_Last_Name")));
				
				map.put(empName, empName);
			}

			return map;

		}

		catch (SQLException exception) {
			exception.printStackTrace();
		} finally {

			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			try {
				if (psmt != null)

					psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;

	}

}