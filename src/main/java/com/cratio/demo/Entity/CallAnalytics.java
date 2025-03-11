package com.cratio.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;  // ✅ Missing Import
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "call_analytics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @JsonProperty("date")
    private Date date;

    @Column(name = "employee_name")
    @JsonProperty("employeeName")
    private String employeeName;

    @Column(name = "call_type")
    @JsonProperty("callType")
    private String callType;

    @Column(name = "total_calls")
    @JsonProperty("totalCalls")
    private int totalCalls;

    @Column(name = "connected_calls")
    @JsonProperty("connectedCalls")
    private int connectedCalls;

    @Column(name = "connected_duration")
    @JsonProperty("connectedDuration")
    private String connectedDuration;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    @JsonProperty("notConnectedCalls")
    private Integer notConnectedCalls = 0;

    @Column(name = "unique_contacts")
    @JsonProperty("uniqueContacts")
    private int uniqueContacts;

    @Column(name = "incoming_calls")
    @JsonProperty("incomingCalls")
    private int incomingCalls;

    @Column(name = "incoming_duration")
    @JsonProperty("incomingDuration")
    private String incomingDuration;

    @Column(name = "outgoing_calls")
    @JsonProperty("outgoingCalls")
    private int outgoingCalls;

    @Column(name = "outgoing_duration")
    @JsonProperty("outgoingDuration")
    private String outgoingDuration;

    @Column(name = "missed_calls")
    @JsonProperty("missedCalls")
    private int missedCalls;

    @Column(name = "rejected_calls")
    @JsonProperty("rejectedCalls")
    private int rejectedCalls;

    @Override
    public String toString() {
        return "CallAnalytics{" +
                "id=" + id +
                ", date=" + date +
                ", employeeName='" + employeeName + '\'' +
                ", callType='" + callType + '\'' +
                ", totalCalls=" + totalCalls +
                ", connectedCalls=" + connectedCalls +
                ", connectedDuration='" + connectedDuration + '\'' +
                ", notConnectedCalls=" + notConnectedCalls +
                ", uniqueContacts=" + uniqueContacts +
                ", incomingCalls=" + incomingCalls +
                ", incomingDuration='" + incomingDuration + '\'' +
                ", outgoingCalls=" + outgoingCalls +
                ", outgoingDuration='" + outgoingDuration + '\'' +
                ", missedCalls=" + missedCalls +
                ", rejectedCalls=" + rejectedCalls +
                '}';
    }

    // ✅ Manually added getter and setter for notConnectedCalls
    public Integer getNotConnectedCalls() {
        return notConnectedCalls;
    }

    public void setNotConnectedCalls(Integer notConnectedCalls) {
        this.notConnectedCalls = notConnectedCalls;
    }

}
