package br.edu.unicid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unicid.domain.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {

}
