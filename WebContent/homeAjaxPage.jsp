<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>PCP Search</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	</head>
	<script>
	function fetchData() {
		document.location.href = "BackupService";
	}
</script>
<style>
.input-sm {
	width: 80px;
}

input[type=number]::-webkit-inner-spin-button {
	-webkit-appearance: none;
	opacity: 1;
}
</style>
<script>
	$(document).ready(function() {
	
			$.get('BackupService', {
				
			}, function(response) {
				alert(response);
				var select = $('#county');
				select.find('option').remove();
				$.each(response, function(index, value) {
				
					$('<option>').val(value).text(value).appendTo(select);
				});
			});
		});
	
</script>
<body>

	<div class="container">

		<form action="BackupService" method="GET" style="margin-top: 100px">
			<table>
				<tr>
					<td>State:</td>
					<td><select id="state" name='stateCd'
						class="form-control input-sm">
							<option>33</option>
							<option>40</option>
							<option>36</option>

					</select></td>
					<td>&nbsp; &nbsp; &nbsp; &nbsp; County:</td>
					<td><select id="county" name='ssacnty'
						class="form-control input-sm">
							

					</select></td>
					
				</tr>
				<tr>
					<td colspan="7" align="center">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<br>
										<th>Zip Codes</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											${listData}
								</td>
									</tr>
								</tbody>
							</table>
						</div>
						<center></center> <input type="button" value="Make Request"
						class="btn btn-success" onclick="fetchData()" />
					</td>
				</tr>
			</table>
		</form>



		

	</div>






</body>
</html>