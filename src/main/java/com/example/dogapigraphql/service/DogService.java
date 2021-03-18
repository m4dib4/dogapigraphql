package com.example.dogapigraphql.service;

import com.example.dogapigraphql.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(int id);
    List<String> retrieveDogNames();
}

