<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${message}</br>
${message2}</br>
${message3}</br>
<form action="${pageContext.request.contextPath}/hello" method="post">

    name:<input type="text" name="name"/><br/>
    <input type="submit" value="login"/>
</form>

</body>
</html>
