package com.ragbecca.boekenwinkel.web;

import com.ragbecca.boekenwinkel.entities.Publisher;
import com.ragbecca.boekenwinkel.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
