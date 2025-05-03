package com.example.demo.controllers.home;

import com.example.demo.controllers.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController {


    @GetMapping("/")
    public ResponseEntity<?> get() {
        return ok();
    }
}
