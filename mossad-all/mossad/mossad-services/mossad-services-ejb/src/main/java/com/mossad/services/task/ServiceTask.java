/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.task;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mossad.irp.interfaces.task.IServiceTask;
import com.mossad.irp.interfaces.task.IServiceTaskLocal;
import com.mossad.lib.domain.constants.Constants;
import com.mossad.lib.domain.task.TaskAttributes;
import com.mossad.jpa.lib.factories.TaskFactory;
import com.mossad.jpa.lib.task.Task;



/**
 *
 * @author mmigdal
 */
@Stateless//(name=Constants.BINDING_SERVICE_TASK,mappedName=Constants.BINDING_SERVICE_TASK)
@Remote(IServiceTask.class)
@Local(IServiceTaskLocal.class)
public class ServiceTask implements IServiceTask {

    private TaskFactory taskFactory;
   
    @PersistenceContext
    EntityManager em;

    Logger log;
    
    
    @javax.annotation.PostConstruct
    public void init() {
        taskFactory = new TaskFactory();
        log  =Logger.getLogger(Constants.LOGGER_SERVICE_TASK);
    }

    @Override
    public Task createTask(TaskAttributes taskAttributes) {

        Task task = taskFactory.getTask(taskAttributes);
        em.persist(task);
        return task;
    }

    @Override
    public void deleteTask(Long taskId) {

        Task task = getTask(taskId);

        if (task == null) {
        } else {
            em.remove(task);
        }

    }

    @Override
    public Task getTask(Long taskId) {
        Task task = (Task) em.createNamedQuery(Constants.TASK_QUERY_NAME_GET_TASK_BY_TASK_ID).setParameter(Constants.PARAM_TASK_ID, taskId).getSingleResult();
        return task;
    }

    @Override
    public List<Task> getTasks(Long userId) {

        List<Task> tasks = em.createNamedQuery(Constants.TASK_QUERY_NAME_GET_USER_TASKS).setParameter(Constants.PARAM_USER_ID, userId).getResultList();

        return tasks;

    }

    @Override
    public Task updateTask(Long taskId, TaskAttributes taskAttributes) {

        Task task = getTask(taskId);

        if (task == null) {
        } else {

            //update parameters
            String title = taskAttributes.getTitle();
            String description = taskAttributes.getDescription();
            long status = taskAttributes.getStatus();
            long priority = taskAttributes.getPriority();
            long type = taskAttributes.getType();


            if (title != null) {
                task.setTitle(null);
            }

            if (description != null) {
                task.setDescription(description);
            }

            if( status!= 0 )
                task.setStatus(status);
            
            if( priority!= 0 )
                task.setPriority(priority);
            
            if( type != 0 )
                task.setType(type);

            em.persist(task);


        }

        return task;
    }

	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}
}
