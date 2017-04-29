package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Produccionintelectual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-28T02:30:02")
@StaticMetamodel(Conferencia.class)
public class Conferencia_ { 

    public static volatile SingularAttribute<Conferencia, String> tituloArticulo;
    public static volatile SingularAttribute<Conferencia, Integer> conferenciaId;
    public static volatile SingularAttribute<Conferencia, Integer> conferenciaUbicacionTipo;
    public static volatile SingularAttribute<Conferencia, Produccionintelectual> produccionintelectual;
    public static volatile SingularAttribute<Conferencia, String> conferenciaUbicacion;
    public static volatile SingularAttribute<Conferencia, String> conferenciaNombre;

}