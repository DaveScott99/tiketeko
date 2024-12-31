package com.tiketeko.ticket.controller;

import com.tiketeko.ticket.model.Ticket;
import com.tiketeko.ticket.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/test")
    public String testConnection() {
        return "TUDO CERTO!!!";
    }

    @GetMapping
    public List<Ticket> list() {
        return ticketService.getAll();
    }
}
