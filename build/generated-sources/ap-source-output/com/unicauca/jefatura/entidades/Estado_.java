package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Estadodocente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T00:37:28")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> estado;
    public static volatile SingularAttribute<Estado, Integer> id;
    public static volatile CollectionAttribute<Estado, Estadodocente> estadodocenteCollection;

}