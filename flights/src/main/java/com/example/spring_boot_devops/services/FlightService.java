package com.example.spring_boot_devops.services;

import com.example.spring_boot_devops.dto.FlightInfo;
import com.example.spring_boot_devops.repository.FlightInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// @Service is also same as @Component
@Service
public class FlightService {
    @Autowired
    FlightInfoRepository flightInfoRepository;
    @Autowired
    private RestTemplate restTemplate;

    public List<FlightInfo> getAllFlights() {
        return flightInfoRepository.getAllFlights();
    }

    public FlightInfo createFlight(FlightInfo flightInfo) {
        return flightInfoRepository.createFlight(flightInfo);
    }

    public FlightInfo getFlight(String id) throws Exception {
        FlightInfo flightInfo = flightInfoRepository.getFlightById(id);
        if(flightInfo != null) {
            return flightInfo;
        }
        else {
            throw new Exception("Flight does not exist");
        }
    }

    public void deleteFlightById(String id) throws Exception {
        FlightInfo flightInfo = flightInfoRepository.getFlightById(id);
        if (flightInfo != null) {
            flightInfoRepository.deleteFlightById(id);
        }
        else {
            throw new Exception("Flight does not exist");
        }
    }

    public Object getFlightSchedules(String flightId, String dates) {
        String scheduleServiceUrl = "http://localhost:5001//schedules?flightId=" + flightId;

        if (dates != null) {
            scheduleServiceUrl += "&dates=" + dates;
        }

        ResponseEntity<Object> response = restTemplate.getForEntity(scheduleServiceUrl, Object.class);
        return response.getBody();
    }
}
