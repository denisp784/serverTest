package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.role.Role;
import com.kyrakova.diploma.models.role.RoleDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolesController extends BaseController<Role> {

    @Autowired
    public RolesController(RoleDaoImpl roleDao) {
        super(roleDao);
    }
}
