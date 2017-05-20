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
 * @author David
 */
@Entity
@Table(name = "soportecomision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soportecomision.findAll", query = "SELECT s FROM Soportecomision s"),
    @NamedQuery(name = "Soportecomision.findByIdSoporteComision", query = "SELECT s FROM Soportecomision s WHERE s.idSoporteComision = :idSoporteComision"),
    @NamedQuery(name = "Soportecomision.findByRutaSoporteComision", query = "SELECT s FROM Soportecomision s WHERE s.rutaSoporteComision = :rutaSoporteComision"),
    @NamedQuery(name = "Soportecomision.findByNombreSoporteComision", query = "SELECT s FROM Soportecomision s WHERE s.nombreSoporteComision = :nombreSoporteComision")})
public class Soportecomision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_SoporteComision")
    private Integer idSoporteComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Ruta_SoporteComision")
    private String rutaSoporteComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Nombre_SoporteComision")
    private String nombreSoporteComision;
    @JoinColumn(name = "IdComision_SoporteComision", referencedColumnName = "Id_Comision")
    @ManyToOne(optional = false)
    private Comision idComisionSoporteComision;

    public Soportecomision() {
    }

    public Soportecomision(Integer idSoporteComision) {
        this.idSoporteComision = idSoporteComision;
    }

    public Soportecomision(Integer idSoporteComision, String rutaSoporteComision, String nombreSoporteComision) {
        this.idSoporteComision = idSoporteComision;
        this.rutaSoporteComision = rutaSoporteComision;
        this.nombreSoporteComision = nombreSoporteComision;
    }

    public Integer getIdSoporteComision() {
        return idSoporteComision;
    }

    public void setIdSoporteComision(Integer idSoporteComision) {
        this.idSoporteComision = idSoporteComision;
    }

    public String getRutaSoporteComision() {
        return rutaSoporteComision;
    }

    public void setRutaSoporteComision(String rutaSoporteComision) {
        this.rutaSoporteComision = rutaSoporteComision;
    }

    public String getNombreSoporteComision() {
        return nombreSoporteComision;
    }

    public void setNombreSoporteComision(String nombreSoporteComision) {
        this.nombreSoporteComision = nombreSoporteComision;
    }

    public Comision getIdComisionSoporteComision() {
        return idComisionSoporteComision;
    }

    public void setIdComisionSoporteComision(Comision idComisionSoporteComision) {
        this.idComisionSoporteComision = idComisionSoporteComision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoporteComision != null ? idSoporteComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soportecomision)) {
            return false;
        }
        Soportecomision other = (Soportecomision) object;
        if ((this.idSoporteComision == null && other.idSoporteComision != null) || (this.idSoporteComision != null && !this.idSoporteComision.equals(other.idSoporteComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Soportecomision[ idSoporteComision=" + idSoporteComision + " ]";
    }
    
}
