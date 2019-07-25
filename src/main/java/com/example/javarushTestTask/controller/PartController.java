package com.example.javarushTestTask.controller;

import com.example.javarushTestTask.domain.Part;
import com.example.javarushTestTask.repo.PartRepo;
import com.example.javarushTestTask.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PartController {

    @Autowired
    private PartRepo partRepo;

    @Autowired
    private PartService partService;


    @GetMapping("/partsList")
    public String getPartsList(
            Model model
    ){

        partService.partList(model);

        return "partsList";
    }

    @GetMapping("/sorted")
    public String getSortedPartsList(
            Model model
    ){

        partService.partList(model);

        return "sorted";
    }

    @GetMapping("/sortedReverse")
    public String getSortedReversePartsList(
            Model model
    ){

        partService.partList(model);

        return "sortedReverse";
    }

    @GetMapping
    public String addition(){
        return "add";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String name,
            @RequestParam String necessary,
            @RequestParam String amount
            ){

        partService.addPart(name, necessary, amount);

        return ("redirect:/partsList");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        partRepo.deleteById(id);
        return "redirect:/partsList";
    }

    @GetMapping("/update")
    public String updatePage(
            @RequestParam Integer id,
            Model model
    ){
        Part part = partRepo.findById(id).get();
        model.addAttribute("name", part.getName());
        model.addAttribute("necessary", part.getNecessary());
        model.addAttribute("amount", part.getAmount());

        return "update";
    }

    @PostMapping("/update")
    public String updatePart(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String necessary,
            @RequestParam String amount
    ){
        partService.updatePart(id, name, necessary, amount);

        return "redirect:/partsList";
    }

    @GetMapping("/found")
    public String showFound(
            Model model,
            @RequestParam(required = false, defaultValue = "") String name
    ){
        Part part = null;

        if(name!=null || !name.isEmpty()){
            part = partRepo.findByName(name.trim());
        }

        model.addAttribute("part", part);
        return "found";
    }


}
