package com.example.spring_boot_devops.services;

import com.example.spring_boot_devops.dto.ScheduleInfo;
import com.example.spring_boot_devops.repository.ScheduleInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service is also same as @Component
@Service
public class ScheduleService {
    @Autowired
    ScheduleInfoRepository scheduleInfoRepository;

    public List<ScheduleInfo> getSchedulesByFlightId(String flightId) {
        return scheduleInfoRepository.getSchedulesByFlightId(flightId);
    }

    public ScheduleInfo createSchedule(ScheduleInfo scheduleInfo) {
        return scheduleInfoRepository.createSchedule(scheduleInfo);
    }

    public void deleteFlightById(String id) throws Exception {
        scheduleInfoRepository.deleteScheduleById(id);
    }
}
