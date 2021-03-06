package com.kyrakova.diploma.models.section;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroup;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SectionDaoImpl extends BaseDao<Section> {
    @Autowired
    private SessionFactory sessionFactory;

    public SectionDaoImpl() {
        super(Section.class);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public List<Section> list() {
        @SuppressWarnings("unchecked")
        List<Section> listObjs = (List<Section>) sessionFactory
                .getCurrentSession()
                .createQuery("from Section S order by S.priority ASC, S.id ASC ")
                .list();

        return listObjs;
    }

    public SectionDaoImpl(SessionFactory sessionFactory) {
        super(Section.class, sessionFactory);
    }
}
