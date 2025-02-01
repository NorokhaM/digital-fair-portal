package com.hacknimeto.fair_service.controllers;

import com.hacknimeto.fair_service.entities.Fair;
import com.hacknimeto.fair_service.services.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fairs")
public class FairController {

    private final FairService fairService;


    @Autowired
    public FairController(FairService fairService) {
        this.fairService = fairService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Fair>> getAllFairs() {
        return ResponseEntity.ok(fairService.findAll());
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<Fair> addFair(@RequestBody Fair fair, @PathVariable Long userId) {
        return ResponseEntity.ok(fairService.save(fair, userId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFair(@PathVariable Long id) {
        fairService.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
