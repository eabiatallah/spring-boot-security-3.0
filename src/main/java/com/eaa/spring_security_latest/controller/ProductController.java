package com.eaa.spring_security_latest.controller;

import com.eaa.spring_security_latest.entity.UserInfo;
import com.eaa.spring_security_latest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to this endpoint, is not secure";
    }

    @GetMapping("welcome2")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String products(){
        return "Welcome to this secured endpoint !";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }
}
