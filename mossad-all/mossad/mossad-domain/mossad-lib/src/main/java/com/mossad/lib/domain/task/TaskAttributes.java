/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.lib.domain.task;

import java.io.Serializable;

/**
 *
 * @author mmigdal
 */
public final class TaskAttributes implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String title;
    private String description;
    private long priority;
    private long user;
    private long status;
    private long type;

    public TaskAttributes() {
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
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the priority
     */
    public long getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(long priority) {
        this.priority = priority;
    }

    /**
     * @return the user
     */
    public long getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(long user) {
        this.user = user;
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
}
