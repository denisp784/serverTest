package com.kyrakova.diploma.models.category;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryDaoImpl extends BaseDao<Category> {
    @Autowired
    private SessionFactory sessionFactory;

    public CategoryDaoImpl() {
        super(Category.class);
    }

    public CategoryDaoImpl(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
