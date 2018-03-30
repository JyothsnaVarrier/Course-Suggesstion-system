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
public class Mark_History {
    //5. mark_history - id,name,group_id,elective_id,dt
    
    public int id;
    public String name;
    public int group_id,elective_id;
    public String dt;

    public Mark_History(int id, String name, int group_id, int elective_id, String dt) {
        this.id = id;
        this.name = name;
        this.group_id = group_id;
        this.elective_id = elective_id;
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Mark_History{" + "id=" + id + ", name=" + name + ", group_id=" + group_id + ", elective_id=" + elective_id + ", dt=" + dt + '}';
    }
    
    
}
