package com.usa.mintic.inqbike3.service;


import com.usa.mintic.inqbike3.entities.Category;
import com.usa.mintic.inqbike3.entities.Quadbike;
import com.usa.mintic.inqbike3.repository.CategoryRepository;
import com.usa.mintic.inqbike3.repository.QuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.isPresent()) {
                return category;
            } else {
                return categoryRepository.save(category);

            }
        }
    }

    public Category update(Category quadbike) {
        if (quadbike.getId() != null) {
            Optional<Category> qb = categoryRepository.getCategory(quadbike.getId());
            if (qb.isPresent()) {
                if (quadbike.getName() != null) {
                    qb.get().setName(quadbike.getName());
                }

                categoryRepository.save(qb.get());

                return qb.get();


            } else {
                return quadbike;
            }


        } else {
            return quadbike;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;

        }
        return flag;

    }

}
