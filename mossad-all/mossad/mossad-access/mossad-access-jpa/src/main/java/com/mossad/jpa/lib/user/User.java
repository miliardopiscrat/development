/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.user;

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
@Entity(name = Constants.MOSSAD_USER_DEF)
@Table(name = Constants.MOSSAD_USER_DEF)
@NamedQueries({
    @NamedQuery(name = Constants.LOGIN_USER_BY_EMAIL_AND_PASSWORD,
    query = "SELECT e FROM mossad_user e WHERE e.email= :"+ Constants.PARAM_EMAIL +" AND e.password = :"+Constants.PARAM_PASSWORD),
    @NamedQuery(name = Constants.QUERY_GET_USER_BY_EMAIL,
    query = "SELECT e FROM mossad_user e WHERE e.email= :"+Constants.PARAM_EMAIL),
    @NamedQuery(name = Constants.QUERY_GET_USER_BY_ID,
    query = "SELECT e FROM mossad_user e WHERE e.id= :"+Constants.PARAM_ID),
    @NamedQuery(name = Constants.GET_ALL_USERS,
    query = "SELECT e FROM mossad_user")
})
public class User extends AbstractEntityLite {

    private static final long serialVersionUID = 1L;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(Long id, String name, String surname, String login, String password, String email) {
        //super(PARAM_ID);
        //this.PARAM_ID = PARAM_ID;
        this.name = name;
        this.surname = surname;
        //this.login = login;
        this.password = password;
        this.email = email;

    }

    //==========================================================================
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mossad.lib.domain.user.User[ id=" + getId() + " ]";
    }

    //==========================================================================
    /**
     * @return the userSurname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param userSurname the userSurname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the userName
     */
    public String getName() {
        return name;
    }

    /**
     * @param userName the userName to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the login
     */
    /*
    public String getLogin() {
    return login;
    }
    
    /**
     * @param login the login to set
     */
    /*
    public void setLogin(String userLogin) {
    this.login = userLogin;
    }
     */
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
