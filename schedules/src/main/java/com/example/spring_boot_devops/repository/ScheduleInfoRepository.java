package com.example.spring_boot_devops.repository;

import com.example.spring_boot_devops.dto.ScheduleInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ScheduleInfoRepository {
    Map<String, ScheduleInfo> scheduleInfoMap;

    @PostConstruct
    public void init() {
        scheduleInfoMap = new HashMap<>();
    }

    public ScheduleInfo createSchedule(ScheduleInfo scheduleInfo) {
        String scheduleId = UUID.randomUUID().toString();
        ScheduleInfo scheduleWithId = scheduleInfo.toBuilder().id(scheduleId).build(); // Create a new instance with ID
        this.scheduleInfoMap.put(scheduleId, scheduleWithId); // Store the correct object
        return scheduleWithId; // Return the stored user
    }

    public List<ScheduleInfo> getSchedulesByFlightId(String flightId) {
        return scheduleInfoMap.values().stream()
                .filter(scheduleInfo -> scheduleInfo.getFlightId().equals(flightId))
                .collect(Collectors.toList());
    }

    public void deleteScheduleById(String id) {
        scheduleInfoMap.remove(id);
    }
}
