package com.example.SpringBootDemo;

import com.example.SpringBootDemo.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AlienRepo extends JpaRepository<Alien,Integer> {


    List<Alien> findByAname(String aname); //Query DSL

    List<Alien> findByAnameOrderByAid(String aname); //Query DSL

    @Query("from Alien where aname= :name")
    List<Alien> find(@Param("name") String aname);

}
