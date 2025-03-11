package com.cratio.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cratio.demo.Entity.CallAnalytics;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

@Repository
public interface CallAnalyticsRepository extends JpaRepository<CallAnalytics, Long> {

    @Query("SELECT c FROM CallAnalytics c WHERE " +
            "(:date IS NULL OR c.date = :date) AND " +
            "(:employeeName IS NULL OR c.employeeName = :employeeName) AND " +
            "(:callType IS NULL OR c.callType = :callType)")
    List<CallAnalytics> findByFilters(@Param("date") Date date,
                                      @Param("employeeName") String employeeName,
                                      @Param("callType") String callType);

    // New method: Fetch analytics within a date range
    @Query("SELECT c FROM CallAnalytics c WHERE c.date BETWEEN :startDate AND :endDate")
    List<CallAnalytics> findByDateRange(@Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate);
}
