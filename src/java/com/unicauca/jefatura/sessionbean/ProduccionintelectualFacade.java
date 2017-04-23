/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Produccionintelectual;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabia
 */
@Stateless
public class ProduccionintelectualFacade extends AbstractFacade<Produccionintelectual> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduccionintelectualFacade() {
        super(Produccionintelectual.class);
    }
    
     public Produccionintelectual agregarProduccion(Produccionintelectual produccion){
        em.persist(produccion);
        em.flush();
        return produccion;
        
    }
    
}
