<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017-07-19
  Time: 오전 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
	String email = "";
	Cookie cookies[] = request.getCookies();
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("cookieId")) {
		        email = cookie.getValue();
		    }
		}
	 }
%>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="/resources/css/regist.css"/>
<link rel="stylesheet" href="/resources/css/animate.css"/>
<link rel="stylesheet" href="/resources/css/login.css?ver1"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<body>
<div id="visual">
    <div id="video-bg">
        <iframe src="https://youtube.com/embed/DPC9erC5WqU?autoplay=1&controls=0&showinfo=0&wmode=opaque&autohide=1&loop=1&playlist=cZcsko5a9lE">
        </iframe>
    </div>
    <!-- login -->
    <div id="visual-content">
        <div class="card card-container animated fadeInUp" id="loginForm" style="animation-delay: 1s;">
            <%--<img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" />--%>
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"/>
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action = "/Login/main" method="POST">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="inputEmail" class="form-control" placeholder="Email address" name = "userEmail" value="<%=email %>" required autofocus>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name = "userPassword" required>
                <div id="remember" class="checkbox">
                    <label style="color: white">
                        <input type="checkbox" name="cookieCheck" value="remember" <%if(email.length()>1) out.println("checked"); %>> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="button" id="btn">Register</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
		<!-- register -->
        <div class="login-form-1" id="register" style="display: none; margin-top: 15%;">
            <form id="register-form" class="text-left" action = "/Login/registOk" method="POST">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <label for="reg_username" class="sr-only">Email address</label>
                            <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="userEmail">
                        </div>
                        <div class="form-group">
                            <label for="reg_password" class="sr-only">Password</label>
                            <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="password">
                        </div>
                        <div class="form-group">
                            <label for="reg_password_confirm" class="sr-only">Password Confirm</label>
                            <input type="password" class="form-control" id="userPasswordCheck" name="userPasswordCheck"
                                   placeholder="confirm password">
                        </div>

                        <div class="form-group">
                            <label for="reg_email" class="sr-only">닉네임</label>
                            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="nickname" required="required">
                            <p id="p1"></p>
                        </div>

                        <div class="form-group">
                            <label for="reg_fullname" class="sr-only">생년 월 일</label>
                            <input type="date" class="form-control" id="reg_fullname" name="reg_fullname"
                                   placeholder="full name">
                        </div>

                        <div class="form-group login-group-checkbox">
                            <input type="checkbox" class="" id="reg_agree" name="reg_agree">
                            <label for="reg_agree">i agree with <a href="#">terms</a></label>
                        </div>
                    </div>

                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>
                <div class="etc-login-form">
                    <p>already have an account? <a href="#">login here</a></p>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#btn').click(function () {
            $('#loginForm').css("animation-delay", "0s");
            $('#loginForm').addClass('animated fadeOutDown');
            $('#register').css("display","block");
            $('#register').addClass('animated fadeInUp');
        });
    });
</script>
<script type="text/javascript">

	$("#nickname").blur(function(){
		
		var id = $("#nickname").val();
			
		$.ajax({
			url: '/Login/idCheck',
			data: id,
			dataType: 'text',
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data) {
				alert(data);
			},
			error: function(data) {
				alert("error");
			}
		}); 
	});

</script>
</body>
</html>