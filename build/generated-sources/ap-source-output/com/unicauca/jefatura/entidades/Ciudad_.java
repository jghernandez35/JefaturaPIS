package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Comision;
import com.unicauca.jefatura.entidades.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T09:15:03")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, Pais> idPaisCiudad;
    public static volatile SingularAttribute<Ciudad, String> nombreCiudad;
    public static volatile CollectionAttribute<Ciudad, Comision> comisionCollection;
    public static volatile SingularAttribute<Ciudad, Integer> idCiudad;

}