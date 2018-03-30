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
public class User_Elective_Result {
    //11. user_elective_result - id,user_mark_id,subject_id,mark
    
    public int id,user_mark_id,subject_id,mark;

    public User_Elective_Result(int id, int user_mark_id, int subject_id, int mark) {
        this.id = id;
        this.user_mark_id = user_mark_id;
        this.subject_id = subject_id;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "User_Elective_Result{" + "id=" + id + ", user_mark_id=" + user_mark_id + ", subject_id=" + subject_id + ", mark=" + mark + '}';
    }
    
    
}
