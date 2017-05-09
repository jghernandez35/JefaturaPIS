package com.unicauca.jefatura.managedbean;

import com.unicauca.jefatura.entidades.CapituloLibro;
import com.unicauca.jefatura.entidades.Conferencia;
import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Libro;
import com.unicauca.jefatura.entidades.Produccionintelectual;
import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.entidades.Revista;
import com.unicauca.jefatura.managedbean.util.JsfUtil;
import com.unicauca.jefatura.managedbean.util.JsfUtil.PersistAction;
import com.unicauca.jefatura.sessionbean.RealizaFacade;

import java.io.Serializable;
import java.util.Date;
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

@Named("realizaController")
@SessionScoped
public class RealizaController implements Serializable {

    @EJB
    private com.unicauca.jefatura.sessionbean.RealizaFacade ejbFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.RevistaFacade ejbRevistaFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.LibroFacade ejbLibroFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.CapituloLibroFacade ejbCapituloLibroFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.ProduccionintelectualFacade ejbProduccionIntelectualFacade;
    @EJB
    private com.unicauca.jefatura.sessionbean.ConferenciaFacade ejbConferenciaFacade;

    private Revista revistaSelect;
    private Libro libroSelect;
    private CapituloLibro capLibroselect;
    private Conferencia conferenciaSelect;
    private Produccionintelectual produccionIntelectualSelect;
    private List<Docente> colaboradores;
    private int idProduccionNueva;
    private List<Realiza> items = null;
    private Realiza selected;
    private List<Realiza> itemsDocente = null;
    private Docente selectDocente;

    private List<Realiza> revistas;
    private List<Realiza> libros;
    private List<Realiza> capitulos_libro;
    private List<Realiza> conferencias;

    private Date currentDate = new Date();

    public Date getCurrentDate() {
        return currentDate;
    }

    public Produccionintelectual getProduccionIntelectualSelect() {
        return produccionIntelectualSelect;
    }

    public void setProduccionIntelectualSelect(Produccionintelectual produccionIntelectualSelect) {
        this.produccionIntelectualSelect = produccionIntelectualSelect;
    }

    public List<Docente> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Docente> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Revista getRevistaSelect() {
        return revistaSelect;
    }

    public void setRevistaSelect(Revista revistaSelect) {
        this.revistaSelect = revistaSelect;
    }

    public Libro getLibroSelect() {
        return libroSelect;
    }

    public void setLibroSelect(Libro libroSelect) {
        this.libroSelect = libroSelect;
    }

    public CapituloLibro getCapLibroselect() {
        return capLibroselect;
    }

    public void setCapLibroselect(CapituloLibro capLibroselect) {
        this.capLibroselect = capLibroselect;
    }

    public Conferencia getConferenciaSelect() {
        return conferenciaSelect;
    }

    public void setConferenciaSelect(Conferencia conferenciaSelect) {
        this.conferenciaSelect = conferenciaSelect;
    }

    public List<Realiza> getRevistas() {
        if (revistas == null) {
            revistas = ejbFacade.getRevistasDocente(selectDocente.getId());
        }
        return revistas;
    }

    public void recargarRevistas() {
        ejbRevistaFacade.findAll();
        revistas = ejbFacade.getRevistasDocente(selectDocente.getId());
    }

    public void setRevistas(List<Realiza> revistas) {
        this.revistas = revistas;
    }

    public List<Realiza> getLibros() {
        if (libros == null) {

            libros = ejbFacade.getLibroDocente(selectDocente.getId());
        }

        return libros;
    }

    public void recargarLibros() {
        ejbFacade.findAll();
        libros = ejbFacade.getLibroDocente(selectDocente.getId());
    }

    public void setLibros(List<Realiza> libros) {
        this.libros = libros;
    }

    public List<Realiza> getCapitulos_libro() {
        if (capitulos_libro == null) {
            capitulos_libro = ejbFacade.getCapituloLibroDocente(selectDocente.getId());
        }

        return capitulos_libro;
    }

