package com.kyrakova.diploma.models.user;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDao<User> {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
        super(User.class);
    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }
}
