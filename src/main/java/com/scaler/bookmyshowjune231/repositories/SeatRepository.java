package com.scaler.bookmyshowjune231.repositories;

import com.scaler.bookmyshowjune231.models.Seat;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findAllByIdIn(List<Long> seatIds);
    // select *
    // from seats
    // where id = {}
    // and col = {}
}
