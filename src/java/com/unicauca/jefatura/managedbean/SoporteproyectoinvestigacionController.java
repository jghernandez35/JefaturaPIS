package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Soporteproyectoinvestigacion;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.SoporteproyectoinvestigacionFacade;

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

@Named("soporteproyectoinvestigacionController")
@SessionScoped
public class SoporteproyectoinvestigacionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.SoporteproyectoinvestigacionFacade ejbFacade;
    private List<Soporteproyectoinvestigacion> items = null;
    private Soporteproyectoinvestigacion selected;

    public SoporteproyectoinvestigacionController() {
    }

    public Soporteproyectoinvestigacion getSelected() {
        return selected;
    }

    public void setSelected(Soporteproyectoinvestigacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SoporteproyectoinvestigacionFacade getFacade() {
        return ejbFacade;
    }

    public Soporteproyectoinvestigacion prepareCreate() {
        selected = new Soporteproyectoinvestigacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("SoporteproyectoinvestigacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("SoporteproyectoinvestigacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("SoporteproyectoinvestigacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Soporteproyectoinvestigacion> getItems() {
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

    public Soporteproyectoinvestigacion getSoporteproyectoinvestigacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Soporteproyectoinvestigacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Soporteproyectoinvestigacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Soporteproyectoinvestigacion.class)
    public static class SoporteproyectoinvestigacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SoporteproyectoinvestigacionController controller = (SoporteproyectoinvestigacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "soporteproyectoinvestigacionController");
            return controller.getSoporteproyectoinvestigacion(getKey(value));
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
            if (object instanceof Soporteproyectoinvestigacion) {
                Soporteproyectoinvestigacion o = (Soporteproyectoinvestigacion) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Soporteproyectoinvestigacion.class.getName()});
                return null;
            }
        }

    }

}
