package com.vetexpert.prontuario_api.controllers;


import com.vetexpert.prontuario_api.model.Tutor;
import com.vetexpert.prontuario_api.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //essa anotação indica que é uma classe Controller REST
@RequestMapping("/api/tutores") //url base para os métodos presentes na classe
public class TutorController {

    @Autowired //evita instanciamento manual e deixa o spring gerenciar
    private TutorService service;

    @PostMapping//faz com que as requisições POST caiam nesse método
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor create(@RequestBody Tutor dados){
        return service.create(dados);
    }//requestbody traduz o JSON da requisição e organiza o objeto conforme os setters
    //agora tudo nesse controller irá delegar funções para a camada de serviços

    @GetMapping//faz com que as requisições GET caiam nesse método
    @ResponseStatus(HttpStatus.OK)
    public List<Tutor> findAll(){
        return service.findAll();//delega a busca para a camada service
    }

    @PutMapping("/{id}")// esse método tendo o "/{id}" adiciona no final do caminho http o direcionamento, garantindo que o PUT seja aplicado apenas ao tutor de id correspondente
    @ResponseStatus(HttpStatus.OK)
    public Tutor update(@PathVariable Long id, @RequestBody Tutor dados){//o path variable identifica qual tutor será atualizado e o request body fornece os novos dados para atualização
        return service.update(id, dados);
    }

    @DeleteMapping("/{id}")// mesma ideia do id de put mapping, mas dessa vez garantindo o método DELETE ao usuário de id correspondente
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){//como não há uma atualização e sim uma exclusão, ele apenas exclui tudo que encontra no id
       service.deleteById(id); //aplica o método delete ao id correspondente com a camada service
    }
}
