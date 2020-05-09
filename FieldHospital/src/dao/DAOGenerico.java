package dao;

import entity.BaseEntity;
import javax.persistence.EntityManager;


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
        
        
    }
}
