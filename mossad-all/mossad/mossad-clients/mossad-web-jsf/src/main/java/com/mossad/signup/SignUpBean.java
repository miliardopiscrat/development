/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.signup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Piotr
 */
@ManagedBean
@RequestScoped
public class SignUpBean {

    private UIForm form;
    private UIComponent emailField;
    private UIComponent passwordField;
    private UIComponent confirmPasswordField;
    private UIComponent acceptTermCheckbox;
    private String password;
    private String retypedPassword;
    private String email;
    private String firstName;
    private String lastName;

    public boolean isFormProperlyFilled(AjaxBehaviorEvent event) {
        return isEmailProper() && isPasswordProper() && passwordsMatch();
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the retypedPassword
     */
    public String getRetypedPassword() {
        return retypedPassword;
    }

    /**
     * @param retypedPassword the retypedPassword to set
     */
    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }

    /**
     * @return the username
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param username the username to set
     */
    public void setEmail(String username) {
        this.email = username;
    }

    private boolean isPasswordProper() {
        return true;
    }

    private boolean isEmailProper() {
        String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        final boolean valid = matcher.matches();
        
        if(!valid) {
            // add message to faces context
        }
        
        return valid;
    }

    private boolean passwordsMatch() {
        return true;
    }

    /**
     * @return the form
     */
    public UIForm getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(UIForm form) {
        this.form = form;
    }
    
    

    /**
     * @return the emailField
     */
    public UIComponent getEmailField() {
        return emailField;
    }

    /**
     * @param emailField the emailField to set
     */
    public void setEmailField(UIComponent emailField) {
        this.emailField = emailField;
    }

    /**
     * @return the passwordField
     */
    public UIComponent getPasswordField() {
        return passwordField;
    }

    /**
     * @param passwordField the passwordField to set
     */
    public void setPasswordField(UIComponent passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * @return the confirmPasswordField
     */
    public UIComponent getConfirmPasswordField() {
        return confirmPasswordField;
    }

    /**
     * @param confirmPasswordField the confirmPasswordField to set
     */
    public void setConfirmPasswordField(UIComponent confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    /**
     * @return the acceptTermCheckbox
     */
    public UIComponent getAcceptTermCheckbox() {
        return acceptTermCheckbox;
    }

    /**
     * @param acceptTermCheckbox the acceptTermCheckbox to set
     */
    public void setAcceptTermCheckbox(UIComponent acceptTermCheckbox) {
        this.acceptTermCheckbox = acceptTermCheckbox;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
