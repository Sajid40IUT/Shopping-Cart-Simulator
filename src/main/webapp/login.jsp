<%--
  Created by IntelliJ IDEA.
  User: sajidchowdhury
  Date: 24/3/23
  Time: 1:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>

<%@include file="include/navBeforeLogin.jsp"%>

    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">User Login</div>
            <div class="card-body">
                <form action="loginServlet" method="post">
                    <div class="form-group">
                        <label>User Name</label>
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>

                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" placeholder="password">
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn">Log in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

<%@include file="/include/foot.jsp"%>


</body>
</html>
