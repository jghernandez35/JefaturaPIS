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
 * @author usuario
 */
@Entity
@Table(name = "soporteproduccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soporteproduccion.findAll", query = "SELECT s FROM Soporteproduccion s"),
    @NamedQuery(name = "Soporteproduccion.findById", query = "SELECT s FROM Soporteproduccion s WHERE s.id = :id"),
    @NamedQuery(name = "Soporteproduccion.findByRuta", query = "SELECT s FROM Soporteproduccion s WHERE s.ruta = :ruta")})
public class Soporteproduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RUTA")
    private String ruta;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produccionintelectual proId;

    public Soporteproduccion() {
    }

    public Soporteproduccion(Integer id) {
        this.id = id;
    }

    public Soporteproduccion(Integer id, String ruta) {
        this.id = id;
        this.ruta = ruta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Produccionintelectual getProId() {
        return proId;
    }

    public void setProId(Produccionintelectual proId) {
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
        if (!(object instanceof Soporteproduccion)) {
            return false;
        }
        Soporteproduccion other = (Soporteproduccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Soporteproduccion[ id=" + id + " ]";
    }
    
}
