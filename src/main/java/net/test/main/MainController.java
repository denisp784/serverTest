package net.test.main;

import com.google.gson.Gson;
import net.test.models.role.Role;
import net.test.models.role.RoleDao;
import net.test.models.user.User;
import net.test.models.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> mainRequest() throws Exception {
        return new ResponseEntity<String>("Server was started!", HttpStatus.OK);
    }
}
