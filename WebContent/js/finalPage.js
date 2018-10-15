


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
      var col = rows.getElementsByTagName('input')[4];
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
    
    var backupResource = rows.getElementsByTagName('input')[4];
                
         
         var url="test.action?fromDate=" +fr.value+"&toDate="+td.value+"&empId="+ei.value+"&empName="+en.value+"&method="+str1+"&backupres="+backupResource.value+"&oldfromdate="+oldfromdate;  
   
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
      var backupResource = rows.getElementsByTagName('input')[4];
          
         var url="test.action?fromDate=" +fr.value+"&toDate="+td.value+"&empId="+ei.value+"&empName="+en.value+"&method="+str1+"&backupres="+backupResource.value;  
          
        

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

    function blockSpecialChar(e){
        var k;
        document.all ? k = e.keyCode : k = e.which;
       return((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32  );
        alert("please enter only text");
        }



