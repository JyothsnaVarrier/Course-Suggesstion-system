
<%@page import="db.tables.Subject_Settings"%>
<%@page import="util.Variables"%>
<%@page import="util.DateTime"%>
<%@page import="db.DBProcess"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject Add Action</title>
    </head>
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Add Subject Result</font></h2>
    <%
         //2. subject_settings - id,s_name,s_descp
    
    String s_name = request.getParameter("s_name");
    String s_descp = request.getParameter("s_descp");
   
    DBProcess dbp =new DBProcess();
    dbp.open();
    int id = dbp.getMaxID_subject_settings()+1;
    dbp.close();
    Subject_Settings  ss =new Subject_Settings(id, s_name, s_descp);
    dbp.open();
    int result = dbp.insert_subject_settings(ss);
    dbp.close();
    out.println(result + ">>"+ss.toString()+"<br>");
    
    %>
    Record Added
    </center>
</body>
</html>
