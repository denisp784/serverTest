package com.kyrakova.diploma.main;

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
