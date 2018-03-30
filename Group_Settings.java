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
public class Group_Settings {
    //3. group_settings - id,g_name,g_descp,dt
    
    public int id;
    public String g_name,g_descp,dt;

    public Group_Settings(int id, String g_name, String g_descp, String dt) {
        this.id = id;
        this.g_name = g_name;
        this.g_descp = g_descp;
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Group_Settings{" + "id=" + id + ", g_name=" + g_name + ", g_descp=" + g_descp + ", dt=" + dt + '}';
    }
    
    
}
