package com.mossad.login;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Piotr Babij
 */
@ManagedBean(name = "logInRequestBean")
@RequestScoped
public class LogInRequestBean implements Serializable {

    public static final String TARGET_FROM_LOGIN_FORM = "my/home.jsf";
    private String email;
    private String password;
    @ManagedProperty(value = "#{logInBean}")
    private LogInBean logInBean;
    @ManagedProperty(value = "#{param.from}")
    private String from;

    public void logIn() {
        final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        try {
            request.login(email, password);
            // TODO: (?) get some additional user data from EJBs
            
            logInBean.setLoggedIn(true);
            logInBean.setUserName(email);
            logInBean.setPassword(password);
          

            // if user got to the login form by redirection -> go to that page after authentication
            // if not (if user got here by typing login.jsf in the address bar) -> go to default page
            if (from == null || from.isEmpty()) {
                from = TARGET_FROM_LOGIN_FORM;
            }
            externalContext.redirect(from);
        } catch (IOException ex) {
            Logger.getLogger(LogInRequestBean.class.getName()).log(Level.SEVERE, "Redirection to " + from + " failed", ex);
        } catch (ServletException ex) {
            Logger.getLogger(LogInBean.class.getName()).log(Level.SEVERE, "Login failed: " + email + " " + password, ex);

            logInBean.setLoggedIn(false);
        }
    }
    
    public void logOut() {
        final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            request.logout();
            logInBean.setLoggedIn(false);
        } catch (ServletException ex) {
            Logger.getLogger(LogInRequestBean.class.getName()).log(Level.SEVERE, "Log out failed", ex);
        }
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String userName) {
        this.email = userName;
    }

    public LogInBean getLogInBean() {
        return logInBean;
    }

    public void setLogInBean(LogInBean logInBean) {
        this.logInBean = logInBean;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
