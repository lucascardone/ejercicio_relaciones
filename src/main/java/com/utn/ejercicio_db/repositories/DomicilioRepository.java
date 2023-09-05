package com.utn.ejercicio_db.repositories;

import com.utn.ejercicio_db.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
