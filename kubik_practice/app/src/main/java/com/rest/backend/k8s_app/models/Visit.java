package com.rest.backend.k8s_app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String visitorName;
    private LocalDateTime visitTime;

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public String getVisitorName() { return visitorName; }
    public void setVisitorName(String name) { this.visitorName = name; }
    public LocalDateTime getVisitTime() { return visitTime; }
    public void setVisitTime(LocalDateTime time) { this.visitTime = time; }
}