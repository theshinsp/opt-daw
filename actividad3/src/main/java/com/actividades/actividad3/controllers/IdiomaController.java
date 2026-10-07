package com.actividades.actividad3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IdiomaController {

    @GetMapping("/elegir")
    public String elegir(@RequestParam(name = "idioma", required = false
            , defaultValue = "english") String idioma) {
        switch (idioma) {
            case "spanish":
                return "redirect:/spanish.html";
            case "french":
                return "redirect:/french.html";
            case "german":
                return "redirect:/german.html";
            case "english":
                return "redirect:/english.html";
            default:
                return "redirect:/english.html";
        }
    }
}
