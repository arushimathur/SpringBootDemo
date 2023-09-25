package com.example.SpringBootDemo;


import com.example.SpringBootDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private AlienRepo alienRepo;

    @ModelAttribute
    public void modelData(Model m)
    {
        m.addAttribute("name","Aliens");
    }

    @RequestMapping("/")
    public String home()
    {
        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m)
    {
        m.addAttribute("result",alienRepo.findAll());
        return "showAliens";
    }

    @GetMapping("getAlienById")
    public String getAlien(@RequestParam int aid, Model m)
    {

        // can only pass primary key with getOne
        m.addAttribute("result",alienRepo.getOne(aid));

        return "showAliens";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String aname, Model m)
    {

        // can only pass primary key with getOne
        m.addAttribute("result",alienRepo.findByAname(aname));

        return "showAliens";
    }

    @GetMapping("getAlienByNameOrderById")
    public String getAlienByNameOrderById(@RequestParam String aname, Model m)
    {

        m.addAttribute("result",alienRepo.findByAnameOrderByAid(aname));

        return "showAliens";
    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("result") Alien a)
    {
        alienRepo.save(a);
        return "showAliens";
    }

}
