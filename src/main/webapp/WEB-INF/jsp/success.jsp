<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h1>Authentication success</h1>
<form action="http://www.163.com" method="post">
    <input type="hidden" name="token" id="token" value="${token}"/>
    <button type="submit">Jump To CPIC</button>
</form>
</body>
</html>
