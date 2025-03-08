package com.example.ticket.services;

import com.example.ticket.entities.Event;
import com.example.ticket.entities.Ticket;
import com.example.ticket.repositories.EventRepository;
import com.example.ticket.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TicketService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional
    public Ticket createTicket(Long userId, Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("event not found"));

        if(event.getAvailableSeats() <= 0){
            throw new RuntimeException("no available seats");
        }

        event.setAvailableSeats(event.getAvailableSeats() - 1);
        eventRepository.save(event);

        Ticket ticket = new Ticket();
        ticket.setUserId(userId);
        ticket.setEvent(event);
        ticket.setTicketDate(LocalDate.now());

        return ticketRepository.save(ticket);
    }
}
