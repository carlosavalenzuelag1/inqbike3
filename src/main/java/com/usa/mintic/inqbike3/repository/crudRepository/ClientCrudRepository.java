package com.usa.mintic.inqbike3.repository.crudRepository;

import com.usa.mintic.inqbike3.entities.Client;
import com.usa.mintic.inqbike3.entities.Quadbike;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
