package com.demo.data.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.demo.data.utility.HibernateUtil;
import com.demo.data.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaQuery;

@Repository
public  class GenericDao<E> implements IGenericDao<E> {


    private SessionFactory sessionFactory;

    protected Class< E> daoType;
    Session session;

    public void setDaoType(Class<E> daoType) {
        this.daoType = daoType;

    }
    public GenericDao() {
        // Class asd=getClass();
        //Type asdasd= asd.getGenericSuperclass();
        //ParameterizedType asd1=(ParameterizedType) asdasd;
        //this.daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        sessionFactory=  HibernateUtil.getInstance().getSessionFactory();
        session=sessionFactory.openSession();
        session.beginTransaction();

    }



    @Override
    public void save(E entity) {

        session.save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        session.saveOrUpdate(entity);
    }


    @Override
    public void remove(E entity) {
        session.delete(entity);
    }

    @Override
    public E findById(int id) {
        return (E) session.get(daoType, id);
    }

    @Override
    public List<E> getAll() {

        CriteriaQuery<E> query = session.getCriteriaBuilder().createQuery((Class) daoType);

        return session.createQuery(query).getResultList();
    }
}