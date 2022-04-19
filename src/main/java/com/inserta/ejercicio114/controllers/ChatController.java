package com.inserta.ejercicio114.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ServletContext app;


    @RequestMapping("/enviar")
    public String chat(
            @RequestParam String usuario,
            @RequestParam String mensaje,
            HttpSession session){
        System.out.println("Usuario: " + usuario + " Mensaje: " + mensaje);
        session.setAttribute("usuario", usuario);

        List<String> chat = (List<String>) app.getAttribute("chat");
        chat.add("Usuario: " + usuario + " Mensaje: " + mensaje);
        app.setAttribute("chat", chat);

        return "index";
    }

}
