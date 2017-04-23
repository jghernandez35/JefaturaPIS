package com.unicauca.jefatura.validadores;


import com.unicauca.jefatura.sessionbean.DocenteFacade;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value="ValidarCampoNumeroIdentificacionDocente")
public class ValidarCampoNumeroIdentificacionDocente implements Validator,Serializable
{
    @EJB
    private DocenteFacade docenteEJB;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String texto = String.valueOf(value);
    
      
        
        if(docenteEJB.buscarPorNumeroIdentificacion(texto))
        {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Numero de identificacion ya esta registrado");
            throw new ValidatorException(msg); 
        }else{
                
        }
        
    }
}