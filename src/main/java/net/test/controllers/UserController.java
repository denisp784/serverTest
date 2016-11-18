package net.test.controllers;

import net.test.models.role.Role;
import net.test.models.role.RoleDao;
import net.test.models.user.User;
import net.test.models.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        roleDao.saveOrUpdate(role);
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        roleDao.saveOrUpdate(role);
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "/getRoles", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<List<Role>>(roleDao.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.GET)
    public ResponseEntity deleteRole(@PathVariable("id") int id) {
        roleDao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userDao.saveOrUpdate(user);
        user = userDao.get(user.getId());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userDao.saveOrUpdate(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userDao.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public ResponseEntity deleteUser(@PathVariable("id") int id) {
        userDao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
