package com.example.FutbolAPI.services.impl;

import com.example.FutbolAPI.DTOs.Get.GetClubesDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresPorClubDTO;
import com.example.FutbolAPI.entities.ClubEntity;
import com.example.FutbolAPI.entities.JugadorEntity;
import com.example.FutbolAPI.repositories.ClubRepository;
import com.example.FutbolAPI.repositories.JugadorRepository;
import com.example.FutbolAPI.services.ClubService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {


    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JugadorRepository jugadorRepository;


    @Override
    public List<GetJugadoresPorClubDTO> getJugadorByClub(Long id_Club) {
        ClubEntity clubEntity = clubRepository.getReferenceById(id_Club);

        List<JugadorEntity> jugadorEntityList = jugadorRepository.findAll();

        return jugadorEntityList.stream()
                .filter(jugador -> jugador.getClubes() != null && jugador.getClubes().contains(clubEntity))
                .map(jugador -> modelMapper.map(jugador, GetJugadoresPorClubDTO.class))
                .toList();
    }

    @Override
    public List<GetClubesDTO> getClubes() {

        List<ClubEntity> clubEntityList = clubRepository.findAll();
        return clubEntityList.stream()
                .map(entity -> modelMapper.map(entity, GetClubesDTO.class))
                .toList();
    }

}
