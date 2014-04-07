<%@page import="com.mossad.jpa.lib.user.User"%>
<%@page import="com.mossad.jpa.lib.task.TaskType"%>
<%@page import="com.mossad.jpa.lib.task.TaskStatus"%>
<%@page import="com.mossad.jpa.lib.task.TaskPriority"%>
<%@page import="com.mossad.lib.domain.task.TaskAttributes"%>
<%@page import="com.mossad.jpa.lib.task.Task"%>
<%@page import="com.mossad.lib.domain.constants.Constants"%>

<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.naming.Context" %>
<%@page import="javax.naming.NamingException" %>
<%@page import="com.mossad.irp.interfaces.IServiceTaskRemote" %>
<%@page import="com.mossad.irp.interfaces.IServiceUser" %>
<%@page import="com.mossad.irp.interfaces.IServiceTaskHelperRemote" %>
<%@page import="com.mossad.irp.servicelocator.IServiceLocator"  %>
<%@page import="com.mossad.irp.servicelocator.ServiceLocator"  %>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World from JSP not JSF!</h1>
        
        
        <%
                
                    /*
                    IServiceLocator sl = new ServiceLocator();             
                    IServiceTask serviceTask = sl.getServiceTask();
                    IServiceUser serviceUser = sl.getServiceUser();            
                    IServiceTaskHelper serviceTaskHelper = sl.getServiceTaskHelper();
                    */
     
                    /*
                     String email ="mail 1111";
                     String password ="password 111111";
                    
                     System.out.println("--------------------------------------------------------");
                     System.out.println("creating u1");
                     User u1 = serviceUser.createUser(email,password);                             
                     System.out.println( u1.getId() );
                     System.out.println( u1.getEmail() );
                     System.out.println( u1.getPassword() );
                     System.out.println( u1.getName() );
                     System.out.println( u1.getSurname() );
                     
                     System.out.println("--------------------------------------------------------");
                     System.out.println("finding u 11");
                     //find
                     User u11 = serviceUser.getByEmail(email);
                     
                     System.out.println( u11.getId() );
                     System.out.println( u11.getEmail() );
                     System.out.println( u11.getPassword() );
                     System.out.println( u11.getName() );
                     System.out.println( u11.getSurname() );
                     
                     System.out.println("--------------------------------------------------------");
                     System.out.println("Removing u11");
                     //delete
                     serviceUser.removeUser(u11.getId());
                     System.out.println("--------------------------------------------------------");
                     System.out.println("Removed u11");
                     
                     
                     
                     String email2 ="mail 2332432432";
                     String password2 ="password 23432432";
                    
                     String name ="name234324";
                     String surname ="surname4324324324";
                     
                     System.out.println("--------------------------------------------------------");
                     System.out.println("creating u2");
                     
                     User u2 = serviceUser.createUser(email2,password2);                             
                     
                     System.out.println( u2.getId() );
                     System.out.println( u2.getEmail() );
                     System.out.println( u2.getPassword() );
                     System.out.println( u2.getName() );
                     System.out.println( u2.getSurname() );
                     
                     System.out.println("--------------------------------------------------------");
                     System.out.println("finding");
                     //find
                     User u22 = serviceUser.getById(u2.getId());
                     
                     System.out.println( u22.getEmail() );
                     System.out.println( u22.getPassword() );
                     System.out.println( u22.getName() );
                     System.out.println( u22.getSurname() );
                     
                     System.out.println("--------------------------------------------------------");
                     System.out.println("Updating");
                     
                     u22.setName(name);
                     u22.setSurname(surname);
                     User u33 = serviceUser.updateUser( u22.getId(), u22.getName(), u22.getSurname() );
                     
                     System.out.println( u33.getEmail() );
                     System.out.println( u33.getPassword() );
                     System.out.println( u33.getName() );
                     System.out.println( u33.getSurname() );
                     */
                     
                   
                     /*
                     List<TaskType> tasktypes =   serviceTaskHelper.getTaskTypes();
                     
                     for(TaskType taskType : tasktypes){
                         
                         System.out.println( taskType.getId() );
                         System.out.println( taskType.getValue() );
                         
                     }
                     
                     
                      List<TaskStatus> taskStatuses =   serviceTaskHelper.getTaskStatuses();
                     
                     for(TaskStatus taskType : taskStatuses){
                         
                         System.out.println( taskType.getId() );
                         System.out.println( taskType.getValue() );
                         
                     }
                     */
                    
                    // TaskPriority
                     /*
                     List<TaskPriority> taskPriorities =   serviceTaskHelper.getTaskPriorities();
               
                     for(TaskPriority tp : taskPriorities){
                         
                         System.out.println( tp.getId() );
                         System.out.println( tp.getValue() );
                         
                     }
                     */
               
                     //Task
               
                    /* 
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
                    
                    Task task = serviceTask.createTask(taskAttributes);
                    
                    System.out.println(task);
                    */
                    
                     /*
                     DataSource ds = (DataSource) ctx.lookup("jdbc/MySQL_Mossad");
                     Connection con = ds.getConnection();
                     con.close();
                     */
                     
                     
              %>          
        
        
    </body>
</html>
