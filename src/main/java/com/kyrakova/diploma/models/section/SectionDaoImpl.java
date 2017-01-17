package com.kyrakova.diploma.models.section;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SectionDaoImpl extends BaseDao<Section> {
    @Autowired
    private SessionFactory sessionFactory;

    public SectionDaoImpl() {
        super(Section.class);
    }

    public SectionDaoImpl(SessionFactory sessionFactory) {
        super(Section.class, sessionFactory);
    }
}
