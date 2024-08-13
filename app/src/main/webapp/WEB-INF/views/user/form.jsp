<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2024. 8. 13.
  Time: 오후 7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>SignUp Form</h1>

<form action="${pageContext.request.contextPath}/user/register" method="post">
    <label for="username">Username</label>
    <input type="text" name="username" id="username"/>
    <br/>

    <label for="password">Password</label>
    <input type="password" name="password" id="password"/>
    <br/>

    <label for="nickname">Nickname</label>
    <input type="text" name="nickname" id="nickname"/>
    <br/>

    <label for="email">Email</label>
    <input type="email" name="email" id="email"/>
    <br/>

    <button type="submit">SignUp</button>
</form>

</body>
</html>
