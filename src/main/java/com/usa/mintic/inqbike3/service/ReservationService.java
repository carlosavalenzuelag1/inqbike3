package com.usa.mintic.inqbike3.service;


import com.usa.mintic.inqbike3.entities.Reservation;
import com.usa.mintic.inqbike3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation  reservation) {
        if ( reservation.getIdReservation() == null) {
            return reservationRepository.save( reservation);
        } else {
            Optional<Reservation>  reservation1 = reservationRepository.getReservation( reservation.getIdReservation());
            if ( reservation1.isPresent()) {
                return  reservation;
            } else {
                return reservationRepository.save( reservation);

            }
        }
    }

    public Reservation update(Reservation  reservation) {

        if ( reservation.getIdReservation() != null) {
            Optional<Reservation> qk = reservationRepository.getReservation( reservation.getIdReservation());
            if (qk.isPresent()) {
                if ( reservation.getIdReservation() != null) {
                    qk.get().setIdReservation( reservation.getIdReservation());
                }
                if ( reservation.getIdReservation() != null) {
                    qk.get().setIdReservation( reservation.getIdReservation());
                }

                reservationRepository.save(qk.get());

                return qk.get();


            } else {
                return  reservation;
            }


        } else {
            return  reservation;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p  .get());
            flag=true;

        }
        return flag;

    }

}
