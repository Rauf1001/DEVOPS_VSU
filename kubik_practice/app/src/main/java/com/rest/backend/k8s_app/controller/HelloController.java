package com.rest.backend.k8s_app.controller;

import com.rest.backend.k8s_app.model.Visit;
import com.rest.backend.k8s_app.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping("/")
    public String hello() {
        String name = System.getenv("NAME");
        if (name == null) name = "Guest";

        // Сохраняем новый визит
        Visit visit = new Visit();
        visit.setVisitorName(name);
        visit.setVisitTime(LocalDateTime.now());
        visitRepository.save(visit);

        // Читаем все визиты
        List<Visit> allVisits = visitRepository.findAll();
        String visitsHtml = allVisits.stream()
                .map(v -> "<li>" + v.getVisitorName() + " visited at " + v.getVisitTime() + "</li>")
                .collect(Collectors.joining());

        return "<html><body>" +
                "<h1>Hello " + name + "</h1>" +
                "<h3>Visit History:</h3>" +
                "<ul>" + visitsHtml + "</ul>" +
                "</body></html>";
    }

}
