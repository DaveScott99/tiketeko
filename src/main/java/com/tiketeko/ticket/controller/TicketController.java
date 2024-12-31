package com.tiketeko.ticket.controller;

import com.tiketeko.ticket.dto.response.TicketDTO;
import com.tiketeko.ticket.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Page<TicketDTO>> list(Pageable pageable) {
        return ResponseEntity.ok(ticketService.getAll(pageable));
    }
}
