package com.vetexpert.prontuario_api.services;

import com.vetexpert.prontuario_api.model.Animal;
import com.vetexpert.prontuario_api.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public Animal save(Animal dados){
        return repository.save(dados);
    }

    public List<Animal> findAll(){
        return repository.findAll();
    }

    public Animal update(Long id, Animal dados){
        dados.setId(id);
        return repository.save(dados);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}

//preste bastante atenção pois seus controllers sempre irão chamar esses métodos, nomeie com sabedoria