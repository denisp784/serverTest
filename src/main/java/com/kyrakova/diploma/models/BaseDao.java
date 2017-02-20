package com.kyrakova.diploma.models;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseDao<T extends BaseModel> {
    @Autowired
    private SessionFactory sessionFactory;

    final Class<T> typeParameterClass;

    public BaseDao(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public BaseDao(Class<T> typeParameterClass, SessionFactory sessionFactory) {
        this.typeParameterClass = typeParameterClass;
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<T> list() {
        @SuppressWarnings("unchecked")
        List<T> listObjs = (List<T>) sessionFactory.getCurrentSession()
                .createCriteria(this.typeParameterClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .addOrder(Order.asc("id"))
                .list();

        return listObjs;
    }

    @Transactional
    public void saveOrUpdate(T obj) {
        sessionFactory.getCurrentSession().saveOrUpdate(obj);
    }

    @Transactional
    public void delete(Long id) {
        T obj = null;
        try {
            obj = typeParameterClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        obj.setId(id);
        sessionFactory.getCurrentSession().delete(obj);
    }

    @Transactional
    public T get(long id) {
        String hql = "from "+ typeParameterClass.getName() +" where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<T> list = (List<T>) query.list();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }
}
