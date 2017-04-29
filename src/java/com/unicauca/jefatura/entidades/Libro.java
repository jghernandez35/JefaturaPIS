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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByLibroId", query = "SELECT l FROM Libro l WHERE l.libroId = :libroId"),
    @NamedQuery(name = "Libro.findByLibroIsbn", query = "SELECT l FROM Libro l WHERE l.libroIsbn = :libroIsbn"),
    @NamedQuery(name = "Libro.findByLibroNombre", query = "SELECT l FROM Libro l WHERE l.libroNombre = :libroNombre"),
    @NamedQuery(name = "Libro.findByLibroEdicion", query = "SELECT l FROM Libro l WHERE l.libroEdicion = :libroEdicion"),
    @NamedQuery(name = "Libro.findByLibroEditorial", query = "SELECT l FROM Libro l WHERE l.libroEditorial = :libroEditorial")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIBRO_ID")
    private Integer libroId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LIBRO_ISBN_")
    private String libroIsbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "LIBRO_NOMBRE")
    private String libroNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIBRO_EDICION")
    private int libroEdicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LIBRO_EDITORIAL")
    private String libroEditorial;
    @JoinColumn(name = "LIBRO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produccionintelectual produccionintelectual;

    public Libro() {
    }

    public Libro(Integer libroId) {
        this.libroId = libroId;
    }

    public Libro(Integer libroId, String libroIsbn, String libroNombre, int libroEdicion, String libroEditorial) {
        this.libroId = libroId;
        this.libroIsbn = libroIsbn;
        this.libroNombre = libroNombre;
        this.libroEdicion = libroEdicion;
        this.libroEditorial = libroEditorial;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public String getLibroIsbn() {
        return libroIsbn;
    }

    public void setLibroIsbn(String libroIsbn) {
        this.libroIsbn = libroIsbn;
    }

    public String getLibroNombre() {
        return libroNombre;
    }

    public void setLibroNombre(String libroNombre) {
        this.libroNombre = libroNombre;
    }

    public int getLibroEdicion() {
        return libroEdicion;
    }

    public void setLibroEdicion(int libroEdicion) {
        this.libroEdicion = libroEdicion;
    }

    public String getLibroEditorial() {
        return libroEditorial;
    }

    public void setLibroEditorial(String libroEditorial) {
        this.libroEditorial = libroEditorial;
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
        hash += (libroId != null ? libroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.libroId == null && other.libroId != null) || (this.libroId != null && !this.libroId.equals(other.libroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.Libro[ libroId=" + libroId + " ]";
    }
    
}
