/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.servicelocator;

import java.util.logging.Level;
import javax.naming.InitialContext;
import java.util.logging.Logger;
import com.mossad.lib.domain.constants.Constants;
import com.mossad.irp.interfaces.task.IServiceTaskRemote;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperRemote;
import com.mossad.irp.interfaces.user.IServiceUserRemote;
import java.util.Properties;
import javax.naming.NamingException;

/**
 *
 * @author mmigdal
 */
public class ServiceLocator implements IServiceLocator {

    InitialContext ctx;
    private static final Logger log = Logger.getLogger(Constants.SERVICE_LOCATOR);

    public ServiceLocator() {


        try {
            ctx = new InitialContext();
        } catch (Exception e) {
            log.log(Level.FINEST, "Error during initialization of Service Locator: {0}", e.getMessage());
        }


    }
    
    public ServiceLocator(Properties props){
        try{
        ctx = new InitialContext(props);
        }catch(Exception e){
            log.log(Level.FINEST, "Error during initialization of Service Locator: {0}", e.getMessage());
        }
    }
    
    

    @Override
    public IServiceTaskRemote getServiceTask() throws NamingException {

        IServiceTaskRemote serviceTask =
                (IServiceTaskRemote) ctx.lookup(Constants.BINDING_SERVICE_TASK);
        return serviceTask;


    }

    @Override
    public IServiceUserRemote getServiceUser() throws NamingException {

        IServiceUserRemote serviceUser =
                (IServiceUserRemote) ctx.lookup(Constants.BINDING_SERVICE_USER);

        return serviceUser;
    }

    @Override
    public IServiceTaskHelperRemote getServiceTaskHelper() throws NamingException {

        IServiceTaskHelperRemote serviceTaskHelper = (IServiceTaskHelperRemote) ctx.lookup(Constants.BINDING_SERVICE_HELPER);
        return serviceTaskHelper;

    }
}
