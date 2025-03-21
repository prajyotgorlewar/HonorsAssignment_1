package com.example.spring_boot_devops;

import com.example.spring_boot_devops.dto.ScheduleInfo;
import com.example.spring_boot_devops.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping()
    ResponseEntity<List<ScheduleInfo>> getSchedulesForFlight(@RequestParam(required = false) String flightId, @RequestParam(required = false) String dates) {
        List<ScheduleInfo> scheduleInfoList = scheduleService.getSchedulesByFlightId(flightId);

        if (dates != null) {
            scheduleInfoList = scheduleInfoList.stream()
                    .filter(scheduleInfo -> scheduleInfo.getDate().toString().startsWith(dates))
                    .collect(Collectors.toList());
        }

        if (scheduleInfoList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleInfoList);
    }

    @PostMapping()
    ScheduleInfo CreateFlight(@RequestBody ScheduleInfo scheduleInfo) {
        return scheduleService.createSchedule(scheduleInfo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ScheduleInfo> deleteFlightById(@PathVariable String id) {
        try {
            scheduleService.deleteFlightById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}