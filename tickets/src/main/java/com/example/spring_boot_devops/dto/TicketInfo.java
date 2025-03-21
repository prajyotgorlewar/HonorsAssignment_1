package com.example.spring_boot_devops.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder (toBuilder = true)
@AllArgsConstructor // Required for Jackson deserialization
@NoArgsConstructor
public class TicketInfo {
    private String id;
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private String flightId;
    private String scheduleId;
    private String seatNumber;
    private double price;
    private TicketStatus status;
}
