package com.rapifuzz.incident_management.repository;

import com.rapifuzz.incident_management.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByReporterId(Long userId);

    Incident findByIncidentId(String incidentId);
}