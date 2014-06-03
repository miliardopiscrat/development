/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.test.data;

import com.mossad.jpa.lib.factories.UserFactory;
import com.mossad.jpa.lib.user.User;
import com.mossad.jpa.test.TestDataConsts;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mmigdal
 */
public class UsersContainer {

    private UserFactory userFactory;
    private Set<User> users;
    private String name = "name";
    private String surname = "suename";
    private String password = "password";
    private String email = "email@dot.com";

    public UsersContainer() {

        userFactory = new UserFactory();
        users = new HashSet();
    }

    public void populate() {

        for (int number = 0; number < TestDataConsts.NUMBER_OF_USERS; number++) {

            User user = userFactory.createUser(Integer.toString(number) + name, Integer.toString(number) + surname, Integer.toString(number) + password, Integer.toString(number) + email);
            users.add(user);
        }

    }

    public Set<User> getData() {
        return users;
    }
}
