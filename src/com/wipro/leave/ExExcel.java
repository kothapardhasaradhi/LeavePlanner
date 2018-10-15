package com.wipro.leave;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import com.opensymphony.xwork2.ActionSupport;
import com.wipro.util.DateFormatter;

public class ExExcel extends ActionSupport {

	private final static String SUCCESS = "success";

	public String execute() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Properties prop = new Properties();
		InputStream input = null;
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		/*
		 * HSSFWorkbook workbook = new HSSFWorkbook(); // Creates new Workbook
		 * HSSFSheet Jan = workbook.createSheet(); CellStyle style =
		 * workbook.createCellStyle();
		 * style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		 * style.setFillPattern(CellStyle.SOLID_FOREGROUND); HSSFFont font =
		 * workbook.createFont(); font.setColor(IndexedColors.BLACK.getIndex());
		 * style.setFont(font);
		 */

		HSSFWorkbook workbook = new HSSFWorkbook(); // Creates new Workbook
		HSSFSheet Jan = workbook.createSheet();
		CellStyle style = workbook.createCellStyle();
		/*
		 * CellStyle style = workbook.createCellStyle(); CellStyle style1 =
		 * workbook.createCellStyle();
		 * style1.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		 * style1.setFillPattern(CellStyle.SOLID_FOREGROUND); HSSFFont font =
		 * workbook.createFont(); font.setColor(IndexedColors.BLACK.getIndex());
		 * style1.setFont(font); style1.setBorderBottom(CellStyle.BORDER_THIN);
		 * style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		 * style1.setBorderLeft(CellStyle.BORDER_THIN);
		 * style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		 * style1.setBorderRight(CellStyle.BORDER_THIN);
		 * style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
		 * style1.setBorderTop(CellStyle.BORDER_THIN);
		 * style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
		 * Jan.createFreezePane(2, 1);
		 */
		Jan.createFreezePane(2, 1);

