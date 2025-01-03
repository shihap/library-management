package com.library.library_management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        return "This is test1 using jwt";
    }

    @GetMapping("/test2")
    public String test2() {
        return "This is test2 using jwt";
    }

}
