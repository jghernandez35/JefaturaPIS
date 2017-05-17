/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e"),
    @NamedQuery(name = "Estudio.findById", query = "SELECT e FROM Estudio e WHERE e.id = :id"),
    @NamedQuery(name = "Estudio.findByNombreEstudio", query = "SELECT e FROM Estudio e WHERE e.nombreEstudio = :nombreEstudio")})
public class Estudio implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estId")
    private Collection<Trabajosinvestigacion> trabajosinvestigacionCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ESTUDIO")
    private String nombreEstudio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estId")
    private Collection<Docente> docenteCollection;

    public Estudio() {
    }

    public Estudio(Integer id) {
        this.id = id;
    }

    public Estudio(Integer id, String nombreEstudio) {
        this.id = id;
        this.nombreEstudio = nombreEstudio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
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
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Estudio[ id=" + id + " ]";
    }
	
    @XmlTransient
    public Collection<Trabajosinvestigacion> getTrabajosinvestigacionCollection() {
        return trabajosinvestigacionCollection;
    }

    public void setTrabajosinvestigacionCollection(Collection<Trabajosinvestigacion> trabajosinvestigacionCollection) {
        this.trabajosinvestigacionCollection = trabajosinvestigacionCollection;
    }	
    
}
