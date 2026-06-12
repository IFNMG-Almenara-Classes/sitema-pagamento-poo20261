package edu.ifnmg.poo.sistemapagamento.controllers;

import edu.ifnmg.poo.sistemapagamento.models.Cliente;
import edu.ifnmg.poo.sistemapagamento.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/novo")
    public String novo(){
        return "clientes/novo";
    }

    @PostMapping("/")
    public String inserir(@RequestParam String nome, @RequestParam String cpf){
        Cliente cliente = new Cliente(nome, cpf);
        clienteRepository.save(cliente);
        return "redirect:/";
    }
}
