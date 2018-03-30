package db;




import java.sql.*;

public class DBCon {

    Connection con = null;
    Statement stmt = null;
    static final String DBPATH ="D:/ElectiveCourse_Prj/out/elective_course_db.db";
   // static final String DBPATH ="/home/kites/Downloads/electivecourse/ElectiveCourse_Prj/out/elective_course_db.db";
    static final String DRIVER = "org.sqlite.JDBC";
    static final String CONSTRING = "jdbc:sqlite:"+DBPATH;
    public static String tables[] =  new String[12];
    public void open() {

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONSTRING);
            System.out.println("Connection Created");
            con.setAutoCommit(false);
            stmt = con.createStatement();
            System.out.println("Statement Created");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DBCon Open Err>>" + e);
        }
    }

    //Table Details
    
    //1. admin_login - id,uname,passwd,status
    //2. subject_settings - id,s_name,s_descp
    //3. group_settings - id,g_name,g_descp,dt
    //4. group_subject_map - id,group_id,subject_id,is_elective
    //5. mark_history - id,name,group_id,elective_id,dt
    //6. mark_details - id,mark_history_id,subject_id,mark
    //7. user_details - id,name,gender,dob,email,contact,dt
    //8. user_login - id,uname,passwd,status
    //9. user_mark - id,user_id,group_id,dt
    //10. user_mark_details - id,user_mark_id,subject_id,mark
    //11. user_elective_result - id,user_mark_id,subject_id,mark
    
    
    
   
    public void createTables() {
        try {
            
            //1. admin_login - id,uname,passwd,status
            tables[0] = "CREATE TABLE IF NOT EXISTS admin_login("
                    + "id INT,"
                    + "uname VARCHAR(50),"
                    + "passwd VARCHAR(15),"
                    + "status VARCHAR(10))";
                  
            //2. subject_settings - id,s_name,s_descp
            tables[1] = "CREATE TABLE IF NOT EXISTS subject_settings("
                    + "id INT,"
                    + "s_name VARCHAR(50),"
                    + "s_descp VARCHAR(250))";
                   
            //3. group_settings - id,g_name,g_descp,dt
            tables[2] = "CREATE TABLE IF NOT EXISTS group_settings("
                    + "id INT,"
                    + "g_name VARCHAR(50),"
                    + "g_descp VARCHAR(250),"
                    + "dt VARCHAR(20))";
            
            //4. group_subject_map - id,group_id,subject_id,is_elective
            tables[3] = "CREATE TABLE IF NOT EXISTS group_subject_map("
                    + "id INT,"
                    + "group_id INT,"
                    + "subject_id INT,"
                    + "is_elective INT)";
            
            //5. mark_history - id,name,group_id,elective_id,dt
            tables[4] = "CREATE TABLE IF NOT EXISTS mark_history("
                    + "id INT,"
                    + "name VARCHAR(50),"
                    + "group_id INT,"
                    + "elective_id INT,"
                    + "dt VARCHAR(25))";
                
            //6. mark_details - id,mark_history_id,subject_id,mark
            tables[5] = "CREATE TABLE IF NOT EXISTS mark_details("
                    + "id INT,"
                    + "mark_history_id INT,"
                    + "subject_id INT,"
                    + "mark INT)";
                   
            //7. user_details - id,name,gender,dob,email,contact,dt
            tables[6] = "CREATE TABLE IF NOT EXISTS user_details("
                    + "id INT,"
                    + "name VARCHAR(40),"
                    + "gender VARCHAR(10),"
                    + "dob VARCHAR(20),"
                    + "email VARCHAR(50),"
                    + "contact VARCHAR(20),"
                    + "dt VARCHAR(20))";
                
            
            //8. user_login - id,uname,passwd,status
            tables[7] = "CREATE TABLE IF NOT EXISTS user_login("
                    + "id INT,"
                    + "uname VARCHAR(40),"
                    + "passwd VARCHAR(20),"
                    + "status VARCHAR(10))";
                
                
            //9. user_mark - id,user_id,group_id,dt
            tables[8] = "CREATE TABLE IF NOT EXISTS user_mark("
                    + "id INT,"
                    + "user_id INT,"
                    + "group_id INT,"
                    + "dt VARCHAR(20))";
            
            //10. user_mark_details - id,user_mark_id,subject_id,mark
            tables[9] = "CREATE TABLE IF NOT EXISTS user_mark_details("
                    + "id INT,"
                    + "user_mark_id INT,"
                    + "subject_id INT,"
                    + "mark INT)";
                  
            
            //11. user_elective_result - id,user_mark_id,subject_id,mark
            tables[10] = "CREATE TABLE IF NOT EXISTS user_elective_result("
                    + "id INT,"
                    + "user_mark_id INT,"
                    + "subject_id INT,"
                    + "mark INT)";
            
            for(int i=0;i<tables.length;i++){
                if(tables[i]==null)continue;
                int j = executeUpdate(tables[i]);

                if (j > 0) {
                    System.out.println("Table Created");
                }
            }
            
        } catch (Exception e) {
            System.out.println("DBConn Create Tables Err>>" + e);
        }
    }

    public void dropTables() {
        try {
     
    
            tables[0] = "DROP TABLE IF EXISTS admin_login";
            tables[1] = "DROP TABLE IF EXISTS subject_settings";
            tables[2] = "DROP TABLE IF EXISTS group_settings";
            tables[3] = "DROP TABLE IF EXISTS group_subject_map";
            tables[4] = "DROP TABLE IF EXISTS mark_history";
            
            tables[5] = "DROP TABLE IF EXISTS mark_details";
            tables[6] = "DROP TABLE IF EXISTS user_details";
            tables[7] = "DROP TABLE IF EXISTS user_login";
            tables[8] = "DROP TABLE IF EXISTS user_mark";
            tables[9] = "DROP TABLE IF EXISTS user_mark_details";
            
            tables[10] = "DROP TABLE IF EXISTS user_elective_result";
          
            
           
             
            
        
            
         
           
            
            for(int i=0;i<tables.length;i++){
                if(tables[i]==null)continue;
                int j = executeUpdate(tables[i]);

                if (j > 0) {
                    System.out.println("Table Deleted");
                }
            }
        } catch (Exception e) {
            System.out.println("DBCon Drop Tables Err>>" + e);
        }

    }

    public int executeUpdate(String query) {
        int result = 0;
        try {
            System.out.println("DBCon Query>>" + query);
            result = stmt.executeUpdate(query);
            con.commit();
        } catch (Exception e) {
            System.out.println("DBCon Execute Update Error>>" + e);
        }
        return result;
    }

    public ResultSet executeQuery(String query) {
        ResultSet rset = null;
        try {

            System.out.println("DBCon Query>>" + query);
            con.commit();
            rset = stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println("DBCon Execute Query Err>>" + e);
        }
        return rset;
    }

    public void close() {
        try {
            stmt.close();
             System.out.println("Statement Closed");
            con.close();
            System.out.println("Connection Closed");
        } catch (Exception e) {
            System.out.println("DBCon Close Err>>" + e);
        }
    }

    public static void main(String args[]) {
        DBCon dbcon = new DBCon();
        dbcon.open();
        dbcon.createTables();
        //dbcon.dropTables();
        dbcon.close();
    }
}