    public void setCapitulos_libro(List<Realiza> capitulos_libro) {
        this.capitulos_libro = capitulos_libro;
    }

    public void recargarCapitulosLibros() {
        capitulos_libro = ejbFacade.getCapituloLibroDocente(selectDocente.getId());
    }

    public List<Realiza> getConferencias() {
        if (conferencias == null) {
            conferencias = ejbFacade.getConferenciaDocente(selectDocente.getId());
        }

        return conferencias;
    }

    public void setConferencias(List<Realiza> conferencias) {
        this.conferencias = conferencias;
    }

    public void recargarConferencias() {
        conferencias = ejbFacade.getConferenciaDocente(selectDocente.getId());
    }

    public RealizaController() {
        selected = new Realiza();
        produccionIntelectualSelect = new Produccionintelectual();
        revistaSelect = new Revista();
        conferenciaSelect = new Conferencia();
        libroSelect = new Libro();
        capLibroselect = new CapituloLibro();
        idProduccionNueva = -1;

    }

    public Realiza getSelected() {
        return selected;
    }

    public Docente getSelectDocente() {
        return selectDocente;
    }

    public void setSelectDocente(Docente selectDocente) {
        this.selectDocente = selectDocente;
        selected.setDocId(selectDocente);
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
        produccionIntelectualSelect = new Produccionintelectual();
        revistaSelect = new Revista();
        conferenciaSelect = new Conferencia();
        libroSelect = new Libro();
        capLibroselect = new CapituloLibro();

        initializeEmbeddableKey();

        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RealizaCreated"));

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            itemsDocente = null;

        }
    }

    public void create(CargarFormularioController formularioController, Integer tipo) {

        ejbProduccionIntelectualFacade.create(produccionIntelectualSelect);

        idProduccionNueva = produccionIntelectualSelect.getId();

        switch (tipo) {
            case 1://crear libro
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
                break;
            case 3://crear  revista
                revistaSelect.setId(idProduccionNueva);
                revistaSelect.setProduccionintelectual(produccionIntelectualSelect);
                ejbRevistaFacade.create(revistaSelect);
                produccionIntelectualSelect.setRevista(revistaSelect);
                break;
            case 4://crear conferencia
                conferenciaSelect.setConferenciaId(idProduccionNueva);
                conferenciaSelect.setProduccionintelectual(produccionIntelectualSelect);

                ejbConferenciaFacade.create(conferenciaSelect);
                produccionIntelectualSelect.setConferencia(conferenciaSelect);
                break;

        }

        selected.setProId(produccionIntelectualSelect);
        selected.setDocId(selectDocente);
        for (int i = 0; i < colaboradores.size(); i++) {
            Docente aux = colaboradores.get(i);
            if (!aux.getDocumento().equals(selectDocente.getDocumento())) {
                Realiza realizaAux = new Realiza();
                realizaAux.setDocId(aux);
                realizaAux.setProId(produccionIntelectualSelect);
                getFacade().create(realizaAux);
                System.out.println("Docentes selecionados:" + aux.getNombres());
            } else {
                System.out.println("Se selecciono a el mismo:" + aux.getNombres());
            }

        }
        colaboradores.clear();

        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RealizaCreated"));

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            itemsDocente = null;

        }
        switch (tipo) {
            case 1://crear libro
                formularioController.cargarVerLibrosDocente();

                break;
            case 2://crear capitulo libro
                formularioController.cargarVerCapLibrosDocente();
                break;
            case 3://crear  revista
                formularioController.cargarVerRevistasDocente();
                break;
            case 4://crear conferencia
                formularioController.cargarVerConferenciasDocente();
                break;

        }

    }

    @PrePersist
    public Realiza prepareCreate(CargarFormularioController formularioController, Integer tipo) {
        selected = new Realiza();
        initializeEmbeddableKey();
        produccionIntelectualSelect = new Produccionintelectual();

        switch (tipo) {
            case 1://crear libro
                libroSelect = new Libro();
                libroSelect.setLibroEdicion(1);
                formularioController.cargarCrearLibro();

                break;
            case 2://crear capitulo libro
                capLibroselect = new CapituloLibro();
                capLibroselect.setLibroEdicion(1);
                capLibroselect.setCapLibroNumero(1);
                formularioController.cargarCrearCapituloLibro();
                break;
            case 3://crear  revista
                revistaSelect = new Revista();
                revistaSelect.setNumeroEdicion(1);
                System.out.println("Se creo la revista");
                formularioController.cargarCrearRevista();
                break;
            case 4://crear conferencia
                conferenciaSelect = new Conferencia();
                System.out.println("Se creo la conferencias");
                formularioController.cargarCrearConferencia();
                break;

        }

        return selected;
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
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

//    public List<Realiza> getItemsDocente(Docente doc) {
//        if (itemsDocente == null) {
//            itemsDocente = getFacade().obtenerProduccionIntelectual(doc.getDocumento());
//        }
//        return itemsDocente;
//    }
    public List<Realiza> getItemsDocente() {

        itemsDocente = null;
        itemsDocente = getFacade().obtenerProduccionIntelectual(selectDocente.getId());

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

    public void prepareViewVerRevista(Realiza rea, CargarFormularioController formularioController, Integer opc) {
        selected = rea;
        formularioController.cargarVerRevista(opc);

    }

    public void prepareViewVerLibro(Realiza rea, CargarFormularioController formularioController, Integer opc) {
        selected = rea;
        formularioController.cargarVerLibro(opc);

    }

    public void prepareViewVerCapituloLibro(Realiza rea, CargarFormularioController formularioController, Integer opc) {
        selected = rea;
        formularioController.cargarVerCapituloLibro(opc);

    }

    public void prepareViewVerConferencia(Realiza rea, CargarFormularioController formularioController, Integer opc) {
        selected = rea;
        formularioController.cargarVerConferencia(opc);

    }

    public void prepareViewItemDocente(Docente selectDocente, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocente.getNombres());
        this.selectDocente = selectDocente;
        formularioController.cargarVerRevistasDocente();

    }

    public void prepareViewConferenciaItemDocente(Docente selectDocente, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocente.getNombres());
        this.selectDocente = selectDocente;
        formularioController.cargarVerConferenciasDocente();

    }

    public void prepareViewLibroItemDocente(Docente selectDocente, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocente.getNombres());
        this.selectDocente = selectDocente;
        formularioController.cargarVerLibrosDocente();

    }

    public void prepareViewCapLibroItemDocente(Docente selectDocente, CargarFormularioController formularioController) {
        System.out.println("el nombre del docente es:" + selectDocente.getNombres());
        this.selectDocente = selectDocente;
        formularioController.cargarVerCapLibrosDocente();

    }

    public void cancel(CargarFormularioController formularioController, Integer tipo) {
        System.out.println("el nombre del docente es:" + selectDocente.getNombres());
        if (this.selectDocente != null) {
            formularioController.cargarVerRevistasDocente();
            switch (tipo) {
                case 1://crear libro
                    formularioController.cargarVerLibrosDocente();

                    break;
                case 2://crear capitulo libro
                    formularioController.cargarVerCapLibrosDocente();
                    break;
                case 3://crear  revista
                    formularioController.cargarVerRevistasDocente();
                    break;
                case 4://crear conferencia
                    formularioController.cargarVerConferenciasDocente();
                    break;

            }
        }

    }

    public void atras(CargarFormularioController formularioController) {
        formularioController.cargarGestionRevista();
        selectDocente = null;
        itemsDocente = null;
    }

    public void verProduccion(Realiza rea, CargarFormularioController formularioController) {

        selected = rea;
        int tipoProduccion = rea.getProId().getTipoProduccion2();
        switch (tipoProduccion) {
            case 1://libro
                formularioController.cargarVerLibro(1);

                break;
            case 2://capitulo libro
                formularioController.cargarVerCapituloLibro(1);
                break;
            case 3://revista
                formularioController.cargarVerRevista(1);
                break;
            case 4://conferencia
                formularioController.cargarVerConferencia(1);
                break;
            default:

                break;

        }

    }

}
