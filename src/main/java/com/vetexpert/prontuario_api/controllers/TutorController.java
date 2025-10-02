package com.vetexpert.prontuario_api.controllers;


import com.vetexpert.prontuario_api.model.Tutor;
import com.vetexpert.prontuario_api.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //essa anotação indica que é uma classe Controller REST
@RequestMapping("/api/tutores") //url base para os métodos presentes na classe
public class TutorController {

    @Autowired //evita instanciamento manual e deixa o spring gerenciar
    private TutorRepository repository;

    @PostMapping//faz com que as requisições POST caiam nesse método
    public void cadastrar(@RequestBody Tutor dados){
        repository.save(dados);
    }//requestbody traduz o JSON da requisição e organiza o objeto de acordo com os setters
}
