<%-- 
    Document   : user_login
    Created on : 24 Nov, 2015, 12:21:16 PM
    Author     : sarath
--%>

<%@page import="util.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.invalidate();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
    </head>
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
         <%@include file="home_menu.jsp" %>
        <h2><font color="#366092">User Login</font></h2>
        <img src="img/person.png" width="150" height="150">
        <form name="frm" action="user_login_action.jsp" method="post">
            <table>
                <tr>
                    <td> User Name </td>
                    <td> <input type="text" name="uname"> </td>
                </tr>
                <tr>
                    <td>  Password </td>
                    <td> <input type="password" name="passwd"> </td>
                </tr>
                
                <tr>
                    <td>  </td>
                    <td> <input type="submit" name="s1" value="Login"> <input type="reset" name="r1" value="Reset"> </td>
                    
                </tr>
                
            </table>
             <br><br><a href="user_user_add.jsp" >New User Registration</a><br><br>
        </form>
    </center>
    </body>
</html>
