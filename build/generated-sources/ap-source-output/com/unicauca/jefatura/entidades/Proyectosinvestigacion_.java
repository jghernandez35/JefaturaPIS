package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Soporteproyectoinvestigacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T22:25:33")
@StaticMetamodel(Proyectosinvestigacion.class)
public class Proyectosinvestigacion_ { 

    public static volatile SingularAttribute<Proyectosinvestigacion, Date> fechaInicio;
    public static volatile SingularAttribute<Proyectosinvestigacion, Integer> id;
    public static volatile SingularAttribute<Proyectosinvestigacion, String> vri;
    public static volatile SingularAttribute<Proyectosinvestigacion, String> nombre;
    public static volatile SingularAttribute<Proyectosinvestigacion, Date> fechaFin;
    public static volatile CollectionAttribute<Proyectosinvestigacion, Soporteproyectoinvestigacion> soporteproyectoinvestigacionCollection;

}