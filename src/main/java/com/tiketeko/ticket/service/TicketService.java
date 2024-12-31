package com.tiketeko.ticket.service;

import com.tiketeko.ticket.dto.mapper.TicketMapper;
import com.tiketeko.ticket.dto.request.TicketRegistryDTO;
import com.tiketeko.ticket.dto.request.TicketUpdateDTO;
import com.tiketeko.ticket.dto.response.TicketDTO;
import com.tiketeko.ticket.model.Ticket;
import com.tiketeko.ticket.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        return ticketMapper.toDto(ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket not found")));
    }

    public TicketDTO create(TicketRegistryDTO ticketDTO) {
        return ticketMapper.toDto(ticketRepository.save(ticketMapper.toEntityRegister(ticketDTO)));
    }

    public TicketUpdateDTO update(Long id, TicketUpdateDTO ticketDTO) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        Ticket newTicket = ticketMapper.toEntityUpdate(ticketDTO);

        if (entity != null) {

            if (newTicket.getDescription() != null && !newTicket.getDescription().equals(entity.getDescription())) {
                entity.setDescription(newTicket.getDescription());
            }

            entity.setUpdatedAt(new Date().toInstant());

            ticketRepository.save(entity);
            return ticketDTO;
        }

        return null;
    }

    public TicketDTO delete(Long id) {
        Ticket entity = ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        entity.setDeletedAt(new Date().toInstant());
        return ticketMapper.toDto(ticketRepository.save(entity));
    }
}
