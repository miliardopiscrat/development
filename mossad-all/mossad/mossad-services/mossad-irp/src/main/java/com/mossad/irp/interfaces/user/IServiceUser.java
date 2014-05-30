package com.mossad.irp.interfaces.user;

import java.util.List;
import javax.ejb.Remote;

import com.mossad.jpa.lib.user.User;
import com.mossad.lib.domain.exceptions.user.UserExistsException;
import com.mossad.lib.domain.exceptions.user.UserNotFoundException;

@Remote
public interface IServiceUser {

    User createUser(String email, String password, String name, String surname) throws UserExistsException;

    // TODO to remove - use REALM instead
    User loginUser(String email, String password) throws UserNotFoundException;

    User getById(Long id) throws UserNotFoundException;

    User getByEmail(String email) throws UserNotFoundException;

    User updateUser(String newName, String newSurname, User user)
            throws UserNotFoundException;

    void activateUser(Long id);

    void removeUser(User user) throws UserNotFoundException;

    List<User> getUsers();
}
