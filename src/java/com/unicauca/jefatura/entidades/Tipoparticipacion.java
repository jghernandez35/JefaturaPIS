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
@Table(name = "tipoparticipacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoparticipacion.findAll", query = "SELECT t FROM Tipoparticipacion t"),
    @NamedQuery(name = "Tipoparticipacion.findByIdTipoParticipacion", query = "SELECT t FROM Tipoparticipacion t WHERE t.idTipoParticipacion = :idTipoParticipacion"),
    @NamedQuery(name = "Tipoparticipacion.findByNombreTipoParticipacion", query = "SELECT t FROM Tipoparticipacion t WHERE t.nombreTipoParticipacion = :nombreTipoParticipacion")})
public class Tipoparticipacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_TipoParticipacion")
    private Integer idTipoParticipacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre_TipoParticipacion")
    private String nombreTipoParticipacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoParticipacionComision")
    private Collection<Comision> comisionCollection;

    public Tipoparticipacion() {
    }

    public Tipoparticipacion(Integer idTipoParticipacion) {
        this.idTipoParticipacion = idTipoParticipacion;
    }

    public Tipoparticipacion(Integer idTipoParticipacion, String nombreTipoParticipacion) {
        this.idTipoParticipacion = idTipoParticipacion;
        this.nombreTipoParticipacion = nombreTipoParticipacion;
    }

    public Integer getIdTipoParticipacion() {
        return idTipoParticipacion;
    }

    public void setIdTipoParticipacion(Integer idTipoParticipacion) {
        this.idTipoParticipacion = idTipoParticipacion;
    }

    public String getNombreTipoParticipacion() {
        return nombreTipoParticipacion;
    }

    public void setNombreTipoParticipacion(String nombreTipoParticipacion) {
        this.nombreTipoParticipacion = nombreTipoParticipacion;
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
        hash += (idTipoParticipacion != null ? idTipoParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoparticipacion)) {
            return false;
        }
        Tipoparticipacion other = (Tipoparticipacion) object;
        if ((this.idTipoParticipacion == null && other.idTipoParticipacion != null) || (this.idTipoParticipacion != null && !this.idTipoParticipacion.equals(other.idTipoParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Tipoparticipacion[ idTipoParticipacion=" + idTipoParticipacion + " ]";
    }
    
}
