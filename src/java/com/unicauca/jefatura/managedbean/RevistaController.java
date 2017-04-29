package com.unicauca.jefatura.managedbean;


import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Produccionintelectual;
import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.entidades.Revista;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.RevistaFacade;

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


@Named("revistaController")
@SessionScoped
public class RevistaController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.RevistaFacade ejbFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.ProduccionintelectualFacade ejbProduccionintelectualFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.RealizaFacade ejbRealizaFacade;
    
    
    
    private List<Revista> items = null;
    private Revista selected;
    private Produccionintelectual produccionintelectual; 
    private Realiza realiza;
    private List<Docente> colaboradores;
    public List<Docente> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Docente> colaboradores) {
        this.colaboradores = colaboradores;
    }
    private int idProduccionNueva;

    public Produccionintelectual getProduccionintelectual() {
        return produccionintelectual;
    }

    public void setProduccionintelectual(Produccionintelectual produccionintelectual) {
        this.produccionintelectual = produccionintelectual;
    }

    public Realiza getRealiza() {
        return realiza;
    }

    public void setRealiza(Realiza realiza) {
        this.realiza = realiza;
    }
    
    
    

    public RevistaController() {
        idProduccionNueva=-1;    
         selected= new Revista();
         produccionintelectual= new Produccionintelectual();
         realiza= new Realiza();
    }

    public Revista getSelected() {
        return selected;
    }

    public void setSelected(Revista selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RevistaFacade getFacade() {
        return ejbFacade;
    }

    public Revista prepareCreate() {
        selected = new Revista();
        initializeEmbeddableKey();
        return selected;
    }
     public void prepareCreate(Docente doc,CargarFormularioController formularioController) {
         produccionintelectual=new Produccionintelectual();
        selected = new Revista();
        initializeEmbeddableKey();
        realiza.setDocId(doc);
        formularioController.cargarCrearRevista();
    }
      public void prepareCreate(CargarFormularioController formularioController) {
        selected = new Revista();
        initializeEmbeddableKey();
     
        formularioController.cargarCrearRevista();
    }

      public void create(CargarFormularioController formularioController) {
//       persist_produccion(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProduccionintelectualCreated"));
       ejbProduccionintelectualFacade.create(produccionintelectual);
        //idProduccionNueva=(ejbProduccionintelectualFacade.agregarProduccion(produccionintelectual)).getId();
		idProduccionNueva=produccionintelectual.getId();
         selected.setProduccionintelectual(produccionintelectual);
         realiza.setProId(produccionintelectual);
         //realiza.setId(((int)(realiza.getDocId().getDocumento())/idProduccionNueva)  );
         selected.setId(idProduccionNueva);
//        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RevistaCreated"));
        // ejbRealizaFacade.create(realiza);
        ejbRealizaFacade.create(realiza);
        for(int i=0;i<colaboradores.size();i++){
            Docente aux=colaboradores.get(i);
            if(!aux.getDocumento().equals(realiza.getDocId().getDocumento())){
                Realiza realizaAux = new Realiza();
                realizaAux.setDocId(aux);
                realizaAux.setProId(produccionintelectual);
                ejbRealizaFacade.create(realizaAux);
                 System.out.println("Docentes selecionados:"+aux.getNombres());
            }else{
                 System.out.println("Se selecciono a el mismo:"+aux.getNombres());
            }
            
        }
     
     
//      persist_realiza(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RealizaCreated"));
      persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RevistaCreated"));
//      ejbFacade.refrescar();
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
       formularioController.cargarVerRevistasDocente();
    }
     
     

     public void cancel(CargarFormularioController formularioController) {
        limpiarRevista();
        formularioController.cargarGestionRevista();
    }
    
      public void gestionRevista(CargarFormularioController formularioController) {
        formularioController.cargarGestionRevista();
    }
      
       public void prepareUpdate(Revista rev, CargarFormularioController formularioController) {
        selected = rev;
        formularioController.cargarModificarRevista();
    }
     
     

        public void update(CargarFormularioController formularioController) {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RevistaUpdated"));
        formularioController.cargarGestionRevista();
    }
        
    
    // el siguiente metodo se adiciono manualmente
    public void destroy(Revista rev,CargarFormularioController formularioController) {
        selected = rev;
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        
        formularioController.cargarGestionDocente();
    }

    // el siguiente metodo se adiciono manualmente
    public void prepareView(Revista rev, CargarFormularioController formularioController) {
        selected = rev;
        formularioController.cargarVerDocente();
    
    }    
     public void limpiarRevista() {
        selected = null;
    }
        
        
       
       
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RevistaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RevistaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Revista> getItems() {
        
            items = getFacade().findAll();
        
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
 // Se borro el if debido a que ya no se encuentra el boton de eliminar en la vista
                // por la misma cuasa se elimino el metodo distroy alojado en esta clase 
            
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

    public Revista getRevista(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Revista> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Revista> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Revista.class)
    public static class RevistaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RevistaController controller = (RevistaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "revistaController");
            return controller.getRevista(getKey(value));
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
            if (object instanceof Revista) {
                Revista o = (Revista) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Revista.class.getName()});
                return null;
            }
        }

    }

   
    
}
