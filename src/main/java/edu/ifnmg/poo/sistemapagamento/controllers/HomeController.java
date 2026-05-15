package edu.ifnmg.poo.sistemapagamento.controllers;

import edu.ifnmg.poo.sistemapagamento.models.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        Cliente cliente = new Cliente(1, "Carlos", "123");

        model.addAttribute("cliente", cliente);
        return "home";
    }

}
