
package com.vetexpert.prontuario_api.controllers;

import com.vetexpert.prontuario_api.model.Animal;
import com.vetexpert.prontuario_api.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody Animal dados) {
        repository.save(dados);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@PathVariable Long id, @RequestBody Animal dados) {
        dados.setId(id);
        repository.save(dados);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> listar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
