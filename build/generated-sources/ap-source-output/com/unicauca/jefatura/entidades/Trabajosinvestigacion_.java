package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Estudianteinvestigacion;
import com.unicauca.jefatura.entidades.Soportetrabajosinvestigacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T23:41:25")
@StaticMetamodel(Trabajosinvestigacion.class)
public class Trabajosinvestigacion_ { 

    public static volatile SingularAttribute<Trabajosinvestigacion, Integer> id;
    public static volatile SingularAttribute<Trabajosinvestigacion, Estudianteinvestigacion> estudId;
    public static volatile SingularAttribute<Trabajosinvestigacion, Soportetrabajosinvestigacion> soportetrabajosinvestigacion;
    public static volatile SingularAttribute<Trabajosinvestigacion, String> actoadministrativo;

}