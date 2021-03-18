package com.example.dogapigraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.dogapigraphql.entity.Dog;
import com.example.dogapigraphql.exception.DogNotFoundException;
import com.example.dogapigraphql.repository.DogRepository;

import java.util.Optional;

public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
