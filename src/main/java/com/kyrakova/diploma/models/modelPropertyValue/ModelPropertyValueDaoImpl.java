package com.kyrakova.diploma.models.modelPropertyValue;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelPropertyValueDaoImpl extends BaseDao<ModelPropertyValue> {
    @Autowired
    private SessionFactory sessionFactory;

    public ModelPropertyValueDaoImpl() {
        super(ModelPropertyValue.class);
    }

    public ModelPropertyValueDaoImpl(SessionFactory sessionFactory) {
        super(ModelPropertyValue.class, sessionFactory);
    }
}
