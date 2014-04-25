/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.testdata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mossad.jpa.lib.task.Task;
import com.mossad.lib.domain.constants.Constants;

/**
 *
 * @author mmigdal
 */
public class TesterTask {

    //static final String separator = "------------------------------------------------------";
    //static final String entitySeparator = "----------------------";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Task> tasks = null;
        System.out.println("Starting task itsefl .... ");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.DB_LOCAL_RESOURCE);
        EntityManager em = emf.createEntityManager();

        // TaskStatus creation

        DomainTestData data = new DomainTestData();
        
        data.fillTasks();
        em.getTransaction().begin();

        tasks = data.getTasks();

        try {

            for (Task task : tasks) {

                em.persist(task);

            }

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }


        System.out.println(Constants.separator);
        
        em = emf.createEntityManager();

        tasks.clear();

        System.out.println(Constants.separator);
        System.out.println("All tasks");
        /*
        tasks = em.createNamedQuery("getAllTasks").getResultList();

        for (Task task : tasks) {

            System.out.println(Constants.entitySeparator);
            System.out.println( task.getId() );
            System.out.println( task.getTitle() );
            System.out.println( task.getDescription() );
            System.out.println( task.getPriority() );
            System.out.println( task.getUser() );
           // System.out.println( task.getType() );
            //int status
            
        }
        */
        System.out.println(Constants.separator);
        
        System.out.println("All tasks for specicfied usrer");
        
        tasks = em.createNamedQuery(Constants.TASK_QUERY_NAME_GET_USER_TASKS).setParameter(Constants.PARAM_USER_ID, 1).getResultList();

        for (Task task : tasks) {

            System.out.println(Constants.entitySeparator);
            System.out.println( task.getId() );
            System.out.println( task.getTitle() );
            System.out.println( task.getDescription() );
            System.out.println( task.getPriority() );
            System.out.println( task.getUserId() );
           // System.out.println( task.getType() );
            //int status
            
        }
        
        
        
        
        em.close(); 

        System.out.println("Done task itself .... ");
         

    }
}
