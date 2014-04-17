/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.lib.domain.constants;

/**
 *
 * @author mmigdal
 */
public final class Constants {

    //Exceptions
    public final static String NOT_FOUND = "not found";
    public final static String USER_WITH_PROVIDED_CREENTIALS = "User with provided credentials";
    public final static String EMPTY_STRING = " ";
    //Task type
    public final static String TASK_TYPE_WORK = "Work";
    public final static String TASK_TYPE_HOME = "Home";
    public final static String TASK_TYPE_FINISHED = "Other";
    public final static String TASK_TYPE_PAUSED = "Private";
    //Task status
    public final static String TASK_STATUS_ONGOING = "Ongoing";
    public final static String TASK_STATUS_NOT_STARTED = "Not started";
    public final static String TASK_STATUS_FINISHED = "Finished";
    public final static String TASK_STATUS_PAUSED = "Paused";
    //Task priority
    public final static String TASK_PRIORITY_HIGH = "High";
    public final static String TASK_PRIORITY_MEDIUM = "Medium";
    public final static String TASK_PRIORITY_LOW = "Low";
    public final static String TASK_PRIORITY_NONE = "None";
    //Testing
    public static final String separator = "------------------------------------------------------";
    public static final String entitySeparator = "----------------------";
    //Loggers
    public final static String LOGGER_SERVICE_USER = "LoggerServiceUser";
    public final static String LOGGER_SERVICE_TASK = "LoggerServiceTask";
    //Common
    
    
    public final static String PARAM_ID = "id";
    //User related
    public final static String MOSSAD_USER_DEF = "mossad_user";
    public final static String PARAM_EMAIL = "email";
    public final static String PARAM_PASSWORD = "password";
    public final static String QUERY_GET_USER_BY_ID = "getUserById";
    public final static String QUERY_GET_USER_BY_EMAIL = "getUserByEmail";
    public final static String LOGIN_USER_BY_EMAIL_AND_PASSWORD = "loginUserByEmailAndPassword";
    public final static String GET_ALL_USERS = "getAllUsers";
    
    //Task related
    public final static String TASK_TYPE_DEF ="task_type";
    public final static String TASK_TYPE_QUERY_NAME = "getTaskTypes";
    public final static String TASK_TYPE_QUERY = "SELECT e FROM task_type e";
    
    public final static String TASK_STATUS_DEF ="task_status";
    public final static String TASK_STATUS_QUERY_NAME ="getTaskStatuses";
    public final static String TASK_STATUS_QUERY ="select e from task_status e";
    
    public final static String TASK_PRIORITY_DEF ="task_priority";
    public final static String TASK_PRIORITY_QUERY_NAME="getTaskPriorities";
    public final static String TASK_PRIORITY_QUERY="select e from task_priority e";
            
    public final static String TASK_DEF = "mossad_task";
    public final static String TASK_QUERY_NAME_GET_USER_TASKS="getUserTasks";
    public final static String TASK_QUERY_NAME_GET_TASK_BY_TASK_ID ="getTaskByTaskId";
    public final static String PARAM_USER_ID ="userId";
    public final static String PARAM_TASK_ID="taskId";
    
    //DB related  
    // how to run it @ server look @ instarukcja.txt
    public final static String DB_LOCAL_RESOURCE = "jdbc/MySQL_Local";
    
    public final static String EMPTY_SIGN =" ";
    
    
    //Bindings
    
    public final static String BINDING_SERVICE_USER ="ServiceUser";
    public final static String BINDING_SERVICE_TASK ="ServiceTask";
    public final static String BINDING_SERVICE_HELPER ="ServiceTaskHelper";
    
    //Service Locator
    public final static String SERVICE_LOCATOR="ServiceLocator";
    
    //JMS related
       
    public final static String JMS_DESTINATION_TYPE ="destinationType";
    public final static String JMS_QUEUE = "javax.jms.Queue";
    
    public final static String JMS_ACKNOWLEDGE_MODE  = "acknowledgeMode";
    public final static String JMS_AUTO_KNOWLEDGE = "Auto-acknowledge";
    
    // desired destinations are defined in instrukcja.txt
    //Typical Quesues
    
    public final static String JMS_MAPPING_QUEUE_CONNECTION_FACTORY = "MossadQueueConnectionFactory";
    public final static String JMS_MAPPING_CONNECTION_FACTORY ="MossadConnectionFactory";
    
    public final static String JMS_MAPPING_NAME_QUEUE= "MossadQueue";
    
    
    
    
    
}
