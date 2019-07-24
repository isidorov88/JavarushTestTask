package com.example.javarushTestTask.controller;

import com.example.javarushTestTask.domain.Part;
import com.example.javarushTestTask.repos.PartRepo;
import com.example.javarushTestTask.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    PartRepo partRepo;

    @Autowired
    PartService partService;

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/addingParts")
    public String addingParts(Model model){
        return "addingParts";
    }

    @PostMapping("/addingParts")
    public String addPart(
            @RequestParam String name,
            @RequestParam String isNecessary,
            @RequestParam String amount,
            Model model
            ){

        Part part = new Part();
        part.setName(name.trim());
        part.setNecessariness(isNecessary);
        part.setAmount(Integer.valueOf(amount));

        model.addAttribute("part", part);

        partService.savePart(part);

        return "addingParts";
    }

    @GetMapping("/partList")
    public String watchList(Model model){
        Iterable<Part> parts = partRepo.findAll();

        model.addAttribute("parts", parts);

        return "partList";
    }



}