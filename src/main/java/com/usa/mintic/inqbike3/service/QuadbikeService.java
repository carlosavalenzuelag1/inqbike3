package com.usa.mintic.inqbike3.service;


import com.usa.mintic.inqbike3.entities.Quadbike;
import com.usa.mintic.inqbike3.repository.QuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuadbikeService {

    @Autowired
    private QuadbikeRepository quadbikeRepository;

    public List<Quadbike> getAll() {
        return quadbikeRepository.getAll();
    }

    public Optional<Quadbike> getQuadbike(int id) {
        return quadbikeRepository.getQuadbike(id);
    }

    public Quadbike save(Quadbike quadbike) {
        if (quadbike.getId() == null) {
            return quadbikeRepository.save(quadbike);
        } else {
            Optional<Quadbike> quadbike1 = quadbikeRepository.getQuadbike(quadbike.getId());
            if (quadbike1.isPresent()) {
                return quadbike;
            } else {
                return quadbikeRepository.save(quadbike);

            }
        }
    }

    public Quadbike update(Quadbike quadbike) {
        if (quadbike.getId() != null) {
            Optional<Quadbike> qk = quadbikeRepository.getQuadbike(quadbike.getId());
            if (qk.isPresent()) {
                if (quadbike.getName() != null) {
                    qk.get().setName(quadbike.getName());
                }
                if (quadbike.getBrand() != null) {
                    qk.get().setBrand(quadbike.getBrand());
                }
                if (quadbike.getYear() != null) {
                    qk.get().setYear(quadbike.getYear());
                }
                if (quadbike.getCategory() != null) {
                    qk.get().setCategory(quadbike.getCategory());
                }

                quadbikeRepository.save(qk.get());

                return qk.get();


            } else {
                return quadbike;
            }


        } else {
            return quadbike;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Quadbike>p=quadbikeRepository.getQuadbike(id);
        if(p.isPresent()){
            quadbikeRepository.delete(p  .get());
            flag=true;

        }
        return flag;

    }

}
