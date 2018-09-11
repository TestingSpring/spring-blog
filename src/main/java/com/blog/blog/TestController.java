package com.blog.blog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    @GetMapping("/lists")
    private String listOfNames() {
        return "lists";
    }


}
