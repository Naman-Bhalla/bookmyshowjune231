package com.scaler.bookmyshowjune231.dtos;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.atn.LexerPopModeAction;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {
    private int amount;
    private Long ticketId;
    private List<String> seatNumber;
    private String auditoriumName;
    private String status;
    private String message;
}

// bookmyshow.com/pay/{ticketId}
