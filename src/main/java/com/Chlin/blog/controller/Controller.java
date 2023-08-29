package com.Chlin.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class Controller {
    @ResponseBody
    @GetMapping("/hello")
    String test(){
        return "0000";
    }

//    @GetMapping("/")
//    public RedirectView index() {
//        return new RedirectView("index.html");
//    }
}
