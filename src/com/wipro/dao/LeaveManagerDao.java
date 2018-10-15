package com.wipro.dao;

import com.wipro.leave.LeaveVO;

public interface LeaveManagerDao {
	public boolean deleteEmpLeave(LeaveVO leaveSchedulerVO);
	public boolean updateEmpLeave(LeaveVO leaveSchedulerVO);

}
