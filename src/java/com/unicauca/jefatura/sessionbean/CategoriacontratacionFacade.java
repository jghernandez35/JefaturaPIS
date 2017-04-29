/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Categoriacontratacion;
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
public class CategoriacontratacionFacade extends AbstractFacade<Categoriacontratacion> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriacontratacionFacade() {
        super(Categoriacontratacion.class);
    }
    
     public List<Categoriacontratacion> buscarPorIdTipoContratacion(int id) {
        Query query = getEntityManager().createNamedQuery("Categoriacontratacion.findByTipoContratacion");
        query.setParameter("tipo", id);
        List<Categoriacontratacion> resultList = query.getResultList();
        return resultList;
    }	
    
}
