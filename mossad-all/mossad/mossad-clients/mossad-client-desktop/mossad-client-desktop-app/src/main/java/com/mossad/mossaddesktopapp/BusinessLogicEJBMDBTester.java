package com.mossad.mossaddesktopapp;

import com.mossad.lib.domain.constants.Constants;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;


/**
 * Hello world!
 *
 */
public class BusinessLogicEJBMDBTester {

    //@Resource(mappedName = Constants.JMS_MAPPING_QUEUE_CONNECTION_FACTORY)
    // private static ConnectionFactory connectionFactory;
    //@Resource(mappedName = Constants.JMS_MAPPING_NAME_QUEUE)
    private static Queue queue;
    private static Connection connection;

    private static Session session;
    private static MessageProducer messageProducer;
    private static TextMessage message;

    //Sends JMS to EJB MDB
    public static void main(String[] args) throws NamingException , JMSException {

        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");  
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        System.out.println("JMS Tester");
        try {
            
            InitialContext ctx = new InitialContext(props);
            
            ConnectionFactory connectionFactory =
                (ConnectionFactory) ctx.lookup(Constants.JMS_MAPPING_CONNECTION_FACTORY);

            connection = connectionFactory.createConnection();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE); 
            queue = (Queue)ctx.lookup(Constants.JMS_MAPPING_NAME_QUEUE);           
            messageProducer = session.createProducer(queue);
            message = session.createTextMessage();
            
            for (int i = 0; i < 3; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Sending message: " + message.getText());
                messageProducer.send(message);
            }


            //JMS Tester
        } catch (NamingException | JMSException ex ) {
           
            System.out.println("Error message : " +  ex.getMessage() );
            System.out.println("Error : " +  ex);
            
        }
        
        
        finally{
            System.out.println("Closing connections : " );
            connection.close();
            System.out.println("Closed connections : " );
   
        }

        



    }
}
