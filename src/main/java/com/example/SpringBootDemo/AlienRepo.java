package com.example.SpringBootDemo;

import com.example.SpringBootDemo.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien,Integer> {


    List<Alien> findByAname(String aname); //Query DSL

    List<Alien> findByAnameOrderByAid(String aname); //Query DSL
}
