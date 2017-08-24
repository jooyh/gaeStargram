<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script type="text/javascript" src="/HTMLProject/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/animate.css">
<script type="text/javascript">
$(function(){
	$("#icon1").click(function(){
		location.href = "#";
	});
	$("#icon1").mouseover(function(){
		
	});
});
</script>
<style>
.h-arrange {
	horizon-align:middle;
}
</style>
</head>
<body>
<%@include file="nav.jsp" %>
<div id="icons" style="horizon-align:middle align=center" class="h-arrange">
	<div id="icon1" class="animated rubberBand">
		<img style="width: 150px; height: auto" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFeXFnFdnAmlPGRx4Zh7Y7JxiW0Z7ZnoYQkvTHldpYZOzLFdv2">
	</div>
	<div id="icon2" class="animated rubberBand">
		<img style="width: 150px; height: auto" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFeXFnFdnAmlPGRx4Zh7Y7JxiW0Z7ZnoYQkvTHldpYZOzLFdv2">
	</div>
	<div id="icon3" class="animated rubberBand">
		<img style="width: 150px; height: auto" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFeXFnFdnAmlPGRx4Zh7Y7JxiW0Z7ZnoYQkvTHldpYZOzLFdv2">
	</div>
	<div id="icon4" class="animated rubberBand">
		<img style="width: 150px; height: auto" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFeXFnFdnAmlPGRx4Zh7Y7JxiW0Z7ZnoYQkvTHldpYZOzLFdv2">
	</div>
</div>
</body>
</html>