package com.ragbecca.boekenwinkel.web;

import com.ragbecca.boekenwinkel.entities.Address;
import com.ragbecca.boekenwinkel.entities.Publisher;
import com.ragbecca.boekenwinkel.repository.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/publisher")
    List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @PostMapping("/publisher/add")
    String createPublisher(@Valid @RequestBody Publisher publisher) {
        if (publisherRepository.findByName(publisher.getName()) != null) {
            return "Er bestond al een adres met die gegevens";
        }
        publisherRepository.save(publisher);
        Long id = publisherRepository.findByName(publisher.getName()).getId();;
        return String.valueOf(id);
    }

}
