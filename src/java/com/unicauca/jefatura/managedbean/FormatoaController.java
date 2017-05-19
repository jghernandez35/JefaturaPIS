package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Estudiantepregrado;
import com.unicauca.jefatura.entidades.Formatoa;
import com.unicauca.jefatura.entidades.Proyecto;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.FormatoaFacade;

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

@Named("formatoaController")
@SessionScoped
public class FormatoaController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.FormatoaFacade ejbFacadeFormatoa;
    @EJB
    private com.unicauca.jefatura.sessionbean.ProyectoFacade ejbFacadeProyecto; 
    @EJB
    private com.unicauca.jefatura.sessionbean.EstudiantepregradoFacade ejbFacadeEstudiantePregrado;    
    private List<Formatoa> items = null;
    //fabian
    private List<Formatoa> items_docente=null;
    //Jose
    private Formatoa formatoa;
    private Proyecto proyecto;
    private Estudiantepregrado estudiantepregrado;
    //fabian
    private Docente docente;
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Estudiantepregrado getEstudiantepregrado() {
        return estudiantepregrado;
    }

    public void setEstudiantepregrado(Estudiantepregrado estudiantepregrado) {
        this.estudiantepregrado = estudiantepregrado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    public FormatoaController() {
        formatoa = new Formatoa();        
        proyecto = new Proyecto();
        estudiantepregrado = new Estudiantepregrado();
        docente = new Docente();
    }

    public Formatoa getFormatoa() {
        return formatoa;
    }

    public void setFormatoa(Formatoa formatoa) {
        this.formatoa = formatoa;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FormatoaFacade getFacade() {
        return ejbFacadeFormatoa;
    }
    //fabian ejecuta consulta para sacar los formatosa asociados a un docente mediante el id
    public List<Formatoa> getItems_docente() {
        items_docente=getFacade().listarFormatosADocente(docente.getId());
        return items_docente;
    }
    //jose
    public void gestionFormatoa(CargarFormularioController formularioController) {
        formularioController.cargarGestionFormatoa();
    }     
    //jose
    public void prepareCreateFormatoa(CargarFormularioController formularioController) {
        formatoa = new Formatoa();
        proyecto = new Proyecto();
        estudiantepregrado = new Estudiantepregrado();
        docente = new Docente();
        initializeEmbeddableKey();
        formularioController.cargarCrearFormatoa();
    }    
    
    public void create(CargarFormularioController formularioController) {
//        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("FormatoaCreated"));
//        if (!JsfUtil.isValidationFailed()) {
//            items = null;    // Invalidate list of items to trigger re-query.
//            items_docente=null;
//        }
        formatoa=ejbFacadeFormatoa.guardar(formatoa);
        //formatoa=ejbFacadeFormatoa.find(9);
        
        System.out.println(formatoa.getId()+"+++++++++++++++++++++++++++++++++++");
        System.out.println("termino de crear formato a");
        estudiantepregrado.setId(formatoa.getId());
        estudiantepregrado.setForId(formatoa);
        System.out.println("termino de crear estudiante");
        ejbFacadeEstudiantePregrado.create(estudiantepregrado);
        System.out.println("guardo estudiante");
        proyecto.setId(formatoa.getId());
        proyecto.setFormatoa(formatoa);
        System.out.println("termino de crear proyecto");
        ejbFacadeProyecto.create(proyecto);
        
        proyecto = formatoa.getProyecto();
        //limpiarFormatoa();
        System.out.println("llamando a siguiente vista 1");
        formularioController.cargarGestionFormatoaDocente();
        System.out.println("llamando a siguiente vista 2");
        estudiantepregrado = new Estudiantepregrado();
    }
    
    //jose
    public void cancel(CargarFormularioController formularioController) {
        limpiarFormatoa();
        formularioController.cargarGestionFormatoa();
    } 
    
     public void cancelDocente(CargarFormularioController formularioController) {
        limpiarFormatoa();
        formularioController.cargarGestionFormatoaDocente();
    }    
    
    //jose
    public void prepareUpdateFormatoa(Formatoa fa, CargarFormularioController formularioController) {
        formatoa = fa;
        formularioController.cargarModificarFormatoa();
    }
    
    public void update(CargarFormularioController formularioController) {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("FormatoaUpdated"));
        formularioController.cargarGestionFormatoa();
    }
    
    public void updateDocente(CargarFormularioController formularioController) {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("FormatoaUpdated"));
        formularioController.cargarGestionFormatoaDocente();
    }    

    public void destroy(CargarFormularioController formularioController) {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("FormatoaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            formatoa = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            items_docente=null;
            docente = null;
            //estudiantepregrado = null;
        }
        formularioController.cargarGestionFormatoa();
    }
    //jose
    public void prepareViewFormatoa(Formatoa fa, CargarFormularioController formularioController) {
        formatoa = fa;
        formularioController.cargarVerFormatoa();
    }    
    //jose
    public void limpiarFormatoa() {
        formatoa = null;
    }
    //jose
    public List<Formatoa> getItems() {
        //if (items == null) {
            items = getFacade().findAll();
        //}
        return items;
    }
    //fabian renderiza la vista de los formatoa de cada docente////////////////////////////////////////////////////////////////////
    //jose
    public void prepareCreateFormatoaDocentes(Docente doc, CargarFormularioController formularioController) {
        formatoa = new Formatoa();
        docente = doc;
        formatoa.setDocId(doc);
        proyecto = new Proyecto();
        //proyecto.setId(formatoa.getId());
        
        initializeEmbeddableKey();
        formularioController.cargarCrearFormatoaDocente();
    }
    //jose
