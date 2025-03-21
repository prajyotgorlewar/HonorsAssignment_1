package com.example.spring_boot_devops.repository;

import com.example.spring_boot_devops.dto.TicketInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TicketInfoRepository {
    Map<String, TicketInfo> ticketInfoMap;

    @PostConstruct
    public void init() {
        ticketInfoMap = new HashMap<>();
    }

    public List<TicketInfo> getAllTickets() {
        return new ArrayList<>(ticketInfoMap.values());
    }

    public TicketInfo createTicket(TicketInfo ticketInfo) {
        String ticketId = UUID.randomUUID().toString();
        TicketInfo ticketWithId = ticketInfo.toBuilder().id(ticketId).build(); // Create a new instance with ID
        this.ticketInfoMap.put(ticketId, ticketWithId); // Store the correct object
        return ticketWithId; // Return the stored user
    }

    public TicketInfo getTicketById(String id) {
        return ticketInfoMap.get(id);
    }

    public void deleteTicketById(String id) {
        ticketInfoMap.remove(id);
    }
}
