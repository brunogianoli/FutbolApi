package com.example.FutbolAPI.services;

import com.example.FutbolAPI.DTOs.Get.GetEstadisticasJugadorDTO;
import com.example.FutbolAPI.DTOs.Put.PutEstadisticasDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstadisticaService {
    GetEstadisticasJugadorDTO getEstadisticas(Long id);
    String putEstadisticas(Long id,PutEstadisticasDTO putEstadisticasDTO);
}
