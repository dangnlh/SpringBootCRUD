package com.myconpany;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("")
    public String showHomePage(){
        return "index" ;
    }
}
