package com.example.spring_boot_devops.repository;

import com.example.spring_boot_devops.dto.FlightInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FlightInfoRepository {
    Map<String, FlightInfo> flightInfoMap;

    @PostConstruct
    public void init() {
        flightInfoMap = new HashMap<>();
    }

    public List<FlightInfo> getAllFlights() {
        return new ArrayList<>(flightInfoMap.values());
    }

    public FlightInfo createFlight(FlightInfo flightInfo) {
        String flightId = UUID.randomUUID().toString();
        FlightInfo flightWithId = flightInfo.toBuilder().id(flightId).build(); // Create a new instance with ID
        this.flightInfoMap.put(flightId, flightWithId); // Store the correct object
        return flightWithId; // Return the stored user
    }

    public FlightInfo getFlightById(String id) {
        return flightInfoMap.get(id);
    }

    public void deleteFlightById(String id) {
        flightInfoMap.remove(id);
    }
}
