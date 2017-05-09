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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fabia
 */
@Entity
@Table(name = "conferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferencia.findAll", query = "SELECT c FROM Conferencia c"),
    @NamedQuery(name = "Conferencia.findByConferenciaId", query = "SELECT c FROM Conferencia c WHERE c.conferenciaId = :conferenciaId"),
    @NamedQuery(name = "Conferencia.findByConferenciaNombre", query = "SELECT c FROM Conferencia c WHERE c.conferenciaNombre = :conferenciaNombre"),
    @NamedQuery(name = "Conferencia.findByConferenciaUbicacionTipo", query = "SELECT c FROM Conferencia c WHERE c.conferenciaUbicacionTipo = :conferenciaUbicacionTipo"),
    @NamedQuery(name = "Conferencia.findByConferenciaUbicacion", query = "SELECT c FROM Conferencia c WHERE c.conferenciaUbicacion = :conferenciaUbicacion"),
    @NamedQuery(name = "Conferencia.findByTituloArticulo", query = "SELECT c FROM Conferencia c WHERE c.tituloArticulo = :tituloArticulo")})
public class Conferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFERENCIA_ID")
    private Integer conferenciaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CONFERENCIA_NOMBRE")
    private String conferenciaNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFERENCIA_UBICACION_TIPO")
    private int conferenciaUbicacionTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CONFERENCIA_UBICACION")
    private String conferenciaUbicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TITULO_ARTICULO")
    private String tituloArticulo;
    @JoinColumn(name = "CONFERENCIA_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produccionintelectual produccionintelectual;

    public Conferencia() {
    }

    public Conferencia(Integer conferenciaId) {
        this.conferenciaId = conferenciaId;
    }

    public Conferencia(Integer conferenciaId, String conferenciaNombre, int conferenciaUbicacionTipo, String conferenciaUbicacion, String tituloArticulo) {
        this.conferenciaId = conferenciaId;
        this.conferenciaNombre = conferenciaNombre;
        this.conferenciaUbicacionTipo = conferenciaUbicacionTipo;
        this.conferenciaUbicacion = conferenciaUbicacion;
        this.tituloArticulo = tituloArticulo;
    }

    public Integer getConferenciaId() {
        return conferenciaId;
    }

    public void setConferenciaId(Integer conferenciaId) {
        this.conferenciaId = conferenciaId;
    }

    public String getConferenciaNombre() {
        return conferenciaNombre;
    }

    public void setConferenciaNombre(String conferenciaNombre) {
        this.conferenciaNombre = conferenciaNombre;
    }

    public int getConferenciaUbicacionTipo() {
        return conferenciaUbicacionTipo;
    }

    public void setConferenciaUbicacionTipo(int conferenciaUbicacionTipo) {
        this.conferenciaUbicacionTipo = conferenciaUbicacionTipo;
    }

    public String getConferenciaUbicacion() {
        return conferenciaUbicacion;
    }

    public void setConferenciaUbicacion(String conferenciaUbicacion) {
        this.conferenciaUbicacion = conferenciaUbicacion;
    }

    public String getTituloArticulo() {
        return tituloArticulo;
    }
    
   
    public void setTituloArticulo(String tituloArticulo) {
        this.tituloArticulo = tituloArticulo;
    }

    public Produccionintelectual getProduccionintelectual() {
        return produccionintelectual;
    }

    public void setProduccionintelectual(Produccionintelectual produccionintelectual) {
        this.produccionintelectual = produccionintelectual;
    }
    
     public String conferenciaUbicacionTipo(){
        if(conferenciaUbicacionTipo==0){
            return "Nacional";
        }else{
             return "Internacional";
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conferenciaId != null ? conferenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conferencia)) {
            return false;
        }
        Conferencia other = (Conferencia) object;
        if ((this.conferenciaId == null && other.conferenciaId != null) || (this.conferenciaId != null && !this.conferenciaId.equals(other.conferenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Conferencia[ conferenciaId=" + conferenciaId + " ]";
    }
    
}
