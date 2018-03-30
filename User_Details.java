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
public class User_Details {
    //7. user_details - id,name,gender,dob,email,contact,dt
    
    public int id;
    public String name,gender,dob,email,contact,dt;

    public User_Details(int id, String name, String gender, String dob, String email, String contact, String dt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.contact = contact;
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "User_Details{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", email=" + email + ", contact=" + contact + ", dt=" + dt + '}';
    }
    
    
}
