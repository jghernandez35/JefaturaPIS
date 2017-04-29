package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Estudiantepregrado;
import com.unicauca.jefatura.entidades.Proyecto;
import com.unicauca.jefatura.entidades.Soporteformatoa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-28T02:30:02")
@StaticMetamodel(Formatoa.class)
public class Formatoa_ { 

    public static volatile SingularAttribute<Formatoa, String> tituloTrabajo;
    public static volatile SingularAttribute<Formatoa, Proyecto> proyecto;
    public static volatile SingularAttribute<Formatoa, Integer> id;
    public static volatile SingularAttribute<Formatoa, Date> fechaActa;
    public static volatile CollectionAttribute<Formatoa, Estudiantepregrado> estudiantepregradoCollection;
    public static volatile SingularAttribute<Formatoa, Integer> actaDepartamento;
    public static volatile CollectionAttribute<Formatoa, Soporteformatoa> soporteformatoaCollection;

}