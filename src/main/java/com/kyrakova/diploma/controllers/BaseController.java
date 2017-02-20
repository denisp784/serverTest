package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.BaseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class BaseController<T extends BaseModel> {

    BaseDao<T> objDao;

    BaseController(BaseDao<T> objDao) {
        this.objDao = objDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<T> add(@RequestBody T obj) throws Exception {
        objDao.saveOrUpdate(obj);
        return new ResponseEntity<T>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<T> update(@RequestBody T obj) {
        objDao.saveOrUpdate(obj);
        return new ResponseEntity<T>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<T>> get() {
        return new ResponseEntity<List<T>>(objDao.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> getById(@PathVariable("id") Long id) {
        System.out.println(objDao.list().size());
        return new ResponseEntity<T>(objDao.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<T>> delete(@PathVariable("id") Long id) {
        objDao.delete(id);
        return new ResponseEntity<List<T>>(objDao.list(), HttpStatus.OK);
    }
}
