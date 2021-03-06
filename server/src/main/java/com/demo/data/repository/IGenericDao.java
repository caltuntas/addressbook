package com.demo.data.repository;


import java.util.List;

public interface IGenericDao<E> {

    void setDaoType(Class<E> daoType);
    public void save(E entity);

    public void saveOrUpdate(E entity);

    public void remove(E entity);

    public E findById(int id);

    public List<E> getAll();
}