/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.task;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.mossad.jpa.lib.abstraction.AbstractEntity;
import com.mossad.lib.domain.constants.Constants;

/**
 *
 * @author mmigdal
 */



@Entity(name = Constants.TASK_STATUS_DEF)
@Table(name = Constants.TASK_STATUS_DEF)
@NamedQueries({
    @NamedQuery(name =Constants.TASK_STATUS_QUERY_NAME , query = Constants.TASK_STATUS_QUERY)   
})

public class TaskStatus extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public TaskStatus() {
    }
    
    public TaskStatus(Long id, String value) {
        super(id, value);
    }

    //==============================
    

    
}
