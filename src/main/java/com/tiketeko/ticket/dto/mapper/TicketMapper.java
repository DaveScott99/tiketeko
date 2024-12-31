package com.tiketeko.ticket.dto.mapper;

import com.tiketeko.ticket.dto.request.TickerRegistryDTO;
import com.tiketeko.ticket.dto.response.TicketDTO;
import com.tiketeko.ticket.model.Ticket;
import com.tiketeko.ticket.model.enums.TicketStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TicketMapper {


    public TicketDTO toDto(Ticket ticket) {
        if (ticket == null) {
            return null;
        }

        return new TicketDTO(ticket);
    }

    public Ticket toEntityRegister(TickerRegistryDTO tickerRegistryDTO) {

        if (tickerRegistryDTO == null) {
            return null;
        }

        Ticket entity = new Ticket();

        entity.setDescription(tickerRegistryDTO.getDescription());
        entity.setStatus(TicketStatus.PENDING);
        entity.setCreatedAt(new Date().toInstant());
        entity.setOwner(tickerRegistryDTO.getOwner());

        return entity;
    }

}
