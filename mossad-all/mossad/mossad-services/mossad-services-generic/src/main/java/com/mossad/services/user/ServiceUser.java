/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.user;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mossad.lib.domain.constants.Constants;
import com.mossad.lib.domain.exceptions.user.UserExistsException;
import com.mossad.lib.domain.exceptions.user.UserNotFoundException;
import com.mossad.irp.interfaces.user.IServiceUserLocal;
import com.mossad.irp.interfaces.user.IServiceUser;
import com.mossad.jpa.lib.factories.UserFactory;
import com.mossad.jpa.lib.user.User;

/**
 *
 * @author mmigdal
 */
@Stateless
// (name=Constants.BINDING_SERVICE_USER,mappedName=Constants.BINDING_SERVICE_USER)
@Remote(IServiceUser.class)
@Local(IServiceUserLocal.class)
@WebService()
public class ServiceUser implements IServiceUser {

    private UserFactory userFactory;
    private static final Logger log = Logger.getLogger(Constants.LOGGER_SERVICE_USER);
    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        userFactory = new UserFactory();
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

        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery cq = cb.createQuery();
        Root<User> root = cq.from(User.class);
        cq.where(
                cb.equal(
                root.get("email"),
                cb.parameter(String.class, "email")));
        
        TypedQuery<User> query = em.createQuery(cq);
        query.setParameter("email", email);
        User user = query.getSingleResult();

        //OLD approach
        //List<User> usersResult = new ArrayList<>();
        //usersResult.addAll(em
        //		.createNamedQuery(Constants.QUERY_GET_USER_BY_EMAIL)
        //		.setParameter(Constants.PARAM_EMAIL, email).getResultList());
        //    
        //if (usersResult.isEmpty()) {
        //	throw new UserNotFoundException(email);
        //} else {
        //	return usersResult.get(0);
        //}
        return user;
    }

    //to test
    //JPQL since JPA2.x
    @Override
    public List<User> getUsers() {


        /*
         CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
        
         Root<User> pet = cq.from(User.class);
         cq.select(pet);

         TypedQuery<User> q = em.createQuery(cq);
         List<User> users = q.getResultList();
            
         return users;
         */

        List<User> usersResult = new ArrayList<>();

        usersResult.addAll(em
                .createNamedQuery(Constants.GET_ALL_USERS)
                .getResultList());

        return usersResult;
    }

    @Override
    public User createUser(String email, String password, String name,
            String surname) throws UserExistsException {

        User user = userFactory.createUser(name, surname, password, email);
        em.persist(user);
        return user;
    }

    @Override
    public User updateUser(String newName, String newSurname, User user)
            throws UserNotFoundException {

        throw new UnsupportedOperationException("to be implemented in future");
    }

    @Override
    public void activateUser(Long id) {
        throw new UnsupportedOperationException("to be implemented in future");
    }

    @Override
    public void removeUser(User user) throws UserNotFoundException {
        em.remove(user);
    }
}
