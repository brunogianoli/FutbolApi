package com.example.FutbolAPI.services.impl;

import com.example.FutbolAPI.DTOs.Get.GetEstadisticasJugadorDTO;
import com.example.FutbolAPI.DTOs.Put.PutEstadisticasDTO;
import com.example.FutbolAPI.entities.EstadisticasEntity;
import com.example.FutbolAPI.entities.JugadorEntity;
import com.example.FutbolAPI.repositories.EstadisticaRepository;
import com.example.FutbolAPI.repositories.JugadorRepository;
import com.example.FutbolAPI.services.EstadisticaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticaServiceImpl implements EstadisticaService {

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    EstadisticaRepository estadisticaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public GetEstadisticasJugadorDTO getEstadisticas(Long id) {
        JugadorEntity jugadorEntity = jugadorRepository.getReferenceById(id);//Consigo el jugador para conseguir las estadisticas
        EstadisticasEntity estadisticas = jugadorEntity.getEstadisticas();//Consigo las estadisticas

        //Las mapeo a tipo DTO
        GetEstadisticasJugadorDTO dto = new GetEstadisticasJugadorDTO();
        dto.setCantidadGoles(estadisticas.getCantidadGoles());
        dto.setPiernaHabil(estadisticas.getPiernaHabil());
        dto.setPartidosJugados(estadisticas.getPartidosJugados());

        return dto;
    }

    @Override
    public String putEstadisticas(Long jugadorId, PutEstadisticasDTO dto) {
        JugadorEntity jugador = jugadorRepository.findById(jugadorId)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        EstadisticasEntity estadisticas = jugador.getEstadisticas();
        if(dto.getCantidadGoles() < 0 || dto.getPartidosJugados() < 0) {
            return "Cantidad de goles y partidos jugados deben ser mayores o iguales a 0";
        }
        modelMapper.map(dto, estadisticas);

        estadisticaRepository.save(estadisticas);

        return "Se actualizaron las estadisticas de " + jugador.getNombre();
    }
}
