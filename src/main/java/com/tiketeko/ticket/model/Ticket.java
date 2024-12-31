package com.tiketeko.ticket.model;

import com.tiketeko.ticket.model.enums.TicketStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Integer status;
    private Instant createdAt;

    public Ticket() {
    }

    public Ticket(long id, String description, TicketStatus status, Instant createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        setStatus(status);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return TicketStatus.valueOf(status);
    }

    public void setStatus(TicketStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
