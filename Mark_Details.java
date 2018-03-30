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
public class Mark_Details {
    //6. mark_details - id,mark_history_id,subject_id,mark
    
    public int id,mark_history_id,subject_id,mark;

    public Mark_Details(int id, int mark_history_id, int subject_id, int mark) {
        this.id = id;
        this.mark_history_id = mark_history_id;
        this.subject_id = subject_id;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark_Details{" + "id=" + id + ", mark_history_id=" + mark_history_id + ", subject_id=" + subject_id + ", mark=" + mark + '}';
    }
    
    
}
