<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.wipro.leave.*"%>
<%@ page import="java.util.*;"%>
<%@ taglib prefix="html" uri="/struts-tags"%>

<html>
<!-- <META content="IE=11.0000" 
http-equiv="X-UA-Compatible">  -->
<head>
 <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>




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
<link rel="stylesheet" href="css/custome.css"> 


<script type="text/javascript">  


       var xmlHttp1 ;  
       var oldfromdate;
   

function getId(element) {

  var rows = document.getElementsByTagName('tr')[element];
    var col = rows.getElementsByTagName('input')[2];
     oldfromdate=col.value;
      col.readOnly =false;
     $(col).datepicker({
    dateFormat: 'yy/mm/dd'
});

    var col1 = rows.getElementsByTagName('input')[3];
       col1.readOnly =false;
       $(col1).datepicker({
    dateFormat: 'yy/mm/dd'
});
     /*  var col = rows.getElementsByTagName('input')[4];
        col.readOnly =false; */
         var col = rows.getElementsByTagName('input')[5];
        col.readOnly =false;
       
var col3=rows.getElementsByTagName('select')[0];


   my_fun(col3.id);

}
function my_fun(selectedId){
$.get('BackupService', {
}, function(response) {
var select = $(selectedId);
 
$.each(response, function(index, value) {
$('<option>').val(value).text(value).appendTo(select);
});
});
    /* some operations */
}

$(function(){
    my_fun(elem); //run my_fun() ondomready
});

// just js
function js_fun(elem){
   my_fun(elem); //== call my_fun() again
}
       function pagemethod(str)  
       { 
  
 
         if (typeof XMLHttpRequest != "undefined")  
         {   
           xmlHttp1= new XMLHttpRequest();  
         }  
         else if (window.ActiveXObject)  
         { xmlHttp1= new ActiveXObject("Microsoft.XMLHTTP");  
         }  
         if (xmlHttp1==null)  
         { return  
         }  
       var url="test.action?method="+str;  
         xmlHttp1.open("GET", url, true);  
         xmlHttp1.send();  
       } 
       function stateChange1()  
       {  
      
         if (xmlHttp1.readyState==4 || xmlHttp1.readyState=="complete")  
         {  
           var strResponse=xmlHttp1.responseText;  
          
    
              
         }  
       }  
       
       function searchSuggest(str,str1)  
       { 
     
         if (typeof XMLHttpRequest != "undefined")  
         { 
           xmlHttp1= new XMLHttpRequest();  
         }  
         else if (window.ActiveXObject)  
         { 
           xmlHttp1= new ActiveXObject("Microsoft.XMLHTTP");  
         }  
         if (xmlHttp1==null)  
         {
          return  
         }  
                     var rows = document.getElementsByTagName('tr')[str]; 
  
 
    var ei = rows.getElementsByTagName('input')[0];
 
     
    var en = rows.getElementsByTagName('input')[1];
 
 
    var fr = rows.getElementsByTagName('input')[2];
 
     
    var td = rows.getElementsByTagName('input')[3];
    
    var backupResource = rows.getElementsByTagName('input')[5];
                
         
         var url="test.action?fromDate=" +fr.value+"&toDate="+td.value+"&empId="+ei.value+"&empName="+en.value+"&method="+str1+"&backupres="+backupResource.value+"&oldfromdate="+oldfromdate+"&leavetype="+leavetype.value; 
   
         xmlHttp1.onreadystatechange = stateChange1;  
         xmlHttp1.open("GET", url, true);  
         xmlHttp1.send();  
       }  
       function stateChange1()  
       {  
      
         if (xmlHttp1.readyState==4 || xmlHttp1.readyState=="complete")  
         {  
           var strResponse=xmlHttp1.responseText;  
          
           document.getElementById('fromdate').value=strResponse;
              
         }  
       }  
       
       function del(str,str1)  
       {  
 
         if (typeof XMLHttpRequest != "undefined")  
         {  xmlHttp1= new XMLHttpRequest();  
         }  
         else if (window.ActiveXObject)  
         { xmlHttp1= new ActiveXObject("Microsoft.XMLHTTP");  
         }  
         if (xmlHttp1==null)  
         { return  
         }  
         
            
                    var rows = document.getElementsByTagName('tr')[str];
  
    var ei = rows.getElementsByTagName('input')[0];
     
    var en = rows.getElementsByTagName('input')[1];
 
    var fr = rows.getElementsByTagName('input')[2];
    var td = rows.getElementsByTagName('input')[3];
   
var leavetype=rows.getElementsByTagName('input')[4];
   var backupResource = rows.getElementsByTagName('input')[5];
         var url="test.action?fromDate=" +fr.value+"&toDate="+td.value+"&empId="+ei.value+"&empName="+en.value+"&method="+str1+"&backupres="+backupResource.value+"&leavetype="+leavetype.value;  
          
        

         xmlHttp1.onreadystatechange = stateChange1;  
         xmlHttp1.open("GET", url, true);  
         xmlHttp1.send();  
       }
       function stateChange1()  
       {  
      
         if (xmlHttp1.readyState==4 || xmlHttp1.readyState=="complete")  
         {  
           var strResponse=xmlHttp1.responseText;  
          
    
              
         }  
       }  


 function confirmDelete(str,str1) {
 
    var r = confirm("Are You Sure To Delete?");
    if (r == true) {
  del(str,str1);
    } else {
    
        return false;
    }
    
} 


