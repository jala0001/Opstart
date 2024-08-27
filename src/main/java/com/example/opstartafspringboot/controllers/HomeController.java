package com.example.opstartafspringboot.controllers;

import com.example.opstartafspringboot.services.SomethingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private SomethingService somethingService;

    public HomeController(SomethingService somethingService) {
        this.somethingService = somethingService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", somethingService.getAllUsers());
        return "home/index";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam int age) {
        somethingService.addUser(name, age);
        return "redirect:/";
    }

    @PostMapping("/removeUser")
    public String removeUser(@RequestParam int personId) {
        somethingService.removeUser(personId);
        return "redirect:/";
    }
}
