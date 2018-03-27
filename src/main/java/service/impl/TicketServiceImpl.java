package service.impl;

import model.Ticket;
import repository.TicketRepository;
import service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService{

    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void addNewTicket(String message, String theme) {
        Ticket ticket = Ticket.build().message(message).theme(theme).build();
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
