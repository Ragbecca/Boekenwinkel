package com.ragbecca.boekenwinkel.web;

import com.ragbecca.boekenwinkel.entities.User;
import com.ragbecca.boekenwinkel.entities.vm.UserVM;
import com.ragbecca.boekenwinkel.validation.CurrentUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @GetMapping("/test")
    String testController() {
        return "De test werkt!";
    }

    @GetMapping("/login")
    String loginControllerTest() {
        return "login!";
    }

    @PostMapping("/login")
    UserVM handleLogin(@CurrentUser User loggedInUser) {
        return new UserVM(loggedInUser);
    }
}
