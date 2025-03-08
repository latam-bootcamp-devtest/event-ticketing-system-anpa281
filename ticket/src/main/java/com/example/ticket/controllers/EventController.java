package com.example.ticket.controllers;

import com.example.ticket.entities.Event;
import com.example.ticket.services.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/event")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        Event newEvent = eventService.createEvent(event);
//        log.debug("newEvent es {}",newEvent);

        System.out.println("new event *********** " + newEvent.getName());
        return ResponseEntity.ok().body(newEvent);
    }
}
