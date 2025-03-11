package com.cratio.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.cratio.demo.Entity.CallAnalytics;
import com.cratio.demo.Repository.CallAnalyticsRepository;
import java.util.Date;

@Service
public class CallAnalyticsService {

    @Autowired
    private CallAnalyticsRepository repository;

//    public List<CallAnalytics> getAllAnalytics() {
//        return repository.findAll();
//    }

    public List<CallAnalytics> getAllAnalytics() {
        List<CallAnalytics> analyticsList = repository.findAll();
//        System.out.println("Retrieved Data: " + analyticsList); // Debugging statement
        return analyticsList;
    }

    public CallAnalytics saveAnalytics(CallAnalytics analytics) {
        if (analytics.getNotConnectedCalls() == null) {
            analytics.setNotConnectedCalls(0);
        }
        return repository.save(analytics);
    }

    public List<CallAnalytics> getFilteredAnalytics(Date date, String employeeName, String callType) {
        return repository.findByFilters(date, employeeName, callType);
    }
}
