package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Clasificacion;
import com.unicauca.jefatura.entidades.Produccionintelectual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T23:41:25")
@StaticMetamodel(Revista.class)
public class Revista_ { 

    public static volatile SingularAttribute<Revista, Produccionintelectual> produccionintelectual;
    public static volatile SingularAttribute<Revista, String> tituloPublicacion;
    public static volatile SingularAttribute<Revista, Clasificacion> claId;
    public static volatile SingularAttribute<Revista, String> nombreRevista;
    public static volatile SingularAttribute<Revista, Integer> numeroEdicion;
    public static volatile SingularAttribute<Revista, Integer> id;

}