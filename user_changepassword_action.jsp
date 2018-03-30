<%@page import="db.tables.User_Login"%>
<%@page import="util.Variables"%>
<%@page import="db.DBProcess"%>
<%

Object obj= session.getAttribute("ul");
if(obj==null)response.sendRedirect("user_login.jsp");
%>
<html>
    <head>
        <title>User Change Password Result</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
            <%@include file="user_settings_menu.jsp" %>
         <h2 ><font color="#366092">User Change Password Result</font></h2>
        <form>
            <%
              
              String opasswd = request.getParameter("opasswd");
              String npasswd = request.getParameter("npasswd");
              User_Login ul = (User_Login)obj;
              DBProcess dbp =new DBProcess();
              dbp.open();
              int result = dbp.update_user_login(ul.uname, opasswd, npasswd);
              dbp.close();
                if(result>0){
                  out.println("Password Changed");}
               else{
                   out.println("Password not changed");
               }
              %>
        </form>
        
    </center>    

</body>
</html>
