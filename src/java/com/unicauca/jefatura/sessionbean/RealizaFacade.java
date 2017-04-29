package com.unicauca.jefatura.sessionbean;



import com.unicauca.jefatura.entidades.Realiza;
import com.unicauca.jefatura.entidades.Revista;
import com.unicauca.jefatura.sessionbean.AbstractFacade;
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
    
    public List<Realiza> obtenerProduccionIntelectual(Integer numeroDocumento){
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

    
      public List<Realiza> getRevistasDocente(Integer doc_id){
          System.out.println("Ingreso a hacer conuslta");
        Query q = em.createNamedQuery("selectProduccionRevistaDocente");
        q.setParameter(1, doc_id);
        List<Realiza> revistas = q.getResultList();
        
       
        return revistas;
    }
      
       public List<Realiza> getCapituloLibroDocente(Integer doc_id){
          System.out.println("Ingreso a hacer conuslta");
        Query q = em.createNamedQuery("selectProduccionCapituloLibroDocente");
        q.setParameter(1, doc_id);
        List<Realiza> revistas = q.getResultList();
        
          
        return revistas;
    }
           public List<Realiza> getLibroDocente(Integer doc_id){
          System.out.println("Ingreso a hacer conuslta");
        Query q = em.createNamedQuery("selectProduccionLibroDocente");
        q.setParameter(1, doc_id);
        List<Realiza> revistas = q.getResultList();
        
        
        return revistas;
    }
               public List<Realiza> getConferenciaDocente(Integer doc_id){
          System.out.println("Ingreso a hacer conuslta");
        Query q = em.createNamedQuery("selectProduccionConferenciaDocente");
        q.setParameter(1, doc_id);
        List<Realiza> revistas = q.getResultList();
        
        return revistas;
    }
    
    
      public void refrescar(){
          
       // em.refresh();
        
    }
    
}
