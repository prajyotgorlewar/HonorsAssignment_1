package com.example.spring_boot_devops;

import com.example.spring_boot_devops.dto.TicketInfo;
import com.example.spring_boot_devops.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping()
    List<TicketInfo> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping()
    TicketInfo CreateTicket(@RequestBody TicketInfo ticketInfo) {
        return ticketService.createTicket(ticketInfo);
    }

    @PostMapping("/{id}")
    ResponseEntity<TicketInfo> getTicketById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(ticketService.getTicket(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<TicketInfo> deleteTicketById(@PathVariable String id) {
        try {
            ticketService.deleteTicketById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}