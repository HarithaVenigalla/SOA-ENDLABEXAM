
package com.example.tourist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    // Fetch all tourists
    public List<Tourist> getAllTourists() {
        return repository.findAll();
    }

    // Fetch tourist by ID
    public Tourist getTouristById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tourist Not Found"
                    ));
    }

    // Update tourist
    public Tourist updateTourist(Long id, Tourist newTourist) {

        Tourist tourist = repository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tourist Not Found"
                    ));

        tourist.setName(newTourist.getName());
        tourist.setEmail(newTourist.getEmail());
        tourist.setDestination(newTourist.getDestination());

        return repository.save(tourist);
    }
}
