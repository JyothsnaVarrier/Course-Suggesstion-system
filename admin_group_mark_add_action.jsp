
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
       
        <%@include file="admin_menu.jsp" %>
        <h2 ><font color="#366092">Add Mark Result</font></h2>
    <%
         //4. group_subject_map - id,group_id,subject_id,is_elective  
         //5. mark_history - id,name,group_id,elective_id,dt
        
      
        // out.print(gid+","+sid+","+ise+",");
        String name = request.getParameter("name");
         
        int group_id = Integer.parseInt(request.getParameter("group_id"));
        int elective_id = Integer.parseInt(request.getParameter("elective_id"));
        int emark = Integer.parseInt(request.getParameter("emark"));
        String dt = DateTime.getDate();
        
        DBProcess dbp = new DBProcess();
        dbp.open();
        Group_Settings gs = dbp.select_group_settings(group_id);
        dbp.close();
        dbp.open();
        ArrayList<Group_Subject_Map> gsmList1 = dbp.selectAll_group_subject_map(gs.id,0);
        dbp.close();
        
        
        dbp.open();
        int id = dbp.getMaxID_mark_history()+1;
        dbp.close();
        Mark_History mh = new Mark_History(id, name, group_id, elective_id, dt);
        dbp.open();
        int result = dbp.insert_mark_history(mh);
        dbp.close();
        out.println(result + ">>"+mh.toString()+"<br>");
        dbp.open();
        int tid = dbp.getMaxID_mark_details()+1;
        dbp.close();
        Mark_Details md = new Mark_Details(tid,mh.id,elective_id,emark);
        dbp.open();
        dbp.insert_mark_details(md);
        dbp.close();
        out.println(result + ">>"+md.toString()+"<br>");
        for(Group_Subject_Map gsm : gsmList1){
            //dbp.open();
            //Subject_Settings ss = dbp.select_subject_settings(gsm.subject_id);
            //dbp.close();
            int tmark =  Integer.parseInt(request.getParameter("subject_"+gsm.id));
            dbp.open();
            tid = dbp.getMaxID_mark_details()+1;
            dbp.close();
            md = new Mark_Details(tid,mh.id,gsm.subject_id,tmark);
            dbp.open();
            dbp.insert_mark_details(md);
            dbp.close();
            out.println(result + ">>"+md.toString()+"<br>");
        }
        
        
        
    
    %>
        Record Added<br>
    <a href="admin_group_mark_list.jsp?id=<%=group_id%>">Marks</a> &nbsp;
    </center>
</body>
</html>
