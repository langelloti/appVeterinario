package com.vetexpert.prontuario_api.controllers;
import com.vetexpert.prontuario_api.dto.DadosCadastroAnimal;
import com.vetexpert.prontuario_api.model.Animal;
import com.vetexpert.prontuario_api.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    private AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal create(@RequestBody DadosCadastroAnimal dados) {
       return service.create(dados);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(@PathVariable Long id, @RequestBody Animal dados) {
       return service.update(id, dados);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
