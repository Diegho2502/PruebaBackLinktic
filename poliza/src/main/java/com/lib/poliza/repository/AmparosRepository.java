package com.lib.poliza.repository;

import com.lib.poliza.entity.Amparos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmparosRepository extends JpaRepository<Amparos, Long> {

    @Query("select a from Amparos a where a.id in(:codigoList)")
    List<Amparos> findAllByCodigos(@Param("codigoList") List<Integer> codigoList);
}
