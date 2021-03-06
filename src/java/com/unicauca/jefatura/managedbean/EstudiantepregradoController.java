package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Estudiantepregrado;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.EstudiantepregradoFacade;

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

@Named("estudiantepregradoController")
@SessionScoped
public class EstudiantepregradoController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.EstudiantepregradoFacade ejbFacade;
    private List<Estudiantepregrado> items = null;
    private Estudiantepregrado selected;

    public EstudiantepregradoController() {
    }

    public Estudiantepregrado getSelected() {
        return selected;
    }

    public void setSelected(Estudiantepregrado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EstudiantepregradoFacade getFacade() {
        return ejbFacade;
    }

    public Estudiantepregrado prepareCreate() {
        selected = new Estudiantepregrado();
        initializeEmbeddableKey();
        return selected;
    }
    
    public void prepareCreateDocente(CargarFormularioController formularioController) {
        selected = new Estudiantepregrado();
        initializeEmbeddableKey();
        formularioController.cargarCrearEstudianteDocente();
    }
    
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("EstudiantepregradoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("EstudiantepregradoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("EstudiantepregradoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Estudiantepregrado> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Estudiantepregrado getEstudiantepregrado(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Estudiantepregrado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Estudiantepregrado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Estudiantepregrado.class)
    public static class EstudiantepregradoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstudiantepregradoController controller = (EstudiantepregradoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estudiantepregradoController");
            return controller.getEstudiantepregrado(getKey(value));
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
            if (object instanceof Estudiantepregrado) {
                Estudiantepregrado o = (Estudiantepregrado) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Estudiantepregrado.class.getName()});
                return null;
            }
        }

    }

}
