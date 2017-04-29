/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Revista;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fabia
 */
@Stateless
public class RevistaFacade extends AbstractFacade<Revista> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RevistaFacade() {
        super(Revista.class);
    }
 
    public void refrescar(){
        em.refresh(this);
        
    }
    
//    public List<Revista> getRevistasDocente(Integer doc_id){
//        Query q = em.createNamedQuery("selectProduccionRevistaDocente");
//        q.setParameter("doc_id", doc_id);
//        List<Revista> revistas = q.getResultList();
//        return revistas;
//    }
            
}
