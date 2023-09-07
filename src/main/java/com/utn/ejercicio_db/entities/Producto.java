package com.utn.ejercicio_db.entities;

import com.utn.ejercicio_db.utils.Tipo;
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
public class Producto extends EntidadBase{
    // (Manufacturada - insumo)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
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
    @JoinColumn(name = "productoId")
    private Rubro rubro;
}
