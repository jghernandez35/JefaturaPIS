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
@Table(name = "informecomision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informecomision.findAll", query = "SELECT i FROM Informecomision i"),
    @NamedQuery(name = "Informecomision.findByIdInformeComision", query = "SELECT i FROM Informecomision i WHERE i.idInformeComision = :idInformeComision"),
    @NamedQuery(name = "Informecomision.findByRutaInformeComision", query = "SELECT i FROM Informecomision i WHERE i.rutaInformeComision = :rutaInformeComision"),
    @NamedQuery(name = "Informecomision.findByNombreInformeComision", query = "SELECT i FROM Informecomision i WHERE i.nombreInformeComision = :nombreInformeComision")})
public class Informecomision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_InformeComision")
    private Integer idInformeComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Ruta_InformeComision")
    private String rutaInformeComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Nombre_InformeComision")
    private String nombreInformeComision;
    @JoinColumn(name = "informeComision_idcomision", referencedColumnName = "Id_Comision")
    @ManyToOne(optional = false)
    private Comision informeComisionidcomision;

    public Informecomision() {
    }

    public Informecomision(Integer idInformeComision) {
        this.idInformeComision = idInformeComision;
    }

    public Informecomision(Integer idInformeComision, String rutaInformeComision, String nombreInformeComision) {
        this.idInformeComision = idInformeComision;
        this.rutaInformeComision = rutaInformeComision;
        this.nombreInformeComision = nombreInformeComision;
    }

    public Integer getIdInformeComision() {
        return idInformeComision;
    }

    public void setIdInformeComision(Integer idInformeComision) {
        this.idInformeComision = idInformeComision;
    }

    public String getRutaInformeComision() {
        return rutaInformeComision;
    }

    public void setRutaInformeComision(String rutaInformeComision) {
        this.rutaInformeComision = rutaInformeComision;
    }

    public String getNombreInformeComision() {
        return nombreInformeComision;
    }

    public void setNombreInformeComision(String nombreInformeComision) {
        this.nombreInformeComision = nombreInformeComision;
    }

    public Comision getInformeComisionidcomision() {
        return informeComisionidcomision;
    }

    public void setInformeComisionidcomision(Comision informeComisionidcomision) {
        this.informeComisionidcomision = informeComisionidcomision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformeComision != null ? idInformeComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informecomision)) {
            return false;
        }
        Informecomision other = (Informecomision) object;
        if ((this.idInformeComision == null && other.idInformeComision != null) || (this.idInformeComision != null && !this.idInformeComision.equals(other.idInformeComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Informecomision[ idInformeComision=" + idInformeComision + " ]";
    }
    
}
