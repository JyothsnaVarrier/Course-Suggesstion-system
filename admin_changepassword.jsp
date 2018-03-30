<%@page import="util.Variables"%>
<%

Object obj= session.getAttribute("al");
if(obj==null)response.sendRedirect("admin_login.jsp");
%>
<html>
    <head>
        <title>Admin Change Password</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
        <%@include file="admin_settings_menu.jsp" %>
        <h2 ><font color="#366092">Admin Change Password</font></h2>
        <form name="frm" action="admin_changepassword_action.jsp" method="post">
            <table>
                <tr>
                    <td> Old Password </td>
                    <td> <input type="password" name="opasswd"> </td>
                </tr>
                <tr>
                    <td>  New Password </td>
                    <td> <input type="password" name="npasswd"> </td>
                </tr>
                <tr>
                    <td> Confirm Password </td>
                    <td> <input type="password" name="cpasswd"> </td>
                </tr>
                <tr>
                    <td>  </td>
                    <td> <input type="submit" name="s1" value="Change Password"> <input type="reset" name="r1" value="Reset"> </td>
                    
                </tr>
                
            </table>

    </center>    

</body>
</html>
