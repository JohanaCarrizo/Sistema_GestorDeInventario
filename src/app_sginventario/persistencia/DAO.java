package app_sginventario.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {
    
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("App_SGInventarioPU");
    protected EntityManager em = EMF.createEntityManager();
    
    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    protected void guardar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    /*protected T buscar(K id){
    
        conectar();
        em.getTransaction().begin();
        T objeto = (T) em.find(Class.class, id);
        em.getTransaction().commit();
        desconectar();
        return objeto;
    }
    
    protected List listar(){
    
        conectar();
        em.getTransaction().begin();
        List<T> lista = em.createQuery("SELECT o FROM "+Class.class+" o").getResultList();
        desconectar();
        return lista;
    }*/
}
