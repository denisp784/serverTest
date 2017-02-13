package com.kyrakova.diploma.models.category;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroup;
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
    public List<Category> getByCategoryGroup(Long id) {
        String hql = "from Category where categoryGroupId = " + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }

    @Transactional
    public CategoryGroup getCategoryGroup(Long categoryGroupId) {
        String hql = "from CategoryGroup where id = " + categoryGroupId;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<CategoryGroup> list = (List<CategoryGroup>) query.list();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }
}
