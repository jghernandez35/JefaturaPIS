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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "contratacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratacion.findAll", query = "SELECT c FROM Contratacion c"),
    @NamedQuery(name = "Contratacion.findById", query = "SELECT c FROM Contratacion c WHERE c.id = :id"),
    @NamedQuery(name = "Contratacion.findByIdDocente", query = "SELECT c FROM Contratacion c WHERE c.docId.id = :docId"),
    @NamedQuery(name = "Contratacion.findByFechaInicio", query = "SELECT c FROM Contratacion c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Contratacion.findByFechaFin", query = "SELECT c FROM Contratacion c WHERE c.fechaFin = :fechaFin")})
public class Contratacion implements Serializable {

    @JoinColumn(name = "CAT_CON_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categoriacontratacion catConId;

    
   
    @JoinColumn(name = "DEP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Departamento depId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conId")
    private Collection<Soportecontratacion> soportecontratacionCollection;
    @JoinColumn(name = "DED_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Dedicacion dedId;
    @JoinColumn(name = "DOC_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Docente docId;
    
    

    public Contratacion() {
    }

    public Contratacion(Integer id) {
        this.id = id;
    }

    public Contratacion(Integer id, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Collection<Soportecontratacion> getSoportecontratacionCollection() {
        return soportecontratacionCollection;
    }

    public void setSoportecontratacionCollection(Collection<Soportecontratacion> soportecontratacionCollection) {
        this.soportecontratacionCollection = soportecontratacionCollection;
    }

    public Dedicacion getDedId() {
        return dedId;
    }

    public void setDedId(Dedicacion dedId) {
        this.dedId = dedId;
    }

    public Docente getDocId() {
        return docId;
    }

    public void setDocId(Docente docId) {
        this.docId = docId;
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
        if (!(object instanceof Contratacion)) {
            return false;
        }
        Contratacion other = (Contratacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Contratacion[ id=" + id + " ]";
    }

  

    public Departamento getDepId() {
        return depId;
    }

    public void setDepId(Departamento depId) {
        this.depId = depId;
    }

    public Categoriacontratacion getCatConId() {
        return catConId;
    }

    public void setCatConId(Categoriacontratacion catConId) {
        this.catConId = catConId;
    }
    
}
