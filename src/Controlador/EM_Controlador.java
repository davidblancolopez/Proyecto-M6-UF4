
package Controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EM_Controlador {
    public static EntityManager getEntityManager() {
         EntityManager em;
        try {
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("INTERNA");
        em = emf.createEntityManager();
        } catch(Exception ex){
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("EXTERNA");
        em = emf.createEntityManager();
        }
       
        return em;
    }
}