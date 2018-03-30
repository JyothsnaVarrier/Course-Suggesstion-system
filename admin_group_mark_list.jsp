
<%@page import="db.tables.Group_Settings"%>
<%@page import="db.tables.Mark_Details"%>
<%@page import="db.tables.Mark_History"%>
<%@page import="db.tables.Group_Subject_Map"%>
<%@page import="db.tables.Subject_Settings"%>
<%@page import="util.Variables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBProcess"%>

<%
 Object obj= session.getAttribute("al");
if(obj==null)response.sendRedirect("admin_login.jsp");
int id = Integer.parseInt(request.getParameter("id") + "");
%>

<html>
    <head>
        <title>Mark List</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
        <%@include file="admin_menu.jsp" %>
         <h2><font color="#366092">Mark List</font></h2>
         <a href="admin_group_mark_add.jsp?id=<%=id%>" >Add Mark</a>
         
        <form>
            <%
         //5. mark_history - id,name,group_id,elective_id,dt
    //6. mark_details - id,mark_history_id,subject_id,mark
          
            %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th> Name </th>
                    <th> Course </th>
                    <th> Subjects </th>
                    <th> Action </th>
                </tr>
                <%
                DBProcess dbp =new DBProcess();
                dbp.open();
                ArrayList<Mark_History> mhList = dbp.selectAll_mark_history(id);
                dbp.close();
                
                if(mhList.size()==0){
                    %>
                    <tr>
                    <td>No</td>
                    <td>Data</td>
                    <td>----</td>
                    <td>----</td>
                    <td>----</td>
                    <td>----</td>
                                  
                    
                </tr>
                    <%
                }
                else{
                    for(Mark_History mh:mhList){
                    dbp.open();
                    ArrayList<Mark_Details> mdList = dbp.selectAll_mark_details(mh.id);
                    dbp.close();
                    dbp.open();
                    Group_Settings gs = dbp.select_group_settings(id);
                    dbp.close();
                    %>
                        <tr>
                        <td><%=mh.id%></td>
                        <td>
                            &nbsp;<%=mh.name%>&nbsp;
                        </td>
                        <td>
                            &nbsp;<%=gs.g_name%>&nbsp;
                        </td>
                        <td>
                            <%
                                for(Mark_Details md:mdList){
                                    dbp.open();
                                    Subject_Settings ss =dbp.select_subject_settings(md.subject_id);
                                    dbp.close();
                            %>
                            <%=ss.s_name%>:<%=md.mark%><br>
                            <%
                                }
                            %>
                                    
                        </td>
                        <td>
                            &nbsp; <a href="admin_group_mark_delete_action.jsp?id=<%=mh.id%>&group_id=<%=mh.group_id%>">Delete</a>&nbsp;
                        </td>
                    </tr>
                        <%
                    }
                }
                dbp.close();
            %>
            </table>
            
        </form>
        <a href="admin_group_mark_add.jsp?id=<%=id%>" >Add Mark</a>
    </center>    

</body>
</html>
