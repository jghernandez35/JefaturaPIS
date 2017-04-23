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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UsuarioGB
 */
@Entity
@Table(name = "soporteproyectoinvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soporteproyectoinvestigacion.findAll", query = "SELECT s FROM Soporteproyectoinvestigacion s")
    , @NamedQuery(name = "Soporteproyectoinvestigacion.findById", query = "SELECT s FROM Soporteproyectoinvestigacion s WHERE s.id = :id")
    , @NamedQuery(name = "Soporteproyectoinvestigacion.findByPath", query = "SELECT s FROM Soporteproyectoinvestigacion s WHERE s.path = :path")})
public class Soporteproyectoinvestigacion implements Serializable {

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
    @JoinColumn(name = "PRO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proyectosinvestigacion proId;

    public Soporteproyectoinvestigacion() {
    }

    public Soporteproyectoinvestigacion(Integer id) {
        this.id = id;
    }

    public Soporteproyectoinvestigacion(Integer id, String path) {
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

    public Proyectosinvestigacion getProId() {
        return proId;
    }

    public void setProId(Proyectosinvestigacion proId) {
        this.proId = proId;
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
        if (!(object instanceof Soporteproyectoinvestigacion)) {
            return false;
        }
        Soporteproyectoinvestigacion other = (Soporteproyectoinvestigacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Soporteproyectoinvestigacion[ id=" + id + " ]";
    }
    
}
