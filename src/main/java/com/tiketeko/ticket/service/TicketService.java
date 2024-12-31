package com.tiketeko.ticket.service;

import com.tiketeko.ticket.dto.mapper.TicketMapper;
import com.tiketeko.ticket.dto.response.TicketDTO;
import com.tiketeko.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<TicketDTO> getAll() {
        return ticketRepository.findAll().stream().map(ticketMapper::toDto).collect(Collectors.toList());
    }

}
