package com.forohub.forohub.domain.topico.repository;

import com.forohub.forohub.domain.topico.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
