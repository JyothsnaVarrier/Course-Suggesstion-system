
<%@page import="db.tables.Group_Subject_Map"%>
<%@page import="db.tables.Subject_Settings"%>
<%@page import="db.tables.Group_Settings"%>
<%@page import="util.Variables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBProcess"%>
<!DOCTYPE html>
<%

Object obj= session.getAttribute("ul");
if(obj==null)response.sendRedirect("user_login.jsp");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Mark  </title>
    </head>
    <!--  
        //2. subject_settings - id,s_name,s_descp
    -->
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="user_menu.jsp" %>
        <h2 ><font color="#366092">Add Mark</font></h2>
        <%
            int id = Integer.parseInt(request.getParameter("id") + "");
            DBProcess dbp = new DBProcess();
             dbp.open();
            Group_Settings gs = dbp.select_group_settings(id);
            dbp.close();
              dbp.open();
            ArrayList<Group_Subject_Map> gsmList1 = dbp.selectAll_group_subject_map(gs.id,0);
            dbp.close();
           
            
            //4. group_subject_map - id,group_id,subject_id,is_elective        
             //9. user_mark - id,user_id,group_id,dt
            //10. user_mark_details - id,user_mark_id,subject_id,mark
        %>
                        
        <form name="frm" action="user_group_mark_add_action.jsp" method="post">
            <table>
               
                <tr>
                    <td>Course Name :</td>
                    <td><%=gs.g_name%> <input type="hidden" name="group_id" value="<%=id%>"> </td>
                </tr>
               
                <tr>
                    <td valign="top"> Subjects </td>
                    
                    <td> 
                        <table>
                            <%
                                for(Group_Subject_Map gsm : gsmList1){
                                  dbp.open();
                                  Subject_Settings ss = dbp.select_subject_settings(gsm.subject_id);
                                  
                                    dbp.close();   

                            %>
                            <tr>
                                <td>
                            <%=ss.s_name%>
                            </td>
                            <td>
                            <input type="text" name="subject_<%=ss.id%>" value="0">
                            </td>
                            </tr>
                            <% }%>
                        
                    
                    </table>
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
