package com.vetexpert.prontuario_api.controllers;


import com.vetexpert.prontuario_api.model.Tutor;
import com.vetexpert.prontuario_api.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {

    @Autowired
    private TutorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody Tutor dados){
        repository.save(dados);
    }
}
