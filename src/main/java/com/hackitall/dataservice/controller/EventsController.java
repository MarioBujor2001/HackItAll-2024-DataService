package com.hackitall.dataservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class EventsController {
    @GetMapping()
    String sayHello(){
        return "Hello";
    }
}
