package com.utn.ejercicio_db.entities;

import com.utn.ejercicio_db.utils.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
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
