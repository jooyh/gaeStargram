<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#eb").click(function(){
		alert("hi~");
	});
});
</script>
<title>JSP</title>
</head>
<body>
	<nav class="navbar navbar-default">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="main.jsp">
			<!-- <img alt="" src="img/dog.jpg" height="30" width="30"> -->
		</a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li><a href="">Main</a></li>
            <li><a href="">Map</a></li>
            <li><a href="">SNS</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
         	<li>
            	<a href="#">anything</a>
            </li>
            <li>
            	<a href="#" id="eb">긴급</a>
            </li>
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                  role="button" aria-haspopup="true" aria-expanded="false">
                  Login<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li class="active"><a href="login.jsp">Login</a></li>
                  <li><a href="">Join</a></li>
               </ul>
            </li>
         </ul>
      </div>
   </nav>
</body>
</html>