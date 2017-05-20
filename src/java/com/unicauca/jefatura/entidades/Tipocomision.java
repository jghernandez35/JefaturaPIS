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
 * @author David
 */
@Entity
@Table(name = "tipocomision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocomision.findAll", query = "SELECT t FROM Tipocomision t"),
    @NamedQuery(name = "Tipocomision.findByIdTipoComision", query = "SELECT t FROM Tipocomision t WHERE t.idTipoComision = :idTipoComision"),
    @NamedQuery(name = "Tipocomision.findByNombreTipoComision", query = "SELECT t FROM Tipocomision t WHERE t.nombreTipoComision = :nombreTipoComision")})
public class Tipocomision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_TipoComision")
    private Integer idTipoComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre_TipoComision")
    private String nombreTipoComision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoComisionComision")
    private Collection<Comision> comisionCollection;

    public Tipocomision() {
    }

    public Tipocomision(Integer idTipoComision) {
        this.idTipoComision = idTipoComision;
    }

    public Tipocomision(Integer idTipoComision, String nombreTipoComision) {
        this.idTipoComision = idTipoComision;
        this.nombreTipoComision = nombreTipoComision;
    }

    public Integer getIdTipoComision() {
        return idTipoComision;
    }

    public void setIdTipoComision(Integer idTipoComision) {
        this.idTipoComision = idTipoComision;
    }

    public String getNombreTipoComision() {
        return nombreTipoComision;
    }

    public void setNombreTipoComision(String nombreTipoComision) {
        this.nombreTipoComision = nombreTipoComision;
    }

    @XmlTransient
    public Collection<Comision> getComisionCollection() {
        return comisionCollection;
    }

    public void setComisionCollection(Collection<Comision> comisionCollection) {
        this.comisionCollection = comisionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoComision != null ? idTipoComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocomision)) {
            return false;
        }
        Tipocomision other = (Tipocomision) object;
        if ((this.idTipoComision == null && other.idTipoComision != null) || (this.idTipoComision != null && !this.idTipoComision.equals(other.idTipoComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Tipocomision[ idTipoComision=" + idTipoComision + " ]";
    }
    
}