		CellStyle leaveStyle = setColor(workbook.createCellStyle(), workbook,
				IndexedColors.YELLOW.getIndex());
		CellStyle holidayStyle = setColor(workbook.createCellStyle(), workbook,
				IndexedColors.AQUA.getIndex());
		CellStyle halfDayStyle = setColor(workbook.createCellStyle(), workbook,
				IndexedColors.GREY_25_PERCENT.getIndex());
		// Jan.autoSizeColumn((short) (1));
		// Jan.autoSizeColumn((short) (2));
		Connection conn = null;
		ResultSet resultSet = null;
		ResultSet rs = null;
		// FileReader reader = null;
		String month = request.getParameter("month").substring(5, 7);
		String year = request.getParameter("month").substring(0, 4);
		System.out.println("year selected : " + year);
		int yearSelected = Integer.parseInt(year);
		int mnth = Integer.parseInt(month) - 1;
		try {
			// reader=new FileReader("holiday.properties");
			/*
			 * File file = new File("holiday.properties");
			 * System.out.println(file.getAbsolutePath()); input = new
			 * FileInputStream("holiday.properties");
			 * 
			 * prop.load(ExExcel.class.getClassLoader().getResourceAsStream(
			 * "holiday.properties"));
			 */

			String filename = "holiday.properties";
			input = ExExcel.class.getClassLoader()
					.getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);

			}

			// load a properties file from class path, inside static method
			prop.load(input);

			prop.load(input);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager
					.getConnection("jdbc:odbc:leaveplanner", "", "");
			PreparedStatement psmt = null;

			List<LeaveVO> array = new ArrayList<LeaveVO>();
			psmt = conn
					.prepareStatement("select * from  EMP_DETAILS order by Emp_Id asc ");
			resultSet = psmt.executeQuery();

			psmt = conn
					.prepareStatement("select * from  register WHERE FROMDATE LIKE ? OR TODATE LIKE ? OR (FROMDATE < ? AND TODATE > ?)  order by EMPID asc ");
			psmt.setString(1, year + "/" + month + "___");
			psmt.setString(2, year + "/" + month + "___");
			psmt.setString(3, year + "/" + month + "/01");
			psmt.setString(4, year + "/" + month + "/01");

			rs = psmt.executeQuery();

			while (rs.next()) {

				LeaveVO leaveVO = new LeaveVO();
				leaveVO.setEmpid(rs.getString("EMPID").trim());
				leaveVO.setEmpname(rs.getString("EMPNAME").trim());
				leaveVO.setFromdate(DateFormatter.validateDate((String) rs
						.getString("FROMDATE").trim()));
				leaveVO.setTodate(DateFormatter.validateDate((String) rs
						.getString("TODATE").trim()));
				leaveVO.setLeavetype(rs.getString("LEAVETYPE").trim());
				array.add(leaveVO);

			}

			System.out.println("month :" + month);
			int i = 1;
			HSSFRow rowhead = Jan.createRow((short) i);
			rowhead.createCell((short) 0).setCellValue("Employee Id");
			rowhead.createCell((short) 1).setCellValue("Employee Name");
			Row row1;
			row1 = Jan.createRow(0);
			DataFormatter formatter = new DataFormatter();
			// ArrayList<Cell> getEmpId=new ArrayList<Cell>();
			ArrayList<String> getEmpId = new ArrayList<String>();
			while (resultSet.next()) {
				row1 = Jan.createRow((short) i + 1);
				row1.createCell((short) 0).setCellValue(
						resultSet.getString("Emp_Id"));
				row1.createCell((short) 1).setCellValue(
						resultSet.getString("Emp_First_Name"));

				String val = formatter.formatCellValue(Jan.getRow(i + 1)
						.getCell(0));
				// getEmpId.add(((Cell)Jan.getCellComment(i+1, 0)));
				getEmpId.add(val);
				i += 1;
			}
			row1 = Jan.createRow(0);
			i = 1;
			Calendar cal = new GregorianCalendar();
			cal.set(yearSelected, mnth, 1);
			int dayOfWeek;
			dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			Locale locale = Locale.getDefault();
			// cal = Calendar.getInstance();
			// cal.set(cal.YEAR, yearSelected);
			// cal.set(cal.MONTH, mnth);

			int Mon = Calendar.DAY_OF_MONTH;

			int maxDay = cal.getActualMaximum(Mon);
			SimpleDateFormat df = new SimpleDateFormat("d-MMM-yy"); // Date
																	// Formate

			int dupJ = 0;

			int dayOfMonth;
			// Creates a row in Sheeet

			// cal.set(cal.DAY_OF_MONTH, 1);

			// cal.set(yearSelected, mnth, 1);
			String monthName = cal.getDisplayName(cal.MONTH, cal.SHORT, locale);
			System.out.println("month name : " + monthName);
			/*
			 * String split[]; split =
			 * prop.getProperty("Jan")+prop.getProperty("Jan"); split =
			 * prop.getProperty("Feb").trim().split(" "); split =
			 * prop.getProperty("May").trim().split(" ");
			 * System.out.println(" jan holiday dates : " + split[0]);
			 * System.out.println(" jan holiday dates : " + split[1]);
			 * System.out.println(" jan holiday dates : " + split[2]);
			 * System.out.println(" jan holiday dates : " + split[3]);
			 */
			for (int j = 1; j <= maxDay; j++) // Shifts the cell towards left or
												// right
			{

				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				System.out.println(dayOfWeek);
				if (dayOfWeek == Calendar.FRIDAY) { // If it's Friday so skip to
													// Monday
					row1.createCell(dupJ + 2).setCellValue(
							df.format(cal.getTime()));
					dupJ += 1;
					cal.set(cal.DAY_OF_MONTH, j + 3);

					j += 2;

				} else if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday
																// skip to
																// Monday

					cal.set(cal.DAY_OF_MONTH, j + 2);
					j += 1;

				} else if (dayOfWeek == Calendar.SUNDAY) {

					cal.set(cal.DAY_OF_MONTH, j + 1);

				} else {

					row1.createCell(dupJ + 2).setCellValue(
							df.format(cal.getTime()));
					dupJ += 1;
					cal.set(cal.DAY_OF_MONTH, j + 1);
				}

			}

			String prevEmpId = "";
			String fromDt = "";
			String toDt = "";
			String split[];
			String keys = prop.getProperty("Jan") + prop.getProperty("Feb")
					+ prop.getProperty("Mar") + prop.getProperty("Apr")
					+ prop.getProperty("May") + prop.getProperty("Jun")
					+ prop.getProperty("Jul") + prop.getProperty("Aug")
					+ prop.getProperty("Sep") + prop.getProperty("Oct")
					+ prop.getProperty("Nov") + prop.getProperty("Dec");
			split = keys.trim().split(",");
			int check = 0;
			for (LeaveVO leaveVO : array) {

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String empId = leaveVO.getEmpid();
				String empName = leaveVO.getEmpname();
				String leaveType = leaveVO.getLeavetype();
				fromDt = leaveVO.getFromdate();
				toDt = leaveVO.getTodate();
				System.out.println(":fromDt:" + fromDt);
				int fromIntVal = Integer.parseInt(fromDt.substring(8, 10));
				int toIntVal = Integer.parseInt(toDt.substring(8, 10));
				int fromMonth = Integer.parseInt(fromDt.substring(5, 7));
				int toMonth = Integer.parseInt(toDt.substring(5, 7));
				int fromYear = Integer.parseInt(fromDt.substring(0, 4));
				int toYear = Integer.parseInt(toDt.substring(0, 4));
				if ((fromYear != yearSelected) && (toYear != yearSelected)) {
					break;
				}
				System.out.println("fromDate.. : " + fromDt);
				System.out.println("toDate... : " + toDt);
				System.out.println("fromIntVal : " + fromIntVal);
				System.out.println("toIntVal : " + toIntVal);

				System.out.println("hello....");
				cal.set(Calendar.MONTH, mnth);
				cal.set(Calendar.DAY_OF_MONTH, 1);

				int dayofweek;
				int count = 0;
				for (int j = 1; j < fromIntVal; j++) {

					dayofweek = cal.get(Calendar.DAY_OF_WEEK);
					if (dayofweek == Calendar.FRIDAY) { // If it's Friday so
														// skip to
						// Monday
						System.out.println("entered friday condition");
						cal.set(Calendar.DAY_OF_MONTH, j + 3);

						j += 2;
						count += 2;

					} else if (dayofweek == Calendar.SATURDAY) { // If it's
																	// Saturday
						// skip to
						// Monday

						cal.set(Calendar.DAY_OF_MONTH, j + 2);
						j += 1;
						count += 2;
						System.out.println("entered saturday condition");

					} else if (dayofweek == Calendar.SUNDAY) {

						cal.set(Calendar.DAY_OF_MONTH, j + 1);
						count += 1;
						System.out.println("entered sunday condition");

					} else {

						cal.set(Calendar.DAY_OF_MONTH, j + 1);

					}
				}
				System.out.println("count value : " + count);

				cal.set(Calendar.DAY_OF_MONTH, fromIntVal);
				// cal.set(Calendar.DAY_OF_MONTH, fromIntVal);

				int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);

				for (String c : getEmpId) {
					row1 = Jan.getRow(i + 1);
					if (empId.equalsIgnoreCase(c)) {

						break;

					}
					i += 1;

				}
				i = 1;
				if (fromDt.equalsIgnoreCase(toDt))

				{

					check = 0;
					while (check < 10) {
						if (split[check].equalsIgnoreCase(fromDt)) {
							check = 11;
							break;
						}
						check++;
					}
					if (check == 11) {
						row1.createCell(fromIntVal + 1 - count).setCellValue(
								"HOLIDAY");
						row1.getCell(fromIntVal + 1 - count).setCellStyle(
								holidayStyle);
						continue;
					}

					if (dayofWeek > 1 && dayofWeek < 7) {

						System.out.println("entered from == to case");

						if (leaveType.equalsIgnoreCase("ML")) {
							row1.createCell(fromIntVal + 1 - count)
									.setCellValue("ML");
							row1.getCell(fromIntVal + 1 - count).setCellStyle(
									leaveStyle);
						} else if (leaveType.equalsIgnoreCase("HL")) {
							row1.createCell(fromIntVal + 1 - count)
									.setCellValue("HL");
							row1.getCell(fromIntVal + 1 - count).setCellStyle(
									halfDayStyle);
						} else {
							row1.createCell(fromIntVal + 1 - count)
									.setCellValue("L");
							row1.getCell(fromIntVal + 1 - count).setCellStyle(
									leaveStyle);
						}

					}
				}

				else {
					int monthInt = mnth + 1;
					if (Math.abs(toMonth - fromMonth) > 1
							&& (fromMonth != monthInt) && (toMonth != monthInt)) {
						int setCell = 0;
						cal.set(Calendar.YEAR, yearSelected);
						cal.set(Calendar.MONTH, mnth);

						for (int j = 0; j < maxDay; j++) {
							cal.set(Calendar.DAY_OF_MONTH, j + 1);
							dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

							if (dayOfWeek > 1 && dayOfWeek < 7) {
								System.out.println("dayofWeek  " + dayofWeek);

								if (leaveType.equalsIgnoreCase("ML")) {
									row1.createCell(setCell + 2).setCellValue(
											"ML");
									row1.getCell(setCell + 2).setCellStyle(
											leaveStyle);
								} else if (leaveType.equalsIgnoreCase("HL")) {
									row1.createCell(setCell + 2).setCellValue(
											"HL");
									row1.getCell(setCell + 2).setCellStyle(
											halfDayStyle);
								} else {
									row1.createCell(setCell + 2).setCellValue(
											"L");
									row1.getCell(setCell + 2).setCellStyle(
											leaveStyle);
								}

								setCell = setCell + 1;
							}

						}
						cal.set(Calendar.MONTH, toMonth);
						cal.set(Calendar.DATE, toIntVal);
						cal.add(cal.DATE, 1);
						fromDt = (String) dateFormat.format(cal.getTime());
					} else if (((monthInt == toMonth) && (toMonth - fromMonth == 1))
							|| ((monthInt == toMonth) && (fromMonth - toMonth == 11))) {
						fromMonth += 1;
						if (toMonth < 10) {
							// fromDt = "0" + toMonth + "/01/" + year;
							fromDt = year + "/0" + toMonth + "/01";

						} else {
							// fromDt = toMonth + "/01/" + year;
							fromDt = year + "/" + toMonth + "/01";

						}
						fromIntVal = Integer.parseInt(fromDt.substring(8, 10));
						count = 0;
					} else if ((monthInt == toMonth)
							&& (Math.abs(toMonth - fromMonth) > 1)) {
						fromIntVal = 1;
						count = 0;
					} else {
						fromIntVal = Integer.parseInt(fromDt.substring(8, 10));
					}
					int sumthing = fromIntVal;
					sumthing = sumthing + 1;
					if ((yearSelected == fromYear) && (fromYear != toYear)) {
						// toDt = String.valueOf(monthInt) + "/" +
						// String.valueOf(maxDay) + "/" +
						// String.valueOf(yearSelected);
						toDt = String.valueOf(yearSelected) + "/"
								+ String.valueOf(monthInt) + "/"
								+ String.valueOf(maxDay);
					}
					while (fromDt.compareTo(toDt) <= 0) {
						cal.set(Calendar.YEAR, yearSelected);
						cal.set(Calendar.MONTH, mnth);
						cal.set(Calendar.DAY_OF_MONTH, fromIntVal);
						check = 0;
						while (check < 10) {
							if (split[check].equalsIgnoreCase(fromDt)) {
								check = 11;
								break;
							}
							check++;
						}
						if (check == 11) {
							cal.add(cal.DATE, 1);
							fromDt = (String) dateFormat.format(cal.getTime());
							row1.createCell(sumthing - count).setCellValue(
									"HOLIDAY");
							row1.getCell(sumthing - count).setCellStyle(
									holidayStyle);

							sumthing += 1;
							fromIntVal += 1;
							continue;
						}

						dayofWeek = cal.get(Calendar.DAY_OF_WEEK);

						if (dayofWeek > 1 && dayofWeek < 7) {
							System.out.println("dayofWeek  " + dayofWeek);
							System.out.println("fromIntVal   " + fromIntVal);
							System.out.println("toIntVal   " + toIntVal);
							if (leaveType.equalsIgnoreCase("ML")) {
								row1.createCell(sumthing - count).setCellValue(
										"ML");
								row1.getCell(sumthing - count).setCellStyle(
										leaveStyle);
							} else if (leaveType.equalsIgnoreCase("HL")) {
								row1.createCell(sumthing - count).setCellValue(
										"HL");
								row1.getCell(sumthing - count).setCellStyle(
										halfDayStyle);
							} else {
								row1.createCell(sumthing - count).setCellValue(
										"L");
								row1.getCell(sumthing - count).setCellStyle(
										leaveStyle);
							}

							sumthing += 1;

						}

						int fromMonthBfInc = Integer.parseInt(fromDt.substring(
								5, 7));
						cal.add(cal.DATE, 1);
						fromIntVal += 1;
						fromDt = (String) dateFormat.format(cal.getTime());
						if (fromMonth < toMonth) {
							fromMonth = Integer
									.parseInt(fromDt.substring(5, 7));
							if (fromMonth == fromMonthBfInc + 1) {
								break;
							}
						}

						if (fromIntVal == (maxDay + 1)) {
							break;
						}
					}

				}

				prevEmpId = empId;

			}
			Jan.autoSizeColumn((short) (0));
			Jan.autoSizeColumn((short) (1));
			response.setContentType("application/vnd.ms-excel; charset=windows-1252");
			response.setHeader("Content-Disposition",
					"attachment; filename=Leaves.xls");
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			outputStream.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqlee) {
				sqlee.printStackTrace();

			}
		}
		return SUCCESS;
	}

	private CellStyle setColor(CellStyle style, HSSFWorkbook workbook,
			short colorValue) {
		style.setFillForegroundColor(colorValue);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		HSSFFont font = workbook.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		style.setFont(font);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return style;

	}

}
