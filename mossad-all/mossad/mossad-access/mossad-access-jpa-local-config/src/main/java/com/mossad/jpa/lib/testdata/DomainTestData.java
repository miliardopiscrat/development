/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.testdata;

import com.mossad.jpa.lib.factories.TaskFactory;
import com.mossad.jpa.lib.factories.TaskRelatedFactory;
import com.mossad.jpa.lib.factories.UserFactory;
import com.mossad.jpa.lib.task.Task;
import com.mossad.jpa.lib.task.TaskPriority;
import com.mossad.jpa.lib.task.TaskStatus;
import com.mossad.jpa.lib.task.TaskType;
import com.mossad.jpa.lib.user.User;
import com.mossad.jpa.test.data.UsersContainer;
import com.mossad.lib.domain.constants.Constants;
import com.mossad.lib.domain.task.TaskAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mmigdal
 */
public class DomainTestData {

    private TaskStatus taskStatus;
    private TaskType taskType;
    private TaskPriority taskPriority;
    private Task task;
    
    
    private List<User> users;
    private List<TaskType> taskTypes;
    private List<TaskStatus> taskStatusList;
    private List<TaskPriority> taskPriorityList;
    private List<Task> tasksList;
    
    
    private TaskRelatedFactory taskRelatedFactory;
    private TaskFactory taskFactory;
    
    private UserFactory userFactory;

    public DomainTestData() {

        users = new ArrayList<User>();
        taskTypes = new ArrayList<TaskType>();
        taskStatusList = new ArrayList<TaskStatus>();
        taskPriorityList = new ArrayList<TaskPriority>();
        tasksList = new ArrayList<Task>();
        
        taskRelatedFactory = new TaskRelatedFactory();
        userFactory = new UserFactory();
        taskFactory = new TaskFactory();

    }

    public void fillUsers() {

       
        UsersContainer uc = new UsersContainer();
        
        Set<User> users = uc.getData();
        
        
        

        users.addAll( users );
       


    }

    public List<User> getUsers() {
        return users;
    }

    public void fillTaskStatuses() {

        taskStatus = taskRelatedFactory.getTaskStatus(Constants.TASK_STATUS_FINISHED);
        taskStatusList.add(taskStatus);

        taskStatus = taskRelatedFactory.getTaskStatus(Constants.TASK_STATUS_NOT_STARTED);
        taskStatusList.add(taskStatus);

        taskStatus = taskRelatedFactory.getTaskStatus(Constants.TASK_STATUS_ONGOING);
        taskStatusList.add(taskStatus);

        taskStatus = taskRelatedFactory.getTaskStatus(Constants.TASK_STATUS_PAUSED);
        taskStatusList.add(taskStatus);
    }

    public List<TaskStatus> getTaskStatuses() {
        return taskStatusList;
    }

    public void fillTaskTypes() {

        taskType = taskRelatedFactory.getTaskType(Constants.TASK_TYPE_FINISHED);
        taskTypes.add(taskType);

        taskType = taskRelatedFactory.getTaskType(Constants.TASK_TYPE_HOME);
        taskTypes.add(taskType);

        taskType = taskRelatedFactory.getTaskType(Constants.TASK_TYPE_WORK);
        taskTypes.add(taskType);

        taskType = taskRelatedFactory.getTaskType(Constants.TASK_TYPE_PAUSED);
        taskTypes.add(taskType);


    }

    public List<TaskType> getTaskTypes() {

        return taskTypes;
    }

    public void fillTaskPriorities() {


        taskPriority = taskRelatedFactory.getTaskPriority(Constants.TASK_PRIORITY_HIGH);
        taskPriorityList.add(taskPriority);

        taskPriority = taskRelatedFactory.getTaskPriority(Constants.TASK_PRIORITY_MEDIUM);
        taskPriorityList.add(taskPriority);

        taskPriority = taskRelatedFactory.getTaskPriority(Constants.TASK_PRIORITY_LOW);
        taskPriorityList.add(taskPriority);

        taskPriority = taskRelatedFactory.getTaskPriority(Constants.TASK_PRIORITY_NONE);
        taskPriorityList.add(taskPriority);

    }

    public List<TaskPriority> getTaskPriorities() {

        return taskPriorityList;

    }
    
    public void fillTasks(){
    
        
        TaskAttributes taskAttributes = new TaskAttributes();
        
        
        
        String taskTitle="taskTitle";
        String taskDescription ="taskDescription";
        long priority=1;
        long userId=1;
        long status = 1;
        long type = 1;
        
        taskAttributes.setTitle(taskTitle);
        taskAttributes.setDescription(taskDescription);
        taskAttributes.setPriority(priority);
        taskAttributes.setUser(userId);
        taskAttributes.setStatus(status);
        taskAttributes.setType(type);
        
       // task =taskRelatedFactory.getTask(taskTitle,taskDescription,priority,userId,status,type);
        task =taskFactory.getTask(taskAttributes);
        tasksList.add(task);
        
    }
    
    public List<Task> getTasks(){
        return tasksList;
    }
    
    
}
