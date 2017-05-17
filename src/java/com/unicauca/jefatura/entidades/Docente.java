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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findById", query = "SELECT d FROM Docente d WHERE d.id = :id"),
    @NamedQuery(name = "Docente.findByApellidos", query = "SELECT d FROM Docente d WHERE d.apellidos = :apellidos"),
    @NamedQuery(name = "Docente.findByNombres", query = "SELECT d FROM Docente d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "Docente.findByDocumento", query = "SELECT d FROM Docente d WHERE d.documento = :documento"),
    
})
public class Docente implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
    private Collection<Trabajosinvestigacion> trabajosinvestigacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
    private Collection<Proyectosinvestigacion> proyectosinvestigacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
    private Collection<Formatoa> formatoaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOCUMENTO")
    private String documento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
    private Collection<Estadodocente> estadodocenteCollection;
    @JoinColumn(name = "EST_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estudio estId;
    @JoinColumn(name = "TIP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tipodocumento tipId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
    private Collection<Contratacion> contratacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
    private Collection<Realiza> realizaCollection;

    public Docente() {
    }

    public Docente(Integer id) {
        this.id = id;
    }

    public Docente(Integer id, String apellidos, String nombres, String documento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.documento = documento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @XmlTransient
    public Collection<Estadodocente> getEstadodocenteCollection() {
        return estadodocenteCollection;
    }

    public void setEstadodocenteCollection(Collection<Estadodocente> estadodocenteCollection) {
        this.estadodocenteCollection = estadodocenteCollection;
    }

    public Estudio getEstId() {
        return estId;
    }

    public void setEstId(Estudio estId) {
        this.estId = estId;
    }

    public Tipodocumento getTipId() {
        return tipId;
    }

    public void setTipId(Tipodocumento tipId) {
        this.tipId = tipId;
    }

    @XmlTransient
    public Collection<Contratacion> getContratacionCollection() {
        return contratacionCollection;
    }

    public void setContratacionCollection(Collection<Contratacion> contratacionCollection) {
        this.contratacionCollection = contratacionCollection;
    }

    @XmlTransient
    public Collection<Realiza> getRealizaCollection() {
        return realizaCollection;
    }

    public void setRealizaCollection(Collection<Realiza> realizaCollection) {
        this.realizaCollection = realizaCollection;
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
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Docente[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Trabajosinvestigacion> getTrabajosinvestigacionCollection() {
        return trabajosinvestigacionCollection;
    }

    public void setTrabajosinvestigacionCollection(Collection<Trabajosinvestigacion> trabajosinvestigacionCollection) {
        this.trabajosinvestigacionCollection = trabajosinvestigacionCollection;
    }

    @XmlTransient
    public Collection<Proyectosinvestigacion> getProyectosinvestigacionCollection() {
        return proyectosinvestigacionCollection;
    }

    public void setProyectosinvestigacionCollection(Collection<Proyectosinvestigacion> proyectosinvestigacionCollection) {
        this.proyectosinvestigacionCollection = proyectosinvestigacionCollection;
    }

    @XmlTransient
    public Collection<Formatoa> getFormatoaCollection() {
        return formatoaCollection;
    }

    public void setFormatoaCollection(Collection<Formatoa> formatoaCollection) {
        this.formatoaCollection = formatoaCollection;
    }    
}
