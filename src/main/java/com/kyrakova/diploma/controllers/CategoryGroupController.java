package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping("/categoryGroups")
public class CategoryGroupController extends BaseController<CategoryGroup> {

    @Autowired
    CategoryGroupController(BaseDao<CategoryGroup> categoryGroupDaoDao) {
        super(categoryGroupDaoDao);
    }
}
