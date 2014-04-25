/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.testdata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mossad.jpa.lib.task.TaskType;
import com.mossad.lib.domain.constants.Constants;



/**
 *
 * @author mmigdal
 */
public class TesterTaskType {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<TaskType> taskTypes = null;
        System.out.println("Starting task type .... ");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.DB_LOCAL_RESOURCE);
        EntityManager em = emf.createEntityManager();

        // TaskTypes creation

        DomainTestData data = new DomainTestData();
        data.fillTaskTypes();
        em.getTransaction().begin();

        taskTypes = data.getTaskTypes();

        try {

            for (TaskType ts : taskTypes) {

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

        taskTypes.clear();

        taskTypes = em.createNamedQuery(Constants.TASK_TYPE_QUERY_NAME).getResultList();

        for (TaskType taskType : taskTypes) {

            System.out.println(Constants.entitySeparator);
            System.out.println(taskType.getId());
            System.out.println(taskType.getValue());
        }



        System.out.println("Done task types .... ");


    }
}
