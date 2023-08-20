package com.GabreuDev.AteMil.Repositories;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrecaoRepository extends JpaRepository<Correcao, Long> {
    List<Correcao> findAllByStatus(StatusEnum statusEnum);
}
