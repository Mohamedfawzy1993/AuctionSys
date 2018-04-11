/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author nagib
 */
@FacesValidator("validator.EmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String mail = (String) value;
        System.out.println("##### validate() ######");
        if (mail.contains("@")) {
            System.out.println("##### Valid ######");
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "summry error", "detail error");
            throw new ValidatorException(message);
        }

    }

}
