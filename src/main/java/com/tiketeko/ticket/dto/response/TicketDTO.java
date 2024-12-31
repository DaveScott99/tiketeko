package com.tiketeko.ticket.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiketeko.ticket.model.Ticket;
import com.tiketeko.ticket.model.enums.TicketStatus;

import java.io.Serializable;
import java.time.Instant;

public class TicketDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "status")
    private TicketStatus status;

    @JsonProperty(value = "createdAt")
    private Instant createdAt;

    @JsonProperty(value = "owner")
    private String owner;

    @JsonProperty(value = "assignedTo")
    private String assignedTo;

    @JsonProperty(value = "updatedAt")
    private Instant updatedAt;

    public TicketDTO() {
    }

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.description = ticket.getDescription();
        this.status = ticket.getStatus();
        this.createdAt = ticket.getCreatedAt();
        this.owner = ticket.getOwner();
        this.assignedTo = ticket.getAssignedTo();
        this.updatedAt = ticket.getUpdatedAt();
    }
}
