package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Contratacion;
import com.unicauca.jefatura.entidades.Estadodocente;
import com.unicauca.jefatura.entidades.Estudio;
import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.entidades.Tipodocumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T22:25:33")
@StaticMetamodel(Docente.class)
public class Docente_ { 

    public static volatile SingularAttribute<Docente, String> apellidos;
    public static volatile SingularAttribute<Docente, Tipodocumento> tipId;
    public static volatile SingularAttribute<Docente, Estudio> estId;
    public static volatile SingularAttribute<Docente, String> documento;
    public static volatile SingularAttribute<Docente, Integer> id;
    public static volatile CollectionAttribute<Docente, Realiza> realizaCollection;
    public static volatile CollectionAttribute<Docente, Contratacion> contratacionCollection;
    public static volatile CollectionAttribute<Docente, Estadodocente> estadodocenteCollection;
    public static volatile SingularAttribute<Docente, String> nombres;

}