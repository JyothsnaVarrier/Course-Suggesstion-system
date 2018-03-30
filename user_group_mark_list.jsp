
<%@page import="db.tables.User_Mark_Details"%>
<%@page import="db.tables.User_Login"%>
<%@page import="db.tables.User_Mark"%>
<%@page import="db.tables.Group_Settings"%>
<%@page import="db.tables.Mark_Details"%>
<%@page import="db.tables.Mark_History"%>
<%@page import="db.tables.Group_Subject_Map"%>
<%@page import="db.tables.Subject_Settings"%>
<%@page import="util.Variables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBProcess"%>

<%
 Object obj= session.getAttribute("ul");
if(obj==null)response.sendRedirect("user_login.jsp");
int id = Integer.parseInt(request.getParameter("id") + "");
User_Login ul = (User_Login)obj;
%>

<html>
    <head>
        <title>Mark List</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
        <%@include file="user_menu.jsp" %>
         <h2><font color="#366092">Mark List</font></h2>
         <a href="user_group_mark_add.jsp?id=<%=id%>" >Add Mark</a>
         
        <form>
            <%
        //9. user_mark - id,user_id,group_id,dt
    //10. user_mark_details - id,user_mark_id,subject_id,mark
          
            %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th> Course </th>
                    <th> Subjects </th>
                   
                </tr>
                <%
                DBProcess dbp =new DBProcess();
                dbp.open();
                ArrayList<User_Mark> umList = dbp.selectAll_user_mark(ul.id,id);
                dbp.close();
                
                if(umList.size()==0){
                    %>
                    <tr>
                    <td>No</td>
                    <td>Data</td>
                    <td>----</td>
                    
                                  
                    
                </tr>
                    <%
                }
                else{
                    for(User_Mark um:umList){
                    dbp.open();
                    ArrayList<User_Mark_Details> umdList = dbp.selectAll_user_mark_details(um.id);
                    dbp.close();
                    dbp.open();
                    Group_Settings gs = dbp.select_group_settings(id);
                    dbp.close();
                    %>
                        <tr>
                        <td><%=um.id%></td>
                        <td>
                            &nbsp;<%=gs.g_name%>&nbsp;
                        </td>
                        <td>
                            <%
                                for(User_Mark_Details umd:umdList){
                                    dbp.open();
                                    Subject_Settings ss =dbp.select_subject_settings(umd.subject_id);
                                    dbp.close();
                            %>
                            <%=ss.s_name%>:<%=umd.mark%><br>
                            <%
                                }
                            %>
                                    
                        </td>
                        
                    </tr>
                        <%
                    }
                }
                dbp.close();
            %>
            </table>
            
        </form>
        <a href="user_group_mark_add.jsp?id=<%=id%>" >Add Mark</a>
    </center>    

</body>
</html>
