package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category> {

    @Autowired
    CategoryController(BaseDao<Category> categoryDao) {
        super(categoryDao);
    }
}
