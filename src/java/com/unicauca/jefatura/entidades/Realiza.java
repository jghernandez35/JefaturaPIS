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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "realiza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Realiza.findAll", query = "SELECT r FROM Realiza r"),
    @NamedQuery(name = "Realiza.findById", query = "SELECT r FROM Realiza r WHERE r.id = :id"),
    @NamedQuery(name = "Realiza.findByFecha", query = "SELECT r FROM Realiza r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Realiza.findByDocId", query = "SELECT r FROM Realiza r WHERE r.docId.documento = :docId")})
public class Realiza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "DOC_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Docente docId;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produccionintelectual proId;

    public Realiza() {
    }

    public Realiza(Integer id) {
        this.id = id;
    }

    public Realiza(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Docente getDocId() {
        return docId;
    }

    public void setDocId(Docente docId) {
        this.docId = docId;
    }

    public Produccionintelectual getProId() {
        return proId;
    }

    public void setProId(Produccionintelectual proId) {
        this.proId = proId;
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
        if (!(object instanceof Realiza)) {
            return false;
        }
        Realiza other = (Realiza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Realiza[ id=" + id + " ]";
    }
    
}
