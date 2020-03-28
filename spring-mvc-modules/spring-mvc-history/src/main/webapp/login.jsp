<%@page import="com.tom.domain.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>Login</title>
</head>
<body>
<%
    final String submitFlag = request.getParameter("submitFlag");
    if ("login".equals(submitFlag)) {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final UserBean userBean = new UserBean(username, password);
        if (userBean.login()) {
            out.write("login success");
        } else {
            out.write("login failed");
        }
    } else {%>
<form action="" method="post">
    <input type="hidden" name="submitFlag" value="login"/></br>
    Username: <input type="text" name="username"/></br>
    Password: <input type="password" name="password"/></br>
    <input type="submit" name="login"/></br>
</form>
<%}%>
</body>
</html>
