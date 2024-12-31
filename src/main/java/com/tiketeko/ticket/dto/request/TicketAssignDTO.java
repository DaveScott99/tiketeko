package com.tiketeko.ticket.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TicketAssignDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "name")
    private String name;

    public TicketAssignDTO() {
    }

    public TicketAssignDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
