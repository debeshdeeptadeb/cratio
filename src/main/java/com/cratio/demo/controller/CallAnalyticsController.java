package com.cratio.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Date;
import com.cratio.demo.Entity.CallAnalytics;
import com.cratio.demo.Service.CallAnalyticsService;
@RestController
@RequestMapping("/api/call-analytics")
@CrossOrigin("*")
public class CallAnalyticsController {

    @Autowired
    private CallAnalyticsService service;

    // ✅ Add @GetMapping for retrieving all data
    @GetMapping("/callAnalytics")
    public List<CallAnalytics> getAnalytics() {
        return service.getAllAnalytics();
    }

    @PostMapping
    public CallAnalytics saveAnalytics(@RequestBody CallAnalytics analytics) {
        return service.saveAnalytics(analytics);
    }

    @GetMapping("/filter")
    public List<CallAnalytics> getFilteredAnalytics(
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) String employeeName,
            @RequestParam(required = false) String callType) {

        return service.getFilteredAnalytics(date, employeeName, callType);
    }
}
