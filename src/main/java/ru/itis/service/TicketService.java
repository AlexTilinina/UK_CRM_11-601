package ru.itis.service;

import org.springframework.stereotype.Service;
import ru.itis.model.Ticket;

import java.util.List;

@Service
public interface TicketService {

    void addNewTicket(String message, String theme);

    void addNewTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);

    void updateTicket(Ticket ticket);

    void deleteTicketById(Long id);

    void deleteTicket(Ticket ticket);
}
