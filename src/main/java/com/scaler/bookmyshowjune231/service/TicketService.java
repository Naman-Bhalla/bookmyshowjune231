package com.scaler.bookmyshowjune231.service;

import com.scaler.bookmyshowjune231.exceptions.InvalidArgumentsException;
import com.scaler.bookmyshowjune231.exceptions.SeatNotAvailableException;
import com.scaler.bookmyshowjune231.models.*;
import com.scaler.bookmyshowjune231.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final SeatRepository seatRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(SeatRepository seatRepository,
                         ShowSeatRepository showSeatRepository,
                         ShowRepository showRepository,
                         UserRepository userRepository,
                         TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }


    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId) throws InvalidArgumentsException, SeatNotAvailableException {
        // 1. for these seatIds get the correponding showseats getSeatsForIds(ids)
        // 2. Check the status of all the showseats getShowSeatsForSeats(seats)
        // 2.a: every seat is available
        // 3.a: lock every seat (set the status to be locked)
        // 4.a: Create ticket obj and return it
        // 2.b some of the seats are not available
        // 3.b: throw an exception

        // 1. 1, 2, 5
        // 2. 2, 3, 5

        // getShowsForSeats()
        // set transavction isolation level serializable
        // start transaction;
        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);
        Optional<Show> showOptional = showRepository.findById(showId);

        if (showOptional.isEmpty()) {
            throw new InvalidArgumentsException(
                    "Show by: " + showId + " doesn't exist."
            );
        }

        // Lock will be taken on the show seats
        List<ShowSeat> showSeats = getAndLokcShowSeats(seats, showOptional);

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new InvalidArgumentsException("User with id: " + userId + " doesn't exist.");
        }

        Ticket ticket = new Ticket();
        ticket.setBookedBy(userOptional.get());
        ticket.setStatus(TicketStatus.PROCESSING);
        ticket.setShow(showOptional.get());
        ticket.setSeats(seats);
        ticket.setAmount(0);
        ticket.setTimeOfBookng(new Date());

        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    public List<ShowSeat> getAndLokcShowSeats(List<Seat> seats, Optional<Show> showOptional) throws SeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, showOptional.get());

        for (ShowSeat showSeat: showSeats) {
            if (!(showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE) || (
                    showSeat.getStatus().equals(ShowSeatStatus.LOCKED)))) { // && new Date( - showSeat.getLockedAt())))) {
                throw new SeatNotAvailableException();
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for (ShowSeat showSeat: showSeats) {
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }


        return showSeats;
    }

    // commit;
    // Lock will be removed
}
