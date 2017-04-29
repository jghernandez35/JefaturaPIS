/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Soportetrabajosinvestigacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author UsuarioGB
 */
@Stateless
public class SoportetrabajosinvestigacionFacade extends AbstractFacade<Soportetrabajosinvestigacion> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoportetrabajosinvestigacionFacade() {
        super(Soportetrabajosinvestigacion.class);
    }
    
}