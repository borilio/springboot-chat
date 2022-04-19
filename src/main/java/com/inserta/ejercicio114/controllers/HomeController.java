package com.inserta.ejercicio114.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ServletContext app;


    @RequestMapping("/")
    public String index() {
        List<String> chat = (List<String>) app.getAttribute("chat");
        if (chat == null) {
            chat = new ArrayList<>();
            app.setAttribute("chat", chat);
        }

        return "index";
    }

}