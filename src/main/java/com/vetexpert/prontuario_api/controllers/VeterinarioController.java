package com.vetexpert.prontuario_api.controllers;

import com.vetexpert.prontuario_api.model.Veterinario;
import com.vetexpert.prontuario_api.repositories.VeterinarioRepository;
import com.vetexpert.prontuario_api.services.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service; //se atentar para utilizar a camada certa para injeção
                                        //de métodos, você bateu cabeça pois estava chamando
                                        // VeterinarioRepository



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veterinario save(@RequestBody Veterinario dados){
        return service.save(dados);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veterinario> findById(){
        return service.findById();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Veterinario add(@PathVariable Long id, @RequestBody Veterinario dados){
        return service.add(id, dados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
