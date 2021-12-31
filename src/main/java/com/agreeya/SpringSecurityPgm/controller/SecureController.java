package com.agreeya.SpringSecurityPgm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home1")
public class SecureController {

    @GetMapping("/view1")
    public String viewDetails()
    {
        return "View Employee";
    }
    @GetMapping("/homePage")
    public String homePage()
    {
        return "Home Page";
    }

    @GetMapping("/addEmployee")
    public String addDetails()
    {
        return "Add Employee";
    }

    @GetMapping("/addBranches")
    public String addBranches()
    {
        return "Add Branches";
    }

    @GetMapping("/viewBranches")
    public String viewBranches()
    {
        return "View Branches";
    }

    @GetMapping("/ceoCall")
    public String ceoCall()
    {
        return "CEO Pages";
    }




}
