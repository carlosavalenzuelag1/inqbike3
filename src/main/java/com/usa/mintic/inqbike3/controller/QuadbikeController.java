package com.usa.mintic.inqbike3.controller;


import com.usa.mintic.inqbike3.entities.Quadbike;
import com.usa.mintic.inqbike3.service.QuadbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Quadbike")
public class QuadbikeController {


    @Autowired
    private QuadbikeService quadbikeService;

    @GetMapping("/all")
    public List<Quadbike> getAll(){

        return quadbikeService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike p){

        return quadbikeService.save(p);
    }

}
