
<%@page import="util.Variables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBProcess"%>
<!DOCTYPE html>
<%

Object obj= session.getAttribute("al");
if(obj==null)response.sendRedirect("admin_login.jsp");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Subject  </title>
    </head>
    <!--  
        //2. subject_settings - id,s_name,s_descp
    -->
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Add Subject</font></h2>
        <%
      
                            
        %>
                        
        <form name="frm" action="admin_subject_add_action.jsp" method="post">
            <table>
                <tr>
                    <td> Name </td>
                    <td> <input type="text" name="s_name"> </td>
                </tr>
                
                    <tr>
                    <td> Description </td>
                    <td> <textarea name="s_descp"></textarea> </td>
                </tr>
                
               
                <tr>
                     <td></td>
                     <td> 
                         <input type="submit" name="s1" value="Add"> 
                        <input type="reset" name="r1" value="Reset"> 
                     </td>
                </tr>
                
            </table>
        </form>
        <center>
    </body>
</html>
