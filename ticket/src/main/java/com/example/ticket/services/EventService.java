package com.example.ticket.services;

import com.example.ticket.entities.Event;
import com.example.ticket.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Page<Event> getEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }
}
