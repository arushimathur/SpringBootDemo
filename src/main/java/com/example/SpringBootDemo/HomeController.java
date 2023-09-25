package com.example.SpringBootDemo;


import com.example.SpringBootDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    public String getAlienById(@RequestParam int aid, Model m)
    {

        m.addAttribute("result",alienRepo.findById(aid));

        return "showAliens";
    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("result") Alien a)
    {
        alienRepo.save(a);
        return "showAliens";
    }

}
