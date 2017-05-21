/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "comision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comision.findAll", query = "SELECT c FROM Comision c"),
    @NamedQuery(name = "Comision.findByIdComision", query = "SELECT c FROM Comision c WHERE c.idComision = :idComision"),
    @NamedQuery(name = "Comision.findByNumeroResolucionComision", query = "SELECT c FROM Comision c WHERE c.numeroResolucionComision = :numeroResolucionComision"),
    @NamedQuery(name = "Comision.findByNumeroActaComision", query = "SELECT c FROM Comision c WHERE c.numeroActaComision = :numeroActaComision"),
    @NamedQuery(name = "Comision.findByFechaSolicitudComision", query = "SELECT c FROM Comision c WHERE c.fechaSolicitudComision = :fechaSolicitudComision"),
    @NamedQuery(name = "Comision.findByFechaInicioComision", query = "SELECT c FROM Comision c WHERE c.fechaInicioComision = :fechaInicioComision"),
    @NamedQuery(name = "Comision.findByFechaFinComision", query = "SELECT c FROM Comision c WHERE c.fechaFinComision = :fechaFinComision"),
    @NamedQuery(name = "Comision.findByOrganizadoPorComision", query = "SELECT c FROM Comision c WHERE c.organizadoPorComision = :organizadoPorComision")})
public class Comision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Comision")
    private Integer idComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NumeroResolucion_Comision")
    private String numeroResolucionComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NumeroActa_Comision")
    private String numeroActaComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaSolicitud_Comision")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitudComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaInicio_Comision")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaFin_Comision")
    @Temporal(TemporalType.DATE)
    private Date fechaFinComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "OrganizadoPor_Comision")
    private String organizadoPorComision;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Descripcion_Comision")
    private String descripcionComision;
    @JoinColumn(name = "IdCiudad_Comision", referencedColumnName = "Id_Ciudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudadComision;
    @JoinColumn(name = "IdTipoParticipacion_Comision", referencedColumnName = "Id_TipoParticipacion")
    @ManyToOne(optional = false)
    private Tipoparticipacion idTipoParticipacionComision;
    @JoinColumn(name = "IdTipoComision_Comision", referencedColumnName = "Id_TipoComision")
    @ManyToOne(optional = false)
    private Tipocomision idTipoComisionComision;
    @JoinColumn(name = "IdEstado_Comision", referencedColumnName = "Id_Estado")
    @ManyToOne(optional = false)
    private Estadocomision idEstadoComision;
    @JoinColumn(name = "idDocente_Comision", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Docente idDocenteComision;

    public Comision() {
    }

    public Comision(Integer idComision) {
        this.idComision = idComision;
    }

    public Comision(Integer idComision, String numeroResolucionComision, String numeroActaComision, Date fechaSolicitudComision, Date fechaInicioComision, Date fechaFinComision, String organizadoPorComision, String descripcionComision) {
        this.idComision = idComision;
        this.numeroResolucionComision = numeroResolucionComision;
        this.numeroActaComision = numeroActaComision;
        this.fechaSolicitudComision = fechaSolicitudComision;
        this.fechaInicioComision = fechaInicioComision;
        this.fechaFinComision = fechaFinComision;
        this.organizadoPorComision = organizadoPorComision;
        this.descripcionComision = descripcionComision;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public String getNumeroResolucionComision() {
        return numeroResolucionComision;
    }

    public void setNumeroResolucionComision(String numeroResolucionComision) {
        this.numeroResolucionComision = numeroResolucionComision;
    }

    public String getNumeroActaComision() {
        return numeroActaComision;
    }

    public void setNumeroActaComision(String numeroActaComision) {
        this.numeroActaComision = numeroActaComision;
    }

    public Date getFechaSolicitudComision() {
        return fechaSolicitudComision;
    }

    public void setFechaSolicitudComision(Date fechaSolicitudComision) {
        this.fechaSolicitudComision = fechaSolicitudComision;
    }

    public Date getFechaInicioComision() {
        return fechaInicioComision;
    }

    public void setFechaInicioComision(Date fechaInicioComision) {
        this.fechaInicioComision = fechaInicioComision;
    }

    public Date getFechaFinComision() {
        return fechaFinComision;
    }

    public void setFechaFinComision(Date fechaFinComision) {
        this.fechaFinComision = fechaFinComision;
    }

    public String getOrganizadoPorComision() {
        return organizadoPorComision;
    }

    public void setOrganizadoPorComision(String organizadoPorComision) {
        this.organizadoPorComision = organizadoPorComision;
    }

    public String getDescripcionComision() {
        return descripcionComision;
    }

    public void setDescripcionComision(String descripcionComision) {
        this.descripcionComision = descripcionComision;
    }

    public Ciudad getIdCiudadComision() {
        return idCiudadComision;
    }

    public void setIdCiudadComision(Ciudad idCiudadComision) {
        this.idCiudadComision = idCiudadComision;
    }

    public Tipoparticipacion getIdTipoParticipacionComision() {
        return idTipoParticipacionComision;
    }

    public void setIdTipoParticipacionComision(Tipoparticipacion idTipoParticipacionComision) {
        this.idTipoParticipacionComision = idTipoParticipacionComision;
    }

    public Tipocomision getIdTipoComisionComision() {
        return idTipoComisionComision;
    }

    public void setIdTipoComisionComision(Tipocomision idTipoComisionComision) {
        this.idTipoComisionComision = idTipoComisionComision;
    }

    public Estadocomision getIdEstadoComision() {
        return idEstadoComision;
    }

    public void setIdEstadoComision(Estadocomision idEstadoComision) {
        this.idEstadoComision = idEstadoComision;
    }

    public Docente getIdDocenteComision() {
        return idDocenteComision;
    }

    public void setIdDocenteComision(Docente idDocenteComision) {
        this.idDocenteComision = idDocenteComision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComision != null ? idComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comision)) {
            return false;
        }
        Comision other = (Comision) object;
        if ((this.idComision == null && other.idComision != null) || (this.idComision != null && !this.idComision.equals(other.idComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Comision[ idComision=" + idComision + " ]";
    }
    
}
