package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Proyecto;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.ProyectoFacade;

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

@Named("proyectoController")
@SessionScoped
public class ProyectoController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.ProyectoFacade ejbFacade;
    private List<Proyecto> items = null;
    private Proyecto proyecto;

    public ProyectoController() {
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProyectoFacade getFacade() {
        return ejbFacade;
    }

//    public Proyecto prepareCreate() {
//        proyecto = new Proyecto();
//        initializeEmbeddableKey();
//        return proyecto;
//    }
    //jose
    public void gestionProyecto(CargarFormularioController formularioController) {
        formularioController.cargarGestionProyecto();
    }     
    //jose
    public void prepareCreate(CargarFormularioController formularioController) {
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC 1111 prepareCreate()");
        proyecto = new Proyecto();
        initializeEmbeddableKey();
        formularioController.cargarCrearProyecto();
    }    
    //jose
    public void registrarProyecto(){
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC 2222 ProyectoController.registrarProyecto()");
        
//        System.err.println("proyecto docente = "+proyecto.getDocente().getNombres()+" "+proyecto.getDocente().getId());
//        System.err.println("proyecto tipo proyecto = "+proyecto.getTipoproyecto().getTipoEstudio());
//        System.err.println("proyecto resolucion = "+proyecto.getResolucion());
//        System.err.println("proyecto res fecha = "+proyecto.getFechaAprobacion());
//        System.err.println("proyecto titulo = "+proyecto.getTituloDelTrabajo());
//        System.err.println("proyecto Acta = "+proyecto.getActadeptartamento());
//        System.err.println("proyecto acta fecha = "+proyecto.getFechaacta());
//        System.err.println("proyecto estudiante = ");
//        System.err.println("proyecto soporte = "+proyecto.getId().getPath());
//        //creo el objeto para agregar llaves foraneas y las agrego
//        ProyectoPK proyectopk = new ProyectoPK();
//        proyectopk.setDocId(proyecto.getDocente().getId());
//        proyectopk.setTipIdEstudio(proyecto.getTipoproyecto().getIdEstudio());
//        //al proyecto le agrego el objeto con las llaves foraneas ya fijadas
//        proyecto.setProyectoPK(proyectopk);
//        // mediante al EJB creo la entrada en la BD del proyecto
//        ejbFacade.create(proyecto);
        
    }
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("ProyectoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    //jose
    public void cancel(CargarFormularioController formularioController) {
        limpiarProyecto();
        formularioController.cargarGestionProyecto();
    } 
    //jose
    public void prepareUpdate(Proyecto pro, CargarFormularioController formularioController) {
        proyecto = pro;
        formularioController.cargarModificarProyecto();
    }    
    //jose
    public void update(CargarFormularioController formularioController) {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("ProyectoUpdated"));
        formularioController.cargarGestionProyecto();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("ProyectoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            proyecto = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    //jose
    public void prepareView(Proyecto pro, CargarFormularioController formularioController) {
        proyecto = pro;
        formularioController.cargarVerProyecto();
    }    
    //jose
    public void limpiarProyecto() {
        proyecto = null;
    }    
    //jose
    public List<Proyecto> getItems() {
        //if (items == null) {
            items = getFacade().findAll();
        //}
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (proyecto != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(proyecto);
                } else {
                    getFacade().remove(proyecto);
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

    public Proyecto getProyecto(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Proyecto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Proyecto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Proyecto.class)
    public static class ProyectoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProyectoController controller = (ProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proyectoController");
            return controller.getProyecto(getKey(value));
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
            if (object instanceof Proyecto) {
                Proyecto o = (Proyecto) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Proyecto.class.getName()});
                return null;
            }
        }

    }

}
