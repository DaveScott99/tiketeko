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

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "assigned_to", nullable = true)
    private String assignedTo;

    @Column(name = "updated_at", nullable = true)
    private Instant updatedAt;

    @Column(name = "deleted_at", nullable = true)
    private Instant deletedAt;

    public Ticket() {
    }

    public Ticket(long id, String description, TicketStatus status, Instant createdAt, String owner, String assignedTo, Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.owner = owner;
        this.assignedTo = assignedTo;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }
}
