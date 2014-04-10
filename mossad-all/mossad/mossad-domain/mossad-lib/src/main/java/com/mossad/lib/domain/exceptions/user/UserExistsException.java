/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.lib.domain.exceptions.user;

/**
 *
 * @author mmigdal
 */
public final class UserExistsException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String email;

    public UserExistsException(String email) {
        this.email = email;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
}
