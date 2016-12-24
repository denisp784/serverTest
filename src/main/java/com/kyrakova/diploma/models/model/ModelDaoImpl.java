package com.kyrakova.diploma.models.model;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelDaoImpl extends BaseDao<Model> {
    @Autowired
    private SessionFactory sessionFactory;

    public ModelDaoImpl() {
        super(Model.class);
    }

    public ModelDaoImpl(SessionFactory sessionFactory) {
        super(Model.class, sessionFactory);
    }
}
