package com.tiketeko.ticket.controller;

import com.tiketeko.ticket.dto.request.TickerRegistryDTO;
import com.tiketeko.ticket.dto.response.TicketDTO;
import com.tiketeko.ticket.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/test")
    String testConnection() {
        return "TUDO CERTO!!!";
    }

    @GetMapping
    ResponseEntity<Page<TicketDTO>> list(Pageable pageable) {
        return ResponseEntity.ok(ticketService.list(pageable));
    }

    @PostMapping
    ResponseEntity<TicketDTO> create(@RequestBody TickerRegistryDTO tickerRegistryDTO) {
        return new ResponseEntity<>(ticketService.create(tickerRegistryDTO), HttpStatus.CREATED);
    }
}
