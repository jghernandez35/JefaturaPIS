/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Realiza;
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
public class RealizaFacade extends AbstractFacade<Realiza> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RealizaFacade() {
        super(Realiza.class);
    }
    
    public List<Realiza> obtenerProduccionIntelectual(String numeroDocumento){
         Query buscarIden = getEntityManager().createNamedQuery("Realiza.findByDocId");
        buscarIden.setParameter("docId", numeroDocumento);
        List<Realiza> lista= buscarIden.getResultList();
        //Docente docente =(Docente)buscarIden.getSingleResult();
        for(int i=0;i<lista.size();i++){
            Realiza aux= lista.get(i);
            if(aux.getProId()==null){
                System.out.println("Es  nula la produccion");
            }else{
                 if(aux.getProId().getRevista()==null){
                    System.out.println("Es  nula la revista");
                 }
                 
            }
            
        }
        return lista;
        
    }
      public void refrescar(){
          
        em.refresh(this);
        
    }
    
}
