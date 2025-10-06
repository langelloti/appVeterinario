package com.vetexpert.prontuario_api.services;


import com.vetexpert.prontuario_api.model.Tutor;
import com.vetexpert.prontuario_api.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired //Agora quem injeta o repository são os services
    private TutorRepository repository;

    public Tutor save(Tutor dados){
        //movemos toda a lógica do negócio para services visando futuras manutenções envolvendo
        //regras de negócios
        return repository.save(dados);
    }

    public List<Tutor> findById(){
        return repository.findAll();
    }

    public Tutor add(Long id, Tutor dados){
        dados.setId(id);
        return repository.save(dados);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
