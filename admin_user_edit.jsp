

<%@page import="db.tables.User_Details"%>
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
        <title>Edit User  </title>
    </head>
    <!--  
      //7. user_details - id,name,gender,dob,email,contact,dt
        //8. user_login - id,uname,passwd,status
    -->
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Edit User</font></h2>
        <%
            int id = Integer.parseInt(request.getParameter("id") + "");
            DBProcess dbp = new DBProcess();
             dbp.open();
            User_Details ud = dbp.select_user_details(id);
            dbp.close();
            
                            
        %>
                        
        <form name="frm" action="admin_user_edit_action.jsp" method="post">
            <table>
                <tr>
                    <td> ID </td>
                    <td> <input type="hidden" name="id" value="<%=ud.id%>"><%=ud.id%> </td>
                </tr>
                <tr>
                    <td> Name </td>
                    <td> <input type="text" name="name" value="<%=ud.name%>"> </td>
                </tr>
                
                <tr>
                    <td> Date Of Birth </td>
                    <td> <input type="date" name="dob" value="<%=ud.dob%>"> </td>
                </tr>
                <tr>
                    <td> Gender </td>
                    <td> 
                        <% 
                        String m="";
                        String f="";
                        
                        if(ud.gender.equals("Male"))m="selected";
                        else f="slected";
                        %>
                        <select name="gender">
                            <option value="Male" <%=m%> >Male</option>
                            <option value="Female" <%=f%> >Female</option>
                        </select> 
                    </td>
                </tr>
                
                <tr>
                    <td> Contact </td>
                    <td> <input type="number" name="contact" value="<%=ud.contact%>"> </td>
                </tr>
                <tr>
                    <td> Email </td>
                    <td> <input type="email" name="email" value="<%=ud.email%>"> </td>
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
