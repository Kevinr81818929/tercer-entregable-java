package com.kevin.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.cajero.entity.Cliente;
import com.kevin.cajero.entity.Cuenta;
import java.util.Optional;
import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findfindByNumero(String numero);
    List<Cuenta> finfindByCliente(Cliente cliente);
}
