package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Dedicacion;
import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Facultad;
import com.unicauca.jefatura.entidades.Soportecontratacion;
import com.unicauca.jefatura.entidades.Tipocontratacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-28T02:30:02")
@StaticMetamodel(Contratacion.class)
public class Contratacion_ { 

    public static volatile SingularAttribute<Contratacion, Tipocontratacion> tipId;
    public static volatile SingularAttribute<Contratacion, Date> fechaInicio;
    public static volatile SingularAttribute<Contratacion, Docente> docId;
    public static volatile CollectionAttribute<Contratacion, Soportecontratacion> soportecontratacionCollection;
    public static volatile SingularAttribute<Contratacion, Facultad> facId;
    public static volatile SingularAttribute<Contratacion, Integer> id;
    public static volatile SingularAttribute<Contratacion, Date> fechaFin;
    public static volatile SingularAttribute<Contratacion, Dedicacion> dedId;

}