package com.example.FutbolAPI.services;

import com.example.FutbolAPI.DTOs.Get.GetClubesDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresPorClubDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {

    List<GetJugadoresPorClubDTO> getJugadorByClub(Long id_Club);
    List<GetClubesDTO> getClubes();

}
