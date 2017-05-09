/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.jefatura.sessionbean;

import com.unicauca.jefatura.entidades.Tipocontratacion;
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
public class TipocontratacionFacade extends AbstractFacade<Tipocontratacion> {

    @PersistenceContext(unitName = "JefaturaPISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipocontratacionFacade() {
        super(Tipocontratacion.class);
    }
    
    
            
    public Tipocontratacion getTipoContratacion(Integer id) {
        System.out.println(""+id);
        Query query = getEntityManager().createNamedQuery("Tipocontratacion.findById");
        query.setParameter("id", id);
        List<Tipocontratacion> result = query.getResultList();
        
        if(result.isEmpty()){
            System.out.println("retorno valor null");
            return null;
        }else{
            System.out.println(result.get(0).getTipo());
            return result.get(0);
        }
        
        
    }	
}
