package com.kyrakova.diploma.models.categoryGroup;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.category.Category;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class CategoryGroupDaoImpl extends BaseDao<CategoryGroup> {
    @Autowired
    private SessionFactory sessionFactory;

    public CategoryGroupDaoImpl() {
        super(CategoryGroup.class);
    }

    public CategoryGroupDaoImpl(SessionFactory sessionFactory) {
        super(CategoryGroup.class, sessionFactory);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public List<CategoryGroup> list() {
        @SuppressWarnings("unchecked")
        List<CategoryGroup> listObjs = (List<CategoryGroup>) sessionFactory.getCurrentSession()
                .createCriteria(CategoryGroup.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .addOrder(Order.asc("priority"))
                .list();

        return listObjs;
    }

    @Transactional
    public List<CategoryGroup> getBySection(Long id) {
        String hql = "from CategoryGroup where sectionId = " + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }
}
