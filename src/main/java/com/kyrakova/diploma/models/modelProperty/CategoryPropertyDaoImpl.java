package com.kyrakova.diploma.models.modelProperty;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryPropertyDaoImpl extends BaseDao<CategoryProperty> {
    @Autowired
    private SessionFactory sessionFactory;

    public CategoryPropertyDaoImpl() {
        super(CategoryProperty.class);
    }

    public CategoryPropertyDaoImpl(SessionFactory sessionFactory) {
        super(CategoryProperty.class, sessionFactory);
    }
}
