/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.interfaces.task.helper;

import java.util.List;
import javax.ejb.Remote;

import com.mossad.jpa.lib.task.TaskPriority;
import com.mossad.jpa.lib.task.TaskStatus;
import com.mossad.jpa.lib.task.TaskType;



/**
 *
 * @author mmigdal
 */


@Remote
public interface IServiceTaskHelper {

    List<TaskType> getTaskTypes();

    List<TaskStatus> getTaskStatuses();

    List<TaskPriority> getTaskPriorities();
}
