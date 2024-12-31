package com.tiketeko.ticket.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiketeko.ticket.model.Ticket;

import java.io.Serializable;

public class TickerRegistryDTO implements Serializable {

    private Long id;

    @JsonProperty(value = "description")
    private String description;

    public TickerRegistryDTO() {
    }

    public TickerRegistryDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.description = ticket.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