//    public void registrarFormatoaDocente(CargarFormularioController formularioController){
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX registrarFormatoaDocente()");
//        
//        System.err.println("Formatoa Acta = "+formatoa.getActaDepartamento());
//        System.err.println("Formatoa fecha Acta= "+formatoa.getFechaActa());
//        System.err.println("Proyecto Resolucion = "+proyecto.getResolucion());
//        System.err.println("Proyecto Fecha Resolucion= "+proyecto.getFechaResolucion());
//        System.err.println("Formatoa Titulo = "+formatoa.getTituloTrabajo());
//        System.err.println("Formatoa Docente = "+formatoa.getDocId()+docente.getNombres());
//        // mediante al EJB creo la entrada en la BD del proyecto
////        Formatoa formatoaAux = new Formatoa();
////        formatoaAux.setId(formatoa.getId());
////        formatoaAux.setDocId(formatoa.getDocId());
////        formatoaAux.setActaDepartamento(formatoa.getActaDepartamento());
////        formatoaAux.setTituloTrabajo(formatoa.getTituloTrabajo());
////        formatoaAux.setFechaActa(formatoa.getFechaActa());
//        proyecto.setId(formatoa.getId());
//        formatoa.setDocId(docente);
//        estudiantepregrado.setForId(formatoa);
//        
//        ejbFacadeFormatoa.create(formatoa);
//        ejbFacadeProyecto.create(proyecto);
//        ejbFacadeEstudiantePregrado.create(estudiantepregrado);
//    }    
   
    //jose
//    public void createFormatoaDocente(CargarFormularioController formularioController) {
//        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProyectosDirigidos").getString("FormatoaCreated"));
//        if (!JsfUtil.isValidationFailed()) {
//            items = null;    // Invalidate list of items to trigger re-query.
//            items_docente=null;
//        }
//        limpiarFormatoaDocente();
//        formularioController.cargarGestionFormatoaDocente();        
//    }    
    //jose
    public void preparaGestionFormatoaDocentes(Docente doc, CargarFormularioController cargarformulario){
        docente=doc;
        cargarformulario.cargarGestionFormatoaDocente();
    }
    //jose
    public void limpiarFormatoaDocente() {
        formatoa = null;
        docente = null;
        estudiantepregrado = null;
    }    
    //jose
    public void preparaVerFormatoaDocentes(Docente doc,Formatoa fa, CargarFormularioController cargarformulario){
        docente=doc;
        formatoa=fa;
        cargarformulario.cargarVerFormatoaDocente();
    }
    //jose
    public void prepareUpdateFormatoaDocentes(Docente doc,Formatoa fa,/*Proyecto pro,*/ CargarFormularioController cargarformulario) {
        docente=doc;
        formatoa = fa;
        proyecto = formatoa.getProyecto();
//        proyecto = pro;
        cargarformulario.cargarModificarFormatoaDocente();
    }
    //fabian renderiza la vista de los formatoa de cada docente////////////////////////////////////////////////////////////////////   
    private void persist(PersistAction persistAction, String successMessage) {
        if (formatoa != null) {
            setEmbeddableKeys();
            
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(formatoa);
                } else {
                    getFacade().remove(formatoa);
                }
                JsfUtil.addSuccessMessage(successMessage);
                System.out.println("se guardo en la bd");
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

    public Formatoa getFormatoa(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Formatoa> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Formatoa> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Formatoa.class)
    public static class FormatoaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FormatoaController controller = (FormatoaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "formatoaController");
            return controller.getFormatoa(getKey(value));
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
            if (object instanceof Formatoa) {
                Formatoa o = (Formatoa) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Formatoa.class.getName()});
                return null;
            }
        }

    }
    public void atras(CargarFormularioController formularioController) {
        docente = null;
        items_docente= null;
        formularioController.cargarGestionDocente();
    }    


}
