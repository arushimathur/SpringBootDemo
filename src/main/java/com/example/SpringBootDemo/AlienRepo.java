package com.example.SpringBootDemo;

import com.example.SpringBootDemo.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien,Integer> {



}
