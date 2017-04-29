/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Contratacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class ContratacionFacade extends AbstractFacade<Contratacion> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratacionFacade() {
        super(Contratacion.class);
    }
    
    public List<Contratacion> obtenerProduccionIntelectual(int id){
        Query buscarIden = getEntityManager().createNamedQuery("Contratacion.findByIdDocente");
        buscarIden.setParameter("docId", id);
        List<Contratacion> lista= buscarIden.getResultList();
        
        return lista;
        
    }
    
    
}
