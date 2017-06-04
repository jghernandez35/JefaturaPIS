package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.CapituloLibro;
import com.unicauca.jefatura.entidades.Comision;
import com.unicauca.jefatura.entidades.Conferencia;
import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Libro;
import com.unicauca.jefatura.entidades.Produccionintelectual;
import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.entidades.Revista;
import com.unicauca.jefatura.entidades.Tipocomision;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.ComisionFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.PrePersist;

@Named("comisionController")
@SessionScoped
public class ComisionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.ComisionFacade ejbComisionFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.TipocomisionFacade ejbTipoComision;
    
    private List<Comision> listaComisionesAcademicas=new ArrayList<>();
    private List<Comision> listaComisionesDeEstudio=new ArrayList<>();
    private List<Comision> listaComisionesAnioSabatico=new ArrayList<>();
    private List<Comision> tipoComision=new ArrayList<>();
    
    private List<Comision> items = null;
    private Comision selected;
    private Docente selectDocente;
    
    public ComisionController() {
        selected=new Comision();
    }

    public Docente getSelectDocente() {
        return selectDocente;
    }
    
    public void setListaComisionesAcademicas(List<Comision> academicas)
    {
        this.listaComisionesAcademicas=academicas;
    }
    public void setListaComisionesEstudios(List<Comision> estudios)
    {
        this.listaComisionesDeEstudio=estudios;
    }
    public void setListaComisionesAnioSabatico(List<Comision> sabatico)
    {
        this.listaComisionesAnioSabatico=sabatico;
    }
    
    public List<Comision> getListaComisionesAcademicas()
    {
        return listaComisionesAcademicas;
    }
    public List<Comision> getListaComisionesEstudios()
    {
        return listaComisionesDeEstudio;
    }
    public List<Comision> getListaComisionesAnioSabatico()
    {
        return listaComisionesAnioSabatico;
    }

    public void setSelectDocente(Docente selectDocente) {
        this.selectDocente = selectDocente;
    }

    public Comision getSelected() {
        return selected;
    }

    public void setSelected(Comision selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComisionFacade getFacade() {
        return ejbComisionFacade;
    }

    public Comision prepareCreate() {
        selected = new Comision();
        initializeEmbeddableKey();
        return selected;
    }
    
    public void cancel(CargarFormularioController formularioController) {
        limpiarComision();
        formularioController.cargarGestionComision();
    }
    
    public void limpiarComision()
    {
    selected=null;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle.comisiones").getString("ComisionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        limpiarComision();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComisionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle.comisiones").getString("ComisionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Comision> getItems() {
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

    public Comision getComision(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Comision> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Comision> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Comision.class)
    public static class ComisionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComisionController controller = (ComisionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comisionController");
            return controller.getComision(getKey(value));
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
            if (object instanceof Comision) {
                Comision o = (Comision) object;
                return getStringKey(o.getIdComision());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Comision.class.getName()});
                return null;
            }
        }

         

    }
    public void prepareView(Comision doc, CargarFormularioController formularioController) {
        selected = doc;
        formularioController.cargarVerComisionAcademicauna();
    limpiarComision();
    }
    public void prepareViewItemDocente(Docente selectDocent, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocent.getNombres());
        this.selectDocente = selectDocent;
        formularioController.cargarVerComisionAcademica();
        
    }
    
    public void prepareViewItemDocenteComisionEstudios(Docente selectDocent, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocent.getNombres());
        this.selectDocente = selectDocent;
        formularioController.cargarVerComisionEstudio();
    }
    
    public void prepareViewItemDocenteAnioSabatico(Docente selectDocent, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocent.getNombres());
        this.selectDocente = selectDocent;
        formularioController.cargarVerComisionAnioSabatico();
    }
    
    public void prepareUpdate(Comision item, CargarFormularioController formularioController) {
        //System.out.println("el nombre del docente es:" + selectDocent.getNombres());
        selected=item;
        formularioController.cargarVerComision();
        
    }
    

     @PrePersist
    public Comision prepareCreate(CargarFormularioController formularioController, Integer tipo) {
        selected = new Comision();
        initializeEmbeddableKey();
        

        switch (tipo) {
           case 1://crear comision de estudios
               formularioController.cargarCrearComisionEstudios();
                break;             
            case 2://crear comision año sabatico
                formularioController.cargarCrearComisionAnioSabatico();
                break;
            case 3://crear  comision academica
                formularioController.cargarCrearComision();
                break;
         
        }

        return selected;
    }
    public java.sql.Date convertirFecha(Date fecha)
    {
       long convertir=0;
       convertir = fecha.getTime();
       java.sql.Date sqlDate = new java.sql.Date(convertir);
       return sqlDate;
    }
    public void create(CargarFormularioController formularioController, Integer tipo) {
        
      Date fechaSolicitud=selected.getFechaSolicitudComision();
      Date fechaInicio=selected.getFechaInicioComision();
      Date fechaFin=selected.getFechaFinComision();
      
      if((fechaSolicitud.compareTo(fechaInicio))==0 || fechaSolicitud.compareTo(fechaInicio)<0){
          System.out.print("Comparar fecha solicitud einicio"+fechaSolicitud.compareTo(fechaInicio));
          if((fechaInicio.compareTo(fechaFin))==0 || (fechaInicio.compareTo(fechaFin))<0)
          {
              System.out.print("Comparar fecha inicio y fin"+fechaInicio.compareTo(fechaFin));
            switch (tipo) {
                case 1://crear comision de estudios
                    List<Tipocomision> lista= new ArrayList<>();
                    lista=ejbTipoComision.findAll();        
                    selected.setIdTipoComisionComision(lista.get(1)); // obtiene la comision de estudios de la tabla tipoComision
                    selected.setIdDocenteComision(selectDocente);
                
                    ejbComisionFacade.create(selected);
                    System.out.println("Hola comision2");
                
                break;
                case 2://crear año sabatico
                    List<Tipocomision> lista1= new ArrayList<>();
                    lista1=ejbTipoComision.findAll();        
                    selected.setIdTipoComisionComision(lista1.get(2));// Obtiene la comision Año sabatico de la tabla tipoComision
                    selected.setIdDocenteComision(selectDocente);
                
                    ejbComisionFacade.create(selected);
                    System.out.println("Hola comision2");
                break;
            
                case 3://crear  comision academica
                    List<Tipocomision> lista2= new ArrayList<>();
                    lista2=ejbTipoComision.findAll();        
                    selected.setIdTipoComisionComision(lista2.get(0));// Obtiene la comision Academica de la tabla  tipoComision
                    selected.setIdDocenteComision(selectDocente);
                
                    ejbComisionFacade.create(selected);
                    System.out.println("Hola comision2");
                break;
       }

       // selected.setProId(produccionIntelectualSelect);
        selected.setIdDocenteComision(selectDocente);
        
     System.out.println("Hola comision3");

        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RealizaCreated"));
          
          }
    
          else{
           if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            items = null;

        }
          }
    }
              
      else{
           if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            items = null;

        }
          }
              /*
            
        switch (tipo) {
            case 1://crear comision de estudios
               List<Tipocomision> lista= new ArrayList<>();
                lista=ejbTipoComision.findAll();        
                selected.setIdTipoComisionComision(lista.get(1)); // obtiene la comision de estudios de la tabla tipoComision
                selected.setIdDocenteComision(selectDocente);
                
                ejbComisionFacade.create(selected);
                System.out.println("Hola comision2");
                
                break;
            case 2://crear año sabatico
                List<Tipocomision> lista1= new ArrayList<>();
                lista1=ejbTipoComision.findAll();        
                selected.setIdTipoComisionComision(lista1.get(2));// Obtiene la comision Año sabatico de la tabla tipoComision
                selected.setIdDocenteComision(selectDocente);
                
                ejbComisionFacade.create(selected);
                System.out.println("Hola comision2");
                break;
            
            case 3://crear  comision academica
                List<Tipocomision> lista2= new ArrayList<>();
                lista2=ejbTipoComision.findAll();        
                selected.setIdTipoComisionComision(lista2.get(0));// Obtiene la comision Academica de la tabla  tipoComision
                selected.setIdDocenteComision(selectDocente);
                
                ejbComisionFacade.create(selected);
                System.out.println("Hola comision2");
                break;
       }

       // selected.setProId(produccionIntelectualSelect);
        selected.setIdDocenteComision(selectDocente);
        
     System.out.println("Hola comision3");

        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RealizaCreated"));

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            items = null;

        }*/
        switch (tipo) {
            case 1://crear libro
                formularioController.cargarVerComisionEstudio();

                break;
            case 2://crear capitulo libro
                formularioController.cargarVerComisionAnioSabatico();
                break;
            case 3://crear  revista
                formularioController.cargarVerComisionAcademica();
                break;
         //   case 4://crear conferencia
           //     formularioController.cargarVerConferenciasDocente();
             //   break;

        }
        limpiarComision();
        formularioController.cargarGestionComision();

    }
    
    public List<Comision> comisiones(int tipo)
    {
        limpiarComision();
  
        List<Comision> aux=new ArrayList<>();
        List<Comision> comisiones=new ArrayList<>();
        comisiones=null;
        aux=null;
        aux=ejbComisionFacade.findAll();
        for(int i=0;i<aux.size();i++)
        {
            int auxiliar=aux.get(i).getIdTipoComisionComision().getIdTipoComision();
            System.out.println(auxiliar);
            //System.out.println("IDDDDDDDDDDDDD"+aux.get(i).getIdDocenteComision().getId());
            if(auxiliar==1&& aux.get(i).getIdDocenteComision().getId().equals(selectDocente.getId()))
                listaComisionesAcademicas.add(aux.get(i));
            if(auxiliar==2 && aux.get(i).getIdDocenteComision().getId().equals(selectDocente.getId()))
                listaComisionesDeEstudio.add(aux.get(i));
            if(auxiliar==3 && aux.get(i).getIdDocenteComision().getId().equals(selectDocente.getId()))
                listaComisionesAnioSabatico.add(aux.get(i));
        }
        
        if (tipo==1)
            comisiones= listaComisionesAcademicas;
        if(tipo==2)
           comisiones= listaComisionesDeEstudio;
        if(tipo==3)
            comisiones= listaComisionesAnioSabatico;
        
        return comisiones;
    }
}