</script>



<style>
.pagination {
display: inline-block;
width: 80%;
margin-left: auto;
margin-right: auto;
border-collapse: collapse;
}

table {
border-collapse: collapse;
width: 90%;
margin-top: 30px;
margin-left: auto;
margin-right: auto;
}

.orange {
background-color: orange;
}

#edit.selected tr {
background-color: orange;
color: orange;
}
#rowid1{
height: 50%;}

tr:hover td {
background-color: lightgreen;
}

tr:hover input {
background-color: lightgreen;
}

tr:nth-child(even):hover input {
background-color: lightgreen;
}

tr:nth-child(even):hover td {
background-color: lightgreen;
}

body {
font-family: 'EB Garamond';
font-size: 18px;
}


th,td {
text-align:center;

}

td {
background-color: white;

}

td:input[type="button"] {
background-color: white;
}

th {
height: 50%;
background-color: #5bc0de;
color: white;
text-shadow: 3px 2px grey;
border-color: black;
text-align: justify;
}

tr:hover {
background-color: lwhite;
}

#td1 {height:10%;
background-color: #5bc0de;

text-align:right;

}

tr:nth-child(even) input {
background-color: #f2f2f2;
}

tr:nth-child(even) td {
background-color: #f2f2f2;

}



.btn-info {
color: #fff;
background-color: #2481B7;
border-color: #46b8da
}

button[type=submit] {
border-color: green;
}

input[type=text] {
border:none;

background-color: transparent;
}

button[type=button]:focus {
background: orange;
}

.btn-info {
color: #fff;
background-color: #2481B7;
border-color: #46b8da
}

#edit:hover {
background-color: lightgreen;
}
#rowid{
height: 10%;}
#edit:focus td {
background: orange;
}

#edit {
border-color: orange;
}

#update:hover {
background-color: lightgreen;
}

#delete {
border-color: red;
}

#delete:hover {
background-color: lightgreen;
}

.edit:hover {
background-color: lightgreen;
}

.edit:active {
background-color: green;
}

.update:hover {
background-color: lightgreen;
}

.delete:hover {
background-color: lightgreen;
}
}
</style>
</head>
<body>

