package com.wipro.sevices;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.wipro.leave.LeaveVO;
import com.wipro.leave.Leavescheduler;

/**
 * Servlet implementation class BackupService
 */
public class BackupService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackupService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		

		LeaveServices leaveService = new LeaveServices();

		Map<String, String> map = leaveService.getBackupRes();

		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		String empNames = ow.writeValueAsString(map);


		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(empNames);
		request.getSession().setAttribute("map", empNames);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
