<%@page import="util.Variables"%>
<%

Object obj= session.getAttribute("ul");
if(obj==null)response.sendRedirect("user_login.jsp");
%>

<html>
    <head>
        <title>Welcome Home User</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
            <%@include file="user_menu.jsp" %>
         <h2 ><font color="#366092">Welcome Home User</font></h2>
        <form>
            <img src="img/bg.png">
        </form>

    </center>    

</body>
</html>
