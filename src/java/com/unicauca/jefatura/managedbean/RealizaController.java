package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.RealizaFacade;

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

@Named("realizaController")
@SessionScoped
public class RealizaController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.RealizaFacade ejbFacade;
    private List<Realiza> items = null;
    private Realiza selected;
    private List<Realiza> itemsDocente = null;
    private Docente selectDocente;

    public RealizaController() {
    }

    public Realiza getSelected() {
        return selected;
    }

    public Docente getSelectDocente() {
        return selectDocente;
    }

    public void setSelectDocente(Docente selectDocente) {
        this.selectDocente = selectDocente;
    }

    public void setSelected(Realiza selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RealizaFacade getFacade() {
        return ejbFacade;
    }

    public Realiza prepareCreate() {
        selected = new Realiza();

        initializeEmbeddableKey();

        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RealizaCreated"));
        ejbFacade.refrescar();

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            itemsDocente = null;
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RealizaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RealizaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            itemsDocente = null;
            selectDocente = null;
        }
    }

    public List<Realiza> getItems() {

        items = getFacade().findAll();

        return items;
    }

//    public List<Realiza> getItemsDocente(Docente doc) {
//        if (itemsDocente == null) {
//            itemsDocente = getFacade().obtenerProduccionIntelectual(doc.getDocumento());
//        }
//        return itemsDocente;
//    }
    public List<Realiza> getItemsDocente() {
        itemsDocente=null;
        itemsDocente = getFacade().obtenerProduccionIntelectual(selectDocente.getDocumento());

        return itemsDocente;
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

    public Realiza getRealiza(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Realiza> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Realiza> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Realiza.class)
    public static class RealizaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RealizaController controller = (RealizaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "realizaController");
            return controller.getRealiza(getKey(value));
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
            if (object instanceof Realiza) {
                Realiza o = (Realiza) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Realiza.class.getName()});
                return null;
            }
        }

    }

    public void prepareView(Realiza rea, CargarFormularioController formularioController) {
        selected = rea;
        formularioController.cargarVerRealiza();

    }

    public void prepareViewItemDocente(Docente selectDocente, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocente.getNombres());
        this.selectDocente = selectDocente;
        formularioController.cargarVerRevistasDocente();

    }

    public void cancel(CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocente.getNombres());
        if (this.selectDocente != null) {
            formularioController.cargarVerRevistasDocente();
        }

    }

    public void atras(CargarFormularioController formularioController) {
        formularioController.cargarGestionRevista();
        selectDocente = null;
        itemsDocente = null;
    }

}
