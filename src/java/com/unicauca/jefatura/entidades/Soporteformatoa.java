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
 * @author UsuarioGB
 */
@Entity
@Table(name = "soporteformatoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soporteformatoa.findAll", query = "SELECT s FROM Soporteformatoa s")
    , @NamedQuery(name = "Soporteformatoa.findById", query = "SELECT s FROM Soporteformatoa s WHERE s.id = :id")
    , @NamedQuery(name = "Soporteformatoa.findByPath", query = "SELECT s FROM Soporteformatoa s WHERE s.path = :path")})
public class Soporteformatoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PATH")
    private String path;
    @JoinColumn(name = "FOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Formatoa forId;

    public Soporteformatoa() {
    }

    public Soporteformatoa(Integer id) {
        this.id = id;
    }

    public Soporteformatoa(Integer id, String path) {
        this.id = id;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Formatoa getForId() {
        return forId;
    }

    public void setForId(Formatoa forId) {
        this.forId = forId;
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
        if (!(object instanceof Soporteformatoa)) {
            return false;
        }
        Soporteformatoa other = (Soporteformatoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Soporteformatoa[ id=" + id + " ]";
    }
    
}
