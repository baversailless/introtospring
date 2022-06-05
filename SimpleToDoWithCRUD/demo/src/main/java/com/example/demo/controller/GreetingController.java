package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//localhost:8080/greeting?name=Something
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam("name") String name,
                           Model model) {

        model.addAttribute("name", name);
        return "greetingPage";
    }
}
