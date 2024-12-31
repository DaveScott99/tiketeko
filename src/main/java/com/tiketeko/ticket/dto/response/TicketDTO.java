package com.tiketeko.ticket.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiketeko.ticket.model.Ticket;
import com.tiketeko.ticket.model.enums.TicketStatus;

import java.time.Instant;

public class TicketDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "status")
    private TicketStatus status;

    @JsonProperty(value = "createdAt")
    private Instant createdAt;

    public TicketDTO() {
    }

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.description = ticket.getDescription();
        this.status = ticket.getStatus();
        this.createdAt = ticket.getCreatedAt();
    }
}
