package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Estado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T23:41:25")
@StaticMetamodel(Estadodocente.class)
public class Estadodocente_ { 

    public static volatile SingularAttribute<Estadodocente, Estado> estId;
    public static volatile SingularAttribute<Estadodocente, Date> fechaInicio;
    public static volatile SingularAttribute<Estadodocente, Docente> docId;
    public static volatile SingularAttribute<Estadodocente, Integer> id;
    public static volatile SingularAttribute<Estadodocente, Date> fechaFin;

}