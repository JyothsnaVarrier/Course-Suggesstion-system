/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

/**
 *
 * @author root
 */
public class User_Login {
    //8. user_login - id,uname,passwd,status
    
    public int id;
    public String uname,passwd,status;

    public User_Login(int id, String uname, String passwd, String status) {
        this.id = id;
        this.uname = uname;
        this.passwd = passwd;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User_Login{" + "id=" + id + ", uname=" + uname + ", passwd=" + passwd + ", status=" + status + '}';
    }
    
    
}
