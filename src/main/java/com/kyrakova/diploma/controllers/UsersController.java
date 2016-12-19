package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.user.User;
import com.kyrakova.diploma.models.user.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController<User> {

    @Autowired
    public UsersController(UserDaoImpl userDao) {
        super(userDao);
    }
}
