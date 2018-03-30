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
public class User_Mark {
    //9. user_mark - id,user_id,group_id,dt
    
    public int id,user_id,group_id;
    public String dt;

    public User_Mark(int id, int user_id, int group_id, String dt) {
        this.id = id;
        this.user_id = user_id;
        this.group_id = group_id;
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "User_Mark{" + "id=" + id + ", user_id=" + user_id + ", group_id=" + group_id + ", dt=" + dt + '}';
    }
    
    
}
