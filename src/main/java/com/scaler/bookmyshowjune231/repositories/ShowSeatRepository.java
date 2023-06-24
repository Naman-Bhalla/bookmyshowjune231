package com.scaler.bookmyshowjune231.repositories;

import com.scaler.bookmyshowjune231.models.Seat;
import com.scaler.bookmyshowjune231.models.Show;
import com.scaler.bookmyshowjune231.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

//    @Query("select * from shows where startTime FOR UPDATE")
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats, Show show);

    ShowSeat save(ShowSeat showSeat);
}
