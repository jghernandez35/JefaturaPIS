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
import javax.persistence.Lob;
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
 * @author UsuarioGB
 */
@Entity
@Table(name = "estudianteinvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudianteinvestigacion.findAll", query = "SELECT e FROM Estudianteinvestigacion e")
    , @NamedQuery(name = "Estudianteinvestigacion.findById", query = "SELECT e FROM Estudianteinvestigacion e WHERE e.id = :id")
    , @NamedQuery(name = "Estudianteinvestigacion.findByCodigo", query = "SELECT e FROM Estudianteinvestigacion e WHERE e.codigo = :codigo")})
public class Estudianteinvestigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "NOMBRE_ESTUDIANTE")
    private String nombreEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private int codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudId")
    private Collection<Trabajosinvestigacion> trabajosinvestigacionCollection;

    public Estudianteinvestigacion() {
    }

    public Estudianteinvestigacion(Integer id) {
        this.id = id;
    }

    public Estudianteinvestigacion(Integer id, String nombreEstudiante, int codigo) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Trabajosinvestigacion> getTrabajosinvestigacionCollection() {
        return trabajosinvestigacionCollection;
    }

    public void setTrabajosinvestigacionCollection(Collection<Trabajosinvestigacion> trabajosinvestigacionCollection) {
        this.trabajosinvestigacionCollection = trabajosinvestigacionCollection;
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
        if (!(object instanceof Estudianteinvestigacion)) {
            return false;
        }
        Estudianteinvestigacion other = (Estudianteinvestigacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Estudianteinvestigacion[ id=" + id + " ]";
    }
    
}
