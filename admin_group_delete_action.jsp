

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
        <h2 ><font color="#366092">Course Delete</font></h2>
        <form>
            <%
            
            int id = Integer.parseInt(request.getParameter("id") + "");
            DBProcess dbp = new DBProcess();
            dbp.open();
            dbp.delete_group_settings(id);
           
            dbp.close();
            dbp.open();
            dbp.delete_group_subject_map2(id);
           
            dbp.close();
          
            out.println("Course Deleted ");
            %>
            <br><a href="admin_group_list.jsp">Course List</a>
        </form>

    </center>    

</body>
</html>
