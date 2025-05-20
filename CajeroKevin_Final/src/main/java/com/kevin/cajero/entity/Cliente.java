package com.kevin.cajero.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    @Column(unique = true)
    private String identificacion;
    private String pin;
    private boolean bloqueado;
    private int intentosFallidos;
    @OneToMany(mappedBy= "cliente", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;


    //Metodos que necesitabas para intentos

    public int getIntentos() {
        return this.intentosFallidos;
    }

    public int setIntentos(int intentos) {
        return this.intentosFallidos = intentos;
    }


    public void incrementarIntentos() {
        this.intentosFallidos++;
    }

    public void reiniciarIntentos() {
        this.intentosFallidos = 0;
    }

    public String getNombreCompleto() {
        return this.nombre;
    }


}