package com.kyrakova.diploma.models.user;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao<User> {

    public UserDaoImpl() {
        super(User.class);
    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }
}
