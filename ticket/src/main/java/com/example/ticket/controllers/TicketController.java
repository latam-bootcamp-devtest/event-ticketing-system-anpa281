package com.example.ticket.controllers;

import com.example.ticket.dtos.TicketRequest;
import com.example.ticket.entities.Event;
import com.example.ticket.entities.Ticket;
import com.example.ticket.repositories.TicketRepository;
import com.example.ticket.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequest ticketRequest){
        Long userId = ticketRequest.getUserId();
        Long eventId = ticketRequest.getEventId();
        Ticket newTicket = ticketService.createTicket(userId, eventId);
        return ResponseEntity.ok().body(newTicket);
    }

    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<HttpStatus> deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    @GetMapping("/tickets")
    public List<Ticket> listTickets(){
        return ticketRepository.findAll();
    }
}
