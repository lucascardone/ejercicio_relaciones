package com.utn.ejercicio_db.entities;

import java.util.ArrayList;
import java.util.List;

import com.utn.ejercicio_db.utils.Estado;
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
    private Estado estado;
    private String horaEstimadaEntrega;
    //(delivery - retira)
    private String tipoEnvio;
    private Double total;

    @OneToOne(fetch = FetchType.EAGER)
    private Factura factura;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedidosId")
    private List<DetallePedido> detallesPedidos = new ArrayList<>();
}
