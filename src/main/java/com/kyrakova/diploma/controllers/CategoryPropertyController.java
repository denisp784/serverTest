package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.categoryProperty.CategoryProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoryProperties")
public class CategoryPropertyController extends BaseController<CategoryProperty> {

    @Autowired
    CategoryPropertyController(BaseDao<CategoryProperty> categoryDao) {
        super(categoryDao);
    }
}
