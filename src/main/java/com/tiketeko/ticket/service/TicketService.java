package com.tiketeko.ticket.service;

import com.tiketeko.ticket.dto.mapper.TicketMapper;
import com.tiketeko.ticket.dto.request.TickerRegistryDTO;
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

    public Page<TicketDTO> list(Pageable pageable) {
        return ticketRepository.findAll(pageable).map(ticketMapper::toDto);
    }

    public TicketDTO findById(Long id) {
        return ticketMapper.toDto(ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found")));
    }

    public TicketDTO create(TickerRegistryDTO ticketDTO) {
        return ticketMapper.toDto(ticketRepository.save(ticketMapper.toEntityRegister(ticketDTO)));
    }

    public TicketDTO update(Long id, TickerRegistryDTO ticketDTO) {
        ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        return ticketMapper.toDto(ticketRepository.save(ticketMapper.toEntityRegister(ticketDTO)));
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
