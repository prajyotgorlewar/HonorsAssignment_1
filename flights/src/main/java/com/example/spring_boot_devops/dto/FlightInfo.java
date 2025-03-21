package com.example.spring_boot_devops.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder (toBuilder = true)
@AllArgsConstructor // Required for Jackson deserialization
@NoArgsConstructor
public class FlightInfo {
    private String id;
    private String flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
}
