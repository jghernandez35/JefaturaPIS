package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Categoria;
import com.unicauca.jefatura.entidades.Categoriacontratacion;
import com.unicauca.jefatura.entidades.Tipocontratacion;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.CategoriacontratacionFacade;

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
import javax.faces.event.ValueChangeEvent;

@Named("categoriacontratacionController")
@SessionScoped
public class CategoriacontratacionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.CategoriacontratacionFacade ejbFacade;
    private List<Categoriacontratacion> items = null;
    private Categoriacontratacion selected;

    public CategoriacontratacionController() {
        selected = new Categoriacontratacion();
    }

    public Categoriacontratacion getSelected() {
        return selected;
    }

    public void setSelected(Categoriacontratacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CategoriacontratacionFacade getFacade() {
        return ejbFacade;
    }

    public Categoriacontratacion prepareCreate() {
        selected = new Categoriacontratacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CategoriacontratacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CategoriacontratacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CategoriacontratacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Categoriacontratacion> getItems() {
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

    public Categoriacontratacion getCategoriacontratacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Categoriacontratacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Categoriacontratacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Categoriacontratacion.class)
    public static class CategoriacontratacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CategoriacontratacionController controller = (CategoriacontratacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoriacontratacionController");
            return controller.getCategoriacontratacion(getKey(value));
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
            if (object instanceof Categoriacontratacion) {
                Categoriacontratacion o = (Categoriacontratacion) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Categoriacontratacion.class.getName()});
                return null;
            }
        }

    }

     public void seleccionCategoria(ValueChangeEvent e) {

        Tipocontratacion contratacion_seleccionada = (Tipocontratacion)e.getNewValue();
        int id = contratacion_seleccionada.getId().intValue();
       
        items = getFacade().buscarPorIdTipoContratacion(id);
       

    }
    
}
