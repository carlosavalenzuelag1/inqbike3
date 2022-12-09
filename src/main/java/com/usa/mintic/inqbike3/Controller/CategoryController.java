package com.usa.mintic.inqbike3.Controller;


import com.usa.mintic.inqbike3.entities.Category;
import com.usa.mintic.inqbike3.entities.Quadbike;
import com.usa.mintic.inqbike3.service.CategoryService;
import com.usa.mintic.inqbike3.service.QuadbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category p){
        return categoryService.save(p);
    }

}


