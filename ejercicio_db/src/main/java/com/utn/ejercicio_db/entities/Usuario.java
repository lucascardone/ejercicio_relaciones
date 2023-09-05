package com.utn.ejercicio_db.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario extends EntidadBase {
    private String nombre;
    private String password;
    private String rol;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedidosId")
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public String toString() {
        return "Usuario{" +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }

}
