package com.example.FutbolAPI.controllers;


import com.example.FutbolAPI.DTOs.Get.GetClubesDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresPorClubDTO;
import com.example.FutbolAPI.entities.ClubEntity;
import com.example.FutbolAPI.entities.JugadorEntity;
import com.example.FutbolAPI.repositories.ClubRepository;
import com.example.FutbolAPI.services.ClubService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clubes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClubController {

    @Autowired
    ClubService clubService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("")
    public ResponseEntity<List<GetClubesDTO>> getClubes() {

        return ResponseEntity.ok(clubService.getClubes());
    }

    @GetMapping("/{id}/jugadores")
    public ResponseEntity<List<GetJugadoresPorClubDTO>> getJugadoresPorClub(@PathVariable Long id) {
        return ResponseEntity.ok(clubService.getJugadorByClub(id));
    }
}
