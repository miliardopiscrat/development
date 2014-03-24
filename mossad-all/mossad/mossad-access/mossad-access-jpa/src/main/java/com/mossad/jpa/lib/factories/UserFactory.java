/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.factories;

import com.mossad.jpa.lib.user.User;

/**
 *
 * @author mmigdal
 */
public class UserFactory {
    
    private User u;
    
    public User createUser(String name, String surname, String password, String email){

        u = new User();
        u.setName(name);
        u.setSurname(surname);
        u.setPassword(password);
        u.setEmail(email);
        
        return u;
    
    }
    
    public User createUser(String email, String password ){
       
        u = new User();
        u.setEmail(email);
        u.setPassword(password);
        return u;
    } 
}
