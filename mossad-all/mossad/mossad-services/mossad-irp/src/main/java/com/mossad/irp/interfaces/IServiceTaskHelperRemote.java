/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.interfaces;

import com.mossad.jpa.lib.task.TaskPriority;
import com.mossad.jpa.lib.task.TaskStatus;
import com.mossad.jpa.lib.task.TaskType;

import java.util.List;

import javax.ejb.*;

/**
 * 
 * @author mmigdal
 */

@Remote
public interface IServiceTaskHelperRemote  {

	List<TaskType> getTaskTypes();

	List<TaskStatus> getTaskStatuses();

	List<TaskPriority> getTaskPriorities();

}
