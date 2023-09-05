package com.utn.ejercicio_db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends EntidadBase{
    // (Manufacturada - insumo)
    private String tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private int stockMinimo;
    private int stockActual;
    private String unidadMedida;
    private String receta;
    private String foto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rubroId")
    private Rubro rubro;
}
