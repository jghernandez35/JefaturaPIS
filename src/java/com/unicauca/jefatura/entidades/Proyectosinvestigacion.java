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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "proyectosinvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectosinvestigacion.findAll", query = "SELECT p FROM Proyectosinvestigacion p")
    , @NamedQuery(name = "Proyectosinvestigacion.findById", query = "SELECT p FROM Proyectosinvestigacion p WHERE p.id = :id")
    , @NamedQuery(name = "Proyectosinvestigacion.findByVri", query = "SELECT p FROM Proyectosinvestigacion p WHERE p.vri = :vri")
    , @NamedQuery(name = "Proyectosinvestigacion.findByFechaInicio", query = "SELECT p FROM Proyectosinvestigacion p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Proyectosinvestigacion.findByFechaFin", query = "SELECT p FROM Proyectosinvestigacion p WHERE p.fechaFin = :fechaFin")})
public class Proyectosinvestigacion implements Serializable {

    @JoinColumn(name = "DOC_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Docente docId;
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 40)
    @Column(name = "VRI")
    private String vri;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Soporteproyectoinvestigacion> soporteproyectoinvestigacionCollection;

    public Proyectosinvestigacion() {
    }

    public Proyectosinvestigacion(Integer id) {
        this.id = id;
    }

    public Proyectosinvestigacion(Integer id, Date fechaInicio, Date fechaFin) {
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

    public String getVri() {
        return vri;
    }

    public void setVri(String vri) {
        this.vri = vri;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public Collection<Soporteproyectoinvestigacion> getSoporteproyectoinvestigacionCollection() {
        return soporteproyectoinvestigacionCollection;
    }

    public void setSoporteproyectoinvestigacionCollection(Collection<Soporteproyectoinvestigacion> soporteproyectoinvestigacionCollection) {
        this.soporteproyectoinvestigacionCollection = soporteproyectoinvestigacionCollection;
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
        if (!(object instanceof Proyectosinvestigacion)) {
            return false;
        }
        Proyectosinvestigacion other = (Proyectosinvestigacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Proyectosinvestigacion[ id=" + id + " ]";
    }

    public Docente getDocId() {
        return docId;
    }

    public void setDocId(Docente docId) {
        this.docId = docId;
    }
    
}
