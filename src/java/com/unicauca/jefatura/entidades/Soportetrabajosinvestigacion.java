/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UsuarioGB
 */
@Entity
@Table(name = "soportetrabajosinvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soportetrabajosinvestigacion.findAll", query = "SELECT s FROM Soportetrabajosinvestigacion s")
    , @NamedQuery(name = "Soportetrabajosinvestigacion.findById", query = "SELECT s FROM Soportetrabajosinvestigacion s WHERE s.id = :id")
    , @NamedQuery(name = "Soportetrabajosinvestigacion.findByPath", query = "SELECT s FROM Soportetrabajosinvestigacion s WHERE s.path = :path")})
public class Soportetrabajosinvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PATH")
    private String path;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Trabajosinvestigacion trabajosinvestigacion;

    public Soportetrabajosinvestigacion() {
    }

    public Soportetrabajosinvestigacion(Integer id) {
        this.id = id;
    }

    public Soportetrabajosinvestigacion(Integer id, String path) {
        this.id = id;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Trabajosinvestigacion getTrabajosinvestigacion() {
        return trabajosinvestigacion;
    }

    public void setTrabajosinvestigacion(Trabajosinvestigacion trabajosinvestigacion) {
        this.trabajosinvestigacion = trabajosinvestigacion;
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
        if (!(object instanceof Soportetrabajosinvestigacion)) {
            return false;
        }
        Soportetrabajosinvestigacion other = (Soportetrabajosinvestigacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Soportetrabajosinvestigacion[ id=" + id + " ]";
    }
    
}
