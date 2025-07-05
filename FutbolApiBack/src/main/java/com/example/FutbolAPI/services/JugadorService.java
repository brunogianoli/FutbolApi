package com.example.FutbolAPI.services;

import com.example.FutbolAPI.DTOs.Get.GetJugadorPorIdDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadorPorRangoDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresActivosDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresDTO;
import com.example.FutbolAPI.DTOs.Post.PostJugadorDTO;
import com.example.FutbolAPI.entities.JugadorEntity;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface JugadorService {
    List<GetJugadoresDTO> getAllJugadores();
    GetJugadorPorIdDTO getJugadorByid(Long id);
    List<GetJugadoresActivosDTO> getJugadoresActivos();
    List<GetJugadorPorRangoDTO> getJugadoresPorRango (String desde, String hasta);
    PostJugadorDTO postJugador(PostJugadorDTO jugadorDTO);
    void deleteJugador(Long id);


    List<GetJugadoresDTO> search(String club, String posicion, LocalDate desde, LocalDate hasta);
}
