
<%@page import="db.tables.Subject_Settings"%>
<%@page import="util.Variables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBProcess"%>

<%
 Object obj= session.getAttribute("al");
if(obj==null)response.sendRedirect("admin_login.jsp");
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
         <a href="admin_subject_add.jsp" >Add Subject</a><br><br>
         
        <form>
            <%
        //2. subject_settings - id,s_name,s_descp
            %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th> Name </th>
                    <th> Description </th>
                   
                    <th> Action </th>
                </tr>
                <%
                DBProcess dbp =new DBProcess();
                dbp.open();
                ArrayList<Subject_Settings> ssList = dbp.selectAll_subject_settings();
                dbp.close();
                
                if(ssList.size()==0){
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
                    for(Subject_Settings ss:ssList){
                        %>
                        <tr>
                        <td><%=ss.id%></td>
                        <td>
                            &nbsp;<%=ss.s_name%>&nbsp;
                        </td>
                        <td>
                            &nbsp;<%=ss.s_descp%>&nbsp;
                        </td>
                        <td>
                            &nbsp; <a href="admin_subject_edit.jsp?id=<%=ss.id%>">Update</a> | 
                            <a href="admin_subject_delete_action.jsp?id=<%=ss.id%>">Delete</a>&nbsp;
                        </td>
                    </tr>
                        <%
                    }
                }
                dbp.close();
            %>
            </table>
            
        </form>
        <a href="admin_subject_add.jsp" >Add Subject</a>
    </center>    

</body>
</html>
