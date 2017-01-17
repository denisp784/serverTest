package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.category.Category;
import com.kyrakova.diploma.models.category.CategoryDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category> {

    CategoryDaoImpl categoryDao;

    @Autowired
    CategoryController(BaseDao<Category> categoryDao) {
        super(categoryDao);
        this.categoryDao = (CategoryDaoImpl) categoryDao;
    }

    @RequestMapping(value = "/getBySection", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getBySection(@RequestParam(value ="sectionId") Long id) {
        return new ResponseEntity<List<Category>>(categoryDao.getBySection(id), HttpStatus.OK);
    }

    /*@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Gro>> delete(@PathVariable("id") Long id) {
        Long categoryGroupId = categoryDao.get(id).getCategoryGroup().getId();
        objDao.delete(id);
        return new ResponseEntity<List<Category>>(categoryDao.getBySection(categoryGroupId), HttpStatus.OK);
    }*/
}
