package edu.ifnmg.poo.sistemapagamento.repository;

import edu.ifnmg.poo.sistemapagamento.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
