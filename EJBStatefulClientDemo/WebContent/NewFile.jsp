<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tf1").hide();
		$("#tf2").hide();
		$("#b1").hide();
		$("#add").click(function(){
			$("#tf1").show();
			$("#tf2").show();
		})
		$("#remove").click(function(){
			$("#tf2").hide();
			$("#tf1").show();
		})
		$("#totalprice").click(function(){
			$("#tf2").hide();
			$("#tf1").hide();
		})
	})
</script>
</head>
<body>
	<form action="Demo" method="get" name="f">
		<input type="radio" value="add" name="choice" id="add">ADD ITEM 
		<input type="radio" value="remove" name="choice" id="remove">REMOVE ITEM 
		<input type="radio" value="totalprice" name="choice" id="totalprice">TOTAL PRICE<br><br>
		<input type="text" name="prodname" id="tf1" placeholder="Enter Name"> <br>
		<input type="text" name="prodprice" id="tf2" placeholder="Enter price"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>