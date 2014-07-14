/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.task;

import com.mossad.jpa.lib.abstraction.AbstractEntity;
import com.mossad.lib.domain.constants.Constants;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mmigdal
 */

@Entity(name = Constants.TASK_TYPE_DEF)
@Table(name = Constants.TASK_TYPE_DEF)
@NamedQueries({
    @NamedQuery(name = Constants.TASK_TYPE_QUERY_NAME,
    query = Constants.TASK_TYPE_QUERY)
})



public class TaskType extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public TaskType() {
        
    }

    public TaskType(Long id, String value) {
        super(id, value);
    }
    
    
    
    
}