<jsp:include page="header1.jsp" />
<html:form>
<!--  name="fom"  method="post" id="form" -->
<table border="blue" id='tableId' style="margin-top:-10px;margin-bottom:0px;" >
<tr id='rowId1'  >
<th style="padding-left:15px;height:50px;">EMPLOYEE ID</th>
<th style="padding-left:15px; ">EMPLOYEE NAME</th>
<th style="padding-left:15px;">FROM DATE</th>
<th style="padding-left:15px;">TO DATE</th>
<th style="padding-left:15px;">LEAVE TYPE</th> 
<th style="padding-left:15px; ">BACKUP</th>
<!-- <th>bckup dropdown</th> -->
<th colspan=3 style="padding-left:15px;width:20%;">MODIFY</th>

</tr>


<html:iterator value="listVO" status="indexx">


				<tr id='rowId'>

					<td><input type="text" class="empid" id="empid" readonly=true style="text-align: center;"
						value="${empid}"></td>
					<td><input type="text" class="empname" id="empname" style="text-align: center; text-transform:uppercase;"
						readonly=true onkeypress="return blockSpecialChar(event);"
						value="${empname}"></td>
					<td><input type="text" class="fromdate" style="text-align: center;"
						id="fromdate+${indexx.index}" readonly=true value="${fromdate}"></td>
					<td><input type="text" class="todate" style="text-align: center;"
						id="todate+${indexx.index}" readonly=true value="${todate}"></td>
					<!-- <td><input type="text" class="test" id="test"
							readonly=true
							value=<html:property value="test"></html:property>></td>  -->
<td><input type="text" id="leavetype" style="text-align: center;" readonly=true
						 value=<html:property value="leavetype" />></td>
					<td><input type="text" class="test" id="backupres"
						readonly=true onkeypress="return blockSpecialChar(event);"
						style="text-transform: uppercase;text-align: center;" value="${backupres}"></td>


					<td style="border: none;"><button type="button" id="edit"
							class="btn btn-default btn-sm"
							onclick="getId(this.parentNode.parentNode.rowIndex);">
							<span class="glyphicon glyphicon-pencil"></span> edit
						</button></td>
					<td style="border: none; padding-left: 4px; padding-right: 4px;"><button
							type="submit" id="update" class="btn btn-default btn-sm"
							onclick="searchSuggest(this.parentNode.parentNode.rowIndex,'update')">
							<span class="glyphicon glyphicon-ok"></span>update
						</button></td>
					<td style="border: none;"><button type="submit" id="delete"
							class="btn btn-default btn-sm confirmation"
							onclick="confirmDelete(this.parentNode.parentNode.rowIndex,'delete')">
							<span class="glyphicon glyphicon-trash"></span>Delete
						</button></td>

				</tr>
			</html:iterator>
<tr>
<td colspan="9" id="td1" height="30%"> <!-- <a href="HomePage.jsp"
class="btn btn-info btn-lg"> <span
class="glyphicon glyphicon-home"></span>
</a> --> 
<button class="btn btn-default btn-sm"
style="float: right; margin-right: 0%; font-size: 12px;border-color:#5bc0de;"
onclick="pagemethod('last')">Last</button>
<button onclick="pagemethod('next')" style="float: right;font-size: 12px;border-color:#5bc0de;"
class="btn btn-default btn-sm">Next</button>
<button class="btn btn-default btn-sm" style="float: right;font-size: 12px;border-color:#5bc0de;"
onclick="pagemethod('previous')">Previous</button>
<button class="btn btn-default btn-sm" style="float: right;font-size: 12px;border-color:#5bc0de; "
onclick="pagemethod('first') ">First</button></td>
</tr>
</div>
</table>
</html:form>



<!-- <button class="btn btn-default btn-sm"
style="float: right; margin-right: 10%; font-size: 12px"
onclick="pagemethod('last')">Last</button>
<button onclick="pagemethod('next')" style="float: right"
class="btn btn-default btn-sm">Next</button>
<button class="btn btn-default btn-sm" style="float: right"
onclick="pagemethod('previous')">Previous</button>
<button class="btn btn-default btn-sm" style="float: right"
onclick="pagemethod('first') ">First</button> -->
<div id="footer" style="margin: 0px;">
<jsp:include page="footer.jsp" />
</div>

</body>
</html>