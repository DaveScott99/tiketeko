package com.tiketeko.ticket.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String status;
    private Instant createdAt;

    public Ticket() {
    }

    public Ticket(long id, String description, String status, Instant createdAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
