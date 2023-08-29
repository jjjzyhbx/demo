package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Controller {

    @GetMapping("/hello")
    String test(){
        return "0000";
    }
//    @RequestMapping("/aaa")
//    public String test01(){
//        return "aaa";
//    }
    @GetMapping("/aaa")
    public RedirectView index() {
        return new RedirectView("aaa.html");
    }
}
