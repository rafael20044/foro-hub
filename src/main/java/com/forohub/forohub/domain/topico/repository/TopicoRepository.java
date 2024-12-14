package com.forohub.forohub.domain.topico.repository;

import com.forohub.forohub.domain.topico.entity.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico t WHERE t.estado <> com.forohub.forohub.domain.estado.Estado.INACTIVO AND t.estado " +
            "<> com.forohub.forohub.domain.estado.Estado.RESUELTO")
    Page<Topico> pageAll(Pageable pageable);
}
