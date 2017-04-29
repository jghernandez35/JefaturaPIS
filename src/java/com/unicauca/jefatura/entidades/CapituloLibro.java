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
@Table(name = "capitulo_libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapituloLibro.findAll", query = "SELECT c FROM CapituloLibro c"),
    @NamedQuery(name = "CapituloLibro.findByCapLibroId", query = "SELECT c FROM CapituloLibro c WHERE c.capLibroId = :capLibroId"),
    @NamedQuery(name = "CapituloLibro.findByCapLibroTitulo", query = "SELECT c FROM CapituloLibro c WHERE c.capLibroTitulo = :capLibroTitulo"),
    @NamedQuery(name = "CapituloLibro.findByCapLibroNumero", query = "SELECT c FROM CapituloLibro c WHERE c.capLibroNumero = :capLibroNumero"),
    @NamedQuery(name = "CapituloLibro.findByLibroIsbn", query = "SELECT c FROM CapituloLibro c WHERE c.libroIsbn = :libroIsbn"),
    @NamedQuery(name = "CapituloLibro.findByLibroNombre", query = "SELECT c FROM CapituloLibro c WHERE c.libroNombre = :libroNombre"),
    @NamedQuery(name = "CapituloLibro.findByLibroEdicion", query = "SELECT c FROM CapituloLibro c WHERE c.libroEdicion = :libroEdicion"),
    @NamedQuery(name = "CapituloLibro.findByLibroEditorial", query = "SELECT c FROM CapituloLibro c WHERE c.libroEditorial = :libroEditorial")})
public class CapituloLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAP_LIBRO_ID")
    private Integer capLibroId;
    @Basic(optional = false)
    @NotNull    
    @Size(min = 1, max = 150)
    @Column(name = "CAP_LIBRO_TITULO")
        private String capLibroTitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAP_LIBRO_NUMERO")
    private int capLibroNumero;
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
    @JoinColumn(name = "CAP_LIBRO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produccionintelectual produccionintelectual;

    public CapituloLibro() {
    }

    public CapituloLibro(Integer capLibroId) {
        this.capLibroId = capLibroId;
    }

    public CapituloLibro(Integer capLibroId, String capLibroTitulo, int capLibroNumero, String libroIsbn, String libroNombre, int libroEdicion, String libroEditorial) {
        this.capLibroId = capLibroId;
        this.capLibroTitulo = capLibroTitulo;
        this.capLibroNumero = capLibroNumero;
        this.libroIsbn = libroIsbn;
        this.libroNombre = libroNombre;
        this.libroEdicion = libroEdicion;
        this.libroEditorial = libroEditorial;
    }

    public Integer getCapLibroId() {
        return capLibroId;
    }

    public void setCapLibroId(Integer capLibroId) {
        this.capLibroId = capLibroId;
    }

    public String getCapLibroTitulo() {
        return capLibroTitulo;
    }

    public void setCapLibroTitulo(String capLibroTitulo) {
        this.capLibroTitulo = capLibroTitulo;
    }

    public int getCapLibroNumero() {
        return capLibroNumero;
    }

    public void setCapLibroNumero(int capLibroNumero) {
        this.capLibroNumero = capLibroNumero;
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
        hash += (capLibroId != null ? capLibroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapituloLibro)) {
            return false;
        }
        CapituloLibro other = (CapituloLibro) object;
        if ((this.capLibroId == null && other.capLibroId != null) || (this.capLibroId != null && !this.capLibroId.equals(other.capLibroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicauca.jefatura.entidades.CapituloLibro[ capLibroId=" + capLibroId + " ]";
    }
    
}
