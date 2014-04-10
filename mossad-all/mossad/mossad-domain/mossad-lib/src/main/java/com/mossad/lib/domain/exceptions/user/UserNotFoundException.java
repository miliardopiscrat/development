/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.lib.domain.exceptions.user;

/**
 *
 * @author mmigdal
 */
public final class UserNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private Long id;

    public UserNotFoundException(String email) {
        this.email = email;
    }

    public UserNotFoundException(Long id) {
        this.id = id;
    }

    public UserNotFoundException(String email, String password) {
        this.password = password;
        this.email = email;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    public Long getUserId() {
        return id;

    }
}
