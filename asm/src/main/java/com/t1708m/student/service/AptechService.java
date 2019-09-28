package com.t1708m.student.service;

import com.t1708m.student.entity.Aptech;
import com.t1708m.student.repository.AptechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AptechService {

    @Autowired
    private AptechRepository aptechRepository;

    public List<Aptech> findAll(){
        return aptechRepository.findAll();
    }

    public Aptech save(Aptech aptech){
        aptechRepository.save(aptech);
        return  aptech;
    }


    public Aptech details(int id){
        Optional<Aptech> optionalGroup = aptechRepository.findById(id);

        if (!optionalGroup.isPresent()){
            return null;
        }
        Aptech group = optionalGroup.get();
        return group;
    }

}
