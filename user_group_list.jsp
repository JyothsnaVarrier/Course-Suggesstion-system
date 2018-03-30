

<%@page import="db.tables.Group_Settings"%>
<%@page import="util.Variables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBProcess"%>

<%
 Object obj= session.getAttribute("ul");
if(obj==null)response.sendRedirect("user_login.jsp");
%>

<html>
    <head>
        <title>Course List</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
        <%@include file="user_menu.jsp" %>
         <h2><font color="#366092">Course List</font></h2>
         
         
        <form>
            <%
       //3. group_settings - id,g_name,g_descp,dt
            %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th> Name </th>
                    <th> Description </th>
                    <th> Date </th>
                    <th> Action </th>
                </tr>
                <%
                DBProcess dbp =new DBProcess();
                dbp.open();
                ArrayList<Group_Settings> gsList = dbp.selectAll_group_settings();
                dbp.close();
                
                if(gsList.size()==0){
                    %>
                    <tr>
                    <td>No</td>
                    <td>Data</td>
                    <td>----</td>
                    <td>----</td>
                    <td>----</td>
                   
                  
                    
                </tr>
                    <%
                }
                else{
                    for(Group_Settings gs:gsList){
                        %>
                        <tr>
                        <td><%=gs.id%></td>
                        <td>
                            &nbsp;<%=gs.g_name%>&nbsp;
                        </td>
                        <td>
                            &nbsp;<%=gs.g_descp%>&nbsp;
                        </td>
                        <td>
                            &nbsp;<%=gs.dt%>&nbsp;
                        </td>
                        <td>
                            &nbsp; 
                            <a href="user_group_subject_list.jsp?id=<%=gs.id%>">Subjects</a> | 
                            <a href="user_group_mark_list.jsp?id=<%=gs.id%>">Marks</a> &nbsp;
                        </td>
                    </tr>
                        <%
                    }
                }
                dbp.close();
            %>
            </table>
            
        </form>
       
    </center>    

</body>
</html>
