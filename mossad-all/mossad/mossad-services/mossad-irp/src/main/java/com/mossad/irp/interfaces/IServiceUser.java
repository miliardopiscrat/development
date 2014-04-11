package com.mossad.irp.interfaces;

import com.mossad.jpa.lib.user.User;
import com.mossad.lib.domain.exceptions.user.UserExistsException;
import com.mossad.lib.domain.exceptions.user.UserNotFoundException;

public interface IServiceUser {

    User createUser(String email, String password) throws UserExistsException;

	// TODO to remove - use REALM instead
	User loginUser(String email, String password) throws UserNotFoundException;

	User getById(Long id) throws UserNotFoundException;

	User getByEmail(String email) throws UserNotFoundException;

	User updateUser(Long id, String name, String surname)
			throws UserNotFoundException;

	void activateUSer();

	void removeUser(Long id) throws UserNotFoundException;
    
}
