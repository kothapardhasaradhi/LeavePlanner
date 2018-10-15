package com.wipro.sevices;

import java.util.ArrayList;
import java.util.Map;

import com.wipro.dao.LeaveManagerDaoImpl;
import com.wipro.leave.LeaveVO;

public class LeaveServices {

	public boolean deleteLeave(LeaveVO LeaveVO) {
		
	
		LeaveManagerDaoImpl LeaveManagerDaoImpl =new LeaveManagerDaoImpl();
		
		String empId = LeaveVO.getEmpid();
	
	return LeaveManagerDaoImpl.deleteEmpLeave(LeaveVO);
	
		/*return true;*/
	}
	
	public boolean updateLeave(LeaveVO leaveDetailsVo){
		
		LeaveManagerDaoImpl LeaveManagerDaoImpl =new LeaveManagerDaoImpl();
		
		
		return  LeaveManagerDaoImpl.updateEmpLeave(leaveDetailsVo);
	/*	
		return true;*/
	}
	public boolean getLeaves(LeaveVO leaveDetailsVo){
		
		LeaveManagerDaoImpl LeaveManagerDaoImpl =new LeaveManagerDaoImpl();
	
		return LeaveManagerDaoImpl.EmpLeaveDetails(leaveDetailsVo);
		/*return true;*/
		
	}
public boolean getLeavesPagination(LeaveVO leaveDetailsVo){
		
		Pagination pagination =new Pagination();
		
		return pagination.EmpLeaveDetailsPagination(leaveDetailsVo);
		
	}
	public boolean applyLeave(LeaveVO leaveDetailsVo) {
	
		LeaveManagerDaoImpl LeaveManagerDaoImpl =new LeaveManagerDaoImpl();
		return LeaveManagerDaoImpl.applyLeave(leaveDetailsVo);
	/*	return true;*/
	}
	

	
	public boolean detailsExists(LeaveVO leaveDetailsVo) {
		// TODO Auto-generated method stub
		LeaveManagerDaoImpl LeaveManagerDaoImpl =new LeaveManagerDaoImpl();
		boolean alreadyExists=LeaveManagerDaoImpl.detailsExists(leaveDetailsVo);
		return alreadyExists;
	}
	
	
	public boolean backup() {
		// TODO Auto-generated method stub
		
		LeaveManagerDaoImpl LeaveManagerDaoImpl =new LeaveManagerDaoImpl();
		
		LeaveManagerDaoImpl.backup();

		return true;
	}

	public Map<String, String> getBackupRes() {
	LeaveManagerDaoImpl leaveManagerDaoImpl =new LeaveManagerDaoImpl();
		
		return leaveManagerDaoImpl.backup();
	}
	
	
}
