package com.rapifuzz.incident_management.service;

import com.rapifuzz.incident_management.constants.Priority;
import com.rapifuzz.incident_management.constants.Status;
import com.rapifuzz.incident_management.model.Incident;
import com.rapifuzz.incident_management.model.User;
import com.rapifuzz.incident_management.repository.IncidentRepository;
import com.rapifuzz.incident_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private UserRepository userRepository;

    public Incident createIncident(Long userId, String details, String priority) {
        User reporter = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        String incidentId = "RMG" + (int) (Math.random() * 100000) + LocalDateTime.now().getYear();
        Incident incident = new Incident();
        incident.setIncidentId(incidentId);
        incident.setReporter(reporter);
        incident.setDetails(details);
        incident.setReportedDateTime(LocalDateTime.now());
        incident.setPriority(Priority.valueOf(priority));
        incident.setStatus(Status.OPEN);

        return incidentRepository.save(incident);
    }

    public List<Incident> getIncidentsByUser(Long userId) {
        return incidentRepository.findByReporterId(userId);
    }

    public Incident getIncidentById(String incidentId) {
        return incidentRepository.findByIncidentId(incidentId);
    }
}
