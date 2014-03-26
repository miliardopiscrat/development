/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.user;

import com.mossad.lib.domain.constants.Constants;
import com.mossad.lib.domain.exceptions.user.UserExistsException;
import com.mossad.lib.domain.exceptions.user.UserNotFoundException;
import com.mossad.irp.interfaces.IServiceUserRemote;
import com.mossad.jpa.lib.factories.UserFactory;
import com.mossad.jpa.lib.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @author mmigdal
 */
@Stateless
// (name=Constants.BINDING_SERVICE_USER,mappedName=Constants.BINDING_SERVICE_USER)
@Remote(IServiceUserRemote.class)
@WebService()
public class ServiceUser implements IServiceUserRemote {

	private UserFactory userFactory;
	@PersistenceContext
	private EntityManager em;
	static final Logger log = Logger.getLogger(Constants.LOGGER_SERVICE_USER);

	@PostConstruct
	public void init() {
		userFactory = new UserFactory();
	}

	@WebMethod
	@Override
	public User createUser(String email, String password)
			throws UserExistsException {

		List<User> usersResult = new ArrayList<>();

		usersResult.addAll(em
				.createNamedQuery(Constants.QUERY_GET_USER_BY_EMAIL)
				.setParameter(Constants.PARAM_EMAIL, email).getResultList());

		if (usersResult.isEmpty()) {
			User user = userFactory.createUser(email, password);
			user.setEmail(email);
			user.setPassword(password);
			em.persist(user);
			return user;
		} else {

			throw new UserExistsException(email);
		}

	}

	@Override
	@WebMethod
	public User loginUser(String email, String password)
			throws UserNotFoundException {

		// List<User> usersResult = em
		List<User> usersResult = new ArrayList<>();
		usersResult.addAll(em
				.createNamedQuery(Constants.LOGIN_USER_BY_EMAIL_AND_PASSWORD)
				.setParameter(Constants.PARAM_EMAIL, email)
				.setParameter(Constants.PARAM_PASSWORD, password)
				.getResultList());
		//getSingleResult() maybe?

		if (usersResult.isEmpty()) {
			throw new UserNotFoundException(email, password);
		}
		return usersResult.get(0);

	}

	@WebMethod
	@Override
	public User updateUser(Long id, String name, String surname)
			throws UserNotFoundException {
		User user = getById(id);

		log.log(Level.INFO, "ServiceUser - found user :{0}", user);

		user.setName(name);
		user.setSurname(surname);

		log.log(Level.INFO, "ServiceUser - updating found user :{0}", user);
		try {
			em.persist(user);
		} catch (Exception e) {
			e.printStackTrace();

			throw new UserNotFoundException(e.getMessage());

		}

		return user;

	}

	@Override
	public void activateUSer() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@WebMethod
	@Override
	public void removeUser(Long id) throws UserNotFoundException {

		User user = getById(id);
		em.remove(user);

	}

	@WebMethod
	@Override
	public User getById(Long id) throws UserNotFoundException {

		log.log(Level.INFO, "ServiceUser - finding user :{0}", id);

		List<User> usersResult = new ArrayList<>();

		usersResult.addAll(em.createNamedQuery(Constants.QUERY_GET_USER_BY_ID)
				.setParameter(Constants.PARAM_ID, id).getResultList());

		log.log(Level.INFO, "ServiceUser - finding user found users :{0}",
				usersResult);

		if (usersResult.isEmpty()) {
			throw new UserNotFoundException(id);
		} else {
			return usersResult.get(0);
		}

	}

	@WebMethod
	@Override
	public User getByEmail(String email) throws UserNotFoundException {

		List<User> usersResult = new ArrayList<>();

		usersResult.addAll(em
				.createNamedQuery(Constants.QUERY_GET_USER_BY_EMAIL)
				.setParameter(Constants.PARAM_EMAIL, email).getResultList());

		if (usersResult.isEmpty()) {
			throw new UserNotFoundException(email);
		} else {
			return usersResult.get(0);
		}

	}
}
