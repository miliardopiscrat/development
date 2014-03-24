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
@FacesValidator("com.mossad.ConfirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        UIInput confirmComponent = (UIInput) component.getAttributes().get("confirmFor");
        String confirm = (String) confirmComponent.getValue();
        
        if (!value.equals(confirm)) {
            FacesMessage msg =
                    new FacesMessage("Passwords do not match.",
                    "Passwords do not match.");
            // this message is anyway overriden by settings in facelet but bundle could be used here
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            UIInput input = (UIInput) component;
            input.setValue(value);
            throw new ValidatorException(msg);
        }
    }
}