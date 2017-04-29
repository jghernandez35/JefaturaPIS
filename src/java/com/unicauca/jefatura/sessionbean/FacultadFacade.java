/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;


import com.unicauca.jefatura.entidades.Facultad;
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
public class FacultadFacade extends AbstractFacade<Facultad> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacultadFacade() {
        super(Facultad.class);
    }

    public Facultad buscarPorIdFacultad(Integer id) {
        System.out.println(""+id);
        Query query = getEntityManager().createNamedQuery("Facultad.findById");
        query.setParameter("id", id);
        List<Facultad> result = query.getResultList();
        
        if(result.isEmpty()){
            System.out.println("retorno valor null");
            return null;
        }else{
            System.out.println(result.get(0).getNombre());
            return result.get(0);
        }
        
        
    }	
    
}


