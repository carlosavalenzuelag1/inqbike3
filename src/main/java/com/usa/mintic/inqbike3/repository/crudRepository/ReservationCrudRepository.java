package com.usa.mintic.inqbike3.repository.crudRepository;

import com.usa.mintic.inqbike3.entities.Quadbike;
import com.usa.mintic.inqbike3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

}
