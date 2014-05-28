/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.task;

import com.mossad.jpa.lib.abstraction.AbstractEntityLite;
import com.mossad.lib.domain.constants.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mmigdal
 */

@Entity(name = Constants.TASK_DEF)
@Table(name = Constants.TASK_DEF)
@NamedQueries({
    @NamedQuery(name = Constants.TASK_QUERY_NAME_GET_USER_TASKS,query = "SELECT e FROM mossad_task e WHERE e.userId= :"+Constants.PARAM_USER_ID),
    @NamedQuery(name = Constants.TASK_QUERY_NAME_GET_TASK_BY_TASK_ID,query = "SELECT e FROM mossad_task e WHERE e.id= :"+Constants.PARAM_TASK_ID)
})


public class Task extends AbstractEntityLite {

    
    @Column(name="title") 
    private String title;

    @Column(name="description")
    private String description ;
    
    @Column(name="priority")
    private Long priority;
    
    @Column(name="userId")
    private long userId;
    
    @Column(name="status")
    private long status;
    
    @Column(name="type")
    private long type;
    
    
    public Task(){
    }
    
    
    public Task(Long id) {

    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the status
     */
    public long getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(long status) {
        this.status = status;
    }

    /**
     * @return the type
     */
    public long getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(long type) {
        this.type = type;
    }

    /**
     * @return the user
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the priority
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mossad.lib.domain.user.User[ id=" + getId() + " ]";
    }
    
    
    
}
