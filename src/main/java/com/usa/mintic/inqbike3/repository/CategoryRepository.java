package com.usa.mintic.inqbike3.repository;

import com.usa.mintic.inqbike3.entities.Category;
import com.usa.mintic.inqbike3.entities.Quadbike;
import com.usa.mintic.inqbike3.repository.crudRepository.CategoryCrudRepository;
import com.usa.mintic.inqbike3.repository.crudRepository.QuadbikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){

        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){

        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c){

        return categoryCrudRepository.save(c);
    }

    public void delete(Category c){

        categoryCrudRepository.delete(c);
    }


}
