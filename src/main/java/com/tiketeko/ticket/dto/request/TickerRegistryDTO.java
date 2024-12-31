package com.tiketeko.ticket.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiketeko.ticket.model.Ticket;

import java.io.Serializable;

public class TickerRegistryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "owner")
    private String owner;

    public TickerRegistryDTO() {
    }

    public TickerRegistryDTO(Ticket ticket) {
        this.description = ticket.getDescription();
        this.owner = ticket.getOwner();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
