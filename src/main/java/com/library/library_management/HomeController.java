package com.library.library_management;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome to the Library Management System!");
        return "home"; // اسم الملف HTML اللي هيتم عرضه , in resources/templates
    }
}
