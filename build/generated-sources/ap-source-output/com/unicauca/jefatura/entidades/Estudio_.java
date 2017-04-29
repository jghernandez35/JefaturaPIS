package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Docente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-28T02:30:02")
@StaticMetamodel(Estudio.class)
public class Estudio_ { 

    public static volatile CollectionAttribute<Estudio, Docente> docenteCollection;
    public static volatile SingularAttribute<Estudio, String> nombreEstudio;
    public static volatile SingularAttribute<Estudio, Integer> id;

}