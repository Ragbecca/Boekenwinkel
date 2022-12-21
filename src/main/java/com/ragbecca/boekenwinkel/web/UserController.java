package com.ragbecca.boekenwinkel.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/test")
    String testController() {
        return "De test werkt!";
    }
}
