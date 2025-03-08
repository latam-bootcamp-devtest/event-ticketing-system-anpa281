package com.example.ticket.repositories;

import com.example.ticket.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
