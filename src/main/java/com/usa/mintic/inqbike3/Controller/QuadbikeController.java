package com.usa.mintic.inqbike3.Controller;


import com.usa.mintic.inqbike3.entities.Quadbike;
import com.usa.mintic.inqbike3.service.QuadbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quadbike")
public class QuadbikeController {


    @Autowired
    private QuadbikeService quadbikeService;

    @GetMapping("/all")
    public List<Quadbike> getAll(){
        return quadbikeService.getAll();
    }

    @PostMapping("/save")
    public Quadbike save(@RequestBody Quadbike p){
        return quadbikeService.save(p);
    }

}
