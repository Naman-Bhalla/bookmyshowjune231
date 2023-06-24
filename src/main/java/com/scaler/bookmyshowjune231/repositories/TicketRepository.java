package com.scaler.bookmyshowjune231.repositories;

import com.scaler.bookmyshowjune231.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket);
}
