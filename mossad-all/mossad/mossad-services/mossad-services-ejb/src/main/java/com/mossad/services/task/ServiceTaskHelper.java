/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.task;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mossad.lib.domain.constants.Constants;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelper;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperRemote;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperLocal;
import com.mossad.jpa.lib.task.TaskPriority;
import com.mossad.jpa.lib.task.TaskStatus;
import com.mossad.jpa.lib.task.TaskType;

/**
 * 
 * @author mmigdal
 */
@Stateless(name = Constants.BINDING_SERVICE_HELPER, mappedName = Constants.BINDING_SERVICE_HELPER)
@Remote(IServiceTaskHelperRemote.class)
@Local(IServiceTaskHelperLocal.class)
public class ServiceTaskHelper implements IServiceTaskHelper {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<TaskType> getTaskTypes() {

		List<TaskType> taskTypes = new ArrayList<>();

		taskTypes.addAll(em.createNamedQuery(Constants.TASK_TYPE_QUERY_NAME)
				.getResultList());
		return taskTypes;

	}

	@Override
	public List<TaskStatus> getTaskStatuses() {

		List<TaskStatus> taskStatuses = new ArrayList<>();
		taskStatuses.addAll(em.createNamedQuery(
				Constants.TASK_STATUS_QUERY_NAME).getResultList());
		return taskStatuses;

	}

	@Override
	public List<TaskPriority> getTaskPriorities() {

		List<TaskPriority> taskPriorities = new ArrayList<>();

		taskPriorities.addAll(em.createNamedQuery(
				Constants.TASK_PRIORITY_QUERY_NAME).getResultList());
		return taskPriorities;
	}

}
