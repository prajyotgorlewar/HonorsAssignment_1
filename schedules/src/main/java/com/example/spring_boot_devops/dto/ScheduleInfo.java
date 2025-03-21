package com.example.spring_boot_devops.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder (toBuilder = true)
@AllArgsConstructor // Required for Jackson deserialization
@NoArgsConstructor
public class ScheduleInfo {
    private String id;
    private String flightId;
    private LocalDateTime date;
    private int availableSeats;
}
