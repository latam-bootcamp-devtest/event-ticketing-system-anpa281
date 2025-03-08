package com.example.ticket.controllers;

import com.example.ticket.entities.Event;
import com.example.ticket.services.EventService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return ResponseEntity.ok().body(newEvent);
    }

    //pagination
    @GetMapping("/event")
    public ResponseEntity<Page<Event>> getEvents(@RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "pagesize", defaultValue = "10") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Event> onePage = eventService.getEvents(pageable);
        return ResponseEntity.ok().body(onePage);
    }


}
