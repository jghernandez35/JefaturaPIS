package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Contratacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T22:25:33")
@StaticMetamodel(Dedicacion.class)
public class Dedicacion_ { 

    public static volatile SingularAttribute<Dedicacion, String> dedicacion;
    public static volatile SingularAttribute<Dedicacion, Integer> id;
    public static volatile CollectionAttribute<Dedicacion, Contratacion> contratacionCollection;

}