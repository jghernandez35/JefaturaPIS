package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Contratacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-28T02:30:02")
@StaticMetamodel(Facultad.class)
public class Facultad_ { 

    public static volatile SingularAttribute<Facultad, Integer> id;
    public static volatile CollectionAttribute<Facultad, Contratacion> contratacionCollection;
    public static volatile SingularAttribute<Facultad, String> nombre;

}