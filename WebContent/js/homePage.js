
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
$("#todt").change(function () {
    var startDate = document.getElementById("fromdt").value;
    var endDate = document.getElementById("todt").value;

    if ((Date.parse(startDate) >= Date.parse(endDate))) {
        alert("End date should be greater than Start date");
        document.getElementById("todt").focus();
    }
});


$(function() {
$("#fromdt").attr("placeholder", "yy/mm/dd");

		$("#todt").attr("placeholder", "yy/mm/dd");
	$("#fromdate").attr("placeholder","yy/mm/dd");
		$("#todate").attr("placeholder", "yy/mm/dd");
		$("#empid").attr("placeholder","Enter Employee Name");

		} );
	$(function() {
		$("#fromdate").datepicker({dateFormat:"yy/mm/dd"});

		$("#todate").datepicker({dateFormat:"yy/mm/dd"});
	});
	$(function() {
	
		$("#fromdt").datepicker({dateFormat:"yy/mm/dd"});
	
		$("#todt").datepicker({dateFormat:"yy/mm/dd"});
		
	});
	
	$(document).ready(function() {
	
			$.get('BackupService', {
				
			}, function(response) {
				var select = $('#backupres');
				
				$.each(response, function(index, value) {
				
					$('<option>').val(value).text(value).appendTo(select);
				});
			});
		});
	

      

       var xmlHttp1 ;  

       function searchSuggest(str)  
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
           alert ("Browser does not support XMLHTTP Request");  
           return  
         }  
     
         var url="conn";  
            
         url += "?search=" +str;  
         xmlHttp1.onreadystatechange = stateChange1;  
         xmlHttp1.open("GET", url, true);  
         xmlHttp1.send();  
       }  
       function stateChange1()  
       {  
    
         if (xmlHttp1.readyState==4 || xmlHttp1.readyState=="complete")  
         {  
           var strResponse=xmlHttp1.responseText; 
        
           document.getElementById('empName').value=strResponse;
              
         }  
       }  
       
	   function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
     alert("please enter only number");   return false;
    }
    return true;
}
   
    
    function blockSpecialChar(e){
        var k;
        document.all ? k = e.keyCode : k = e.which;
       return((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32  );
        alert("please enter only text");
        }
        
    function reload(){
        location.reload();
        return true;
        }

	 function validate() {

		var fromdt = document.getElementById("fromdt").value;

		var todt = document.getElementById("todt").value;
			fromdate = new Date(fromdt);
todate = new Date(todt);

		if (fromdate == "" && todate == "") {
			return true;
		} else if (fromdate != "" && todate == "") {
			return true;
		} else if (fromdate == "" && todate != "") {
			return true;
		} else if (fromdate != "" && todate != "") {
			if (fromdate > todate) {
				alert("Fromdate should not be more than todate ");
				document.getElementById("todt").focus();
				return false;
			} else
				return true;
		}
		return true;
	} 
	
	



function validation() {

		var fromdt = document.getElementById("fromdate").value;

		var todt = document.getElementById("todate").value;
			fromdate = new Date(fromdt);
todate = new Date(todt);

		if (fromdate == "" && todate == "") {
			return true;
		} else if (fromdate != "" && todate == "") {
			return true;
		} else if (fromdate == "" && todate != "") {
			return true;
		} else if (fromdate != "" && todate != "") {
			if (fromdate > todate) {
				alert("Fromdate should not be more than todate ");
				document.getElementById("todate").focus();
				return false;
			} else
			
				var day1 = fromdate.getDay();
		var day2 =todate.getDay();
		if((day1 == 6) || (day1 == 0)){
		alert("select 'From Date' between Mon to Fri");
			document.getElementById("fromdate").focus();
			return false;}
		else if((day2 == 6) || (day2 == 0)){alert("select 'To Date' between Mon to Fri");
			document.getElementById("todate").focus();
		return false;}
		/* alert(day1);
		alert(day2); */
else
				return true;
		}
	
		
		  document.getElementById("forms").submit();
	} 

	
	
	
	function clearDates() {
		document.getElementById("formFromdate").value = "";
		document.getElementById("formtodate").value = "";
	}
		 function hideshow() {
        document.getElementById("applyleave").disabled = true; 
        this.style.display = "none";
        return true;
    } 
    
    function trialdates(){
    
  
     return true;
     }
     
       function disableexport() {
document.getElementById("exp").disabled = true; 
 return true;
    } 
     function enableexport() {
document.getElementById("exp").disabled = false; 
        return true;
    } 
    
        function disableapply() {

       document.getElementById("id03").disabled = true; 
document.getElementById("app").disabled = true; 
        return true;
    } 
     function enableapply() {
document.getElementById("app").disabled = false; 
        return true;
    } 
    
    
    
    
     
      function hideshow() {

       document.getElementById("empid").disabled = true; 

        return true;
    }  
       function hideshow1() {

       document.getElementById("fromdt").disabled = true; 
document.getElementById("todt").disabled = true; 

        return true;
    }  
    
    
    function setPage (pageName){
   
    
    if("leave" == pageName){
   
     document.getElementById("body").style.display ='none';
     document.getElementById("leavePage").style.display ='';
    }
    }
