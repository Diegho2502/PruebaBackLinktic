package com.lib.poliza.repository;

import com.lib.poliza.entity.Asegurados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AseguradosRepository extends JpaRepository<Asegurados, Long> {
    Optional<Asegurados> findByNumeroIdentificacion(String numeroIdentificacion);

}
