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
public class Domicilio extends EntidadBase {
    private String calle;
    private String numero;
    private String localidad;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
}
