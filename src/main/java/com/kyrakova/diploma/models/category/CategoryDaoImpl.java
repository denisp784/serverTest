package com.kyrakova.diploma.models.category;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroup;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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

    @Override
    @Transactional
    public List<Category> list() {
        @SuppressWarnings("unchecked")
        String hql = "from Category C order by C.priority ASC, C.id ASC";
        List<Category> listObjs = (List<Category>) sessionFactory
                .getCurrentSession()
                .createQuery(hql)
                .list();

        return listObjs;
    }

    @Transactional
    public List<Category> getByCategoryGroup(Long id) {
        String hql = "from Category C where categoryGroupId = " + id + " order by C.priority ASC, C.id ASC";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }

    @Transactional
    public CategoryGroup getCategoryGroup(Long categoryGroupId) {
        String hql = "from CategoryGroup CC where id = " + categoryGroupId + " order by CC.priority ASC, CC.id ASC";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<CategoryGroup> list = (List<CategoryGroup>) query.list();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    @Transactional
    public Category getByUrl(String url) {
        String hql = "from Category where urlName = '" + url + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<Category> list = (List<Category>) query.list();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }
}
