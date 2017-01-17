package com.kyrakova.diploma.models.categoryGroup;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryGroupDaoImpl extends BaseDao<CategoryGroup> {
    @Autowired
    private SessionFactory sessionFactory;

    public CategoryGroupDaoImpl() {
        super(CategoryGroup.class);
    }

    public CategoryGroupDaoImpl(SessionFactory sessionFactory) {
        super(CategoryGroup.class, sessionFactory);
    }

    /*@Transactional
    public List<CategoryGroup> getByCategoryGroup(Long id) {
        String hql = "from Category where categoryGroupId = " + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }*/
}
