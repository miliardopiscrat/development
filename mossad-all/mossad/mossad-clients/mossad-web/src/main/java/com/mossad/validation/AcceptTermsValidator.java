package com.mossad.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Piotr
 */
@FacesValidator("com.mossad.AcceptTermsValidator")
public class AcceptTermsValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        if (!((Boolean)value)) {

            FacesMessage msg =
                    new FacesMessage("You must accept terms and conditions.",
                    "You must accept terms and conditions.");
            // this message is anyway overriden by settings in facelet but bundle could be used here
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}