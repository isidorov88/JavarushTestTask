package com.example.javarushTestTask.service;

import com.example.javarushTestTask.domain.Part;
import com.example.javarushTestTask.repo.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Iterator;

@Service
public class PartService {

    @Autowired
    PartRepo partRepo;

    public boolean addPart(
            String name,
            String necessary,
            String amount
    ){
        Part partFromDb = partRepo.findByName(name);

        if(name.isEmpty()||name==null){
            return false;
        }

        if(partFromDb!=null&&partFromDb.getName().equals(name)){
            return false;
        }


        Boolean temp = necessary.equals("Да")?true:false;
        Part part = new Part(name, temp, amount.isEmpty()? 0 : Integer.valueOf(amount));
        partRepo.save(part);

        return true;

    }

    public void updatePart(
            Integer id,
            String name,
            String necessary,
            String amount
    ){
        Part partFromDb = partRepo.findByName(name);
        boolean partExists = partFromDb!=null;

        Part part = partRepo.findById(id).get();
        boolean isNameChanged = (!partExists && name!=null && !name.isEmpty() && !name.equals(part.getName()) );

        if(isNameChanged)
            part.setName(name);

        boolean newNecessary;
        if(necessary.equals("Да")){
            newNecessary = true;}
        else {newNecessary = false;}

        boolean isNecessaryChanged = !(part.getNecessary() == newNecessary);

        if(isNecessaryChanged)
            part.setNecessary(newNecessary);

        boolean isAmountValid = !amount.isEmpty();
        Integer newAmount = isAmountValid? Integer.valueOf(amount) : 0;
        boolean isAmountChanged = !(newAmount.equals(part.getAmount()));

        if(isAmountChanged)
            part.setAmount(newAmount);

        partRepo.save(part);
    }

    public void partList(Model model){
        Iterable<Part> parts = partRepo.findAll();


        Iterator<Part> partIterator = parts.iterator();


        int minNecessaryAmount =0;

        while(partIterator.hasNext()){
            Part part = partIterator.next();

            if(part.getNecessary() && part.getAmount()==0){

                break;
            }

            if(part.getNecessary()&& part.getAmount()>0){

                if(minNecessaryAmount>part.getAmount() || minNecessaryAmount ==0){
                    minNecessaryAmount = part.getAmount();
                }
            }

        }


        model.addAttribute("necessaryAmount", minNecessaryAmount);

        model.addAttribute("parts", parts);

    }

}
