package it.si2001.dao;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/*
Classe base che fornisce funzionalità CRUD persistenti nel db.
ricerca,create,update e delete.

Classe generica da cui implementare DAO più specifici.

T tipo della classe di persistenza
PK tipo della primary key
 */

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager(){
        return em;
    }

    protected T getByKey(PK key) {
        return (T) em.find(persistentClass, key);
    }

    protected void persist(T entity) {
        em.persist(entity);
    }

    protected void update(T entity) {
        em.merge(entity);
    }

    protected void delete(T entity) {
        em.remove(entity);
    }

}
