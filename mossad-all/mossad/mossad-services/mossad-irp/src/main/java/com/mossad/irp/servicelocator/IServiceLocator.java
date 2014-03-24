/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.servicelocator;

import com.mossad.irp.interfaces.IServiceTaskRemote;
import com.mossad.irp.interfaces.IServiceTaskHelperRemote;
import com.mossad.irp.interfaces.IServiceUserRemote;
import javax.naming.NamingException;

/**
 *
 * @author mmigdal
 */
public interface IServiceLocator {
    
    IServiceTaskRemote getServiceTask() throws NamingException;
    
    IServiceUserRemote getServiceUser() throws NamingException ;
    
    IServiceTaskHelperRemote getServiceTaskHelper() throws NamingException ;
    
}
