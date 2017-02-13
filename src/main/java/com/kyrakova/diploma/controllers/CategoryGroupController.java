package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.category.Category;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroup;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroupDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping("/categoryGroups")
public class CategoryGroupController extends BaseController<CategoryGroup> {

    CategoryGroupDaoImpl categoryGroupDao;

    @Autowired
    CategoryGroupController(BaseDao<CategoryGroup> categoryGroupDao) {
        super(categoryGroupDao);
        this.categoryGroupDao = (CategoryGroupDaoImpl) categoryGroupDao;
    }

    @RequestMapping(value = "/getBySection", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryGroup>> getBySection(@RequestParam(value ="sectionId") Long id) {
        return new ResponseEntity<List<CategoryGroup>>(categoryGroupDao.getBySection(id), HttpStatus.OK);
    }
}
