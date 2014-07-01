/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.servicelocator;

import com.mossad.irp.interfaces.task.IServiceTask;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelper;
import com.mossad.irp.interfaces.user.IServiceUser;
import javax.naming.NamingException;

/**
 *
 * @author mmigdal
 */
public interface IServiceLocator {
    
    IServiceTask getServiceTask() throws NamingException;
    
    IServiceUser getServiceUser() throws NamingException ;
    
    IServiceTaskHelper getServiceTaskHelper() throws NamingException ;
    
}
