

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
        <h2 ><font color="#366092">User Delete</font></h2>
        <form>
            <%
            
            int id = Integer.parseInt(request.getParameter("id") + "");
            DBProcess dbp = new DBProcess();
            dbp.open();
            dbp.delete_user_details(id);
           
            dbp.close();
            dbp.open();
            dbp.delete_user_login(id);
           
            dbp.close();
          
            out.println("User Deleted ");
            %>
            <br><a href="admin_user_list.jsp">User List</a>
        </form>

    </center>    

</body>
</html>
