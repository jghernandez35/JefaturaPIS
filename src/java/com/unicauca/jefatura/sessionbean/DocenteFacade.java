/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Docente;
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
public class DocenteFacade extends AbstractFacade<Docente> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteFacade() {
        super(Docente.class);
    }
   
    public boolean buscarPorNumeroIdentificacion(String numeroDeIdentificacion) {
        Query buscarIden = getEntityManager().createNamedQuery("Docente.findByDocumento");
        buscarIden.setParameter("documento", numeroDeIdentificacion);
        List<Docente> lista= buscarIden.getResultList();

        if(lista.size()==0){
            return false;
        }else{
           return true;
        }
        
    }
}
