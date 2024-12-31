package com.tiketeko.ticket.service;

import com.tiketeko.ticket.dto.mapper.TicketMapper;
import com.tiketeko.ticket.dto.response.TicketDTO;
import com.tiketeko.ticket.repository.TicketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public Page<TicketDTO> getAll(Pageable pageable) {
        return ticketRepository.findAll(pageable).map(ticketMapper::toDto);
    }

}
