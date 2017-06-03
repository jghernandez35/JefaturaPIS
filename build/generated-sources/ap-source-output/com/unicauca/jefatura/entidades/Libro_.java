package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Produccionintelectual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T09:15:03")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, Produccionintelectual> produccionintelectual;
    public static volatile SingularAttribute<Libro, Integer> libroId;
    public static volatile SingularAttribute<Libro, String> libroNombre;
    public static volatile SingularAttribute<Libro, String> libroIsbn;
    public static volatile SingularAttribute<Libro, Integer> libroEdicion;
    public static volatile SingularAttribute<Libro, String> libroEditorial;

}