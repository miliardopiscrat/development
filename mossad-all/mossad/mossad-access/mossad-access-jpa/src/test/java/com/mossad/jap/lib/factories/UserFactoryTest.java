/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jap.lib.factories;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mossad.jpa.lib.factories.UserFactory;
import com.mossad.jpa.lib.user.User;

/**
 *
 * @author mmigdal
 */
public class UserFactoryTest {
    
    private UserFactory userFactory;
    
    @Before
    public void setUp(){
        userFactory = new UserFactory();
    }
    
    @After
    public void tearDown(){
        userFactory = null;
    }
    
    @Test
    public void dummyTest(){
    
        Assert.assertNotNull( userFactory );
         
    }
    
    @Test
    public void testUserCtreation(){
        
        String name="myName";
        String surname ="";
        String password ="";
        String email="";
        
       User user = userFactory.createUser(name , surname, password, email );
       
       
       
        
    }
    
    
    
}
