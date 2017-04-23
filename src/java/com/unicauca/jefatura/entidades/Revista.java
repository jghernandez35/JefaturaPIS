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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "revista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revista.findAll", query = "SELECT r FROM Revista r"),
    @NamedQuery(name = "Revista.findById", query = "SELECT r FROM Revista r WHERE r.id = :id"),
    @NamedQuery(name = "Revista.findByNombreRevista", query = "SELECT r FROM Revista r WHERE r.nombreRevista = :nombreRevista"),
    @NamedQuery(name = "Revista.findByNumeroEdicion", query = "SELECT r FROM Revista r WHERE r.numeroEdicion = :numeroEdicion"),
    @NamedQuery(name = "Revista.findByTituloPublicacion", query = "SELECT r FROM Revista r WHERE r.tituloPublicacion = :tituloPublicacion")})
public class Revista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE_REVISTA")
    private String nombreRevista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_EDICION")
    private int numeroEdicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TITULO_PUBLICACION")
    private String tituloPublicacion;
    @JoinColumn(name = "CLA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Clasificacion claId;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produccionintelectual produccionintelectual;

    public Revista() {
    }

    public Revista(Integer id) {
        this.id = id;
    }

    public Revista(Integer id, String nombreRevista, int numeroEdicion, String tituloPublicacion) {
        this.id = id;
        this.nombreRevista = nombreRevista;
        this.numeroEdicion = numeroEdicion;
        this.tituloPublicacion = tituloPublicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    public Clasificacion getClaId() {
        return claId;
    }

    public void setClaId(Clasificacion claId) {
        this.claId = claId;
    }

    public Produccionintelectual getProduccionintelectual() {
        return produccionintelectual;
    }

    public void setProduccionintelectual(Produccionintelectual produccionintelectual) {
        this.produccionintelectual = produccionintelectual;
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
        if (!(object instanceof Revista)) {
            return false;
        }
        Revista other = (Revista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Revista[ id=" + id + " ]";
    }
    
}
