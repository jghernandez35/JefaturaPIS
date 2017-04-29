package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Docente;

import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.DocenteFacade;


import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("docenteController")
@SessionScoped
public class DocenteController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.DocenteFacade ejbFacade;
    private List<Docente> items = null;
    // cambio del nombre de la variable de select a docente para que asi sea mas claro lo que representa
    // si al cambiar el nombre de la variable se realiza cambio tambien en los metodos get y set
    // es necesario hacer manualmente el cambio en las vistas debido a que la funcion rename no lo hace
    private Docente docente;
   

    public DocenteController() {
        docente = new Docente();
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

      
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    

    public Docente getSelected() {
        return docente;
    }


    public void setSelected(Docente docente) {
        this.docente = docente;
    }
    
    private DocenteFacade getFacade() {
        return ejbFacade;
    }

     public void prepareCreate(CargarFormularioController formularioController) {
        docente = new Docente();
        initializeEmbeddableKey();
        formularioController.cargarCrearDocente();
    }

    public void create(CargarFormularioController formularioController) {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DocenteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
       limpiarDocente();
       formularioController.cargarGestionDocente();
    }

    
    public void cancel(CargarFormularioController formularioController) {
        limpiarDocente();
        formularioController.cargarGestionDocente();
    }
    
    public void gestionDocente(CargarFormularioController formularioController) {
        limpiarDocente();
        formularioController.cargarGestionDocente();
    }


    public void prepareUpdate(Docente doc, CargarFormularioController formularioController) {
        docente = doc;
        formularioController.cargarModificarDocente();
    }

    public void update(CargarFormularioController formularioController) {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DocenteUpdated"));
        limpiarDocente();
        formularioController.cargarGestionDocente();
    }
   

    // el siguiente metodo se adiciono manualmente
    public void destroy(Docente doc,CargarFormularioController formularioController) {
        docente = doc;
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DocenteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            limpiarDocente(); // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        
        formularioController.cargarGestionDocente();
    }

    // el siguiente metodo se adiciono manualmente
    public void prepareView(Docente doc, CargarFormularioController formularioController) {
        docente = doc;
        formularioController.cargarVerDocente();
    
    }
    
    public void limpiarDocente() {
        docente = null;
    }
   
    public List<Docente> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (docente != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(docente);
                } else {
                    getFacade().remove(docente);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Docente getDocente(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Docente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Docente> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Docente.class)
    public static class DocenteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DocenteController controller = (DocenteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "docenteController");
            return controller.getDocente(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Docente) {
                Docente o = (Docente) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Docente.class.getName()});
                return null;
            }
        }

    }

}
