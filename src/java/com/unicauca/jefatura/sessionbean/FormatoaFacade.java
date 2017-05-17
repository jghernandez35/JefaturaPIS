/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Formatoa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author UsuarioGB
 */
@Stateless
public class FormatoaFacade extends AbstractFacade<Formatoa> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormatoaFacade() {
        super(Formatoa.class);
    }
    
    public List<Formatoa> listarFormatosADocente(Integer docId){
        Query consulta=getEntityManager().createNamedQuery("Formatoa.findByDocIdId");
        consulta.setParameter("docId",docId);
        
        List<Formatoa> lista=consulta.getResultList();
        
        return lista;
        
    }
    
    public Formatoa guardar(Formatoa formatoa){
        em.persist(formatoa);
        em.flush();
        return formatoa;
    }
}
