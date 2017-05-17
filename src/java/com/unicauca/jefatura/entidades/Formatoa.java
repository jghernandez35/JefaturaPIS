/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UsuarioGB
 */
@Entity
@Table(name = "formatoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formatoa.findAll", query = "SELECT f FROM Formatoa f")
    , @NamedQuery(name = "Formatoa.findById", query = "SELECT f FROM Formatoa f WHERE f.id = :id")
    , @NamedQuery(name = "Formatoa.findByTituloTrabajo", query = "SELECT f FROM Formatoa f WHERE f.tituloTrabajo = :tituloTrabajo")
    , @NamedQuery(name = "Formatoa.findByFechaActa", query = "SELECT f FROM Formatoa f WHERE f.fechaActa = :fechaActa")
    , @NamedQuery(name = "Formatoa.findByEstudiante", query = "SELECT ep FROM Formatoa fa JOIN Estudiantepregrado ep WHERE fa.id = ep.forId")
    , @NamedQuery(name = "Formatoa.findByDocIdId", query = "SELECT f FROM Formatoa f WHERE f.docId.id = :docId")
    })               
public class Formatoa implements Serializable {

    @JoinColumn(name = "DOC_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Docente docId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forId")
    private Collection<Soporteformatoa> soporteformatoaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "formatoa")
    private Proyecto proyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forId")
    private Collection<Estudiantepregrado> estudiantepregradoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "ACTA_DEPARTAMENTO")
    private String actaDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TITULO_TRABAJO")
    private String tituloTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACTA")
    @Temporal(TemporalType.DATE)
    private Date fechaActa;

    public Formatoa() {
    }

    public Formatoa(Integer id) {
        this.id = id;
    }

    public Formatoa(Integer id, String actaDepartamento, String tituloTrabajo, Date fechaActa) {
        this.id = id;
        this.actaDepartamento = actaDepartamento;
        this.tituloTrabajo = tituloTrabajo;
        this.fechaActa = fechaActa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActaDepartamento() {
        return actaDepartamento;
    }

    public void setActaDepartamento(String actaDepartamento) {
        this.actaDepartamento = actaDepartamento;
    }

    public String getTituloTrabajo() {
        return tituloTrabajo;
    }

    public void setTituloTrabajo(String tituloTrabajo) {
        this.tituloTrabajo = tituloTrabajo;
    }

    public Date getFechaActa() {
        return fechaActa;
    }

    public void setFechaActa(Date fechaActa) {
        this.fechaActa = fechaActa;
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
        if (!(object instanceof Formatoa)) {
            return false;
        }
        Formatoa other = (Formatoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Formatoa[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Soporteformatoa> getSoporteformatoaCollection() {
        return soporteformatoaCollection;
    }

    public void setSoporteformatoaCollection(Collection<Soporteformatoa> soporteformatoaCollection) {
        this.soporteformatoaCollection = soporteformatoaCollection;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @XmlTransient
    public Collection<Estudiantepregrado> getEstudiantepregradoCollection() {
        return estudiantepregradoCollection;
    }

    public void setEstudiantepregradoCollection(Collection<Estudiantepregrado> estudiantepregradoCollection) {
        this.estudiantepregradoCollection = estudiantepregradoCollection;
    }
    //fabian
    public String getNombreEstudiantes(){
        String s="";
       
        for(Estudiantepregrado est : estudiantepregradoCollection){
            s+=est.getCodigo()+" - "+est.getNombreEstudiante()+" / ";
        }
        return s;
    }
    public Docente getDocId() {
        return docId;
    }

    public void setDocId(Docente docId) {
        this.docId = docId;
    }
    
}
