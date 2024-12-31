package com.tiketeko.ticket.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiketeko.ticket.model.Ticket;

import java.io.Serializable;

public class TicketUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "description")
    private String description;

    public TicketUpdateDTO() {
    }

    public TicketUpdateDTO(Ticket ticket) {
        this.description = ticket.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
