<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017-08-23
  Time: 오후 5:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.ts.vo.TimeLine"%>
<%@page import="java.util.List"%>
<%
	List<TimeLine> list = (List<TimeLine>) request.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/animate.css"/>
<link rel="stylesheet" href="css/login.css?ver6"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
    .naviBar{
        width: 100%;
        height: 7%;
        border: 1px solid black;
    }

    .search{
        width: 200px;
        height: auto;
        border: 1px solid black;
        margin-left: 40%;
    }

    .container{
        width: 600px;
        height: auto;
        margin-left: auto;
        border: 1px solid black;
    }

    .photo{
        width: 100%;
        height: 600px;
        border: 1px solid black;
    }

    .nickName{
        width: 100%;
        height: 50px;
        border: 1px solid black;
    }

    .iconBar{
        width: 100%;
        height: 50px;
        border: 1px solid black;
    }
    .content{
        width: 100%;
        height: 100px;
        border: 1px solid black;
    }
    .comment{
        width: 100%;
        height: 100px;
        border: 1px solid black;
    }
</style>
<body>
<div class="naviBar">
    <div class="search">
        <input type="search">
    </div>
</div>

<div class="container">

<c:forEach items="${list}" var="timelineVO">
    <div class="nickName">
            ${timelineVO.tid}
    </div>
    <div class="photo">
            ${timelineVO.mainImgPath}
    </div>
    <div class="iconBar">
        IconBar
    </div>
    <div class="content">
        Content
    </div>
    <div class="comment">
       Comment
    </div>
</c:forEach>
</div>

</body>
</html>
