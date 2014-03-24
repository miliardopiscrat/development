/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.testdata;

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
public class TesterTaskStatus {

    //static final String separator = "------------------------------------------------------";
    //static final String entitySeparator = "----------------------";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<TaskStatus> taskStatuses = null;
        System.out.println("Starting task status .... ");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.DB_LOCAL_RESOURCE);
        EntityManager em = emf.createEntityManager();

        // TaskStatus creation

        DomainTestData data = new DomainTestData();
        data.fillTaskStatuses();
        em.getTransaction().begin();

        taskStatuses = data.getTaskStatuses();

        try {

            for (TaskStatus ts : taskStatuses) {

                em.persist(ts);

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

        taskStatuses.clear();

        taskStatuses = em.createNamedQuery(Constants.TASK_STATUS_QUERY_NAME).getResultList();

        for (TaskStatus taskType : taskStatuses) {

            System.out.println(Constants.entitySeparator);
            System.out.println(taskType.getId());
            System.out.println(taskType.getValue());
        }



        System.out.println("Done task statuses .... ");


    }
}
