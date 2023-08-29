package Blogproject.springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//ReponseBody converts the java object to json
public class HelloWorldController {

    //Http get request
    @GetMapping("/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }

}
