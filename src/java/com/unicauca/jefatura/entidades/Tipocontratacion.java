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
@Table(name = "tipocontratacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocontratacion.findAll", query = "SELECT t FROM Tipocontratacion t"),
    @NamedQuery(name = "Tipocontratacion.findById", query = "SELECT t FROM Tipocontratacion t WHERE t.id = :id"),
    @NamedQuery(name = "Tipocontratacion.findByTipo", query = "SELECT t FROM Tipocontratacion t WHERE t.tipo = :tipo")})
public class Tipocontratacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipId")
    private Collection<Contratacion> contratacionCollection;

    public Tipocontratacion() {
    }

    public Tipocontratacion(Integer id) {
        this.id = id;
    }

    public Tipocontratacion(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Tipocontratacion)) {
            return false;
        }
        Tipocontratacion other = (Tipocontratacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Tipocontratacion[ id=" + id + " ]";
    }
    
}
