package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.services.StreetService;

@RestController
public class AjaxController {

    @Autowired
    private StreetService streetService;

    @PostMapping("/api/property/streets")
    public ResponseEntity<?> getStreets(@RequestBody Long city){
        return ResponseEntity.ok(streetService.getAllStreetsByCity(city));
    }
}
