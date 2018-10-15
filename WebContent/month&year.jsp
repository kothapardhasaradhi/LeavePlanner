
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="css/monthpicker.css" rel="stylesheet" type="text/css">
</head>

</div>
<div class="jquery-script-clear"></div>
</div>

<div class="container" style="margin:150px auto 50px auto; max-width:640px;">
<h2>select month,year:</h2>
<!-- <input id="demo-1" type="text" /> -->


</div>
<!-- <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/monthpicker.min.js"></script> -->
<!-- <script>
$('#demo-1').Monthpicker();/* 
$('#demo-1').Monthpicker(); */
bootbox.prompt({
    title: "This is a prompt with a date input!",
    inputType: 'date',
    callback: function (result) {
        console.log(result);
    }
});bootbox.prompt({
    title: "This is a prompt with a date input!",
    inputType: 'date',
    callback: function (result) {
        console.log(result);
    }
});
</script> -->

<script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
<script>
    webshims.setOptions('forms-ext', {types: 'month'});
webshims.polyfill('forms forms-ext');
</script>
<input type="month" />

</body>
</html>
