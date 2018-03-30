<%@page import="util.Variables"%>
<html>
    <head>
        <title>Welcome Home Admin</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
        <%@include file="admin_settings_menu.jsp" %>
        <h2 ><font color="#366092">Settings</font></h2>
        <form>
             <img src="img/settings.png">
        </form>

    </center>    

</body>
</html>
