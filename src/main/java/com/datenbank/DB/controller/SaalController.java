package com.datenbank.DB.controller;

import com.datenbank.DB.DBKlassen.Saal;
import com.datenbank.DB.repository.SaalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saele")
public class SaalController {

    @Autowired
    private SaalRepository saalRepository;

    @GetMapping
    public List<Saal> getAlleSaele() {
        return saalRepository.findAll();
    }

    @PostMapping
    public Saal neuerSaal(@RequestBody Saal saal) {
        return saalRepository.save(saal);
    }

    @GetMapping("/{name}")
    public Saal getSaalByName(@PathVariable String name) {
        return saalRepository.findByName(name);
    }
}
