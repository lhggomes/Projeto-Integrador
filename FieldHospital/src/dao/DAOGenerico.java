package dao;

import entity.BaseEntity;
import java.awt.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAOGenerico <T extends BaseEntity>{
    private static DAOGenerico instance; 
    protected EntityManager entityManager; 
    
    public static DAOGenerico getInstance(){
        if (instance != null){
        } else {
            instance = new DAOGenerico();
        }
        return instance; 
    }
    
    private DAOGenerico(){
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory; 
        factory = Persistence.createEntityManagerFactory("FieldHospitalPU"); 
        if (entityManager == null){
            entityManager = factory.createEntityManager(); 
        }
        
        return entityManager; 
        
                
    }
    
    public T obtemPorID (Class<T> classe, Long id){
        return entityManager.find(classe, id);
        
    }
    
    public void grava (Class<T> classe, T c){
        
        try{
            entityManager.getTransaction().begin();
            T cont = entityManager.find(classe, c.getId()); 
            if (cont == null){
                entityManager.persist(c);
            } else{
                entityManager.merge(c); 
            }
            
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            entityManager.getTransaction().rollback();
        }
        
    }
    
    public List<T> obtemTodos (Class<T> classe){
        return entityManager.createNamedQuery(classe.getSimpleName()+".findAll").getResultList();
    }
    
    public void apaga(Class<T> classe, T c){
        try{
            entityManager.getTransaction().begin();
            c = entityManager.find(classe, c.getId()); 
            entityManager.getTransaction().commit();
            
        } catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    
    
    
}
