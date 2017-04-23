package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Contratacion;
import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.ContratacionFacade;

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

@Named("contratacionController")
@SessionScoped
public class ContratacionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.ContratacionFacade ejbFacade;
    private List<Contratacion> items = null;
    private Contratacion selected;

    public ContratacionController() {
        selected = new Contratacion();
    }

    public Contratacion getSelected() {
        return selected;
    }

    public void setSelected(Contratacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
    public void cancel(CargarFormularioController formularioController) {
        limpiarContratacion();
        formularioController.cargarGestionContratacion();
    }
    
    private ContratacionFacade getFacade() {
        return ejbFacade;
    }

    public void prepareCreate(Docente doc,CargarFormularioController formularioController) {
        selected = new Contratacion();
        initializeEmbeddableKey();
        selected.setDocId(doc);
        formularioController.cargarCrearContratacion();
    }

    public void create(CargarFormularioController formularioController) {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ContratacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        formularioController.cargarGestionDocente();
    }
    
    public void prepareUpdate(Contratacion con, CargarFormularioController formularioController) {
        selected = con;
        formularioController.cargarModificarContratacion();
    }

    public void update(CargarFormularioController formularioController) {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ContratacionUpdated"));
        formularioController.cargarGestionContratacion();
    }

     public void gestionContratacion(CargarFormularioController formularioController) {
        formularioController.cargarGestionContratacion();
    }
    
    public void destroy(Contratacion con, CargarFormularioController formularioController) {
        selected = con;
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ContratacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        formularioController.cargarGestionContratacion();
    }
    
    public void prepareView(Contratacion con, CargarFormularioController formularioController) {
        selected = con;
        formularioController.cargarVerContratacion();
    
    }
    
    public void limpiarContratacion() {
        selected = null;
    }

    public List<Contratacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
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

    public Contratacion getContratacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Contratacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Contratacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Contratacion.class)
    public static class ContratacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ContratacionController controller = (ContratacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "contratacionController");
            return controller.getContratacion(getKey(value));
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
            if (object instanceof Contratacion) {
                Contratacion o = (Contratacion) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Contratacion.class.getName()});
                return null;
            }
        }

    }

}
