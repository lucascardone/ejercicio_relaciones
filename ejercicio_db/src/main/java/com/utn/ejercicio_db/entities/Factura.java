package com.utn.ejercicio_db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends EntidadBase {
    //DateTime
    private String fecha;
    private int numero;
    private Double descuento;
    //(efectivo - etc)
    private String formaPago;
    private int total;

    @Override
    public String toString() {
        return "Factura{" +
                "fecha=" + fecha +
                ", numero=" + numero +
                ", descuento=" + descuento +
                ", formaPago='" + formaPago + '\'' +
                ", total=" + total +
                '}';
    }
}
