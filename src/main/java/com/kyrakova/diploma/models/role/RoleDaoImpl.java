package com.kyrakova.diploma.models.role;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Denis on 14.11.2016.
 */
public class RoleDaoImpl extends BaseDao<Role> {
    @Autowired
    private SessionFactory sessionFactory;

    public RoleDaoImpl() {
        super(Role.class);
    }

    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(Role.class, sessionFactory);
    }
}
