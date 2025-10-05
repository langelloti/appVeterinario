package com.vetexpert.prontuario_api.controllers;

import com.vetexpert.prontuario_api.model.Veterinario;
import com.vetexpert.prontuario_api.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody Veterinario dados){
        repository.save(dados);
    }

    @GetMapping
    public List<Veterinario> listar(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Veterinario dados){
        dados.setId(id);
        repository.save(dados);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
