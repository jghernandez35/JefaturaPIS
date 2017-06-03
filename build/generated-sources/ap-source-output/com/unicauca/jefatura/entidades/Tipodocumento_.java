package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Docente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T09:15:03")
@StaticMetamodel(Tipodocumento.class)
public class Tipodocumento_ { 

    public static volatile SingularAttribute<Tipodocumento, String> tipo;
    public static volatile CollectionAttribute<Tipodocumento, Docente> docenteCollection;
    public static volatile SingularAttribute<Tipodocumento, Integer> id;

}