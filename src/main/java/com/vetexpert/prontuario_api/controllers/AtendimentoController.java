package com.vetexpert.prontuario_api.controllers;
import com.vetexpert.prontuario_api.model.Atendimento;
import com.vetexpert.prontuario_api.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atendimento cadastrar(@RequestBody Atendimento dados){
        return service.save(dados);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Atendimento update(@PathVariable Long id, @RequestBody Atendimento dados){
        return service.update(id, dados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Atendimento> findAll(){
        return service.findAll();
    }
}
