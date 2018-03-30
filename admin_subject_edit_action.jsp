


<%@page import="db.tables.Subject_Settings"%>
<%@page import="db.tables.User_Login"%>
<%@page import="db.tables.User_Details"%>
<%@page import="util.Variables"%>
<%@page import="util.DateTime"%>
<%@page import="db.DBProcess"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject Edit Action</title>
    </head>
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>

        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Edit Subject Result</font></h2>
            <%
                //2. subject_settings - id,s_name,s_descp
                int id = Integer.parseInt(request.getParameter("id") + "");
                String s_name = request.getParameter("s_name");
                String s_descp = request.getParameter("s_descp");

                DBProcess dbp = new DBProcess();
                dbp.open();
                Subject_Settings ss = dbp.select_subject_settings(id);
                dbp.close();
                ss = new Subject_Settings(id, s_name, s_descp);
                dbp.open();
                int result = dbp.update_subject_settings(ss);
                dbp.close();
                out.println(result + ">>" + ss.toString() + "<br>");

            %>
        Record Updated
    </center>
</body>
</html>
