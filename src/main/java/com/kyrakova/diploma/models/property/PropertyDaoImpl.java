package com.kyrakova.diploma.models.property;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertyDaoImpl extends BaseDao<Property> {
    @Autowired
    private SessionFactory sessionFactory;

    public PropertyDaoImpl() {
        super(Property.class);
    }

    public PropertyDaoImpl(SessionFactory sessionFactory) {
        super(Property.class, sessionFactory);
    }
}
