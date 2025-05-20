package com.kevin.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.kevin.cajero.entity.Cuenta;
import com.kevin.cajero.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento>  findByCuenta(Cuenta cuenta);
    List <Movimiento> findByCuenta_NumeroOrderByFechaDesc(String numeroCuenta);
    List<Movimiento> findByCuentaOrderByFechaDesc(Cuenta cuenta);
}
