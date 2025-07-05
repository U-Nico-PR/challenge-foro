package com.aluracursos.challenge_foro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @GetMapping
    public String hello(){
        return "Hola. Haciendo mi primer API REST de Back-End.";
    }
}
