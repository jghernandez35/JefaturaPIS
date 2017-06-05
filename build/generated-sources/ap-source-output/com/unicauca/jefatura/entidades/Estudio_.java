package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Trabajosinvestigacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-04T22:43:41")
@StaticMetamodel(Estudio.class)
public class Estudio_ { 

    public static volatile CollectionAttribute<Estudio, Trabajosinvestigacion> trabajosinvestigacionCollection;
    public static volatile CollectionAttribute<Estudio, Docente> docenteCollection;
    public static volatile SingularAttribute<Estudio, String> nombreEstudio;
    public static volatile SingularAttribute<Estudio, Integer> id;

}