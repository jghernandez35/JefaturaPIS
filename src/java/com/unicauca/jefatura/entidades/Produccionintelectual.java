/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "produccionintelectual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccionintelectual.findAll", query = "SELECT p FROM Produccionintelectual p"),
    @NamedQuery(name = "Produccionintelectual.findById", query = "SELECT p FROM Produccionintelectual p WHERE p.id = :id"),
    @NamedQuery(name = "Produccionintelectual.findByFecha", query = "SELECT p FROM Produccionintelectual p WHERE p.fecha = :fecha")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "selectProduccionRevistaDocente", query = "SELECT r.ID, r.PRO_ID, r.DOC_ID FROM revista rv JOIN  produccionintelectual pi  on pi.ID=rv.ID  JOIN realiza r  on r.PRO_ID = pi.ID   WHERE   r.DOC_ID= ?1",resultClass = Realiza.class),
    @NamedNativeQuery(name = "selectProduccionCapituloLibroDocente", query = "SELECT r.ID, r.PRO_ID, r.DOC_ID FROM capitulo_libro cl JOIN  produccionintelectual pi  on pi.ID=cl.CAP_LIBRO_ID  JOIN realiza r  on r.PRO_ID = pi.ID   WHERE   r.DOC_ID= ?1",resultClass = Realiza.class),
    @NamedNativeQuery(name = "selectProduccionLibroDocente", query = "SELECT r.ID, r.PRO_ID, r.DOC_ID FROM libro l JOIN  produccionintelectual pi  on pi.ID=l.LIBRO_ID  JOIN realiza r  on r.PRO_ID = pi.ID   WHERE   r.DOC_ID= ?1",resultClass = Realiza.class),
    @NamedNativeQuery(name = "selectProduccionConferenciaDocente", query = "SELECT r.ID, r.PRO_ID, r.DOC_ID FROM conferencia c JOIN  produccionintelectual pi  on pi.ID=c.CONFERENCIA_ID  JOIN realiza r  on r.PRO_ID = pi.ID   WHERE   r.DOC_ID= ?1",resultClass = Realiza.class)
})
public class Produccionintelectual implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produccionintelectual")
    private Libro libro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produccionintelectual")
    private Conferencia conferencia;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produccionintelectual")
    private CapituloLibro capituloLibro;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produccionintelectual")
    private Revista revista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Soporteproduccion> soporteproduccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Realiza> realizaCollection;

    public Produccionintelectual() {
    }

    public Produccionintelectual(Integer id) {
        this.id = id;
    }

    public Produccionintelectual(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    @XmlTransient
    public Collection<Soporteproduccion> getSoporteproduccionCollection() {
        return soporteproduccionCollection;
    }

    public void setSoporteproduccionCollection(Collection<Soporteproduccion> soporteproduccionCollection) {
        this.soporteproduccionCollection = soporteproduccionCollection;
    }

    @XmlTransient
    public Collection<Realiza> getRealizaCollection() {
        return realizaCollection;
    }

    public void setRealizaCollection(Collection<Realiza> realizaCollection) {
        this.realizaCollection = realizaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccionintelectual)) {
            return false;
        }
        Produccionintelectual other = (Produccionintelectual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Produccionintelectual[ id=" + id + " ]";
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public CapituloLibro getCapituloLibro() {
        return capituloLibro;
    }

    public void setCapituloLibro(CapituloLibro capituloLibro) {
        this.capituloLibro = capituloLibro;
    }
    
    public String getTipoProduccion(){
       String ret;
        if(libro!=null){
            ret= "Libro";          
        }else{
            if(capituloLibro!=null){
            ret= "Capitulo Libro";          
        }else{
            if(revista!=null){
            ret= "Revista";          
        }else{
                if(conferencia!=null){
                        ret= "Conferencia";          
            }else{
                  ret= "Ninguna";          
            }
        }
        }
        }
        return ret;
    }
    public Integer getTipoProduccion2(){
       Integer ret;
        if(libro!=null){
            ret= 1;          
        }else{
            if(capituloLibro!=null){
            ret=2;          
        }else{
            if(revista!=null){
            ret=3;          
        }else{
                if(conferencia!=null){
                        ret=4;          
            }else{
                  ret= -1;          
            }
        }
        }
        }
        return ret;
    }
    public String getTituloPublicacion(){
        String ret;
        if(libro!=null){
            ret= libro.getLibroNombre();          
        }else{
            if(capituloLibro!=null){
            ret= capituloLibro.getCapLibroTitulo();          
        }else{
            if(revista!=null){
            ret= revista.getTituloPublicacion();          
        }else{
                if(conferencia!=null){
                        ret= conferencia.getTituloArticulo();          
            }else{
                  ret= "Ninguna";          
            }
        }
        }
        }
        return ret;
    }
    
}
