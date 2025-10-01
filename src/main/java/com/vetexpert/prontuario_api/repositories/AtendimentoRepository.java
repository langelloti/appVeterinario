package com.vetexpert.prontuario_api.repositories;

import com.vetexpert.prontuario_api.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento,Long> {
}
