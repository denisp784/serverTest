package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.category.Category;
import com.kyrakova.diploma.models.category.CategoryDaoImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping("/categories")
@Api(description = "Операции с категориями.")
public class CategoryController extends BaseController<Category> {

    CategoryDaoImpl categoryDao;

    @Autowired
    CategoryController(BaseDao<Category> categoryDao) {
        super(categoryDao);
        this.categoryDao = (CategoryDaoImpl) categoryDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Category> add(@RequestBody Category category) throws Exception {

        category.setCategoryGroup(categoryDao.getCategoryGroup(category.getCategoryGroup().getId()));
        categoryDao.saveOrUpdate(category);

        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/getByCategoryGroup", method = RequestMethod.GET)
    @ApiOperation(value = "Категории по ID группы.")
    public ResponseEntity<List<Category>> getBySection(@RequestParam(value = "categoryGroupId") Long id) {
        return new ResponseEntity<List<Category>>(categoryDao.getByCategoryGroup(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/getByUrl", method = RequestMethod.GET)
    @ApiOperation(value = "Категория по urlName.")
    public ResponseEntity<Category> getByUrl(@RequestParam(value = "url") String url) {
        return new ResponseEntity<Category>(categoryDao.getByUrl(url), HttpStatus.OK);
    }

    /*@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Gro>> delete(@PathVariable("id") Long id) {
        Long categoryGroupId = categoryDao.get(id).getCategoryGroup().getId();
        objDao.delete(id);
        return new ResponseEntity<List<Category>>(categoryDao.getBySection(categoryGroupId), HttpStatus.OK);
    }*/
}
