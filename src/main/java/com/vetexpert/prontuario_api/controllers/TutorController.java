package com.vetexpert.prontuario_api.controllers;


import com.vetexpert.prontuario_api.model.Tutor;
import com.vetexpert.prontuario_api.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //essa anotação indica que é uma classe Controller REST
@RequestMapping("/api/tutores") //url base para os métodos presentes na classe
public class TutorController {

    @Autowired //evita instanciamento manual e deixa o spring gerenciar
    private TutorRepository repository;

    @PostMapping//faz com que as requisições POST caiam nesse método
    public void cadastrar(@RequestBody Tutor dados){
        repository.save(dados);
    }//requestbody traduz o JSON da requisição e organiza o objeto conforme os setters

    @GetMapping//faz com que as requisições GET caiam nesse método
    public List<Tutor> listar(){
        return repository.findAll();//usa o repositório para buscar todos os registros
    }

    @PutMapping("/{id}")// esse método tendo o "/{id}" adiciona no final do caminho http o direcionamento, garantindo que o PUT seja aplicado apenas ao tutor de id correspondente
    public void atualizar(@PathVariable Long id, @RequestBody Tutor dados){//o path variable identifica qual tutor será atualizado e o request body fornece os novos dados para atualização
        dados.setId(id);//garante que o id do objeto seja o mesmo da url
        repository.save(dados);//salva os dados atualizados no repositório
    }

    @DeleteMapping("/{id}")// mesma ideia do id de put mapping, mas dessa vez garantindo o método DELETE ao usuário de id correspondente
    public void deleteById(@PathVariable Long id){//como não há uma atualização e sim uma exclusão, ele apenas exclui tudo que encontra no id
        repository.deleteById(id); //aplica o método delete ao id correspondente no repositório
    }
}
