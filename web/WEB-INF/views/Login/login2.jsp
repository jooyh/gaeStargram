<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<meta charset="UTF-8">
<title>JSP</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
h2   {color:white}
p    {color:white}

body, html {
    height: 100%;
    background-repeat: no-repeat;
    /*background-image: linear-gradient(135deg, rgba(31,123,229,1) 0%, rgba(58,139,232,1) 47%, rgba(70,153,234,1) 92%, rgba(72,156,234,1) 100%);*/
	/*background-image: url("https://youtube.com/embed/tvTRZJ-4EyI?autoplay=1&controls=0&showinfo=0&wmode=opaque&autohide=1&loop=1&playlist=cZcsko5a9lE"); */    
	background-size: 100% 100%;
}

.card-container.card {
    width: 350px;
    padding: 40px 40px;
    margin-top: 200px;
    background-color: rgba(255,255,255,0.9);
}

.btn {
    font-weight: 700;
    height: 36px;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    cursor: default;
}

/*
 * Card component
 */
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}

/*
 * Form styles
 */
.profile-name-card {
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    margin: 10px 0 0;
    min-height: 1em;
}

.reauth-email {
    display: block;
    color: #404040;
    line-height: 2;
    margin-bottom: 10px;
    font-size: 14px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin #inputEmail,
.form-signin #inputPassword {
    direction: ltr;
    height: 44px;
    font-size: 16px;
}

.form-signin input[type=email],
.form-signin input[type=password],
.form-signin input[type=text],
.form-signin button {
    width: 100%;
    display: block;
    margin-bottom: 10px;
    z-index: 1;
    position: relative;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin .form-control:focus {
    border-color: rgb(104, 145, 162); 
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
    /*background-color: #4d90fe; */
    /*background-color: rgb(104, 145, 162);
    / background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
    padding: 0px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
}


.forgot-password {
    color: rgb(104, 145, 162);
}

.forgot-password:hover,
.forgot-password:active,
.forgot-password:focus{
    color: rgb(12, 97, 33);
}

.iframe {
	z-index: -100;
	width: 100%
}

</style>
</head>
<body>
<%@include file="nav.jsp" %>
<div class="container">
	<div id="iframe">
		<iframe src="https://youtube.com/embed/tvTRZJ-4EyI?autoplay=1&controls=0&showinfo=0&wmode=opaque&autohide=1&loop=1&playlist=cZcsko5a9lE"></iframe>
	</div>
	<div class="card card-container">
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="/Login/loginOk" method="POST">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="userEmail" name="userEmail" class="form-control" value="<%=email %>" placeholder="Email" required autofocus>
                <input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" name="cookieCheck" value="remember" <%if(email.length()>1) out.println("checked"); %>> Remember-Email
                    </label>
                </div>
                <button class="btn btn-lg btn-success btn-block btn-signin" type="submit">Login</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">Forgot the password?</a>
            <a href="#" class="forgot-password">Regist</a>
	</div><!-- /card-container -->
</div><!-- /container -->
</body>
</html>