package com.rapifuzz.incident_management.model;


import com.rapifuzz.incident_management.constants.Priority;
import com.rapifuzz.incident_management.constants.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String incidentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reporter;

    private String details;

    private LocalDateTime reportedDateTime;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

}
