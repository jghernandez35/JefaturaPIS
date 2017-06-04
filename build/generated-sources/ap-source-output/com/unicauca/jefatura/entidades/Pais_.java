package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Ciudad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-04T11:34:25")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, Integer> idPais;
    public static volatile CollectionAttribute<Pais, Ciudad> ciudadCollection;
    public static volatile SingularAttribute<Pais, String> nombrePais;

}