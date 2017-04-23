
package com.unicauca.jefatura.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value="ValidarCampoMinimo6Numeros")
public class ValidarCampoMinimo6Numeros implements Validator
{
   

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String texto = String.valueOf(value);
        
        if(texto.length()<6)
        {
             FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"","No se permite menos de 6 digitos.");
             throw new ValidatorException(msg);  
        }           
        
    }
}