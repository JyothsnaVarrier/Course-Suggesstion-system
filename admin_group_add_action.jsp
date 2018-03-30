
<%@page import="db.tables.Group_Settings"%>
<%@page import="util.Variables"%>
<%@page import="util.DateTime"%>
<%@page import="db.DBProcess"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Add Action</title>
    </head>
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Add Course Result</font></h2>
    <%
         
     //3. group_settings - id,g_name,g_descp,dt
     
    String g_name = request.getParameter("g_name");
    String g_descp = request.getParameter("g_descp");
   String dt = DateTime.getDate();
    DBProcess dbp =new DBProcess();
    dbp.open();
    int id = dbp.getMaxID_group_settings()+1;
    dbp.close();
    Group_Settings gs = new Group_Settings(id, g_name, g_descp, dt);
    dbp.open();
    int result = dbp.insert_group_settings(gs);
    dbp.close();
    out.println(result + ">>"+gs.toString()+"<br>");
    
    %>
    Record Added
    </center>
</body>
</html>
