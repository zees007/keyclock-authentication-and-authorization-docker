package com.devzees.keyclock.controllers;

/**
 * Author: Zeeshan Adil
 * User:mhmdz
 * Date:30-08-2024
 * Time:01:12
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello, public!";
    }

    @GetMapping("/user/hello")
    @PreAuthorize("hasRole('USER')")
    public String userHello() {
        return "Hello, user!";
    }

    @GetMapping("/admin/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminHello() {
        return "Hello, admin!";
    }

}