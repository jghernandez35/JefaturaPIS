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
@Table(name = "dedicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dedicacion.findAll", query = "SELECT d FROM Dedicacion d"),
    @NamedQuery(name = "Dedicacion.findById", query = "SELECT d FROM Dedicacion d WHERE d.id = :id"),
    @NamedQuery(name = "Dedicacion.findByDedicacion", query = "SELECT d FROM Dedicacion d WHERE d.dedicacion = :dedicacion")})
public class Dedicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DEDICACION")
    private String dedicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dedId")
    private Collection<Contratacion> contratacionCollection;

    public Dedicacion() {
    }

    public Dedicacion(Integer id) {
        this.id = id;
    }

    public Dedicacion(Integer id, String dedicacion) {
        this.id = id;
        this.dedicacion = dedicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    @XmlTransient
    public Collection<Contratacion> getContratacionCollection() {
        return contratacionCollection;
    }

    public void setContratacionCollection(Collection<Contratacion> contratacionCollection) {
        this.contratacionCollection = contratacionCollection;
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
        if (!(object instanceof Dedicacion)) {
            return false;
        }
        Dedicacion other = (Dedicacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Dedicacion[ id=" + id + " ]";
    }
    
}
