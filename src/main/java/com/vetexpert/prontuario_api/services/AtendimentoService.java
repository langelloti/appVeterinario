package com.vetexpert.prontuario_api.services;

import com.vetexpert.prontuario_api.model.Atendimento;

import com.vetexpert.prontuario_api.repositories.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    public Atendimento create(Atendimento dados){
        return repository.save(dados);
    }

    public List<Atendimento> findAll(){
        return repository.findAll();
    }

    public Atendimento update(Long id, Atendimento dados){
        dados.setId(id);
        return repository.save(dados);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
