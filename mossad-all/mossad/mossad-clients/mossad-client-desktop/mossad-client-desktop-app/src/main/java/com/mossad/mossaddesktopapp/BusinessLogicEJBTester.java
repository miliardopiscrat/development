package com.mossad.mossaddesktopapp;

import com.mossad.irp.interfaces.task.IServiceTask;
import com.mossad.irp.servicelocator.IServiceLocator;
import com.mossad.irp.servicelocator.ServiceLocator;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelper;
import com.mossad.jpa.lib.task.TaskType;
import com.mossad.lib.util.TimeMeasurement;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.naming.NamingException;

/**
 * Hello world!
 *
 */
public class BusinessLogicEJBTester {

    public static void main(String[] args) {

        TimeMeasurement tm = new TimeMeasurement();

        tm.reset();



        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        // optional    
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        System.out.println("Creating ServiceLocator ");
        tm.start();
        IServiceLocator serviceLocator = new ServiceLocator(props);
        tm.stop();
        System.out.println("Created ServiceLocator " + tm.getResultInMiliseconds());
        tm.reset();
        IServiceTaskHelper taskHelper = null;


        try {

            System.out.println("Getting service ");
            tm.start();
            taskHelper = serviceLocator.getServiceTaskHelper();
            tm.stop();
            System.out.println("Received service " + tm.getResultInMiliseconds());
            tm.reset();
            List<TaskType> taskTypes = null;

            if (taskHelper != null) {
                System.out.println("taskHelper is not null - OK - getting TaskTypes");

                for (int x = 0; x < 50; x++) {

                    tm.start();
                    taskTypes = taskHelper.getTaskTypes();
                    tm.stop();

                    System.out.println("TaskTypes received : " + tm.getResultInMiliseconds());
                    tm.reset();

                }
            } else {
                System.out.println("taskHelper is null - NOT OK");

            }

            for (TaskType taskType : taskTypes) {
                System.out.println(taskType.getId());
                System.out.println(taskType.getValue());
            }




        } catch (NamingException e) {
            //System.out.println( e.getExplanation() );
            //System.out.println( e.getMessage() );
        } catch (Exception e) {

            System.out.println("Erorr .....");
            System.out.println(e);

        }

        System.out.println("BusinessLogicEJBTester finished .... " + Calendar.getInstance().getTime().toString());
    
    }
}
