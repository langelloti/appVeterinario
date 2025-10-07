package com.vetexpert.prontuario_api.services;
import com.vetexpert.prontuario_api.model.Veterinario;
import com.vetexpert.prontuario_api.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository repository;

    public Veterinario create(Veterinario dados) {
        return repository.save(dados);
    }

    public List<Veterinario> findAll() {
        return repository.findAll();
    }

    public Veterinario update(Long id, Veterinario dados) {
        dados.setId(id);
        return repository.save(dados);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
