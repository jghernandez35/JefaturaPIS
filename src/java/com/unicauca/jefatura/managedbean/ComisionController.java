package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.CapituloLibro;
import com.unicauca.jefatura.entidades.Comision;
import com.unicauca.jefatura.entidades.Conferencia;
import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Libro;
import com.unicauca.jefatura.entidades.Produccionintelectual;
import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.entidades.Revista;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.ComisionFacade;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.PrePersist;

@Named("comisionController")
@SessionScoped
public class ComisionController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.ComisionFacade ejbComisionFacade;
    
    private List<Comision> listaComisionesAcademicas=new ArrayList<>();
    private List<Comision> listaComisionesDeEstudio=new ArrayList<>();
    private List<Comision> listaComisionesAnioSabatico=new ArrayList<>();
    
    
    private List<Comision> items = null;
    private Comision selected;
    private Docente selectDocente;
    
    public ComisionController() {
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

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle.comisiones").getString("ComisionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle.comisiones").getString("ComisionUpdated"));
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
    

     @PrePersist
    public Comision prepareCreate(CargarFormularioController formularioController, Integer tipo) {
        selected = new Comision();
        initializeEmbeddableKey();
        

        switch (tipo) {
        /*    case 1://crear libro
                libroSelect = new Libro();
                libroSelect.setLibroEdicion(1);
                formularioController.cargarCrearLibro();

                break;
            case 2://crear capitulo libro
                capLibroselect = new CapituloLibro();
                capLibroselect.setLibroEdicion(1);
                capLibroselect.setCapLibroNumero(1);
                formularioController.cargarCrearCapituloLibro();
                break;*/
            case 3://crear  revista
                //revistaSelect = new Revista();
               // revistaSelect.setNumeroEdicion(1);
                System.out.println("Se creo la revista");
                formularioController.cargarCrearComision();
                break;
           /* case 4://crear conferencia
                conferenciaSelect = new Conferencia();
                System.out.println("Se creo la conferencias");
                formularioController.cargarCrearConferencia();
                break;
*/
        }

        return selected;
    }
    
    public void create(CargarFormularioController formularioController, Integer tipo) {

        //ejbProduccionIntelectualFacade.create(produccionIntelectualSelect);

        //idProduccionNueva = produccionIntelectualSelect.getId();
        System.out.println("Hola comision1");
        switch (tipo) {
            /*case 1://crear libro
                libroSelect.setLibroId(idProduccionNueva);
                libroSelect.setProduccionintelectual(produccionIntelectualSelect);
                ejbLibroFacade.create(libroSelect);
                produccionIntelectualSelect.setLibro(libroSelect);
                break;
            case 2://crear capitulo libro
                capLibroselect.setCapLibroId(idProduccionNueva);
                capLibroselect.setProduccionintelectual(produccionIntelectualSelect);
                ejbCapituloLibroFacade.create(capLibroselect);
                produccionIntelectualSelect.setCapituloLibro(capLibroselect);
                break;*/
            
            case 3://crear  revista
                //revistaSelect.setId(idProduccionNueva);
                //revistaSelect.setProduccionintelectual(produccionIntelectualSelect);
                //ejbRevistaFacade.create(revistaSelect);
                //produccionIntelectualSelect.setRevista(revistaSelect);
                selected.setIdDocenteComision(selectDocente);
                ejbComisionFacade.create(selected);
                System.out.println("Hola comision2");
                break;
                
                
           /* case 4://crear conferencia
                conferenciaSelect.setConferenciaId(idProduccionNueva);
                conferenciaSelect.setProduccionintelectual(produccionIntelectualSelect);

                ejbConferenciaFacade.create(conferenciaSelect);
                produccionIntelectualSelect.setConferencia(conferenciaSelect);
                break;
*/
        }

       // selected.setProId(produccionIntelectualSelect);
        selected.setIdDocenteComision(selectDocente);
        
     System.out.println("Hola comision3");

        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RealizaCreated"));

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            items = null;

        }
        switch (tipo) {
            /*case 1://crear libro
                formularioController.cargarVerLibrosDocente();

                break;
            case 2://crear capitulo libro
                formularioController.cargarVerCapLibrosDocente();
                break;*/
            case 3://crear  revista
                formularioController.cargarVerComisionAcademica();
                break;
         //   case 4://crear conferencia
           //     formularioController.cargarVerConferenciasDocente();
             //   break;

        }

    }
    
    public List<Comision> comisiones(int tipo)
    {
        List<Comision> aux=new ArrayList<>();
        List<Comision> comisiones=new ArrayList<>();
        aux=ejbComisionFacade.findAll();
        for(int i=0;i<aux.size();i++)
        {
            int auxiliar=aux.get(i).getIdTipoComisionComision().getIdTipoComision();
            System.out.println(auxiliar);
            if(auxiliar==1)
                listaComisionesAcademicas.add(aux.get(i));
            if(auxiliar==2)
                listaComisionesDeEstudio.add(aux.get(i));
            if(auxiliar==3)
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
