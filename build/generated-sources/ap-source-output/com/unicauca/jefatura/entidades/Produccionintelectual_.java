package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.CapituloLibro;
import com.unicauca.jefatura.entidades.Conferencia;
import com.unicauca.jefatura.entidades.Libro;
import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.entidades.Revista;
import com.unicauca.jefatura.entidades.Soporteproduccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T00:37:28")
@StaticMetamodel(Produccionintelectual.class)
public class Produccionintelectual_ { 

    public static volatile SingularAttribute<Produccionintelectual, Libro> libro;
    public static volatile SingularAttribute<Produccionintelectual, Date> fecha;
    public static volatile SingularAttribute<Produccionintelectual, Conferencia> conferencia;
    public static volatile SingularAttribute<Produccionintelectual, CapituloLibro> capituloLibro;
    public static volatile SingularAttribute<Produccionintelectual, Revista> revista;
    public static volatile SingularAttribute<Produccionintelectual, Integer> id;
    public static volatile CollectionAttribute<Produccionintelectual, Realiza> realizaCollection;
    public static volatile CollectionAttribute<Produccionintelectual, Soporteproduccion> soporteproduccionCollection;

}