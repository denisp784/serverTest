package com.kyrakova.diploma.models.category;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CategoryDaoImpl extends BaseDao<Category> {
    @Autowired
    private SessionFactory sessionFactory;

    public CategoryDaoImpl() {
        super(Category.class);
    }

    public CategoryDaoImpl(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }

    @Transactional
    public List<Category> getBySection(Long id) {
        String hql = "from Category where sectionId = " + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }
}
