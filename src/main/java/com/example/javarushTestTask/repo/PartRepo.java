package com.example.javarushTestTask.repo;

import com.example.javarushTestTask.domain.Part;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PartRepo extends CrudRepository<Part, Integer> {

    Part findByName(String name);

    @Override
    Optional<Part> findById(Integer integer);
}
