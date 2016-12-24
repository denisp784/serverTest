package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.modelPropertyValue.ModelPropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelPropertyValues")
public class ModelPropertyValueController extends BaseController<ModelPropertyValue> {

    @Autowired
    ModelPropertyValueController(BaseDao<ModelPropertyValue> propertyDao) {
        super(propertyDao);
    }
}
