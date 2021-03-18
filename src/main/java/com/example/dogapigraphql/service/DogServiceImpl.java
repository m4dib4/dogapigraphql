package com.example.dogapigraphql.service;

import com.example.dogapigraphql.entity.Dog;
import com.example.dogapigraphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    public String retrieveDogBreedById(Long id) {
        return (String) dogRepository.findBreedById(id);
    }

    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }

    public String retrieveDogBreedById(int id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById((long) id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
}
