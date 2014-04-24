/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.testdata;

import com.mossad.jpa.lib.task.TaskPriority;
import com.mossad.jpa.lib.task.TaskStatus;
import com.mossad.lib.domain.constants.Constants;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mmigdal
 */
public class TesterTaskPriority {

    //static final String separator = "------------------------------------------------------";
    //static final String entitySeparator = "----------------------";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<TaskPriority> taskPriorities = null;
        System.out.println("Starting task priorities .... ");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.DB_LOCAL_RESOURCE);
        EntityManager em = emf.createEntityManager();

        // TaskStatus creation

        DomainTestData data = new DomainTestData();
        data.fillTaskPriorities();
        em.getTransaction().begin();

        taskPriorities = data.getTaskPriorities();

        try {

            for (TaskPriority tp : taskPriorities) {

                em.persist(tp);

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

        taskPriorities.clear();

        taskPriorities = em.createNamedQuery(Constants.TASK_PRIORITY_QUERY_NAME).getResultList();

        for (TaskPriority taskType : taskPriorities) {

            System.out.println(Constants.entitySeparator);
            System.out.println(taskType.getId());
            System.out.println(taskType.getValue());
        }



        System.out.println("Done task priorities .... ");


    }
}
