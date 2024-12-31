package com.tiketeko.ticket.controller;

import com.tiketeko.ticket.dto.request.TicketAssignDTO;
import com.tiketeko.ticket.dto.request.TicketRegistryDTO;
import com.tiketeko.ticket.dto.request.TicketUpdateDTO;
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

    @GetMapping("/{id}")
    ResponseEntity<TicketDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @PostMapping
    ResponseEntity<TicketDTO> create(@RequestBody TicketRegistryDTO ticketRegistryDTO) {
        return new ResponseEntity<>(ticketService.create(ticketRegistryDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    ResponseEntity<TicketUpdateDTO> update(@PathVariable Long id, @RequestBody TicketUpdateDTO ticketUpdateDTO) {
        return ResponseEntity.ok(ticketService.update(id, ticketUpdateDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<TicketDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.delete(id));
    }

    @PatchMapping("/{id}/assign")
    ResponseEntity<TicketDTO> assign(@PathVariable Long id, @RequestBody TicketAssignDTO ticketAssignDTO) {
        return ResponseEntity.ok(ticketService.assign(id, ticketAssignDTO));
    }

    @PatchMapping("/{id}/unassign")
    ResponseEntity<TicketDTO> unassign(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.unassign(id));
    }

    @PatchMapping("/{id}/finish")
    ResponseEntity<TicketDTO> finish(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.finish(id));
    }

    @PatchMapping("/{id}/close")
    ResponseEntity<TicketDTO> close(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.close(id));
    }
}
