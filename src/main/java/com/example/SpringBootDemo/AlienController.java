package com.example.SpringBootDemo;


import com.example.SpringBootDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {


    @Autowired
    private AlienRepo alienRepo;

    @GetMapping("getAliensNew")
    public List<Alien> getAliensNew()
    {
      List<Alien> aliens =   alienRepo.findAll();
      System.out.println("After EXECUTIONS...");
      return aliens;
    }

    @GetMapping("getAlienNew/{aid}")
    public List<Alien> getAlienNew(@PathVariable("aid") int aid)
    {
        long startTime = System.currentTimeMillis();
        List<Alien> aliens = alienRepo.findByIdNew(aid);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(executionTime +"milliseconds");
       return aliens;
    }


    @PostMapping("alien")
    public Alien addAlien(Alien alien)
    {
        alienRepo.save(alien);

        return alien;
    }


}
