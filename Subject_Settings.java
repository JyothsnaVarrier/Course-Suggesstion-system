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
public class Subject_Settings {
    //2. subject_settings - id,s_name,s_descp

    public int id;
    public String s_name,s_descp;

    public Subject_Settings(int id, String s_name, String s_descp) {
        this.id = id;
        this.s_name = s_name;
        this.s_descp = s_descp;
    }

    @Override
    public String toString() {
        return "Subject_Settings{" + "id=" + id + ", s_name=" + s_name + ", s_descp=" + s_descp + '}';
    }
    
    
}
