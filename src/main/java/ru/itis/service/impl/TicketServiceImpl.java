package ru.itis.service.impl;

import org.springframework.stereotype.Service;
import ru.itis.model.Ticket;
import ru.itis.repository.TicketRepository;
import ru.itis.service.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void addNewTicket(String message, String theme) {
        Ticket ticket = Ticket.builder().message(message).theme(theme).build();
        ticketRepository.save(ticket);
    }

    @Override
    public void addNewTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.getOne(id);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.delete(ticket.getId());
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.delete(id);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }
}