package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Produccionintelectual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-04T11:34:25")
@StaticMetamodel(CapituloLibro.class)
public class CapituloLibro_ { 

    public static volatile SingularAttribute<CapituloLibro, String> capLibroTitulo;
    public static volatile SingularAttribute<CapituloLibro, Integer> capLibroId;
    public static volatile SingularAttribute<CapituloLibro, Produccionintelectual> produccionintelectual;
    public static volatile SingularAttribute<CapituloLibro, String> libroNombre;
    public static volatile SingularAttribute<CapituloLibro, String> libroIsbn;
    public static volatile SingularAttribute<CapituloLibro, Integer> libroEdicion;
    public static volatile SingularAttribute<CapituloLibro, String> libroEditorial;
    public static volatile SingularAttribute<CapituloLibro, Integer> capLibroNumero;

}