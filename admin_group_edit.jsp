
<%@page import="db.tables.Group_Settings"%>
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
        <title>Edit Course  </title>
    </head>
    <!--  
      //3. group_settings - id,g_name,g_descp,dt
    -->
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Edit Course</font></h2>
        <%
            int id = Integer.parseInt(request.getParameter("id") + "");
            DBProcess dbp = new DBProcess();
             dbp.open();
            Group_Settings gs =dbp.select_group_settings(id);
            dbp.close();
            
                            
        %>
                        
        <form name="frm" action="admin_group_edit_action.jsp" method="post">
            <table>
                <tr>
                    <td> ID </td>
                    <td> <input type="hidden" name="id" value="<%=gs.id%>"><%=gs.id%> </td>
                </tr>
                <tr>
                    <td> Name </td>
                    <td> <input type="text" name="g_name" value="<%=gs.g_name%>"> </td>
                </tr>
                
                <tr>
                    <td> Description </td>
                    <td> <input type="text" name="g_descp" value="<%=gs.g_descp%>"> </td>
                </tr>
                
                <tr>
                     <td></td>
                     <td> 
                         <input type="submit" name="s1" value="Update"> 
                        <input type="reset" name="r1" value="Reset"> 
                     </td>
                </tr>
                
            </table>
        </form>
        <center>
    </body>
</html>
