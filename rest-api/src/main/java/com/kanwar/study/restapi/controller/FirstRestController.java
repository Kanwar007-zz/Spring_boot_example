package com.kanwar.study.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

    @GetMapping(path="/first-rest")
    public String getFirstValue(){
        return "Vijay singh kanwar";
    }

}
