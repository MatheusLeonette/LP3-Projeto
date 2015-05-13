package DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class BasicDao<G,PK extends Serializable> {
    protected Class<G> entityClass;
    @PersistenceContext
    protected EntityManager entityManager;
    
    public BasicDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
        this.entityClass = (Class<G>) genericSuperclass
             .getActualTypeArguments()[0];
    }
    
    public G create(G entityClass) {
        this.entityManager.persist(entityClass);
        return entityClass;
    }

    public G read(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    public G update(G entityClass ) {
        return this.entityManager.merge(entityClass);
    }
    
    public void delete(G entityClass) {
        entityClass = this.entityManager.merge(entityClass);
        this.entityManager.remove(entityClass);
    }
}
 