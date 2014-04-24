/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.testdata;

import com.mossad.jpa.lib.user.User;
import com.mossad.lib.domain.constants.Constants;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mmigdal
 */
public class TesterUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<User> usersSource = null;
        List<User> usersResult = null;

        System.out.println("Starting users .... ");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.DB_LOCAL_RESOURCE);
        EntityManager em = emf.createEntityManager();
        DomainTestData data = new DomainTestData();
        data.fillUsers();

        em.getTransaction().begin();

        usersSource = data.getUsers();

        try {

            for (User u : usersSource) {

                em.persist(u);

            }

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }


        em = emf.createEntityManager();
        usersResult = em.createNamedQuery(Constants.QUERY_GET_USER_BY_ID).setParameter(Constants.PARAM_ID, 1).getResultList();

        System.out.println(Constants.separator);

        for (User u : usersResult) {

            System.out.println(Constants.entitySeparator);
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getSurname());
        }

        em.close();
        System.out.println("Done users .... ");


    }
}
