package com.unicauca.jefatura.entidades;

import com.unicauca.jefatura.entidades.Ciudad;
import com.unicauca.jefatura.entidades.Docente;
import com.unicauca.jefatura.entidades.Estadocomision;
import com.unicauca.jefatura.entidades.Tipocomision;
import com.unicauca.jefatura.entidades.Tipoparticipacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-04T11:34:25")
@StaticMetamodel(Comision.class)
public class Comision_ { 

    public static volatile SingularAttribute<Comision, Date> fechaSolicitudComision;
    public static volatile SingularAttribute<Comision, Integer> idComision;
    public static volatile SingularAttribute<Comision, String> organizadoPorComision;
    public static volatile SingularAttribute<Comision, Date> fechaFinComision;
    public static volatile SingularAttribute<Comision, Tipoparticipacion> idTipoParticipacionComision;
    public static volatile SingularAttribute<Comision, Tipocomision> idTipoComisionComision;
    public static volatile SingularAttribute<Comision, Estadocomision> idEstadoComision;
    public static volatile SingularAttribute<Comision, Date> fechaInicioComision;
    public static volatile SingularAttribute<Comision, Docente> idDocenteComision;
    public static volatile SingularAttribute<Comision, Ciudad> idCiudadComision;
    public static volatile SingularAttribute<Comision, String> descripcionComision;
    public static volatile SingularAttribute<Comision, String> numeroResolucionComision;
    public static volatile SingularAttribute<Comision, String> numeroActaComision;

}