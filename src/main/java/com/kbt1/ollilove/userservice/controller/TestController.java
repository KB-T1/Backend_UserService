package com.kbt1.ollilove.userservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(name = "Test", description = "testAPI")
public class TestController {
    @GetMapping("/name")
    public String Test() {
        return "hi";
    }
}