


<%@page import="db.tables.Group_Settings"%>
<%@page import="util.Variables"%>
<%@page import="util.DateTime"%>
<%@page import="db.DBProcess"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Edit Action</title>
    </head>
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>

        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Edit Course Result</font></h2>
            <%
                 //3. group_settings - id,g_name,g_descp,dt
                int id = Integer.parseInt(request.getParameter("id") + "");
                String g_name = request.getParameter("g_name");
                String g_descp = request.getParameter("g_descp");

                DBProcess dbp = new DBProcess();
                dbp.open();
                Group_Settings gs = dbp.select_group_settings(id);
                dbp.close();
                gs = new Group_Settings(id, g_name, g_descp, gs.dt);
                dbp.open();
                int result = dbp.update_group_settings(gs);
                dbp.close();
                out.println(result + ">>" + gs.toString() + "<br>");

            %>
        Record Updated
    </center>
</body>
</html>
