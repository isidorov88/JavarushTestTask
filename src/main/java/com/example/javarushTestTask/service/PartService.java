package com.example.javarushTestTask.service;

import com.example.javarushTestTask.domain.Part;
import com.example.javarushTestTask.repos.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartService {

    @Autowired
    private PartRepo partRepo;

    public boolean savePart(Part part){

        Part partfromBb = partRepo.findByName(part.getName());

        if(partfromBb != null){
            return false;
        }

        partRepo.save(part);

        return true;

    }
}
