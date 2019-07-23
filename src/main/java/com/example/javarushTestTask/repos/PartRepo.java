package com.example.javarushTestTask.repos;

import com.example.javarushTestTask.domain.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepo extends CrudRepository<Part, Integer> {
}
