package com.mossad.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Piotr
 */
@FacesValidator("com.mossad.PasswordValidator")
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        String password = (String) value;
        
        if (password.length() < 5) {
            FacesMessage msg =
                    new FacesMessage("Password is not long enough.",
                    "Invalid password.");
            // this message is anyway overriden by settings in facelet but bundle could be used here
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            UIInput input = (UIInput) component;
            input.setValue(value);
            throw new ValidatorException(msg);
        }
    }
}