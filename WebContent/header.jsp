
<%@ page language="java"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="/struts-tags"%>

<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">



<div class="w3-container">
	<ul class="w3-container w3-blue">
		<li><a class="active" href="HomePage.jsp"><span
				class="glyphicon glyphicon-home"></span></a></li>
		<li class="export1" style="width: auto;">
			<h5>LEAVE MANAGER</h5>

		</li>
	
		<li class="export">
			<button id="app"	onclick="document.getElementById('id01').style.display='block'; disableexport();"  
				style="width: auto;">Apply</button>
			<div id="id01" class="modal1" style="border:none;"> 
				<html:form action="apply" cssClass="modal-content animate" id="forms">

				

	 		 <div class="container" align="center"
						style="background-color:Gainsboro ; background-position: center; width:50% ;"> 
						<center>
							<span
						onclick="document.getElementById('id01').style.display='none',enableexport();"
						class="close" title="Close Modal">&times;</span>
						<br>	

			
							<label
								style="font-style: italic; font-weight: bolder; color: teal; padding-right: 10"> <span
								class="glyphicon glyphicon-user"></span><b> EMPLOYEE ID</b><input
								type="text" placeholder="Enter Employee id" id="state"
								onchange="searchSuggest(this.value);"
								onkeypress="return isNumber(event)" name="empid" value=""
								maxlength="6" autocomplete="off" required></label> <br> <label
								style="font-style: italic; color: teal;"> <span
								class="glyphicon glyphicon-user"></span><b> EMPLOYEE NAME</b><input
								type="text" name="empname" style="text-transform:uppercase;" id="empName" value="" placeholder="Enter Employee Name"
								autocomplete="off" required id="empname"
								onkeypress="return blockSpecialChar(event)"></label> <br> <label
								style="font-style: italic; color: teal; padding-right: 10""><span
								class="glyphicon glyphicon-calendar"></span><b> FROM DATE </b>
								<input type="text" name="fromdate" id="fromdate"
								placeholder="mm/dd/yyy" value=""
								style="font-style: italic; color: grey; 
								autocomplete="off" required></label><br> <label
								style="font-style: italic; color: teal; padding-right: 10""> <span
								class="glyphicon glyphicon-calendar"></span><b>TO DATE </b> <input
								type="text" name="todate" id="todate" placeholder="mm/dd/yyy"
								value="" style="font-style: italic; color: grey;"
								autocomplete="off"  required></label>  <br>
					<label style="font-style: italic; color: teal;">LEAVE TYPE</label>
				<%-- 	  <html:select label="Leave Type"
		headerKey="-1" headerValue="Leave Type"
		list="#{'HL':'HALF DAY', 'FL':'FULL DAY'}"
		name="leavetype"
		value="2" /> <br> --%>
			 
     <select id="leavetype" name="leavetype" style="width: 110px;"
						class="form-control input-sm" >
						
						<option value="HL">HALF DAY</option>
						<option value="L">FULL DAY</option>
						<option value="ML">MATERNITY LEAVE</option>
					</select>
	<br>
								 <label style="font-style: italic; color: teal;"> <b>Backup</b> 
				
		 
     <select id="backupres" name="backupres"
						class="form-control input-sm">
						<option value="NONE">NONE</option>
					</select>

	
  
  

<html:iterator value="empNameList">
<input type="text"  id="empname" style="color:Gainsboro;background-color: Gainsboro"s
value=<html:property value="empname"></html:property>></td>

				</html:iterator> 
 </label> <br>  
 
							<button type="submit" style="color:white;" class="btn btn-success" onclick="return validation()" >APPLY LEAVE</button>
						</center>
<br>	<br>
				
					</div>
				
				</html:form>
				
			</div>
		</li>





		<!------------------------------ trial------------------------------ -->

		<li class="dropdown">
			<button id="exp"
				onclick="document.getElementById('id03').style.display='block' , disableapply();"
				style="width: auto;">Export</button>

			<div id="id03" class="modal">

				<html:form action="month" cssClass="modal1-content animate">
					

					<div class="container" style="background-color:Gainsboro ;">
<span
							onclick="document.getElementById('id03').style.display='none',enableapply();"
							class="close" title="Close Modal">&times;</span>
				<center>	<label style="color:maroon;"><b>Select Month & Year </b></label> <br>
				<input type="month" name="month" style="background-color:Gainsboro ;"  required >
			</center>
						<center>
							<button class="submit" type="submit" id="exp">Export</button>
						</center>
					</div>


      
				</html:form>
			</div>
		</li>
		<%-- <jsp:include page="ApplyForm.jsp"></jsp:include>
			 --%>
	</ul>
</div>



