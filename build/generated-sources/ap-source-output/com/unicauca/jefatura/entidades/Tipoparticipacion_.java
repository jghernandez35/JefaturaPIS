package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Comision;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T09:15:03")
@StaticMetamodel(Tipoparticipacion.class)
public class Tipoparticipacion_ { 

    public static volatile SingularAttribute<Tipoparticipacion, Integer> idTipoParticipacion;
    public static volatile SingularAttribute<Tipoparticipacion, String> nombreTipoParticipacion;
    public static volatile CollectionAttribute<Tipoparticipacion, Comision> comisionCollection;

}