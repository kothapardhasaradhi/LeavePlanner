<%@ page language="java"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
	
<script src="js/homePage.js"></script>
<link rel="stylesheet" href="css/custome.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/homePage.css">


<script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
<script>
    webshims.setOptions('forms-ext', {types: 'date'});
webshims.polyfill('forms forms-ext');
</script> 


</head>
<style>


</style>
<body >
	<!-- 
	header -->
	<jsp:include page="header.jsp" />
	<!-- 	 <center>  -->

	<%-- id="fromdate" name="searchFromdate" --%>
	<div id='body'>
		<div class="w3-container" style="background-color: White;width:97.6% ;margin-left:1.2% ;margin-right:10%">
			<div class="w3-card-4" style="width: 500%; height: 100%;"></div>
			<div>
				<br> <br>
			</div>
			<html:form action="retrieve" method="post" theme="simple">

				<table border="3" bordercolor="blue" >

					<tr>
						<!-- <td style="padding-left: 5%; padding-bottom: 6%;" width="20%"
							align="left"> -->
						<td width="20%" style="padding-bottom: 53px;"><font size="4"
							color="Black"><b> FROM DATE</b> <span
								class="glyphicon glyphicon-calendar"></span> <html:textfield
									size="1" id="fromdt" name="fromdate"
									onclick="return hideshow();" cssClass="textSize" /> <br>
						</font></td>
					
						<td width="20%" style="padding-top: 20px;"><font size="4"
							color="Black"><b> TO DATE</b> <span
								class="glyphicon glyphicon-calendar"></span> <html:textfield
									size="1" id="todt" name="todate" onchange="validate()"
									cssClass="textSize" />
								<center>
									<button type="submit" value="submit" id="search"
										class="btn btn-success" style="padding-top: -13%">
										<html:hidden name="method" value="null"></html:hidden>
										<center>
											<span class="glyphicon glyphicon-circle-arrow-right"></span>Search

										
									</button>
								</center> </font></td>



						<td width="20%" style="padding-bottom: 53px;"><font size="4"
							color="Black"><b> EMPNAME</b> <span
								class="glyphicon glyphicon-user"></span> <html:textfield
									size="1" id="empid" name="empname"
									onclick="return hideshow1();"
									onkeypress="return blockSpecialChar(event);"
									cssStyle="text-transform:uppercase;" cssClass="textSize" /> <br>
						</font></td>

						<td id="td1" align="center" width="50%"><label
							style="float: middle; font-size: 16px; font-stretch: expanded; padding-bottom: 3%;padding-top: 3%; padding-left: 43%">
								Holiday Calendar</label> <img
							src="${pageContext.request.contextPath}/images/1.jpg"
							align="right" height="290" width="90%"></td>

					</tr>


				</table>

			</html:form>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>


