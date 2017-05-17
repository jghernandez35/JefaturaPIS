/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UsuarioGB
 */
@Entity
@Table(name = "trabajosinvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajosinvestigacion.findAll", query = "SELECT t FROM Trabajosinvestigacion t")
    , @NamedQuery(name = "Trabajosinvestigacion.findById", query = "SELECT t FROM Trabajosinvestigacion t WHERE t.id = :id")})
public class Trabajosinvestigacion implements Serializable {

    @JoinColumn(name = "EST_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estudio estId;
    @JoinColumn(name = "DOC_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Docente docId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ACTOADMINISTRATIVO")
    private String actoadministrativo;
    @JoinColumn(name = "ESTUD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estudianteinvestigacion estudId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trabajosinvestigacion")
    private Soportetrabajosinvestigacion soportetrabajosinvestigacion;

    public Trabajosinvestigacion() {
    }

    public Trabajosinvestigacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActoadministrativo() {
        return actoadministrativo;
    }

    public void setActoadministrativo(String actoadministrativo) {
        this.actoadministrativo = actoadministrativo;
    }

    public Estudianteinvestigacion getEstudId() {
        return estudId;
    }

    public void setEstudId(Estudianteinvestigacion estudId) {
        this.estudId = estudId;
    }

    public Soportetrabajosinvestigacion getSoportetrabajosinvestigacion() {
        return soportetrabajosinvestigacion;
    }

    public void setSoportetrabajosinvestigacion(Soportetrabajosinvestigacion soportetrabajosinvestigacion) {
        this.soportetrabajosinvestigacion = soportetrabajosinvestigacion;
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
        if (!(object instanceof Trabajosinvestigacion)) {
            return false;
        }
        Trabajosinvestigacion other = (Trabajosinvestigacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Trabajosinvestigacion[ id=" + id + " ]";
    }

    public Estudio getEstId() {
        return estId;
    }

    public void setEstId(Estudio estId) {
        this.estId = estId;
    }

    public Docente getDocId() {
        return docId;
    }

    public void setDocId(Docente docId) {
        this.docId = docId;
    }	
    
}
