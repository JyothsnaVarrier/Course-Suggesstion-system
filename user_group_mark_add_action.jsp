
<%@page import="db.tables.User_Mark_Details"%>
<%@page import="db.tables.User_Mark"%>
<%@page import="db.tables.User_Login"%>
<%@page import="db.tables.Mark_Details"%>
<%@page import="db.tables.Mark_History"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.tables.Group_Settings"%>
<%@page import="db.tables.Group_Subject_Map"%>
<%@page import="db.tables.Subject_Settings"%>
<%@page import="util.Variables"%>
<%@page import="util.DateTime"%>
<%@page import="db.DBProcess"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mark Add Action</title>
    </head>
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="user_menu.jsp" %>
        <h2 ><font color="#366092">Add Mark Result</font></h2>
    <%
        Object obj= session.getAttribute("ul");
if(obj==null)response.sendRedirect("user_login.jsp");
User_Login ul =(User_Login)obj;
         //4. group_subject_map - id,group_id,subject_id,is_elective  
             //9. user_mark - id,user_id,group_id,dt
            //10. user_mark_details - id,user_mark_id,subject_id,mark
        
      
        // out.print(gid+","+sid+","+ise+",");
       
         
        int group_id = Integer.parseInt(request.getParameter("group_id"));
     
        String dt = DateTime.getDate();
        
        DBProcess dbp = new DBProcess();
        dbp.open();
        Group_Settings gs = dbp.select_group_settings(group_id);
        dbp.close();
        dbp.open();
        ArrayList<Group_Subject_Map> gsmList1 = dbp.selectAll_group_subject_map(gs.id,0);
        dbp.close();
        
        
        dbp.open();
        int id = dbp.getMaxID_user_mark()+1;
        dbp.close();
        User_Mark um = new User_Mark(id, ul.id, group_id, dt);
        dbp.open();
        int result = dbp.insert_user_mark(um);
        dbp.close();
        out.println(result + ">>"+um.toString()+"<br>");
        for(Group_Subject_Map gsm : gsmList1){
            //dbp.open();
            //Subject_Settings ss = dbp.select_subject_settings(gsm.subject_id);
            //dbp.close();
            int tmark =  Integer.parseInt(request.getParameter("subject_"+gsm.id));
            dbp.open();
            int tid = dbp.getMaxID_mark_details()+1;
            dbp.close();
            User_Mark_Details umd = new User_Mark_Details(tid,um.id,gsm.subject_id,tmark);
            dbp.open();
            dbp.insert_user_mark_details(umd);
            dbp.close();
            out.println(result + ">>"+umd.toString()+"<br>");
        }
        
        
        
    
    %>
        Record Added<br>
    <a href="user_group_mark_list.jsp?id=<%=group_id%>">Marks</a> &nbsp;
    </center>
</body>
</html>
