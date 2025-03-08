package com.example.ticket.dtos;

import com.example.ticket.entities.Event;
import lombok.Data;

@Data
public class TicketRequest {
    private Long userId;
    private Long eventId;



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public TicketRequest(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }


}
