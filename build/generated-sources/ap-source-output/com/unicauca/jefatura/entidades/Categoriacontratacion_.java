package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Categoria;
import com.unicauca.jefatura.entidades.Contratacion;
import com.unicauca.jefatura.entidades.Tipocontratacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T22:25:33")
@StaticMetamodel(Categoriacontratacion.class)
public class Categoriacontratacion_ { 

    public static volatile SingularAttribute<Categoriacontratacion, Categoria> catId;
    public static volatile SingularAttribute<Categoriacontratacion, Integer> id;
    public static volatile SingularAttribute<Categoriacontratacion, Tipocontratacion> tipConId;
    public static volatile CollectionAttribute<Categoriacontratacion, Contratacion> contratacionCollection;

}