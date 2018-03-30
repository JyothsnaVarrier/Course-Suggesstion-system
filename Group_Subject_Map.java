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
public class Group_Subject_Map {
    //4. group_subject_map - id,group_id,subject_id,is_elective
    
    public int id,group_id,subject_id,is_elective;

    public Group_Subject_Map(int id, int group_id, int subject_id, int is_elective) {
        this.id = id;
        this.group_id = group_id;
        this.subject_id = subject_id;
        this.is_elective = is_elective;
    }

    @Override
    public String toString() {
        return "Group_Subject_Map{" + "id=" + id + ", group_id=" + group_id + ", subject_id=" + subject_id + ", is_elective=" + is_elective + '}';
    }
    
    
}
