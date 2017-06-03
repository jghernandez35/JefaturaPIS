package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Comision;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T09:15:03")
@StaticMetamodel(Estadocomision.class)
public class Estadocomision_ { 

    public static volatile SingularAttribute<Estadocomision, Integer> idEstado;
    public static volatile SingularAttribute<Estadocomision, String> nombreEstado;
    public static volatile CollectionAttribute<Estadocomision, Comision> comisionCollection;

}