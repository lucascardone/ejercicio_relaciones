package com.utn.ejercicio_db.entities;

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
public class DetallePedido extends EntidadBase {

    private int cantidad;
    private Double subtotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productoId")
    private Producto producto;

}
