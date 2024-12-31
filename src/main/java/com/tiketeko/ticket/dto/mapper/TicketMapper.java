package com.tiketeko.ticket.dto.mapper;

import com.tiketeko.ticket.dto.request.TicketRegistryDTO;
import com.tiketeko.ticket.dto.request.TicketUpdateDTO;
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

    public Ticket toEntityRegister(TicketRegistryDTO ticketRegistryDTO) {

        if (ticketRegistryDTO == null) {
            return null;
        }

        Ticket entity = new Ticket();

        entity.setDescription(ticketRegistryDTO.getDescription());
        entity.setStatus(TicketStatus.PENDING);
        entity.setCreatedAt(new Date().toInstant());
        entity.setOwner(ticketRegistryDTO.getOwner());

        return entity;
    }

    public Ticket toEntityUpdate(TicketUpdateDTO ticketUpdateDTO) {

        if (ticketUpdateDTO == null) {
            return null;
        }

        Ticket entity = new Ticket();

        entity.setDescription(ticketUpdateDTO.getDescription());

        return entity;
    }


}
