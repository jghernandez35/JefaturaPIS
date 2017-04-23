/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "cargarFormulariosController")
@SessionScoped
public class CargarFormularioController implements Serializable {

    private String ruta;
    public String getRuta() {
        return ruta;
    }

    public CargarFormularioController() {
          this.ruta="/index.xhtml";
    }

    public void cargarGestionDocente() {
        this.ruta = "/Jefe/docente/List.xhtml";
    }
    
    public void cargarGestionContratacion() {
        this.ruta = "/Jefe/contratacion/List.xhtml";
    }
    
    public void cargarVerDocente() {
        this.ruta = "/Jefe/docente/View.xhtml";
    }
    public void cargarVerContratacion() {
        this.ruta = "/Jefe/contratacion/View.xhtml";
    }
    
    
    public void cargarCrearDocente() {
        this.ruta = "/Jefe/docente/Create.xhtml";
    }
    
    public void cargarCrearContratacion() {
        this.ruta = "/Jefe/contratacion/Create.xhtml";
    }
    
    public void cargarModificarDocente() {
        this.ruta = "/Jefe/docente/Edit.xhtml";
    }
    
    public void cargarModificarContratacion() {
        this.ruta = "/Jefe/contratacion/Edit.xhtml";
    }
     
    
    
    public void cargarCrearRevista() {
        this.ruta = "/Jefe/revista/Create.xhtml";
    }
     public void cargarModificarRevista() {
        this.ruta = "/Jefe/revista/Edit.xhtml";
    }
      public void cargarVerRevista() {
        this.ruta = "/Jefe/revista/View.xhtml";
    }
    
      public void cargarGestionRevista() {
        this.ruta = "/Jefe/revista/List.xhtml";
    }
      
      public void cargarGestionProduccion(){
          this.ruta = "/Jefe/realiza/List.xhtml";
      }
      
         public void cargarVerRealiza() {
        this.ruta = "/Jefe/realiza/View.xhtml";
    }
            public void cargarVerRevistasDocente(){
                  this.ruta = "/Jefe/realiza/List_Docente.xhtml";
            }
                    
    
    


}
