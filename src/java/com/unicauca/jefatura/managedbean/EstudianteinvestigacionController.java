package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Estudianteinvestigacion;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.EstudianteinvestigacionFacade;

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

@Named("estudianteinvestigacionController")
@SessionScoped
public class EstudianteinvestigacionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.EstudianteinvestigacionFacade ejbFacade;
    private List<Estudianteinvestigacion> items = null;
    private Estudianteinvestigacion selected;

    public EstudianteinvestigacionController() {
    }

    public Estudianteinvestigacion getSelected() {
        return selected;
    }

    public void setSelected(Estudianteinvestigacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EstudianteinvestigacionFacade getFacade() {
        return ejbFacade;
    }

    public Estudianteinvestigacion prepareCreate() {
        selected = new Estudianteinvestigacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("EstudianteinvestigacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("EstudianteinvestigacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("EstudianteinvestigacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Estudianteinvestigacion> getItems() {
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

    public Estudianteinvestigacion getEstudianteinvestigacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Estudianteinvestigacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Estudianteinvestigacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Estudianteinvestigacion.class)
    public static class EstudianteinvestigacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstudianteinvestigacionController controller = (EstudianteinvestigacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estudianteinvestigacionController");
            return controller.getEstudianteinvestigacion(getKey(value));
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
            if (object instanceof Estudianteinvestigacion) {
                Estudianteinvestigacion o = (Estudianteinvestigacion) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Estudianteinvestigacion.class.getName()});
                return null;
            }
        }

    }

}
