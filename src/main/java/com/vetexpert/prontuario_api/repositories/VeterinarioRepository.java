package com.vetexpert.prontuario_api.repositories;

import com.vetexpert.prontuario_api.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Long> {
}
