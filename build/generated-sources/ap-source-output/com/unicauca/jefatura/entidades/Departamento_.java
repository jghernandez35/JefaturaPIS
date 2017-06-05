package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Contratacion;
import com.unicauca.jefatura.entidades.Facultad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-04T22:43:40")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Facultad> facId;
    public static volatile SingularAttribute<Departamento, Integer> id;
    public static volatile CollectionAttribute<Departamento, Contratacion> contratacionCollection;
    public static volatile SingularAttribute<Departamento, String> nombre;

}