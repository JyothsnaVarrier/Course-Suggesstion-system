
<%@page import="db.tables.Subject_Settings"%>
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
            int id = Integer.parseInt(request.getParameter("id") + "");
            DBProcess dbp = new DBProcess();
             dbp.open();
            Group_Settings gs = dbp.select_group_settings(id);
            dbp.close();
              dbp.open();
            ArrayList<Subject_Settings> ssList = dbp.selectAll_subject_settings();
            dbp.close();
                    //4. group_subject_map - id,group_id,subject_id,is_elective        
        %>
                        
        <form name="frm" action="admin_group_subject_add_action.jsp" method="post">
            <table>
                <tr>
                    <td>Course Name </td>
                    <td><%=gs.g_name%> <input type="hidden" name="group_id" value="<%=id%>"> </td>
                </tr>
                <tr>
                    <td> Subjects </td>
                    <td> 
                        <select name="subject_id">
                            <%
                                for(Subject_Settings ss : ssList){
                            %>
                            <option value="<%=ss.id%>"><%=ss.s_name%></option>
                            <% }%>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td> Elective </td>
                    <td> 
                        <select name="is_elective">
                            <option value="0">No</option>
                            <option value="1">Yes</option>
                        </select> 
                    </td>
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
