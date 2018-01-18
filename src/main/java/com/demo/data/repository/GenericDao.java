package com.demo.data.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDao<E extends Serializable> implements IGenericDao<E> {
    @Autowired
    private SessionFactory sessionFactory;

    protected Class<E> daoType;


    public GenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(E entity) {
        currentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }


    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }

    @Override
    public E findById(int id) {
        return (E) currentSession().get(daoType, id);
    }

    @Override
    public List<E> getAll() {

        CriteriaQuery<E> query = currentSession().getCriteriaBuilder().createQuery(daoType);

        return currentSession().createQuery(query).getResultList();
    }
}