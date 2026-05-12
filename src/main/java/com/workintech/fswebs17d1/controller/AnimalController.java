package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullname;

    @GetMapping
    public List<Animal> findAll() {
        return animals.values()
                .stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Integer id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable Integer id) {
        return animals.remove(id);
    }
}