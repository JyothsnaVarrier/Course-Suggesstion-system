
<%@page import="db.tables.User_Login"%>
<%@page import="db.tables.User_Details"%>
<%@page import="util.Variables"%>
<%@page import="util.DateTime"%>
<%@page import="db.DBProcess"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Add Action</title>
    </head>
    <body>
    <center>
        <h1 ><font color="#366092"><%=Variables.prjName%></font></h1>
       
        <%@include file="home_menu.jsp" %>
        <h2 ><font color="#366092">Add User Result</font></h2>
    <%
       //7. user_details - id,name,gender,dob,email,contact,dt
    //8. user_login - id,uname,passwd,status
    
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String dob = request.getParameter("dob");
    
    
    String contact = request.getParameter("contact");
    String email = request.getParameter("email");
    
    String uname=email;
    String passwd=request.getParameter("passwd");
    String status="new";
    
    String dt = DateTime.getDate();
    
    DBProcess dbp =new DBProcess();
    dbp.open();
    int id = dbp.getMaxID_user_details()+1;
    dbp.close();
    User_Details  ud =new User_Details(id, name, gender, dob, email, contact, dt);
    dbp.open();
    int result = dbp.insert_user_details(ud);
    dbp.close();
    out.println(result + ">>"+ud.toString()+"<br>");
    User_Login ul = new User_Login(id, uname, passwd, status);
    dbp.open();
    result = dbp.insert_user_login(ul);
    dbp.close();
    out.println(result + ">>"+ul.toString()+"<br>");
    
    
    %>
    Record Added
    </center>
</body>
</html>
