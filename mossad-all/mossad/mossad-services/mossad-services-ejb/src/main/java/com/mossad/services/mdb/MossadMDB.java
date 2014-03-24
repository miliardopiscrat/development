/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;

import javax.jms.Message;
import javax.jms.MessageListener;

import com.mossad.lib.domain.constants.Constants;

/**
 *
 * @author mmigdal
 */
@MessageDriven(mappedName = Constants.JMS_MAPPING_NAME_QUEUE, activationConfig = {
    @ActivationConfigProperty(propertyName = Constants.JMS_ACKNOWLEDGE_MODE, propertyValue = Constants.JMS_AUTO_KNOWLEDGE),
    @ActivationConfigProperty(propertyName = Constants.JMS_DESTINATION_TYPE, propertyValue = Constants.JMS_QUEUE)
})
public class MossadMDB implements MessageListener {

    private final Logger log = Logger.getLogger(getClass().getName());
    private MessageDrivenContext mdc;

    @Override
    public void onMessage(Message message) {

        log.log(Level.FINE, " Here is MDB {0}", message.toString());

        System.out.println("MDB #################### Message has arrived " + message.toString());

        log.info("MESSAGE BEAN: Message received: " + message);
        System.out.println("The onMessage() is called");

    }
}
