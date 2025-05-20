package com.kevin.cajero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kevin.cajero.service.ClienteService;
import com.kevin.cajero.service.CuentaService;
import com.kevin.cajero.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kevin.cajero.entity.Cuenta;
import com.kevin.cajero.entity.TipoCuenta;



@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")

public class AdminController {

    private final ClienteService clienteService;
    private final CuentaService cuentaService;

    @GetMapping
    public String adminHome() {
        return "admin/index";
    }

    @GetMapping("/crear-cliente")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "admin/crear-cliente";
    }

    @PostMapping("/crear-cliente")
    public String crearCliente(@ModelAttribute Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "redirect:/admin";
    }

    @PostMapping("/crear-cuenta")
    public String mostrarFormularCuenta(Model model) {
       model.addAttribute("cuenta", new Cuenta()); 
        return "admin/crear-cuenta";
    }

    @PostMapping("/crear-cuenta")
    public String crearCuenta(@RequestParam String identificacion,
    @RequestParam String numero,
    @RequestParam TipoCuenta tipo,
    @RequestParam double saldo) {
        Cliente cliente = clienteService.buscarPorIdentificacion(identificacion).orElseThrow();
        cuentaService.crearCuenta(cliente, numero, tipo, saldo);
        return "redirect:/admin";
    }
     
        @GetMapping("/desbloquear")
    public String mostrarDesbloqueo() {
        return "admin/desbloquear";
    }

    @PostMapping("/desbloquear")
    public String desbloquearCuenta(@RequestParam String identificacion,
    @RequestParam String nuevoPIN) {
        clienteService.desbloquearCliente(identificacion, nuevoPIN);
        return "redirect:/admin";
    }   

}


    

