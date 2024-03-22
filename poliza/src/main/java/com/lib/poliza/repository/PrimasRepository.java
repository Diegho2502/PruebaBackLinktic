package com.lib.poliza.repository;

import com.lib.poliza.entity.Primas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimasRepository extends JpaRepository<Primas, Long> {

    @Query(value = "select p from Primas p where :edad between p.edadMinima and p.edadMaxima")
    List<Primas> consultaPrimas(@Param("edad") Integer edad);
}
