package com.libraryProd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/library")
public class LibraryController {
    @GetMapping()
    private String showMainScreen(){
        return "mainScreen";
    }
}
