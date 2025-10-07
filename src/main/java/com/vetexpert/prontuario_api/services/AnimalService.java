package com.vetexpert.prontuario_api.services;
import com.vetexpert.prontuario_api.dto.DadosCadastroAnimal;
import com.vetexpert.prontuario_api.model.Animal;
import com.vetexpert.prontuario_api.repositories.AnimalRepository;
import com.vetexpert.prontuario_api.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {


    private AnimalRepository repository;
    private TutorRepository tutorRepository;

    public AnimalService(AnimalRepository repository, TutorRepository tutorRepository) {
        this.repository = repository;
        this.tutorRepository = tutorRepository;
    }

    public Animal create(DadosCadastroAnimal dados){
        var tutor = tutorRepository.findById(dados.tutorId()).orElseThrow(() -> new RuntimeException("Tutor não encontrado!"));

        var animal = new Animal();
        animal.setNome(dados.nome());
        animal.setRaca(dados.raca());
        animal.setPeso(dados.peso());
        animal.setIdade(dados.idade());
        animal.setTutor(tutor);

        return repository.save(animal);
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