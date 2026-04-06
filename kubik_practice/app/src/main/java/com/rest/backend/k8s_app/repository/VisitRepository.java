package com.rest.backend.k8s_app.repository;

import com.rest.backend.k8s_app.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}