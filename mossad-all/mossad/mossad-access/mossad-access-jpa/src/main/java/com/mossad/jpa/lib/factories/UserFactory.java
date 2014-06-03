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
    
    private User user;
    /**
     @param name
     @param surname
     @param password
     @param  email
     @return Set of <code>User</code>
     
     */
    public User createUser(String name, String surname, String password, String email){

        user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);
        
        return user;
    
    }
    
}
