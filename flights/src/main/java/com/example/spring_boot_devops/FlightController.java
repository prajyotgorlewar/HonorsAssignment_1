package com.example.spring_boot_devops;

import com.example.spring_boot_devops.dto.FlightInfo;
import com.example.spring_boot_devops.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping()
    List<FlightInfo> getAllFlights(@RequestParam(required = false) String sort) {
        List<FlightInfo> flights = flightService.getAllFlights();

        if ("asc".equalsIgnoreCase(sort)) {
            return flights.stream()
                    .sorted(Comparator.comparing(FlightInfo::getDepartureTime))
                    .collect(Collectors.toList());
        } else if ("desc".equalsIgnoreCase(sort)) {
            return flights.stream()
                    .sorted(Comparator.comparing(FlightInfo::getDepartureTime).reversed())
                    .collect(Collectors.toList());
        }

        return flights;
    }

    @GetMapping("/{id}")
    ResponseEntity<FlightInfo> getFlightById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(flightService.getFlight(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/schedules")
    ResponseEntity<Object> getFlightSchedules(@PathVariable String id, @RequestParam(required = false) String dates) {
        Object schedules = flightService.getFlightSchedules(id, dates);
        return ResponseEntity.ok(schedules);
    }

    @PostMapping()
    FlightInfo CreateFlight(@RequestBody FlightInfo flightInfo) {
        return flightService.createFlight(flightInfo);
    }



    @DeleteMapping("/{id}")
    ResponseEntity<FlightInfo> deleteFlightById(@PathVariable String id) {
        try {
            flightService.deleteFlightById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}