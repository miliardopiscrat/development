/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.factories;

import com.mossad.jpa.lib.task.Task;
import com.mossad.lib.domain.task.TaskAttributes;

/**
 *
 * @author mmigdal
 */
public class TaskFactory {
    
    private Task task;
    
    public TaskFactory(){
    }
    
    public Task getTask(TaskAttributes taskAttributes){
       
        task = new Task();
        task.setTitle( taskAttributes.getTitle() );
        task.setDescription(taskAttributes.getDescription());
        task.setPriority(taskAttributes.getPriority());
        task.setUser(taskAttributes.getUser());
        task.setStatus(taskAttributes.getStatus());
        task.setType(taskAttributes.getType());
        return task;
        
    }
    
    
    
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
