
<%@page import="db.tables.Group_Subject_Map"%>
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
         //4. group_subject_map - id,group_id,subject_id,is_elective     
         String gid=request.getParameter("group_id");
         String sid = request.getParameter("subject_id");
         String ise =request.getParameter("is_elective");
      
        // out.print(gid+","+sid+","+ise+",");
         
        int group_id = Integer.parseInt(gid);
        int subject_id = Integer.parseInt(sid);
        int is_elective = Integer.parseInt(ise);
   
    DBProcess dbp =new DBProcess();
    dbp.open();
    int id = dbp.getMaxID_group_subject_map()+1;
    dbp.close();
    Group_Subject_Map gsm =new Group_Subject_Map(id, group_id, subject_id, is_elective);
    dbp.open();
    int result = dbp.insert_group_subject_map(gsm);
    dbp.close();
    out.println(result + ">>"+gsm.toString()+"<br>");
    
    %>
        Record Added<br>
    <a href="admin_group_subject_list.jsp?id=<%=group_id%>">Subjects</a> &nbsp;
    </center>
</body>
</html>
