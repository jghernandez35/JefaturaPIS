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

	//DOCENTE CONTRATACION - JOSE RIVERA
    public CargarFormularioController() {
        this.ruta = "/index.xhtml";
    }

    public void cargarGestionDocente() {
        this.ruta = "/Jefe/docente/List.xhtml";
    }
    
    public void  cargarGestionContratacionDocentes() {
        this.ruta = "/Jefe/contratacion/List_Docente.xhtml";
    }

    public void  cargarGestionContratacionDocente() {
        this.ruta = "/Jefe/contratacion/List_Docente_Contratacion.xhtml";
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
    
    public void cargarVerContratacionDocente() {
        this.ruta = "/Jefe/contratacion/View_Docente.xhtml";
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

    public void cargarModificarContratacionDocente() {
        this.ruta = "/Jefe/contratacion/Edit_Docente.xhtml";
    }
    
    public void cargarModificarContratacion() {
        this.ruta = "/Jefe/contratacion/Edit.xhtml";
    }
	//DOCENTE CONTRATACION - JOSE RIVERA
	//PRODUCCIÓN INTELECTUAL FABIAN MUNOZ
    public void cargarModificarRevista() {
        this.ruta = "/Jefe/produccionIntelectual/revista/Edit.xhtml";
    }

    public void cargarGestionRevista() {
        this.ruta = "/Jefe/produccionIntelectual/revista/List.xhtml";
    }

    public void cargarGestionProduccion() {
        this.ruta = "/Jefe/produccionIntelectual/realiza/List.xhtml";
    }

    public void cargarVerRealiza() {
        this.ruta = "/Jefe/produccionIntelectual/realiza/View.xhtml";
    }

    public void cargarVerRevistasDocente() {
        this.ruta = "/Jefe/produccionIntelectual/revista/List_Docente.xhtml";
    }

    public void cargarVerConferenciasDocente() {
        this.ruta = "/Jefe/produccionIntelectual/conferencia/List_Docente.xhtml";
    }

    public void cargarVerLibrosDocente() {
        this.ruta = "/Jefe/produccionIntelectual/libro/List_Docente.xhtml";
    }

    public void cargarVerCapLibrosDocente() {
        this.ruta = "/Jefe/produccionIntelectual/capitulo_libro/List_Docente.xhtml";
    }

    public void cargarVerRevista(Integer opc) {
        if (opc == 0) {
            this.ruta = "/Jefe/produccionIntelectual/revista/View_Docente.xhtml";
        } else {
            this.ruta = "/Jefe/produccionIntelectual/revista/View.xhtml";
        }
    }

    public void cargarVerLibro(Integer opc) {
        if (opc == 0) {
            this.ruta = "/Jefe/produccionIntelectual/libro/View_Docente.xhtml";
        } else {
            this.ruta = "/Jefe/produccionIntelectual/libro/View.xhtml";
        }
    }

    public void cargarVerCapituloLibro(Integer opc) {
        if (opc == 0) {
            this.ruta = "/Jefe/produccionIntelectual/capitulo_libro/View_Docente.xhtml";
        } else {
            this.ruta = "/Jefe/produccionIntelectual/capitulo_libro/View.xhtml";
        }
    }

    public void cargarVerConferencia(Integer opc) {
        if (opc == 0) {
            this.ruta = "/Jefe/produccionIntelectual/conferencia/View_Docente.xhtml";
        } else {
            this.ruta = "/Jefe/produccionIntelectual/conferencia/View.xhtml";
        }
    }

    public void cargarCrearRevista() {
        this.ruta = "/Jefe/produccionIntelectual/revista/Create.xhtml";
    }

    public void cargarCrearLibro() {
        this.ruta = "/Jefe/produccionIntelectual/libro/Create.xhtml";
    }

    public void cargarCrearCapituloLibro() {
        this.ruta = "/Jefe/produccionIntelectual/capitulo_libro/Create.xhtml";
    }

    public void cargarCrearConferencia() {
        this.ruta = "/Jefe/produccionIntelectual/conferencia/Create.xhtml";
    }
	//PRODUCCIÓN INTELECTUAL FABIAN MUNOZ
    //GESTION DE PROYECTOS JOSE HERNANDEZ  
    
    public void cargarGestionProyecto() {
        this.ruta = "/Jefe/proyectosdirigidos/proyecto/List.xhtml";
    }   
	
    public void cargarVerProyecto() {
        this.ruta = "/Jefe/proyecto/View.xhtml";
    }
	
    public void cargarModificarProyecto() {
        this.ruta = "/Jefe/proyecto/Edit.xhtml";
    }
	
    public void cargarCrearProyecto() {
        this.ruta = "/Jefe/proyectosdirigidos/proyecto/Create.xhtml";
    }
    
    public void cargarGestionFormatoa() {     
        this.ruta = "/Jefe/proyectosdirigidos/formatoa/List.xhtml";
    }
	
    public void cargarVerFormatoa() {
        this.ruta = "/Jefe/proyectosdirigidos/formatoa/View.xhtml";
    }
	
    public void cargarModificarFormatoa() {
        this.ruta = "/Jefe/proyectosdirigidos/formatoa/Edit.xhtml";
    }
    
    public void cargarCrearFormatoa() {
        this.ruta = "/Jefe/proyectosdirigidos/formatoa/Create.xhtml";
    }    
    
    public void cargarGestionEstudiantes() {
        this.ruta = "/Jefe/estudiante/List.xhtml";
    }      
    //FORMATOS A DE CADA DOCENTE
    public void cargarGestionFormatoaDocente(){
       System.out.println("llamando a siguiente vista 3");
         this.ruta = "/Jefe/proyectosdirigidos/formatoa/List_Docentes.xhtml";
         System.out.println("llamando a siguiente vista 4");
    }
	
	public void cargarVerFormatoaDocente(){
         this.ruta = "/Jefe/proyectosdirigidos/formatoa/View_Docentes.xhtml";
    }
	
    public void cargarModificarFormatoaDocente() {
        this.ruta = "/Jefe/proyectosdirigidos/formatoa/Edit_Docentes.xhtml";
    }
    
    public void cargarCrearFormatoaDocente() {
        this.ruta = "/Jefe/proyectosdirigidos/formatoa/Create_Docentes.xhtml";
    }
    
    void cargarCrearEstudianteDocente() {
        this.ruta = "/Jefe/proyectosdirigidos/estudiantepregrado/Create.xhtml";
    }    
	//GESTION DE PROYECTOS JOSE HERNANDEZ  
    
     public void cargarComision() {
        this.ruta = "/Jefe/comision/List.xhtml";
    }
     
     public void cargarGestionComision() {
        this.ruta = "/Jefe/comision/List.xhtml";
    }

    public void cargarVerComisionAcademica() {
        
        this.ruta = "/Jefe/comision/ListComisionAcademica.xhtml";
        
    }
    public void cargarVerComisionAcademicauna() {
        
        this.ruta = "/Jefe/comision/View.xhtml";
        
    }
    
    public void cargarVerComisionEstudio() {
        this.ruta = "/Jefe/comision/ListComisionEstudios.xhtml";
    }
    public void cargarVerComisionAnioSabatico() {
        this.ruta = "/Jefe/comision/ListComisionAnioSabatico.xhtml";
    }
    
     public void cargarCrearComision() { //redirecciona a la interfaz de crear una comision Academica
        this.ruta = "/Jefe/comision/Create.xhtml";
    }
     
      public void cargarCrearComisionEstudios() {//redirecciona a la interfaz de crear una comision estudios
        this.ruta = "/Jefe/comision/CreateComisionEstudios.xhtml";
    }
      
       public void cargarCrearComisionAnioSabatico() {//redirecciona a la interfaz de crear una comision Año sabatico
        this.ruta = "/Jefe/comision/CreateAnioSabatico.xhtml";
    }
    public void cargarVerComision() {        //Carga una comision para modificarla
        
        System.out.println("metodo cargar editar");
        this.ruta = "/Jefe/comision/Edit.xhtml";
        
    }
}
