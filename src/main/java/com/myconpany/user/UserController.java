package com.myconpany.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private  UserService service ;

    @GetMapping("/user")
    public String showUserList(Model model){
        List<User> listUser = service.listAll() ;
        model.addAttribute("listUsers" ,listUser );
        return "users" ;
    }

    @GetMapping("/users/new")
    public String newFormUser (Model model){
        model.addAttribute("user" , new User());
        return "user_form" ;
    }
}
