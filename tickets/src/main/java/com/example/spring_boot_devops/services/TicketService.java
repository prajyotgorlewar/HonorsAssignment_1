package com.example.spring_boot_devops.services;

import com.example.spring_boot_devops.dto.TicketInfo;
import com.example.spring_boot_devops.repository.TicketInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service is also same as @Component
@Service
public class TicketService {
    @Autowired
    TicketInfoRepository ticketInfoRepository;

    public List<TicketInfo> getAllTickets() {
        return ticketInfoRepository.getAllTickets();
    }

    public TicketInfo createTicket(TicketInfo ticketInfo) {
        return ticketInfoRepository.createTicket(ticketInfo);
    }

    public TicketInfo getTicket(String id) throws Exception {
        TicketInfo ticketInfo = ticketInfoRepository.getTicketById(id);
        if(ticketInfo != null) {
            return ticketInfo;
        }
        else {
            throw new Exception("Ticket does not exist");
        }
    }

    public void deleteTicketById(String id) throws Exception {
        TicketInfo ticketInfo = ticketInfoRepository.getTicketById(id);
        if (ticketInfo != null) {
            ticketInfoRepository.deleteTicketById(id);
        }
        else {
            throw new Exception("Ticket does not exist");
        }
    }
}
