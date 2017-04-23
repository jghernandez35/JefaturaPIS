package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Soportetrabajosinvestigacion;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.SoportetrabajosinvestigacionFacade;

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

@Named("soportetrabajosinvestigacionController")
@SessionScoped
public class SoportetrabajosinvestigacionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.SoportetrabajosinvestigacionFacade ejbFacade;
    private List<Soportetrabajosinvestigacion> items = null;
    private Soportetrabajosinvestigacion selected;

    public SoportetrabajosinvestigacionController() {
    }

    public Soportetrabajosinvestigacion getSelected() {
        return selected;
    }

    public void setSelected(Soportetrabajosinvestigacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SoportetrabajosinvestigacionFacade getFacade() {
        return ejbFacade;
    }

    public Soportetrabajosinvestigacion prepareCreate() {
        selected = new Soportetrabajosinvestigacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("SoportetrabajosinvestigacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("SoportetrabajosinvestigacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("SoportetrabajosinvestigacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Soportetrabajosinvestigacion> getItems() {
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

    public Soportetrabajosinvestigacion getSoportetrabajosinvestigacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Soportetrabajosinvestigacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Soportetrabajosinvestigacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Soportetrabajosinvestigacion.class)
    public static class SoportetrabajosinvestigacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SoportetrabajosinvestigacionController controller = (SoportetrabajosinvestigacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "soportetrabajosinvestigacionController");
            return controller.getSoportetrabajosinvestigacion(getKey(value));
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
            if (object instanceof Soportetrabajosinvestigacion) {
                Soportetrabajosinvestigacion o = (Soportetrabajosinvestigacion) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Soportetrabajosinvestigacion.class.getName()});
                return null;
            }
        }

    }

}
