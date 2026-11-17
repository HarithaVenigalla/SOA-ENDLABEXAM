
package com.example.tourist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;

import com.example.tourist.entity.Tourist;
import com.example.tourist.service.TouristService;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;

    private final String VALID_TOKEN;

    public TouristController(
            TouristService service,
            @Value("${app.security.token}") String token) {

        this.service = service;
        this.VALID_TOKEN = token;
    }

    // Fetch all tourists
    @GetMapping
    public List<Tourist> getAllTourists() {

        return service.getAllTourists();
    }

    // Fetch tourist by ID
    @GetMapping("/{id}")
    public Tourist getTouristById(@PathVariable Long id) {

        return service.getTouristById(id);
    }

    // Update tourist with token validation
    @PutMapping("/{id}")
    public ResponseEntity<Tourist> updateTourist(
            @PathVariable Long id,
            @RequestHeader(value = "Token", required = false)
            String token,
            @RequestBody Tourist tourist) {

        if (!VALID_TOKEN.equals(token)) {
            return ResponseEntity
                    .status(500)
                    .build();
        }

        Tourist updated =
                service.updateTourist(id, tourist);

        return ResponseEntity.ok(updated);
    }
}
