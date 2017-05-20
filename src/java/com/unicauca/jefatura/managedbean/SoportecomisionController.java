package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Soportecomision;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.SoportecomisionFacade;

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

@Named("soportecomisionController")
@SessionScoped
public class SoportecomisionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.SoportecomisionFacade ejbFacade;
    private List<Soportecomision> items = null;
    private Soportecomision selected;

    public SoportecomisionController() {
    }

    public Soportecomision getSelected() {
        return selected;
    }

    public void setSelected(Soportecomision selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SoportecomisionFacade getFacade() {
        return ejbFacade;
    }

    public Soportecomision prepareCreate() {
        selected = new Soportecomision();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle.comisiones").getString("SoportecomisionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle.comisiones").getString("SoportecomisionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle.comisiones").getString("SoportecomisionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Soportecomision> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle.comisiones").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle.comisiones").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Soportecomision getSoportecomision(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Soportecomision> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Soportecomision> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Soportecomision.class)
    public static class SoportecomisionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SoportecomisionController controller = (SoportecomisionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "soportecomisionController");
            return controller.getSoportecomision(getKey(value));
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
            if (object instanceof Soportecomision) {
                Soportecomision o = (Soportecomision) object;
                return getStringKey(o.getIdSoporteComision());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Soportecomision.class.getName()});
                return null;
            }
        }

    }

}
