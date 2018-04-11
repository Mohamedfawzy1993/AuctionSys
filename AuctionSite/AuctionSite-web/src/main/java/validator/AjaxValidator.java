/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Eman
 */
@ManagedBean(name = "AjaxValidator")
@SessionScoped
public class AjaxValidator implements Serializable {

    public AjaxValidator() {
    }

    public void validateName(FacesContext context, UIComponent component, Object value) {

        if (((String) value).contains("?")) {
            FacesMessage message = new FacesMessage("Email Can not contain '?' ");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

}
