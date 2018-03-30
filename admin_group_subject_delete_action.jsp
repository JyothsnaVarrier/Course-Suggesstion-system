

<%@page import="util.Variables"%>
<%@page import="util.DateTime"%>
<%@page import="db.DBProcess"%>


<html>
    <head>
        <title>User Delete</title>

    </head>

    <body>

    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Subject Delete</font></h2>
        <form>
            <%
            
            int id = Integer.parseInt(request.getParameter("id") + "");
            int group_id = Integer.parseInt(request.getParameter("group_id") + "");
            DBProcess dbp = new DBProcess();
            dbp.open();
            dbp.delete_group_subject_map(id);
           
            dbp.close();
          
            out.println("Subject Deleted ");
            %>
            <br><a href="admin_group_subject_list.jsp?id=<%=group_id%>">Subjects</a> &nbsp;
        </form>

    </center>    

</body>
</html>
