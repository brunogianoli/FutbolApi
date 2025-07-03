package com.example.FutbolAPI.controllers;

import com.example.FutbolAPI.DTOs.Get.GetEstadisticasJugadorDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadorPorIdDTO;
import com.example.FutbolAPI.DTOs.Put.PutEstadisticasDTO;
import com.example.FutbolAPI.entities.EstadisticasEntity;
import com.example.FutbolAPI.entities.JugadorEntity;
import com.example.FutbolAPI.repositories.EstadisticaRepository;
import com.example.FutbolAPI.repositories.JugadorRepository;
import com.example.FutbolAPI.services.EstadisticaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/jugadores/{id}/estadisticas")
@CrossOrigin(origins = "http://localhost:4200") // habilita CORS solo para Angular
public class EstadisticasController {

    @Autowired
    EstadisticaService estadisticaService;


    @GetMapping("")
    public ResponseEntity<GetEstadisticasJugadorDTO> getEstadisticasJugador(@PathVariable Long id) {
        return ResponseEntity.ok(estadisticaService.getEstadisticas(id));
    }

    @PutMapping("")
    public ResponseEntity<PutEstadisticasDTO >putEstadisticasJugador(@PathVariable PutEstadisticasDTO putEstadisticasDTO, @PathVariable Long id){

        return ResponseEntity.ok(estadisticaService.putEstadisticas(id,putEstadisticasDTO));


    }
}
