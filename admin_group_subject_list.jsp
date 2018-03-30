
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
        <title>Subject List</title>

    </head>

    <body >

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
        <%@include file="admin_menu.jsp" %>
         <h2><font color="#366092">Subject List</font></h2>
         <a href="admin_group_subject_add.jsp?id=<%=id%>" >Add Subject</a>
         
        <form>
            <%
        //4. group_subject_map - id,group_id,subject_id,is_elective   
          
            %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th> Name </th>
                    <th> Is Elective </th>
                   
                    <th> Action </th>
                </tr>
                <%
                DBProcess dbp =new DBProcess();
                dbp.open();
                ArrayList<Group_Subject_Map> gsmList = dbp.selectAll_group_subject_map(id);
                dbp.close();
                
                if(gsmList.size()==0){
                    %>
                    <tr>
                    <td>No</td>
                    <td>Data</td>
                    <td>----</td>
                   
                    <td>----</td>
                   
                  
                    
                </tr>
                    <%
                }
                else{
                    for(Group_Subject_Map gsm:gsmList){
                    dbp.open();
                    Subject_Settings ss=dbp.select_subject_settings(gsm.subject_id);
                     String elective[]=new String[]{"No","Yes"};   
                    dbp.close();
                    %>
                        <tr>
                        <td><%=gsm.id%></td>
                        <td>
                            &nbsp;<%=ss.s_name%>&nbsp;
                        </td>
                        <td>
                            &nbsp;<%=elective[gsm.is_elective]%>&nbsp;
                        </td>
                        <td>
                            &nbsp; <a href="admin_group_subject_delete_action.jsp?id=<%=gsm.id%>&group_id=<%=gsm.group_id%>">Delete</a>&nbsp;
                        </td>
                    </tr>
                        <%
                    }
                }
                dbp.close();
            %>
            </table>
            
        </form>
        <a href="admin_group_subject_add.jsp?id=<%=id%>" >Add Subject</a>
    </center>    

</body>
</html>
