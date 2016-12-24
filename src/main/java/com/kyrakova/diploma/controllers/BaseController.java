package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class BaseController<T extends BaseModel> {

    BaseDao<T> objDao;

    BaseController(BaseDao<T> objDao) {
        this.objDao = objDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity delete(@PathVariable("id") int id) {
        objDao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
