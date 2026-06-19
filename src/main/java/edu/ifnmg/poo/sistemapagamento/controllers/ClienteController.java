package edu.ifnmg.poo.sistemapagamento.controllers;

import edu.ifnmg.poo.sistemapagamento.dtos.ListarClienteResponse;
import edu.ifnmg.poo.sistemapagamento.dtos.NovoClienteRequest;
import edu.ifnmg.poo.sistemapagamento.models.Cliente;
import edu.ifnmg.poo.sistemapagamento.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new NovoClienteRequest());

        return "clientes/novo";
    }

    @PostMapping("/")
    public String inserir(@Valid NovoClienteRequest request,
                          BindingResult result,
                          Model model) {
        if(result.hasErrors()){
            model.addAttribute("cliente", request);
            model.addAttribute("errors", result.getAllErrors());
            return "clientes/novo";
        }
        Cliente cliente = new Cliente(request.getNome(), request.getCpf());
        clienteRepository.save(cliente);
        return "redirect:/cliente/";
    }

    @GetMapping("/")
    public String listar(Model model){
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/listar";
    }

    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        ListarClienteResponse response = ListarClienteResponse.fromEntity(cliente);
        model.addAttribute("cliente", response);
        return "clientes/detalhes";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return "redirect:/cliente/";
    }
}
