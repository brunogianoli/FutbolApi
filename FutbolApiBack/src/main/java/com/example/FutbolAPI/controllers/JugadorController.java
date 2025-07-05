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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "http://localhost:4200")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;


    @GetMapping("")
    ResponseEntity<List<GetJugadoresDTO>> getAll( ){
        return ResponseEntity.ok(jugadorService.getAllJugadores());
    }

    @GetMapping("/search")
    ResponseEntity<List<GetJugadoresDTO>> getAllFiltrados(
            @RequestParam (required = false) String club,
            @RequestParam (required = false) String posicion,
            @RequestParam (required = false) String desde,
            @RequestParam (required = false) String hasta
    ){
        List<GetJugadoresDTO> jugadoresDTOList = jugadorService.getAllJugadoresFiltrados(club, posicion, desde, hasta);
        return ResponseEntity.ok(jugadoresDTOList);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<DummyResponseDto>> searchDummies(
//            @RequestParam(required = false) String dummyField,
//            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate
//    ) {
//        List<DummyResponseDto> result = dummyService.search(dummyField, fromDate);
//        return ResponseEntity.ok(result);
//    }


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
    @GetMapping("/search")
    public ResponseEntity<List<GetJugadoresDTO>> searchJugadores(
            @RequestParam(required = false) String club,
            @RequestParam(required = false) String posicion,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta
    ) {
        List<GetJugadoresDTO> result = jugadorService.search(club, posicion, desde, hasta);
        return ResponseEntity.ok(result);
    }
}