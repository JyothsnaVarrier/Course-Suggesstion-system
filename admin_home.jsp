<%@page import="util.Variables"%>
<%

Object obj= session.getAttribute("al");
if(obj==null)response.sendRedirect("admin_login.jsp");
%>

<html>
    <head>
        <title>Welcome Home Admin</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
            <%@include file="admin_menu.jsp" %>
         <h2 ><font color="#366092">Welcome Home Admin</font></h2>
        <form>
            <img src="img/bg.png">
        </form>

    </center>    

</body>
</html>
