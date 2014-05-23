package com.mossad.irp.interfaces.user;

import java.util.List;
import javax.ejb.Remote;

import com.mossad.jpa.lib.user.User;
import com.mossad.lib.domain.exceptions.user.UserExistsException;
import com.mossad.lib.domain.exceptions.user.UserNotFoundException;

@Remote
public interface IServiceUser {

	@Deprecated
        User createUser(String email, String password) throws UserExistsException;

        User createUser(String email, String password, String name, String surname) throws UserExistsException;
    
	// TODO to remove - use REALM instead
	User loginUser(String email, String password) throws UserNotFoundException;

	User getById(Long id) throws UserNotFoundException;

	User getByEmail(String email) throws UserNotFoundException;

	@Deprecated
	User updateUser(Long id, String name, String surname)
			throws UserNotFoundException;

	User updateUser( String newName, String newSurname, User user)
			throws UserNotFoundException;
	
	
	void activateUser(Long id);

	@Deprecated
	void removeUser(Long id) throws UserNotFoundException;
      
	
	void removeUser(User user) throws UserNotFoundException;
	
        List<User> getUsers();
        
    
}
