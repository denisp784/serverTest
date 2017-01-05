package com.kyrakova.diploma.models.image;

import com.kyrakova.diploma.models.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageDaoImpl extends BaseDao<Image> {
    @Autowired
    private SessionFactory sessionFactory;

    public ImageDaoImpl() {
        super(Image.class);
    }

    public ImageDaoImpl(SessionFactory sessionFactory) {
        super(Image.class, sessionFactory);
    }
}
