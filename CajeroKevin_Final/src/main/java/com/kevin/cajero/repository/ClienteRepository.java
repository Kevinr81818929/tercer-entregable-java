package com.kevin.cajero.repository;

import java.util.Optional;

import com.kevin.cajero.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByIdentificacion(String identificacion);
}
