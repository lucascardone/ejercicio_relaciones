package com.utn.ejercicio_db.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends EntidadBase {

    private String fecha;
    //(iniciado - preparacion - entregado)
    private String estado;
    private String horaEstimadaEntrega;
    //(delivery - retira)
    private String tipoEnvio;
    private Double total;

    @OneToOne(fetch = FetchType.EAGER)
    private Factura factura;

    @OneToMany(fetch = FetchType.EAGER)
    private List<DetallePedido> detallesPedidos = new ArrayList<>();
}
