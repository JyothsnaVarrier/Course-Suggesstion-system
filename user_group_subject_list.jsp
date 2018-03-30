
<%@page import="db.tables.Group_Subject_Map"%>
<%@page import="db.tables.Subject_Settings"%>
<%@page import="util.Variables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBProcess"%>

<%
 Object obj= session.getAttribute("ul");
if(obj==null)response.sendRedirect("user_login.jsp");
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
        
         
        <form>
            <%
        //4. group_subject_map - id,group_id,subject_id,is_elective   
          
            %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th> Name </th>
                    <th> Is Elective </th>
                   
                    
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
