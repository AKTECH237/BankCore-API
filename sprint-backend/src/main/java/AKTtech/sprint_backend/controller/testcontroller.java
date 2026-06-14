package AKTtech.sprint_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class testcontroller {

    @GetMapping(path = "string")

    public static String getString(){

        return "Hello bank API";
    }
}
