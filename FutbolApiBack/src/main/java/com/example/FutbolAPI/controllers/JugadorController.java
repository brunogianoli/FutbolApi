package com.example.FutbolAPI.controllers;


import com.example.FutbolAPI.DTOs.Get.*;
import com.example.FutbolAPI.DTOs.Post.PostJugadorDTO;
import com.example.FutbolAPI.entities.JugadorEntity;
import com.example.FutbolAPI.services.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "http://localhost:4200")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;


    @GetMapping("")
    ResponseEntity<List<GetJugadoresDTO>> getAll(){
        return ResponseEntity.ok(jugadorService.getAllJugadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetJugadorPorIdDTO> getJugadorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.getJugadorByid(id));
    }

    @GetMapping("/activos")
    public ResponseEntity<List<GetJugadoresActivosDTO>>  getJugadoresActivos() {
        return ResponseEntity.ok(jugadorService.getJugadoresActivos());
    }

    @GetMapping("debut")
    public ResponseEntity<List<GetJugadorPorRangoDTO>> obtenerJugadoresPorRango(
            @RequestParam String desde,
            @RequestParam String hasta
    )
    {
        return ResponseEntity.ok(jugadorService.getJugadoresPorRango(desde, hasta));
    }

    @PostMapping("")
    public ResponseEntity<PostJugadorDTO> postJugador(@RequestBody PostJugadorDTO jugadorDTO){

        return ResponseEntity.ok(jugadorService.postJugador(jugadorDTO));
    }

    @DeleteMapping("{id}")
    public void deleteJugador(@PathVariable Long id){
        jugadorService.deleteJugador(id);
    }
}