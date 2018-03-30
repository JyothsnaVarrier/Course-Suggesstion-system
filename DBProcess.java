
package db;

import db.tables.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author root
 */
public class DBProcess extends DBCon{
 
      //Table Details
    
    //1. admin_login - id,uname,passwd,status
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_admin_login(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM admin_login";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_admin_login Err>>"+e);
        }
        return mid;
    }

    public int insert_admin_login(Admin_Login obj){
        int result =0;
        try {
            String query="INSERT INTO admin_login(id,uname,passwd,status) VALUES("+obj.id+",'"+obj.uname+"','"+obj.passwd+"','"+obj.status+"')";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_admin_login Err>>"+e);
        }
        return result;
    }
    public int delete_admin_login(int id){
        int result = 0;
        try {
            String query="DELETE FROM admin_login WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_admin_login Err>>"+e);
        }
        return result;
    }
    
    public int update_admin_login(Admin_Login obj){
        int result =0;
        try {
            String query="UPDATE admin_login SET uname='"+obj.uname+"',passwd='"+obj.passwd+"',status='"+obj.status+"' WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_admin_login Err>>"+e);
        }
        return result;
    }
    public int update_admin_login(String uname,String opasswd,String npasswd){
        int result =0;
        try {
            String query="UPDATE admin_login SET passwd='"+npasswd+"' WHERE uname='"+uname+"' AND passwd='"+opasswd+"'";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_admin_login Err>>"+e);
        }
        return result;
    }
     public Admin_Login select_admin_login(int id){
        Admin_Login obj =null;
        try {
            String query="SELECT id,uname,passwd,status FROM admin_login WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,uname,passwd,status
                id = rset.getInt("id");
               String uname= rset.getString("uname");
               String passwd= rset.getString("passwd");
               String status= rset.getString("status");
               
               obj = new Admin_Login(id, uname, passwd, status);
               
            }
        } catch (SQLException e) {
            System.out.println("select_admin_login Err>>"+e);
        }
        return obj;
    }
    public Admin_Login select_admin_login(String uname,String passwd){
        Admin_Login obj =null;
        try {
            String query="SELECT id,uname,passwd,status FROM admin_login WHERE uname='"+uname+"' AND passwd='"+passwd+"'";
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,uname,passwd,status
               int id = rset.getInt("id");
               uname= rset.getString("uname");
               passwd= rset.getString("passwd");
               String status= rset.getString("status");
               
               obj = new Admin_Login(id, uname, passwd, status);
               
            }
        } catch (SQLException e) {
            System.out.println("select_admin_login Err>>"+e);
        }
        return obj;
    }
    public ArrayList<Admin_Login> selectAll_admin_login(){
        ArrayList<Admin_Login> objList = new ArrayList<Admin_Login>();
        try {
            String query="SELECT id,uname,passwd,status FROM admin_login ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Admin_Login obj;
               int    id = rset.getInt("id");
               String uname= rset.getString("uname");
               String passwd= rset.getString("passwd");
               String status= rset.getString("status");
               
               obj = new Admin_Login(id, uname, passwd, status);
               objList.add(obj);
               
            }
        } catch (SQLException e) {
            System.out.println("selectAll_admin_login Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //2. subject_settings - id,s_name,s_descp
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_subject_settings(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM subject_settings";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_subject_settings Err>>"+e);
        }
        return mid;
    }

    public int insert_subject_settings(Subject_Settings obj){
        int result =0;
        try {
            String query="INSERT INTO subject_settings(id,s_name,s_descp) VALUES("+obj.id+",'"+obj.s_name+"','"+obj.s_descp+"')";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_subject_settings Err>>"+e);
        }
        return result;
    }
    public int delete_subject_settings(int id){
        int result = 0;
        try {
            String query="DELETE FROM subject_settings WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_subject_settings Err>>"+e);
        }
        return result;
    }
    
    public int update_subject_settings(Subject_Settings obj){
        int result =0;
        try {
            String query="UPDATE subject_settings SET s_name='"+obj.s_name+"',s_descp='"+obj.s_descp+"' WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_subject_settings Err>>"+e);
        }
        return result;
    }
     public Subject_Settings select_subject_settings(int id){
        Subject_Settings obj =null;
        try {
            String query="SELECT id,s_name,s_descp FROM subject_settings WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,s_name,s_descp
                id = rset.getInt("id");
               String s_name= rset.getString("s_name");
               String s_descp= rset.getString("s_descp");
               
               obj = new Subject_Settings(id, s_name, s_descp);
               
            }
        } catch (SQLException e) {
            System.out.println("select_subject_settings Err>>"+e);
        }
        return obj;
    }

    public ArrayList<Subject_Settings> selectAll_subject_settings(){
        ArrayList<Subject_Settings> objList = new ArrayList<Subject_Settings>();
        try {
            String query="SELECT id,s_name,s_descp FROM subject_settings ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Subject_Settings obj;
               int     id = rset.getInt("id");
               String s_name= rset.getString("s_name");
               String s_descp= rset.getString("s_descp");
               
               obj = new Subject_Settings(id, s_name, s_descp);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_subject_settings Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //3. group_settings - id,g_name,g_descp,dt
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_group_settings(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM group_settings";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_group_settings Err>>"+e);
        }
        return mid;
    }

    public int insert_group_settings(Group_Settings obj){
        int result =0;
        try {
            String query="INSERT INTO group_settings(id,g_name,g_descp,dt) VALUES("+obj.id+",'"+obj.g_name+"','"+obj.g_descp+"','"+obj.dt+"')";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_group_settings Err>>"+e);
        }
        return result;
    }
    public int delete_group_settings(int id){
        int result = 0;
        try {
            String query="DELETE FROM group_settings WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_group_settings Err>>"+e);
        }
        return result;
    }
    
    public int update_group_settings(Group_Settings obj){
        int result =0;
        try {
            String query="UPDATE group_settings SET g_name='"+obj.g_name+"',g_descp='"+obj.g_descp+"',dt='"+obj.dt+"' WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_group_settings Err>>"+e);
        }
        return result;
    }
     public Group_Settings select_group_settings(int id){
        Group_Settings obj =null;
        try {
            String query="SELECT id,g_name,g_descp,dt FROM group_settings WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,g_name,g_descp,dt
                 id = rset.getInt("id");
                String g_name= rset.getString("g_name");
                String g_descp= rset.getString("g_descp");
                String dt= rset.getString("dt");
                
                obj = new Group_Settings(id, g_name, g_descp, dt);
                
                
            }
        } catch (SQLException e) {
            System.out.println("select_group_settings Err>>"+e);
        }
        return obj;
    }

    public ArrayList<Group_Settings> selectAll_group_settings(){
        ArrayList<Group_Settings> objList = new ArrayList<Group_Settings>();
        try {
            String query="SELECT id,g_name,g_descp,dt FROM group_settings ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Group_Settings obj;
               int   id = rset.getInt("id");
                String g_name= rset.getString("g_name");
                String g_descp= rset.getString("g_descp");
                String dt= rset.getString("dt");
                
                obj = new Group_Settings(id, g_name, g_descp, dt);
                objList.add(obj);
                
            }
        } catch (SQLException e) {
            System.out.println("selectAll_group_settings Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //4. group_subject_map - id,group_id,subject_id,is_elective
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_group_subject_map(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM group_subject_map";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_group_subject_map Err>>"+e);
        }
        return mid;
    }

    public int insert_group_subject_map(Group_Subject_Map obj){
        int result =0;
        try {
            String query="INSERT INTO group_subject_map(id,group_id,subject_id,is_elective) VALUES("+obj.id+","+obj.group_id+","+obj.subject_id+","+obj.is_elective+")";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_group_subject_map Err>>"+e);
        }
        return result;
    }
    public int delete_group_subject_map(int id){
        int result = 0;
        try {
            String query="DELETE FROM group_subject_map WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_group_subject_map Err>>"+e);
        }
        return result;
    }
    public int delete_group_subject_map2(int group_id){
        int result = 0;
        try {
            String query="DELETE FROM group_subject_map WHERE group_id="+group_id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_group_subject_map Err>>"+e);
        }
        return result;
    }
    public int update_group_subject_map(Group_Subject_Map obj){
        int result =0;
        try {
            String query="UPDATE group_subject_map SET group_id="+obj.group_id+",subject_id="+obj.subject_id+",is_elective="+obj.is_elective+" WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_group_subject_map Err>>"+e);
        }
        return result;
    }
     public Group_Subject_Map select_group_subject_map(int id){
        Group_Subject_Map obj =null;
        try {
            String query="SELECT id,group_id,subject_id,is_elective FROM group_subject_map WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,group_id,subject_id,is_elective
               id = rset.getInt("id");
               int group_id = rset.getInt("group_id");
               int subject_id = rset.getInt("subject_id");
               int is_elective = rset.getInt("is_elective");
               
               obj = new Group_Subject_Map(id, group_id, subject_id, is_elective);
               
            }
        } catch (SQLException e) {
            System.out.println("select_group_subject_map Err>>"+e);
        }
        return obj;
    }

    public ArrayList<Group_Subject_Map> selectAll_group_subject_map(){
        ArrayList<Group_Subject_Map> objList = new ArrayList<Group_Subject_Map>();
        try {
            String query="SELECT id,group_id,subject_id,is_elective FROM group_subject_map ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Group_Subject_Map obj;
               int id = rset.getInt("id");
               int group_id = rset.getInt("group_id");
               int subject_id = rset.getInt("subject_id");
               int is_elective = rset.getInt("is_elective");
               
               obj = new Group_Subject_Map(id, group_id, subject_id, is_elective);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_group_subject_map Err>>"+e);
        }
        return objList;
    }
   
      public ArrayList<Group_Subject_Map> selectAll_group_subject_map(int group_id){
        ArrayList<Group_Subject_Map> objList = new ArrayList<Group_Subject_Map>();
        try {
            String query="SELECT id,group_id,subject_id,is_elective FROM group_subject_map WHERE group_id="+group_id;
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Group_Subject_Map obj;
               int id = rset.getInt("id");
                group_id = rset.getInt("group_id");
               int subject_id = rset.getInt("subject_id");
               int is_elective = rset.getInt("is_elective");
               
               obj = new Group_Subject_Map(id, group_id, subject_id, is_elective);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_group_subject_map Err>>"+e);
        }
        return objList;
    }
      public ArrayList<Group_Subject_Map> selectAll_group_subject_map(int group_id,int is_elective){
        ArrayList<Group_Subject_Map> objList = new ArrayList<Group_Subject_Map>();
        try {
            String query="SELECT id,group_id,subject_id,is_elective FROM group_subject_map WHERE group_id="+group_id+" AND is_elective="+is_elective;
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Group_Subject_Map obj;
               int id = rset.getInt("id");
                group_id = rset.getInt("group_id");
               int subject_id = rset.getInt("subject_id");
               is_elective = rset.getInt("is_elective");
               
               obj = new Group_Subject_Map(id, group_id, subject_id, is_elective);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_group_subject_map Err>>"+e);
        }
        return objList;
    }
    /******************************************************************/
    //5. mark_history - id,name,group_id,elective_id,dt
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_mark_history(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM mark_history";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_mark_history Err>>"+e);
        }
        return mid;
    }

    public int insert_mark_history(Mark_History obj){
        int result =0;
        try {
            String query="INSERT INTO mark_history(id,name,group_id,elective_id,dt) VALUES("+obj.id+",'"+obj.name+"',"+obj.group_id+","+obj.elective_id+",'"+obj.dt+"')";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_mark_history Err>>"+e);
        }
        return result;
    }
    public int delete_mark_history(int id){
        int result = 0;
        try {
            String query="DELETE FROM mark_history WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_mark_history Err>>"+e);
        }
        return result;
    }
    
    public int update_mark_history(Mark_History obj){
        int result =0;
        try {
            String query="UPDATE mark_history SET name='"+obj.name+"',group_id="+obj.group_id+",elective_id="+obj.elective_id+",dt='"+obj.dt+"' WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_mark_history Err>>"+e);
        }
        return result;
    }
     public Mark_History select_mark_history(int id){
        Mark_History obj =null;
        try {
            String query="SELECT id,name,group_id,elective_id,dt FROM mark_history WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,name,group_id,elective_id,dt
               id = rset.getInt("id");
               String name= rset.getString("name");
               int group_id = rset.getInt("group_id");
               int elective_id = rset.getInt("elective_id");
               String dt = rset.getString("dt");
               
               obj = new Mark_History(id, name, group_id, elective_id, dt);
               
               
            }
        } catch (SQLException e) {
            System.out.println("select_mark_history Err>>"+e);
        }
        return obj;
    }

    public ArrayList<Mark_History> selectAll_mark_history(){
        ArrayList<Mark_History> objList = new ArrayList<Mark_History>();
        try {
            String query="SELECT id,name,group_id,elective_id,dt FROM mark_history ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Mark_History obj ;
               int    id = rset.getInt("id");
               String name= rset.getString("name");
               int group_id = rset.getInt("group_id");
               int elective_id = rset.getInt("elective_id");
               String dt = rset.getString("dt");
               
               obj = new Mark_History(id, name, group_id, elective_id, dt);
               objList.add(obj);
               
            }
        } catch (SQLException e) {
            System.out.println("selectAll_mark_history Err>>"+e);
        }
        return objList;
    }
   public ArrayList<Mark_History> selectAll_mark_history(int group_id){
        ArrayList<Mark_History> objList = new ArrayList<Mark_History>();
        try {
            String query="SELECT id,name,group_id,elective_id,dt FROM mark_history WHERE group_id="+group_id;
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Mark_History obj ;
               int    id = rset.getInt("id");
               String name= rset.getString("name");
               group_id = rset.getInt("group_id");
               int elective_id = rset.getInt("elective_id");
               String dt = rset.getString("dt");
               
               obj = new Mark_History(id, name, group_id, elective_id, dt);
               objList.add(obj);
               
            }
        } catch (SQLException e) {
            System.out.println("selectAll_mark_history Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //6. mark_details - id,mark_history_id,subject_id,mark
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_mark_details(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM mark_details";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_mark_details Err>>"+e);
        }
        return mid;
    }

    public int insert_mark_details(Mark_Details obj){
        int result =0;
        try {
            String query="INSERT INTO mark_details(id,mark_history_id,subject_id,mark) VALUES("+obj.id+","+obj.mark_history_id+","+obj.subject_id+","+obj.mark+")";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_mark_details Err>>"+e);
        }
        return result;
    }
    public int delete_mark_details(int id){
        int result = 0;
        try {
            String query="DELETE FROM mark_details WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_mark_details Err>>"+e);
        }
        return result;
    }
    public int delete_mark_details2(int mark_history_id){
        int result = 0;
        try {
            String query="DELETE FROM mark_details WHERE mark_history_id="+mark_history_id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_mark_details Err>>"+e);
        }
        return result;
    }
    
    public int update_mark_details(Mark_Details obj){
        int result =0;
        try {
            String query="UPDATE mark_details SET mark_history_id="+obj.mark_history_id+",subject_id="+obj.subject_id+",mark="+obj.mark+" WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_mark_details Err>>"+e);
        }
        return result;
    }
    public Mark_Details select_mark_details(int id){
        Mark_Details obj =null;
        try {
            String query="SELECT id,mark_history_id,subject_id,mark FROM mark_details WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,mark_history_id,subject_id,mark
               id = rset.getInt("id");
               int mark_history_id = rset.getInt("mark_history_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new Mark_Details(id, mark_history_id, subject_id, mark);
               
            }
        } catch (SQLException e) {
            System.out.println("select_mark_details Err>>"+e);
        }
        return obj;
    }

    public ArrayList<Mark_Details> selectAll_mark_details(){
        ArrayList<Mark_Details> objList = new ArrayList<Mark_Details>();
        try {
            String query="SELECT id,mark_history_id,subject_id,mark FROM mark_details ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Mark_Details obj;
               int id = rset.getInt("id");
               int mark_history_id = rset.getInt("mark_history_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new Mark_Details(id, mark_history_id, subject_id, mark);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_mark_details Err>>"+e);
        }
        return objList;
    }
    public ArrayList<Mark_Details> selectAll_mark_details(int mark_history_id){
        ArrayList<Mark_Details> objList = new ArrayList<Mark_Details>();
        try {
            String query="SELECT id,mark_history_id,subject_id,mark FROM mark_details WHERE mark_history_id="+mark_history_id;
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               Mark_Details obj;
               int id = rset.getInt("id");
               mark_history_id = rset.getInt("mark_history_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new Mark_Details(id, mark_history_id, subject_id, mark);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_mark_details Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //7. user_details - id,name,gender,dob,email,contact,dt
    
    /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_user_details(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM user_details";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_user_details Err>>"+e);
        }
        return mid;
    }

    public int insert_user_details(User_Details obj){
        int result =0;
        try {
            String query="INSERT INTO user_details(id,name,gender,dob,email,contact,dt) VALUES("+obj.id+",'"+obj.name+"','"+obj.gender+"','"+obj.dob+"','"+obj.email+"','"+obj.contact+"','"+obj.dt+"')";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_user_details Err>>"+e);
        }
        return result;
    }
    public int delete_user_details(int id){
        int result = 0;
        try {
            String query="DELETE FROM user_details WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_user_details Err>>"+e);
        }
        return result;
    }
    
    public int update_user_details(User_Details obj){
        int result =0;
        try {
            String query="UPDATE user_details SET name='"+obj.name+"',gender='"+obj.gender+"',dob='"+obj.dob+"',email='"+obj.email+"',contact='"+obj.contact+"',dt='"+obj.dt+"' WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_user_details Err>>"+e);
        }
        return result;
    }
     public User_Details select_user_details(int id){
        User_Details obj =null;
        try {
            String query="SELECT id,name,gender,dob,email,contact,dt FROM user_details WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,name,gender,dob,email,contact,dt
                id = rset.getInt("id");
               String name= rset.getString("name");
               String gender= rset.getString("gender");
               String dob= rset.getString("dob");
               String email= rset.getString("email");
               String contact= rset.getString("contact");
               String dt= rset.getString("dt");
               
               obj = new User_Details(id, name, gender, dob, email, contact, dt);
               
               
            }
        } catch (SQLException e) {
            System.out.println("select_user_details Err>>"+e);
        }
        return obj;
    }

    public ArrayList<User_Details> selectAll_user_details(){
        ArrayList<User_Details> objList = new ArrayList<User_Details>();
        try {
            String query="SELECT id,name,gender,dob,email,contact,dt FROM user_details ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Details obj;
               int     id = rset.getInt("id");
               String name= rset.getString("name");
               String gender= rset.getString("gender");
               String dob= rset.getString("dob");
               String email= rset.getString("email");
               String contact= rset.getString("contact");
               String dt= rset.getString("dt");
               
               obj = new User_Details(id, name, gender, dob, email, contact, dt);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_details Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //8. user_login - id,uname,passwd,status
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_user_login(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM user_login";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_user_login Err>>"+e);
        }
        return mid;
    }

    public int insert_user_login(User_Login obj){
        int result =0;
        try {
            String query="INSERT INTO user_login(id,uname,passwd,status) VALUES("+obj.id+",'"+obj.uname+"','"+obj.passwd+"','"+obj.status+"')";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_user_login Err>>"+e);
        }
        return result;
    }
    public int delete_user_login(int id){
        int result = 0;
        try {
            String query="DELETE FROM user_login WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_user_login Err>>"+e);
        }
        return result;
    }
    
    public int update_user_login(User_Login obj){
        int result =0;
        try {
            String query="UPDATE user_login SET uname='"+obj.uname+"',passwd='"+obj.passwd+"',status='"+obj.status+"' WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_user_login Err>>"+e);
        }
        return result;
    }
    public int update_user_login(String uname,String opasswd,String npasswd){
        int result =0;
        try {
            String query="UPDATE user_login SET passwd='"+npasswd+"' WHERE uname='"+uname+"' AND passwd='"+opasswd+"'";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_user_login Err>>"+e);
        }
        return result;
    }
     public User_Login select_user_login(int id){
        User_Login obj =null;
        try {
            String query="SELECT id,uname,passwd,status FROM user_login WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,uname,passwd,status
                id = rset.getInt("id");
               String uname= rset.getString("uname");
               String passwd= rset.getString("passwd");
               String status= rset.getString("status");
               
               obj = new User_Login(id, uname, passwd, status);
            }
        } catch (SQLException e) {
            System.out.println("select_user_login Err>>"+e);
        }
        return obj;
    }
     public User_Login select_user_login(String uname,String passwd){
        User_Login obj =null;
        try {
            String query="SELECT id,uname,passwd,status FROM user_login WHERE uname='"+uname+"' AND passwd='"+passwd+"'";
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,uname,passwd,status
               int id = rset.getInt("id");
               uname = rset.getString("uname");
               passwd = rset.getString("passwd");
               String status= rset.getString("status");
               
               obj = new User_Login(id, uname, passwd, status);
            }
        } catch (SQLException e) {
            System.out.println("select_user_login Err>>"+e);
        }
        return obj;
    }

    public ArrayList<User_Login> selectAll_user_login(){
        ArrayList<User_Login> objList = new ArrayList<User_Login>();
        try {
            String query="SELECT id,uname,passwd,status FROM user_login ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Login obj;
               int     id = rset.getInt("id");
               String uname= rset.getString("uname");
               String passwd= rset.getString("passwd");
               String status= rset.getString("status");
               
               obj = new User_Login(id, uname, passwd, status);
               objList.add(obj);
                       
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_login Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //9. user_mark - id,user_id,group_id,dt
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_user_mark(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM user_mark";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_user_mark Err>>"+e);
        }
        return mid;
    }

    public int insert_user_mark(User_Mark obj){
        int result =0;
        try {
            String query="INSERT INTO user_mark(id,user_id,group_id,dt) VALUES("+obj.id+","+obj.user_id+","+obj.group_id+",'"+obj.dt+"')";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_user_mark Err>>"+e);
        }
        return result;
    }
    public int delete_user_mark(int id){
        int result = 0;
        try {
            String query="DELETE FROM user_mark WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_user_mark Err>>"+e);
        }
        return result;
    }
    
    public int update_user_mark(User_Mark obj){
        int result =0;
        try {
            String query="UPDATE user_mark SET user_id="+obj.user_id+",group_id="+obj.group_id+",dt='"+obj.dt+"' WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_user_mark Err>>"+e);
        }
        return result;
    }
     public User_Mark select_user_mark(int id){
        User_Mark obj =null;
        try {
            String query="SELECT id,user_id,group_id,dt FROM user_mark WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,user_id,group_id,dt
                id = rset.getInt("id");
               int user_id = rset.getInt("user_id");
               int group_id = rset.getInt("group_id");
               String dt= rset.getString("dt");
               
               obj = new User_Mark(id, user_id, group_id, dt);
               
               
            }
        } catch (SQLException e) {
            System.out.println("select_user_mark Err>>"+e);
        }
        return obj;
    }

    public ArrayList<User_Mark> selectAll_user_mark(){
        ArrayList<User_Mark> objList = new ArrayList<User_Mark>();
        try {
            String query="SELECT id,user_id,group_id,dt FROM user_mark ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Mark obj;
               int     id = rset.getInt("id");
               int user_id = rset.getInt("user_id");
               int group_id = rset.getInt("group_id");
               String dt= rset.getString("dt");
               
               obj = new User_Mark(id, user_id, group_id, dt);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_mark Err>>"+e);
        }
        return objList;
    }
   public ArrayList<User_Mark> selectAll_user_mark(int user_id){
        ArrayList<User_Mark> objList = new ArrayList<User_Mark>();
        try {
            String query="SELECT id,user_id,group_id,dt FROM user_mark WHERE user_id="+user_id;
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Mark obj;
               int     id = rset.getInt("id");
                user_id = rset.getInt("user_id");
               int group_id = rset.getInt("group_id");
               String dt= rset.getString("dt");
               
               obj = new User_Mark(id, user_id, group_id, dt);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_mark Err>>"+e);
        }
        return objList;
    }
   public ArrayList<User_Mark> selectAll_user_mark(int user_id,int group_id){
        ArrayList<User_Mark> objList = new ArrayList<User_Mark>();
        try {
            String query="SELECT id,user_id,group_id,dt FROM user_mark WHERE user_id="+user_id+" AND group_id="+group_id;
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Mark obj;
               int     id = rset.getInt("id");
                user_id = rset.getInt("user_id");
                group_id = rset.getInt("group_id");
               String dt= rset.getString("dt");
               
               obj = new User_Mark(id, user_id, group_id, dt);
               
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_mark Err>>"+e);
        }
        return objList;
    }
    
    /******************************************************************/
    //10. user_mark_details - id,user_mark_id,subject_id,mark
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_user_mark_details(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM user_mark_details";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_user_mark_details Err>>"+e);
        }
        return mid;
    }

    public int insert_user_mark_details(User_Mark_Details obj){
        int result =0;
        try {
            String query="INSERT INTO user_mark_details(id,user_mark_id,subject_id,mark) VALUES("+obj.id+","+obj.user_mark_id+","+obj.subject_id+","+obj.mark+")";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_user_mark_details Err>>"+e);
        }
        return result;
    }
    public int delete_user_mark_details(int id){
        int result = 0;
        try {
            String query="DELETE FROM user_mark_details WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_user_mark_details Err>>"+e);
        }
        return result;
    }
    
    public int update_user_mark_details(User_Mark_Details obj){
        int result =0;
        try {
            String query="UPDATE user_mark_details SET user_mark_id="+obj.user_mark_id+",subject_id="+obj.subject_id+",mark="+obj.mark+" WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_user_mark_details Err>>"+e);
        }
        return result;
    }
     public User_Mark_Details select_user_mark_details(int id){
        User_Mark_Details obj =null;
        try {
            String query="SELECT id,user_mark_id,subject_id,mark FROM user_mark_details WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,user_mark_id,subject_id,mark
                id = rset.getInt("id");
               int user_mark_id = rset.getInt("user_mark_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new User_Mark_Details(id, user_mark_id, subject_id, mark);
               
               
            }
        } catch (SQLException e) {
            System.out.println("select_user_mark_details Err>>"+e);
        }
        return obj;
    }

    public ArrayList<User_Mark_Details> selectAll_user_mark_details(){
        ArrayList<User_Mark_Details> objList = new ArrayList<User_Mark_Details>();
        try {
            String query="SELECT id,user_mark_id,subject_id,mark FROM user_mark_details ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Mark_Details obj ;
               int    id = rset.getInt("id");
               int user_mark_id = rset.getInt("user_mark_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new User_Mark_Details(id, user_mark_id, subject_id, mark);
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_mark_details Err>>"+e);
        }
        return objList;
    }
   
    public ArrayList<User_Mark_Details> selectAll_user_mark_details(int user_mark_id){
        ArrayList<User_Mark_Details> objList = new ArrayList<User_Mark_Details>();
        try {
            String query="SELECT id,user_mark_id,subject_id,mark FROM user_mark_details WHERE user_mark_id="+user_mark_id;
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Mark_Details obj ;
               int    id = rset.getInt("id");
               user_mark_id = rset.getInt("user_mark_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new User_Mark_Details(id, user_mark_id, subject_id, mark);
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_mark_details Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    //11. user_elective_result - id,user_mark_id,subject_id,mark
    
     /******************************************************************/
    /**
     * 
     * @return 
     */
    public int getMaxID_user_elective_result(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM user_elective_result";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getMaxID_user_elective_result Err>>"+e);
        }
        return mid;
    }

    public int insert_user_elective_result(User_Elective_Result obj){
        int result =0;
        try {
            String query="INSERT INTO user_elective_result(id,user_mark_id,subject_id,mark) VALUES("+obj.id+","+obj.user_mark_id+","+obj.subject_id+","+obj.mark+")";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("insert_user_elective_result Err>>"+e);
        }
        return result;
    }
    public int delete_user_elective_result(int id){
        int result = 0;
        try {
            String query="DELETE FROM user_elective_result WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("delete_user_elective_result Err>>"+e);
        }
        return result;
    }
    
    public int update_user_elective_result(User_Elective_Result obj){
        int result =0;
        try {
            String query="UPDATE user_elective_result SET user_mark_id="+obj.user_mark_id+",subject_id="+obj.subject_id+",mark="+obj.mark+" WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println("update_user_elective_result Err>>"+e);
        }
        return result;
    }
     public User_Elective_Result select_user_elective_result(int id){
        User_Elective_Result obj =null;
        try {
            String query="SELECT id,user_mark_id,subject_id,mark FROM user_elective_result WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
                //id,user_mark_id,subject_id,mark
                id = rset.getInt("id");
               int user_mark_id = rset.getInt("user_mark_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new User_Elective_Result(id, user_mark_id, subject_id, mark);
               
               
            }
        } catch (SQLException e) {
            System.out.println("select_user_elective_result Err>>"+e);
        }
        return obj;
    }

    public ArrayList<User_Elective_Result> selectAll_user_elective_result(){
        ArrayList<User_Elective_Result> objList = new ArrayList<User_Elective_Result>();
        try {
            String query="SELECT id,user_mark_id,subject_id,mark FROM user_elective_result ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               User_Elective_Result obj;
               int     id = rset.getInt("id");
               int user_mark_id = rset.getInt("user_mark_id");
               int subject_id = rset.getInt("subject_id");
               int mark = rset.getInt("mark");
               
               obj = new User_Elective_Result(id, user_mark_id, subject_id, mark);
               objList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("selectAll_user_elective_result Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    
    
    
    
    /******************************************************************
    public int getMaxID_(){
        int mid =0;
        try {
            String query="SELECT MAX(id) FROM **";
             ResultSet rset = executeQuery(query);
            if(rset.next()){
                mid = rset.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(" Err>>"+e);
        }
        return mid;
    }

    public int insert_(Object obj){
        int result =0;
        try {
            String query="INSERT INTO **() VALUES()";
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println(" Err>>"+e);
        }
        return result;
    }
    public int delete_(int id){
        int result = 0;
        try {
            String query="DELETE FROM ** WHERE id="+id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println(" Err>>"+e);
        }
        return result;
    }
    
    public int update_(Object obj){
        int result =0;
        try {
            String query="UPDATE ** SET ** WHERE id="+obj.id;
             result = executeUpdate(query);
        } catch (Exception e) {
            System.out.println(" Err>>"+e);
        }
        return result;
    }
     public Object select_(int id){
        Object obj =null;
        try {
            String query="SELECT ** FROM ** WHERE id="+id;
            ResultSet rset = executeQuery(query);
            if(rset.next()){
               int id = rset.getInt("id");
               String uname= rset.getString("uname");
            }
        } catch (SQLException e) {
            System.out.println(" Err>>"+e);
        }
        return obj;
    }

    public ArrayList<Object> selectAll_(){
        ArrayList<Object> objList = new ArrayList<Object>();
        try {
            String query="SELECT ** FROM ** ";
            ResultSet rset = executeQuery(query);
            while(rset.next()){
               
            }
        } catch (SQLException e) {
            System.out.println(" Err>>"+e);
        }
        return objList;
    }
   
    
    /******************************************************************/
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
    }
}
