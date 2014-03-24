/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.factories;

//import com.mossad.lib.domain.task.TaskType;
import com.mossad.jpa.lib.task.Task;
import com.mossad.jpa.lib.task.TaskPriority;
import com.mossad.jpa.lib.task.TaskStatus;
import com.mossad.jpa.lib.task.TaskType;

/**
 *
 * @author mmigdal
 */
public class TaskRelatedFactory {

    private TaskType taskType;
    private TaskStatus taskStatus;
    
    private TaskPriority taskPriority;
    private Task task;
    
    public TaskRelatedFactory() {
    }
    
    

    public TaskType getTaskType(String value) {

        taskType = new TaskType();
        taskType.setValue(value);
        return taskType;

    }

    
    public TaskStatus getTaskStatus(String value) {

        taskStatus = new TaskStatus();
        taskStatus.setValue(value);
        return taskStatus;

    }
     
    public TaskPriority getTaskPriority(String value){
        taskPriority = new TaskPriority();
        taskPriority.setValue(value);
        return taskPriority;
    
    }
    
    //use task factory
    @Deprecated 
    public Task getTask(String title,String description,long priority, long user, long status, long type){
        
     
        task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setUser(user);
        task.setStatus(status);
        task.setType(type);
        return task;
        
    }
    
    
    
     
}
