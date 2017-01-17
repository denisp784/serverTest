package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.section.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping("/sections")
public class SectionController extends BaseController<Section> {

    @Autowired
    SectionController(BaseDao<Section> sectionDao) {
        super(sectionDao);
    }
}
