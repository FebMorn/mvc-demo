package com.sl.basic.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/base")
public class BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
