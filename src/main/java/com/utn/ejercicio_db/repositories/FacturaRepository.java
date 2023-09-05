package com.utn.ejercicio_db.repositories;

import com.utn.ejercicio_db.entities.Cliente;
import com.utn.ejercicio_db.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
