package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Revista;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T23:41:25")
@StaticMetamodel(Clasificacion.class)
public class Clasificacion_ { 

    public static volatile SingularAttribute<Clasificacion, Integer> id;
    public static volatile SingularAttribute<Clasificacion, String> clasificacion;
    public static volatile CollectionAttribute<Clasificacion, Revista> revistaCollection;

}